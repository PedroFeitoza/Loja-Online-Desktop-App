package view;

import javax.swing.JOptionPane;
import controller.UserController;
import controller.interfaces.IUserController;

public class LoginPage extends javax.swing.JFrame {

    private final IUserController userController;

    public LoginPage(IUserController userController) {
        this.userController = userController;
        initComponents();
    }

    public LoginPage() {
        this(new UserController());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_login = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        TXTLogin = new javax.swing.JTextField();
        TXTSenha = new javax.swing.JPasswordField();
        jLabelLogin = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        btn_register = new javax.swing.JButton();
        jLabelBackgroud = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STEAM VERDE");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        pnl_login.setFocusCycleRoot(true);
        pnl_login.setMinimumSize(new java.awt.Dimension(1366, 768));
        pnl_login.setPreferredSize(new java.awt.Dimension(1366, 768));
        pnl_login.setRequestFocusEnabled(false);
        pnl_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_login.setText("Sign In");
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_login.addActionListener(evt -> performLogin());
        pnl_login.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 120, 30));

        pnl_login.add(TXTLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 259, -1));
        pnl_login.add(TXTSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 259, -1));

        jLabelLogin.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabelLogin.setForeground(new java.awt.Color(242, 242, 242));
        jLabelLogin.setText("Login");
        pnl_login.add(jLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 90, 30));

        jLabelSenha.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabelSenha.setForeground(new java.awt.Color(242, 242, 242));
        jLabelSenha.setText("Senha");
        pnl_login.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 110, -1));

        btn_register.setText("Sign Up");
        btn_register.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_register.addActionListener(evt -> openRegisterPage());
        pnl_login.add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 120, 30));

        jLabelBackgroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo.png")));
        jLabelBackgroud.setText("jLabel3");
        pnl_login.add(jLabelBackgroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -140, 1360, 1040));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void performLogin() {
        String username = TXTLogin.getText().trim();
        String password = new String(TXTSenha.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o login e a senha.", "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int userId = userController.login(username, password);
            if (userId > 0) {
                openHomePage(userId);
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar fazer login: " + e.getMessage(), "Erro de Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openHomePage(int userId) {
        HomePage homePage = new HomePage(userId);
        homePage.setVisible(true);
        this.dispose();
    }

    private void openRegisterPage() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LoginPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTLogin;
    private javax.swing.JPasswordField TXTSenha;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabelBackgroud;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPanel pnl_login;
    // End of variables declaration//GEN-END:variables
}
