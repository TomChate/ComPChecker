
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luke
 */
public class ChooseComponent extends javax.swing.JFrame {

    /**
     * Creates new form ChooseComponent
     */
    public ChooseComponent() throws ClassNotFoundException, NoSuchMethodException, 
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        //initComponents();
        
        //Connection con = DatabaseConnection.establishConnection();
        
        DefaultTableModel model = (DefaultTableModel) tblComponents.getModel();
        model.setRowCount(0);   //Resets rows each time form is opened
        
        //Trying to sort out creating a class from the passed variable
        EditBuild myBuild = new EditBuild();
        String className = myBuild.getPart();
        Class cl = Class.forName(className);
        Constructor cons = cl.getConstructor(String.class, String.class);
        Object myPart = cons.newInstance();
        
        System.out.println(myPart);
        
//        CPU cpu = new CPU(); //Need to setup the class (If we're doing it that way)
//        
//        ResultSet rs;
//        Make make = new Make();
//        rs = make.getMakes();
//        try {
//            while (rs.next()) {
//                String dbMake = rs.getString("Name");
//
//            }
//        } catch (SQLException err) {
//            System.out.println(err.getMessage());   //Prints out SQL error 
//        }
//        
//        String[][] CPUs = a.getCPUs();//Here is where you'd get the result set
//        for (String[] row : CPUs) {
//            model.addRow(row);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblComponents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblComponents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Brand", "Name", "Price", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblComponents);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ChooseComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChooseComponent().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ChooseComponent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(ChooseComponent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ChooseComponent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ChooseComponent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ChooseComponent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(ChooseComponent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComponents;
    // End of variables declaration//GEN-END:variables
}
