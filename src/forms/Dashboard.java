
package forms;

import java.awt.event.KeyEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import util.DB;

public class Dashboard extends javax.swing.JFrame {
    
    DB db = new DB();
    int cid = -1;
    int oid = -1;
    
    public Dashboard() {
        setBackgroundImage("src/icons/background.jpg");
        initComponents();
        setAdminName();
        tblCustomerRefresh();
        tblOrderRefresh();
    }
    
    public void tblCustomerRefresh(){
        tblCustomer.setModel(db.fncAllCustomer(""));
    }
    
    public void tblCustomerRefresh(String txt){
        tblCustomer.setModel(db.fncAllCustomer(txt));
    }
    
    public void tblOrderRefresh(){
        tblOrder.setModel(db.fncAllOrders(""));
    }
    
    public void setAdminName(){
        try {
            String name = DB.ls.get(1);
            lblName.setText(name);
        } catch (Exception e) {
            System.err.println("Username not found " + e);
            lblName.setText("Username not found");
        }
    }
    
    public void setBackgroundImage(String path){
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(path)))));
            } catch (Exception e) {
                System.err.println("Background Image Error" + e);
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnCustomerInsert = new javax.swing.JButton();
        btnCustomerUpdate = new javax.swing.JButton();
        btnCustomerDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnNewOrder = new javax.swing.JButton();
        btnDelivery = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnArchive = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setResizable(false);

        lblName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User Action"));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 300));

        jLabel1.setText("Search");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        btnCustomerInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnCustomerInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerInsertActionPerformed(evt);
            }
        });

        btnCustomerUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnCustomerUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerUpdateActionPerformed(evt);
            }
        });

        btnCustomerDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnCustomerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCustomerInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(btnCustomerUpdate)
                        .addGap(81, 81, 81)
                        .addComponent(btnCustomerDelete)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCustomerDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCustomerUpdate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCustomerInsert, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Order Action"));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 300));

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        btnNewOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        btnDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car.png"))); // NOI18N
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        btnDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smile.png"))); // NOI18N
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnArchive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/archive.png"))); // NOI18N
        btnArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNewOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelivery)
                        .addGap(18, 18, 18)
                        .addComponent(btnDone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(btnArchive)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelivery)
                    .addComponent(btnNewOrder)
                    .addComponent(btnDone)
                    .addComponent(btnArchive))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String txt = txtSearch.getText();
            tblCustomerRefresh(txt);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        if (oid == -1) {
            JOptionPane.showMessageDialog(null, "Selected item is invalid.");
        }else{
            int statu = db.orderStatuChange(oid, 3);
            if (statu == 1) {
                tblOrderRefresh();
                tblCustomerRefresh();
                oid = -1;
                JOptionPane.showMessageDialog(null, "Order status changed as 'done'.");
            }
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCustomerInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerInsertActionPerformed
        
        CustomerInsert ui = new CustomerInsert();
        ui.setVisible(true);
    }//GEN-LAST:event_btnCustomerInsertActionPerformed
    
    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        int row = tblCustomer.getSelectedRow();
        cid = (int) tblCustomer.getValueAt(row, 0);
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void btnCustomerDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDeleteActionPerformed
        if (cid == -1) {
            JOptionPane.showMessageDialog(null, "Selected item is invalid.");
        }else{
            int statu = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?");
            if (statu == 0) {
                int deleteStatu = db.customerDelete(cid);
                if (deleteStatu == 1) {
                    tblOrderRefresh();
                    tblCustomerRefresh();
                    cid = -1;
                    JOptionPane.showMessageDialog(null, "The item deleted successfully.");
                }
            }
        }
    }//GEN-LAST:event_btnCustomerDeleteActionPerformed

    private void btnCustomerUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerUpdateActionPerformed
        
        if (cid == -1) {
            JOptionPane.showMessageDialog(null, "Selected item is invalid.");
        }else{
            int row = tblCustomer.getSelectedRow();
            CustomerUpdate.cid = (int) tblCustomer.getValueAt(row, 0);
            CustomerUpdate.name = "" + tblCustomer.getValueAt(row, 1);
            CustomerUpdate.mail = "" + tblCustomer.getValueAt(row, 2);
            CustomerUpdate.tel = "" + tblCustomer.getValueAt(row, 3);
            CustomerUpdate.address = "" + tblCustomer.getValueAt(row, 4);
            
            CustomerUpdate cu = new CustomerUpdate();
            cu.setVisible(true);
            
        }
    }//GEN-LAST:event_btnCustomerUpdateActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        if ( cid == -1 ){
            JOptionPane.showMessageDialog(null, "Selected item is invalid.");
        }else{
            int piece = Integer.valueOf(JOptionPane.showInputDialog(null,"Enter the piece"));
            int statu = db.newOrder(cid, piece);
            
            if (statu == 1) {
                tblOrderRefresh();
                tblCustomerRefresh();
                cid=-1;
                JOptionPane.showMessageDialog(null, "Order successfully added.");
            }
        }
    }//GEN-LAST:event_btnNewOrderActionPerformed
    
    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        int row = tblOrder.getSelectedRow();
        oid = (int) tblOrder.getValueAt(row, 0);
    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        if (oid == -1) {
            JOptionPane.showMessageDialog(null, "Selected item is invalid.");
        }else{
            int statu = db.orderStatuChange(oid, 2);
            if (statu == 1) {
                tblOrderRefresh();
                oid = -1;
                JOptionPane.showMessageDialog(null, "Order status changed as 'delivery'.");
            }
        }
    }//GEN-LAST:event_btnDeliveryActionPerformed

    private void btnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveActionPerformed

        OrderArchive oa = new OrderArchive();
        oa.setVisible(true);
    }//GEN-LAST:event_btnArchiveActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchive;
    private javax.swing.JButton btnCustomerDelete;
    private javax.swing.JButton btnCustomerInsert;
    private javax.swing.JButton btnCustomerUpdate;
    private javax.swing.JButton btnDelivery;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
