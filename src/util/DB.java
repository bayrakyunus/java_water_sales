package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DB {
    public static List<String> ls = new ArrayList<>();
    private String path = "jdbc:sqlite:db/WaterSales.db";
    public Connection conn = null;

    public DB() {
        try {
            // connection
            conn = DriverManager.getConnection(path);
            System.out.println("Connect Success");
        } catch (SQLException e) {
            System.err.println("Connect Error : " + e);
        }
    }
    // Admin Login
    public List<String> login (String userName, String pass){
        try {
            String query ="SELECT * FROM admin WHERE mail = ? and pass = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, userName);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                ls.add(""+rs.getInt("aid"));
                ls.add(rs.getString("name"));
                ls.add(rs.getString("pass"));
            }
            pre.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Login Error: " + e);
        }
        return ls;
    }
    
    // Data Customer function
    public DefaultTableModel fncAllCustomer(String txt){
        DefaultTableModel dtm = new DefaultTableModel();
        String query ="";
        if (txt.equals("")) {
            query = "SELECT * FROM customer";
        }else{
            query = "SELECT * FROM customer WHERE name like '%"+txt+"%' or mail like '%"+txt+"%' or tel like '%"+txt+"%'";
        }
        dtm.addColumn("Cid");
        dtm.addColumn("Name");
        dtm.addColumn("Mail");
        dtm.addColumn("Tel");
        dtm.addColumn("Address");
        
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                int cid = rs.getInt("cid");
                String name = rs.getString("name");
                String mail = rs.getString("mail");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                Object[] row = {cid,name,mail,tel,address};
                dtm.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("fnAllCustomer Error: " + e);
        }
        return dtm;
    }
    
    // Customer Insert
    public int  customerInsert( String name, String mail, String tel, String address ){
        int statu = 0;
        try {
            String query = "insert into customer values ( null, ? , ? , ? , ? )";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, name);
            pre.setString(2, mail);
            pre.setString(3, tel);
            pre.setString(4, address);
            statu = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("Customer Insert Error : " + e);
        }
        return statu;
    }
    
    // Customer Delete
    public int customerDelete(int cid){
        int statu = 0;
        
        try {
            String query="delete from customer where cid =?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, cid);
            statu = pre.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Customer Delete Error : " + e);
        }
        return statu;
    }
    
    // Customer Update
    public int  customerUpdate(int cid, String name, String mail, String tel, String address ){
        int statu = 0;
        try {
            String query = "update customer set name = ?, mail = ?, tel = ?, address = ? where cid = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, name);
            pre.setString(2, mail);
            pre.setString(3, tel);
            pre.setString(4, address);
            pre.setInt(5, cid);
            statu = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("Customer Update Error : " + e);
        }
        return statu;
    }
    
        // Data Order function
    public DefaultTableModel fncAllOrders(String txt){
        
        String query ="";
        if (txt.equals("archive")) {
            query ="SELECT * FROM orderWater INNER JOIN customer"
                    + " on orderWater.cid = customer.cid where statu = 3 ";
            
        }else{
            query ="SELECT * FROM orderWater INNER JOIN customer"
                    + " on orderWater.cid = customer.cid where statu != 3 ";
        }
        DefaultTableModel dtm = new DefaultTableModel();

        dtm.addColumn("OID");
        dtm.addColumn("Name");
        dtm.addColumn("Tel");
        dtm.addColumn("Address");
        dtm.addColumn("Piece");
        dtm.addColumn("Statu");
        dtm.addColumn("Date");

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                int oid = rs.getInt("oid");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                int piece = rs.getInt("piece");
                int statu = rs.getInt("statu");
                
                String statuString = "";
                if (statu == 1) {
                    statuString ="Preparing";
                }
                if (statu == 2) {
                    statuString ="Delivery";
                }
                if (statu == 3) {
                    statuString ="Done";
                }
                
                String date = rs.getString("date");
                Object[] row = {oid,name,tel,address,piece,statuString,date};
                dtm.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("fnAllOrder Error: " + e);
        }
        return dtm;
    }
    
    // New Order
    public int newOrder(int cid, int piece){
        int statu = -1;
        
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String ts = sdf.format(timestamp);
            
            
            String query = "insert into orderWater values ( null, ? , ? , 1 , '"+ts+"' )";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, cid);
            pre.setInt(2, piece);
            statu = pre.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("New Order Error : " + e);
        }
        return statu;
    }
    
    // Order Statu Change
    public int orderStatuChange(int oid, int newStatu){
        int statu = -1;
        
        try {
           String query = "update orderWater set statu = ? where oid = ?";
           PreparedStatement pre = conn.prepareStatement(query);
           pre.setInt(1, newStatu);
           pre.setInt(2,oid);
           statu = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("Order Statu Change Error : " + e);
            
        }
        
        return statu;
    }
    
}
