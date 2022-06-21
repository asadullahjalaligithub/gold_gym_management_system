package GoldGymManagementSystem;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatusPage extends javax.swing.JFrame {
Statement st;
ResultSet result;
DatabaseConnection db;
    public StatusPage() {
        initComponents();
        db = new DatabaseConnection();
        this.centeringTheForm();
        this.loadTable("","");
        if(LoginPage.rid==200)
        {
           this.addusermenu.setEnabled(false);
           this.addintervalmenu.setEnabled(false);
           this.addpackagemenu.setEnabled(false);
          }
         this.mytable.addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int row = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
          // new ViewClientPage().setVisible(true);
        }
    }
});
    }
  
    
    // centering the form
    public  void centeringTheForm(){
    Dimension screenSize,frameSize;
int x,y;
screenSize=Toolkit.getDefaultToolkit().getScreenSize();
frameSize=getSize();
x=(screenSize.width-frameSize.width)/2;
y=(screenSize.height-frameSize.height)/2;
setLocation(x, y);
}
    // loading the contents
    public void loadTable(String clause,String key){
        String query;
        if(clause.compareTo("Name")==0) 
         query="SELECT package.*, shift.*, register.*, sportsman.* from package inner join register on register.pid=package.pid inner join shift on shift.shiftid=register.shiftid inner join sportsman on sportsman.sid=register.sid where sportsman.sname like '%"+key+"%' or sportsman.slastname like '%"+key+"%'";
        else if(clause.compareTo("NID")==0)
                     query="SELECT package.*, shift.*, register.*, sportsman.* from package inner join register on register.pid=package.pid inner join shift on shift.shiftid=register.shiftid inner join sportsman on sportsman.sid=register.sid where sportsman.snid like '%"+key+"%'";
        else
            query="SELECT package.*, shift.*, register.*, sportsman.* from package inner join register on register.pid=package.pid inner join shift on shift.shiftid=register.shiftid inner join sportsman on sportsman.sid=register.sid";
            
         int count,rowIndex=0;
            try {
             st = db.con.createStatement();
             result=st.executeQuery(query);
            result.next();
            result.last();
            count=result.getRow();// obtaining the number of rows in the table
            result.beforeFirst();
             String Data[][] = new String[count][10];

             while(result.next())
             {
                 Data[rowIndex][0] = String.valueOf(result.getInt("sid"));
                 Data[rowIndex][1]=result.getString("sname");
                 Data[rowIndex][2]=result.getString("slastname");
                 Data[rowIndex][3]=result.getString("sdob");
                 Data[rowIndex][4]=result.getString("sgender");
                 Data[rowIndex][5]=result.getString("snid");
                 Data[rowIndex][6]=result.getString("sstart");
                 Data[rowIndex][7]=result.getString("send");
                 Data[rowIndex][8]=result.getString("pname");
                 Data[rowIndex][9]=String.valueOf(result.getInt("pfee"));
                 rowIndex++;
             }
             String cols[] = {"ID","First Name","Last Name","DOB","Gender","NID","Start","End","Package Name","Fee"};
             DefaultTableModel table = new DefaultTableModel(Data,cols);
             this.mytable.setModel(table);}
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        registerMenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        addintervalmenu = new javax.swing.JMenuItem();
        addpackagemenu = new javax.swing.JMenuItem();
        addusermenu = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Athaletes Status");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        mytable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(mytable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Search");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "NID" }));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        registerMenu.setText("Register Athalete");
        registerMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMenuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerMenuMousePressed(evt);
            }
        });
        jMenu1.add(registerMenu);

        jMenuItem2.setText("Register Clients");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        addintervalmenu.setText("Add Interval");
        addintervalmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addintervalmenuMousePressed(evt);
            }
        });
        jMenu1.add(addintervalmenu);

        addpackagemenu.setText("Add Packages");
        addpackagemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpackagemenuActionPerformed(evt);
            }
        });
        jMenu1.add(addpackagemenu);

        addusermenu.setText("Add User");
        addusermenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addusermenuActionPerformed(evt);
            }
        });
        jMenu1.add(addusermenu);

        jMenuItem9.setText("Log Out");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem9MousePressed(evt);
            }
        });
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Help");

        jMenuItem11.setText("About");
        jMenu4.add(jMenuItem11);

        jMenuItem1.setText("Contact Us");
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        String key=this.jTextField1.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
          
        String  whereClause=this.jComboBox1.getSelectedItem().toString();
       //   JOptionPane.showMessageDialog(null,whereClause);
           this.loadTable(whereClause, key);
        }
        else if(key.compareTo("")==0)
                {
                 this.loadTable("","");
                }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void registerMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMenuMouseClicked
    
    }//GEN-LAST:event_registerMenuMouseClicked

    private void registerMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMenuMousePressed

        new RegisterAthlate().setVisible(true);
    }//GEN-LAST:event_registerMenuMousePressed

    private void addintervalmenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addintervalmenuMousePressed
        new IntervalPage().setVisible(true);
    }//GEN-LAST:event_addintervalmenuMousePressed

    private void addpackagemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpackagemenuActionPerformed
       new PackagePage().setVisible(true);
    }//GEN-LAST:event_addpackagemenuActionPerformed

    private void addusermenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addusermenuActionPerformed
        new UserPage().setVisible(true);
    }//GEN-LAST:event_addusermenuActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
      
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MousePressed
       this.dispose();
       new LoginPage().setVisible(true);
    }//GEN-LAST:event_jMenuItem9MousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
       new RegisterClients().setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      this.loadTable("", "");
    }//GEN-LAST:event_formWindowActivated

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatusPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addintervalmenu;
    private javax.swing.JMenuItem addpackagemenu;
    private javax.swing.JMenuItem addusermenu;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable mytable;
    private javax.swing.JMenuItem registerMenu;
    // End of variables declaration//GEN-END:variables
}
