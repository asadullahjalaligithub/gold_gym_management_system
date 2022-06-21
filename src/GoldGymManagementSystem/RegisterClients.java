package GoldGymManagementSystem;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RegisterClients extends javax.swing.JFrame {

Statement st;
ResultSet result;
DatabaseConnection db;
PreparedStatement pst;
public static int selectedpid=-1,selectedshiftid=-1,selectedsid=-1;
    public RegisterClients() {
        initComponents();
        db = new DatabaseConnection();
       this.loadTable();
       this.centeringTheForm();
    }
    public  void centeringTheForm(){
    Dimension screenSize,frameSize;
int x,y;
screenSize=Toolkit.getDefaultToolkit().getScreenSize();
frameSize=getSize();
x=(screenSize.width-frameSize.width)/2;
y=(screenSize.height-frameSize.height)/2;
setLocation(x, y);
}
    private void clearAll(){
        this.selectclientlabel.setText("Select an Athalete");
        this.selectpackagelabel.setText("Select a Package");
        this.selectshiftlabel.setText("Select a Shift");
        selectedpid=-1;
        selectedshiftid=-1;
        selectedsid=-1;
        this.clientid.setText("");
        this.savebutton.setEnabled(true);
        this.deletebutton.setEnabled(false);
        this.updatebutton.setEnabled(false);
        
    }
    
public void loadTable(){
               
        String query="SELECT package.*, shift.*, register.*, sportsman.* from package inner join register on register.pid=package.pid inner join shift on shift.shiftid=register.shiftid inner join sportsman on sportsman.sid=register.sid ";
     
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
                 Data[rowIndex][0] = String.valueOf(result.getInt("rid"));
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
             this.jTable1.setModel(table);}
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"No Records Found!"+ex.getMessage());
       }
           
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectclientlabel = new javax.swing.JLabel();
        selectpackagelabel = new javax.swing.JLabel();
        selectshiftlabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        savebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        clientid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Client Form");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Registered Athalete");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Package");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Shift");

        selectclientlabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectclientlabel.setText("Select an Athelate");
        selectclientlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectclientlabelMouseClicked(evt);
            }
        });

        selectpackagelabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectpackagelabel.setText("Select a Package");
        selectpackagelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectpackagelabelMouseClicked(evt);
            }
        });

        selectshiftlabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectshiftlabel.setText("Select a Shift");
        selectshiftlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectshiftlabelMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Client ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        savebutton.setText("Save");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });

        deletebutton.setText("Delete");
        deletebutton.setEnabled(false);
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        updatebutton.setText("Update");
        updatebutton.setEnabled(false);
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        clearbutton.setText("Clear");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        clientid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clientid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clientid, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(238, 238, 238)
                                .addComponent(savebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selectclientlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectpackagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectshiftlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(229, 229, 229)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(updatebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savebutton)
                        .addComponent(clientid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectclientlabel))
                    .addComponent(deletebutton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectpackagelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updatebutton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(selectshiftlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearbutton))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
         if(selectedpid==-1 || selectedshiftid==-1 || selectedsid==-1)
        {
            JOptionPane.showMessageDialog(null,"The form is incomplete");
        }
        else {        

          String query="insert into register(pid,sid,shiftid) values(?,?,?)";
        try {
          PreparedStatement  pst = db.con.prepareCall(query);
          pst.setInt(1, selectedpid);
          pst.setInt(2, selectedsid);
          pst.setInt(3, selectedshiftid);
          pst.execute();
           JOptionPane.showMessageDialog(null,"Client Inserted Successfully");
            clearAll();
            pst.close();
            this.loadTable();
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Failed to Insert the record "+ex);
        }
    }
    }//GEN-LAST:event_savebuttonActionPerformed

    private void selectclientlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectclientlabelMouseClicked
       new SelectAthaletePage().setVisible(true);
    }//GEN-LAST:event_selectclientlabelMouseClicked

    private void selectpackagelabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectpackagelabelMouseClicked
        new SelectPackagePage().setVisible(true);
    }//GEN-LAST:event_selectpackagelabelMouseClicked

    private void selectshiftlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectshiftlabelMouseClicked
        new SelectShiftPage().setVisible(true);
    }//GEN-LAST:event_selectshiftlabelMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
      
           
    
    }//GEN-LAST:event_formFocusGained
public void selection(){
      if(selectedpid!=-1)
           this.selectpackagelabel.setText("Selected");
       if(selectedshiftid!=-1)
           this.selectshiftlabel.setText("Selected");
       if(selectedsid!=-1)
           this.selectclientlabel.setText("Selected");
}
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    this.selection();
    }//GEN-LAST:event_formWindowActivated

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        
       String cid=this.clientid.getText();
       if(cid.equals("")==true) {
            JOptionPane.showMessageDialog(null,"The form is incomplete");
        }
        else {        

          String query="delete from  register where rid="+cid;
        try {
            st = db.con.createStatement();
            
        st.execute(query);
           JOptionPane.showMessageDialog(null,"Client Deleted Successfully Successfully");
            clearAll();
            st.close();
            this.loadTable();
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Failed to Insert the record "+ex);
        }
    }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
          String rid = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
          this.savebutton.setEnabled(false);
     String query = "select * from register where rid='"+rid+"'";
     try {
         st = db.con.createStatement();
         result=st.executeQuery(query);
         result.next();
         this.clientid.setText(result.getInt("rid")+"");
        selectedpid=result.getInt("pid");
        selectedshiftid=result.getInt("shiftid");
        selectedsid=result.getInt("sid");
        this.selection();
        this.deletebutton.setEnabled(true);
        this.updatebutton.setEnabled(true);
         st.close();
         result.close();
     }
     catch(Exception ex) {
         JOptionPane.showMessageDialog(null,ex);
     }
    }//GEN-LAST:event_jTable1MouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        String cid=this.clientid.getText();
        if(selectedpid==-1 || selectedshiftid==-1 || selectedsid==-1 || cid.equals("")==true)
        {
            JOptionPane.showMessageDialog(null,"The form is incomplete");
        }
        else {        

          String query="update register set pid=?, sid=?, shiftid=? where rid='"+cid+"'";
        try {
          PreparedStatement  pst = db.con.prepareStatement(query);
          pst.setInt(1, selectedpid);
          pst.setInt(2, selectedsid);
          pst.setInt(3, selectedshiftid);
          pst.execute();
           JOptionPane.showMessageDialog(null,"Client Updated Successfully Successfully");
            clearAll();
            pst.close();
            this.loadTable();
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Failed to Insert the record "+ex);
        }
    }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        this.clearAll();
    }//GEN-LAST:event_clearbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RegisterClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterClients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel clientid;
    private javax.swing.JButton deletebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton savebutton;
    private javax.swing.JLabel selectclientlabel;
    private javax.swing.JLabel selectpackagelabel;
    private javax.swing.JLabel selectshiftlabel;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
