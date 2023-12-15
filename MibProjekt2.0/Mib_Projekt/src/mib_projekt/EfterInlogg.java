/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mib_projekt;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author hillv
 */
public class EfterInlogg extends javax.swing.JFrame {
      
      private InfDB idb;
      private String epost;  
    /**
     * Creates new form EfterInlogg
     */
     public EfterInlogg() {
        initComponents();
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("funka");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

    /**
     * Creates new form EfterInlogg with email
     *
     * @param epost
     */
    public EfterInlogg(String epost) {
        initComponents();
        this.epost = epost;
        lbValkommen.setText("Välkommen, " + epost + "!");

        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("funka");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbValkommen = new javax.swing.JLabel();
        btnAndraLosenord = new javax.swing.JButton();
        txtNyttLosenord = new javax.swing.JTextField();
        lbAndraLosenord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbValkommen.setText("Välkommen!");

        btnAndraLosenord.setText("Ändra Lösenord");
        btnAndraLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraLosenordActionPerformed(evt);
            }
        });

        lbAndraLosenord.setText("Om du vill ändra lösenord:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAndraLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNyttLosenord)
                        .addComponent(lbAndraLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbValkommen, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbValkommen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbAndraLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNyttLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnAndraLosenord)
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraLosenordActionPerformed

           try {
              String nyttLosenord = txtNyttLosenord.getText();
              if( nyttLosenord.length() <= 6){
                String fraga = "UPDATE agent SET losenord ='" + nyttLosenord + "' WHERE epost = '" + epost + "'";
                idb.update(fraga);
                lbValkommen.setText("Lösenord är ändrat!");
              }
              else{
                  JOptionPane.showMessageDialog(null, "För långt lösenord!");
              }
            } 
           catch (InfException ex) 
           {
              JOptionPane.showMessageDialog(null, "Något gick fel!");
              System.out.println("Internt felmeddelande" + ex.getMessage());
              
           }
           
    }//GEN-LAST:event_btnAndraLosenordActionPerformed

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
            java.util.logging.Logger.getLogger(EfterInlogg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EfterInlogg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EfterInlogg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EfterInlogg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EfterInlogg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraLosenord;
    private javax.swing.JLabel lbAndraLosenord;
    private javax.swing.JLabel lbValkommen;
    private javax.swing.JTextField txtNyttLosenord;
    // End of variables declaration//GEN-END:variables
}