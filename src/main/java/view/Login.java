package view;

import javax.swing.JOptionPane;

import controller.UserController;
import controller.interfaces.IUserController;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    
    public Login() {
        initComponents();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_login = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        TXTLogin = new javax.swing.JTextField();
        TXTSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_login1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STEAM VERDE");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        pnl_login.setFocusCycleRoot(true);
        pnl_login.setMinimumSize(new java.awt.Dimension(1366, 768));
        pnl_login.setPreferredSize(new java.awt.Dimension(1366, 768));
        pnl_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_login.setText("Sign In");
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        pnl_login.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 120, 30));

        TXTLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTLoginActionPerformed(evt);
            }
        });
        pnl_login.add(TXTLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 259, -1));
        pnl_login.add(TXTSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 259, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Login");
        pnl_login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 90, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Senha");
        pnl_login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 110, -1));

        btn_login1.setText("Sign Up");
        btn_login1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_login1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_login1MouseClicked(evt);
            }
        });
        btn_login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login1ActionPerformed(evt);
            }
        });
        pnl_login.add(btn_login1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 120, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        pnl_login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -140, 1360, 1040));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
 
        
        
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        String usuario = TXTLogin.getText();
        String senha = TXTSenha.getText();
        IUserController controller = new UserController();
        
        if(controller.Login(usuario, senha)) {
            Home homePage = new Home();
            homePage.setVisible(true);
            this.dispose();
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Usuário Incorreto!", "Erro", ERROR);
        }
    }//GEN-LAST:event_btn_loginMouseClicked

    private void TXTLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTLoginActionPerformed

    private void btn_login1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_login1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_login1MouseClicked

    private void btn_login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_login1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTLogin;
    private javax.swing.JPasswordField TXTSenha;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_login1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnl_login;
    // End of variables declaration//GEN-END:variables
}



