package view;

import controller.CartController;
import controller.ProductController;
import controller.UserController;
import controller.interfaces.ICartController;
import controller.interfaces.IUserController;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import model.dtos.ProductCart;
import model.entity.Product;
import model.enums.Operation;

public class HomePage extends javax.swing.JFrame {

    private List<Product> produtos;
    private List<ProductCart> produtosCart;
    private int userId;

    public int getUserId() {
        return this.userId;
    }

    public HomePage() {
        initComponents();
    }

    public HomePage(int userId) {
        initComponents();
        this.userId = userId;
        DefaultTableModel tableModelProduct = (DefaultTableModel) jTableProduct.getModel();
        jTableProduct.setRowSorter(new TableRowSorter(tableModelProduct));
        addGameCategories();
        DefaultTableModel tableModelCart = (DefaultTableModel) jTableCart.getModel();
        jTableCart.setRowSorter(new TableRowSorter(tableModelCart));

        // Define o renderer e editor da coluna de ação
        jTableProduct.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer()); // Coluna de logo
        jTableProduct.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        jTableProduct.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(this));

        jTableCart.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer()); // Coluna de logo
        jTableCart.getColumnModel().getColumn(5).setCellRenderer(new ButtonCartDeleteRenderer());
        jTableCart.getColumnModel().getColumn(5).setCellEditor(new ButtonCartDeleteEditor(this));

        GetUserName();

        readJTable();
        readJTableCart();
    }

    private void addGameCategories() {
        String[] categories = {
            "Action", "Adventure", "RPG", "Simulation", "Strategy",
            "Sports", "Puzzle", "Arcade", "Platformer", "Shooter",
            "Fighting", "Horror", "Survival", "Stealth", "Open World",
            "Sandbox", "Card", "Board", "Racing", "Rhythm",
            "Educational", "Trivia", "Casual", "Multiplayer", "Singleplayer",
            "MMORPG", "MOBA", "Battle Royale", "VR", "Idle",
            "Metroidvania", "Roguelike", "Roguelite", "Point and Click", "Interactive Story",
            "Tower Defense", "Tycoon", "Hack and Slash", "Visual Novel", "Fitness"
        };

        for (String category : categories) {
            listCategories.add(category);
        }
    }

    public void updateProductTable() {
        readJTable(); // Recarrega a tabela
    }

    public void updateCartTable() {
        readJTableCart(); // Recarrega a tabela
    }

    private void GetUserName() {
        IUserController controller = new UserController();
        String user = controller.getUserName(this.userId);
        jLabelUser.setText("Welcome, " + user);
    }

    // Renderer para exibir imagens na coluna da tabela
    private static class ImageRenderer extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon(GetImage(value, 100, 100)));
            setHorizontalAlignment(CENTER);
            return this;
        }

        public Image GetImage(Object imagePath, int width, int height) {
            // Caminho relativo para a pasta resources
            String path = "/images/" + imagePath;

            try {
                // Obtém o recurso de dentro de resources
                ImageIcon icon = new ImageIcon(getClass().getResource(path));

                // Ajuste a imagem para caber na célula
                return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            } catch (Exception ex) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                ImageIcon iconDefault = new ImageIcon(getClass().getResource("/images/logo.png"));
                return iconDefault.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            }
        }
    }

    private void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTableProduct.getModel();
        modelo.setNumRows(0);
        ProductController pdao = new ProductController();

        produtos = pdao.getAll();

        for (Product p : produtos) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getImagePath(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                "Ações"
            });
        }
    }

    private void readJTableCart() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCart.getModel();
        modelo.setNumRows(0);
        ICartController controller = new CartController();
        jTableCart.setBackground(new Color(26, 42, 59));
        produtosCart = controller.getProductsInCart(this.userId);

        for (Product p : produtosCart) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getImagePath(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                "Ações"
            });
        }
    }

    // Método para obter o produto da linha
    public Product getProductAtRow(int row) {
        return produtos.get(row);
    }

    public ProductCart getProductFromCartAtRow(int row) {
        return produtosCart.get(row);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanelHome = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jTabbedPnlHome = new javax.swing.JTabbedPane();
        jPanelStore = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        txtFieldSearch = new javax.swing.JTextField();
        jPanelCategory = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listCategories = new java.awt.List();
        jLabelSearch = new javax.swing.JLabel();
        jPanelCart = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButtonBuyCart = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAdminAddBtn = new javax.swing.JMenuItem();
        jMenuItemAdminEditBtn = new javax.swing.JMenuItem();
        jMenuItemAdminDeleteBtn = new javax.swing.JMenuItem();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton1)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STEAM VERDE");
        setBackground(new java.awt.Color(15, 18, 54));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanelHome.setBackground(new java.awt.Color(15, 18, 54));

        jPanelHeader.setBackground(new java.awt.Color(15, 18, 54));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/header.png"))); // NOI18N

        jLabelUser.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setText("welcome, ");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GAMES     NEWS     COMMUNITY     PROFILE");

        jLabelExit.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setText("END SESSION");
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabelExit)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addComponent(jLabelUser)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelExit))))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPnlHome.setBackground(new java.awt.Color(15, 18, 54));

        jPanelStore.setBackground(new java.awt.Color(15, 18, 54));
        jPanelStore.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanelStore.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanelStore.setPreferredSize(new java.awt.Dimension(1280, 720));

        jTableProduct.setBackground(new java.awt.Color(26, 42, 59));
        jTableProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableProduct.setForeground(new java.awt.Color(255, 255, 255));
        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Logo", "Nome", "Descrição", "Valor", "Ação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduct.setAutoscrolls(false);
        jTableProduct.setGridColor(new java.awt.Color(26, 42, 59));
        jTableProduct.setRowHeight(100);
        jTableProduct.setShowGrid(false);
        jTableProduct.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jTableProduct);

        txtFieldSearch.setToolTipText("Procure por um nome de jogo");
        txtFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldSearchActionPerformed(evt);
            }
        });
        txtFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldSearchKeyReleased(evt);
            }
        });

        jPanelCategory.setBackground(new java.awt.Color(15, 10, 25));

        jLabel2.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("categories");

        listCategories.setBackground(new java.awt.Color(15, 10, 25));
        listCategories.setForeground(new java.awt.Color(255, 255, 255));
        listCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCategoriesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCategoryLayout = new javax.swing.GroupLayout(jPanelCategory);
        jPanelCategory.setLayout(jPanelCategoryLayout);
        jPanelCategoryLayout.setHorizontalGroup(
            jPanelCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCategoryLayout.createSequentialGroup()
                .addGroup(jPanelCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCategoryLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(jPanelCategoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCategoryLayout.setVerticalGroup(
            jPanelCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCategoryLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSearch.setText("Find a Game");

        javax.swing.GroupLayout jPanelStoreLayout = new javax.swing.GroupLayout(jPanelStore);
        jPanelStore.setLayout(jPanelStoreLayout);
        jPanelStoreLayout.setHorizontalGroup(
            jPanelStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSearch)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelStoreLayout.setVerticalGroup(
            jPanelStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStoreLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
            .addComponent(jPanelCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPnlHome.addTab("Store", jPanelStore);

        jPanelCart.setBackground(new java.awt.Color(15, 18, 54));
        jPanelCart.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCart.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanelCart.setMinimumSize(new java.awt.Dimension(1280, 720));

        jTableCart.setBackground(new java.awt.Color(26, 42, 59));
        jTableCart.setForeground(new java.awt.Color(255, 255, 255));
        jTableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Logo", "Nome", "Descrição", "Valor", "Ação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCart.setRowHeight(100);
        jScrollPane2.setViewportView(jTableCart);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("You are buying");

        jButtonBuyCart.setBackground(new java.awt.Color(0, 153, 0));
        jButtonBuyCart.setText("BUY");
        jButtonBuyCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBuyCartMouseClicked(evt);
            }
        });
        jButtonBuyCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCartLayout = new javax.swing.GroupLayout(jPanelCart);
        jPanelCart.setLayout(jPanelCartLayout);
        jPanelCartLayout.setHorizontalGroup(
            jPanelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(jPanelCartLayout.createSequentialGroup()
                .addGroup(jPanelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCartLayout.createSequentialGroup()
                        .addGap(462, 462, 462)
                        .addComponent(jButtonBuyCart, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCartLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCartLayout.setVerticalGroup(
            jPanelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuyCart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPnlHome.addTab("Cart", jPanelCart);

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addComponent(jTabbedPnlHome, javax.swing.GroupLayout.PREFERRED_SIZE, 1353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPnlHome, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHomeLayout.createSequentialGroup()
                    .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(602, Short.MAX_VALUE))
            .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHomeLayout.createSequentialGroup()
                    .addGap(354, 354, 354)
                    .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jPanelHome, java.awt.BorderLayout.CENTER);

        jMenu1.setText("ADMIN");
        jMenu1.setMinimumSize(new java.awt.Dimension(45, 19));
        jMenu1.setPreferredSize(new java.awt.Dimension(45, 30));

        jMenuItemAdminAddBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemAdminAddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adicionar.png"))); // NOI18N
        jMenuItemAdminAddBtn.setText("Add Product");
        jMenuItemAdminAddBtn.setPreferredSize(new java.awt.Dimension(10, 30));
        jMenuItemAdminAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemAdminAddBtnMouseClicked(evt);
            }
        });
        jMenuItemAdminAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdminAddBtnActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAdminAddBtn);

        jMenuItemAdminEditBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItemAdminEditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        jMenuItemAdminEditBtn.setText("Edit Product");
        jMenuItemAdminEditBtn.setPreferredSize(new java.awt.Dimension(300, 30));
        jMenuItemAdminEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdminEditBtnActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAdminEditBtn);

        jMenuItemAdminDeleteBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItemAdminDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        jMenuItemAdminDeleteBtn.setText("Remove Product");
        jMenuItemAdminDeleteBtn.setPreferredSize(new java.awt.Dimension(45, 30));
        jMenuItemAdminDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdminDeleteBtnActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAdminDeleteBtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAdminAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdminAddBtnActionPerformed
        // TODO add your handling code here:
        ProductManagerModal manager = new ProductManagerModal(this, Operation.Add);
        jLabel3.add(manager);
        manager.setVisible(true);

        manager.toFront();
        // Traz o JInternalFrame para frente
        try {
            manager.setSelected(true);// Traz o JInternalFrame para frente
        } catch (PropertyVetoException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Dá o foco ao JInternalFrame

        // Dá o foco ao JInternalFrame

    }//GEN-LAST:event_jMenuItemAdminAddBtnActionPerformed

    private void jMenuItemAdminAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemAdminAddBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAdminAddBtnMouseClicked

    private void listCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCategoriesActionPerformed

    }//GEN-LAST:event_listCategoriesActionPerformed

    private void txtFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldSearchKeyReleased
        ProductController controller = new ProductController();

        DefaultTableModel modelo = (DefaultTableModel) jTableProduct.getModel();
        modelo.setNumRows(0);

        produtos = controller.getByName(txtFieldSearch.getText());

        for (Product p : produtos) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getImagePath(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                "Ações"
            });
        }
    }//GEN-LAST:event_txtFieldSearchKeyReleased

    private void txtFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldSearchActionPerformed

    private void jButtonBuyCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyCartActionPerformed
        // TODO add your handling code here:
        ICartController controller = new CartController();
        controller.completePurchase(this.userId);
        this.updateCartTable();
        JOptionPane.showMessageDialog(this, "Compra Realizada com sucesso");
    }//GEN-LAST:event_jButtonBuyCartActionPerformed

    private void jButtonBuyCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuyCartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuyCartMouseClicked

    private void jMenuItemAdminEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdminEditBtnActionPerformed
// TODO add your handling code here:
        ProductManagerModal manager = new ProductManagerModal(this, Operation.Edit);
        jLabel3.add(manager);
        manager.setVisible(true);

        manager.toFront();
        // Traz o JInternalFrame para frente
        try {
            manager.setSelected(true);// Traz o JInternalFrame para frente
        } catch (PropertyVetoException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemAdminEditBtnActionPerformed

    private void jMenuItemAdminDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdminDeleteBtnActionPerformed
        ProductManagerModal manager = new ProductManagerModal(this, Operation.Delete);
        jLabel3.add(manager);
        manager.setVisible(true);

        manager.toFront();
        // Traz o JInternalFrame para frente
        try {
            manager.setSelected(true);// Traz o JInternalFrame para frente
        } catch (PropertyVetoException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jMenuItemAdminDeleteBtnActionPerformed

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        LoginPage login = new LoginPage();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    private static class ButtonRenderer extends JPanel implements TableCellRenderer {

        private final JButton btnCompra = new JButton("BUY");
        private final JButton btnCarrinho = new JButton();
        private final ImageRenderer renderer = new ImageRenderer();

        public ButtonRenderer() {
            setAlignmentY(CENTER);
            setAlignmentX(CENTER);
            setBackground(new Color(26, 42, 59));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            btnCompra.setAlignmentY(CENTER_ALIGNMENT);
            btnCompra.setBackground(Color.GREEN);
            btnCompra.setSize(100, 30);
            btnCarrinho.setIcon(new ImageIcon(renderer.GetImage("carrinho.png", 30, 30)));
            add(btnCompra);
            add(btnCarrinho);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return this;
        }
    }

    private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private final JPanel panel = new JPanel();
        private final JButton btnCompra = new JButton("BUY");
        private final JButton btnCarrinho = new JButton();
        private final ImageRenderer renderer = new ImageRenderer();

        public ButtonEditor(HomePage home) {
            setBackground(new Color(26, 42, 59));
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            btnCompra.setBackground(Color.GREEN);
            btnCompra.setSize(70, 20);
            btnCarrinho.setIcon(new ImageIcon(renderer.GetImage("carrinho.png", 30, 30)));
            panel.add(btnCompra);
            panel.add(btnCarrinho);

            // Configura os eventos de ação dos botões
            btnCompra.addActionListener((ActionEvent e) -> {
                int row = jTableProduct.getSelectedRow();
                Product produto = home.getProductAtRow(row);
                JOptionPane.showMessageDialog(panel, produto.getName() + " purchased successfully, key will be sent by email");
                stopCellEditing();
            });

            btnCarrinho.addActionListener((ActionEvent e) -> {
                int row = jTableProduct.getSelectedRow();
                Product produto = home.getProductAtRow(row); // Obter o produto
                ICartController controller = new CartController();
                controller.addProductToCart(home.getUserId(), produto.getId());
                home.updateCartTable();
                JOptionPane.showMessageDialog(panel, "Added to cart: " + produto.getName());
                stopCellEditing();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }

    private static class ButtonCartDeleteRenderer extends JPanel implements TableCellRenderer {

        private final JButton btnDelete = new JButton();
        private final ImageRenderer renderer = new ImageRenderer();

        public ButtonCartDeleteRenderer() {
            setBackground(new Color(26, 42, 59));
            btnDelete.setSize(25, 25);
            btnDelete.setIcon(new ImageIcon(renderer.GetImage("excluir.png", 20, 20)));
            add(btnDelete);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return this;
        }
    }

    private class ButtonCartDeleteEditor extends AbstractCellEditor implements TableCellEditor {

        private final JPanel panel = new JPanel();
        private final JButton btnDelete = new JButton();
        private final ImageRenderer renderer = new ImageRenderer();

        public ButtonCartDeleteEditor(HomePage home) {
            setBackground(new Color(26, 42, 59));
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            btnDelete.setSize(25, 25);
            btnDelete.setIcon(new ImageIcon(renderer.GetImage("excluir.png", 20, 20)));
            panel.add(btnDelete);

            // Configura os eventos de ação dos botões
            btnDelete.addActionListener((ActionEvent e) -> {
                int row = jTableCart.getSelectedRow();
                ProductCart produto = home.getProductFromCartAtRow(row);
                ICartController controller = new CartController();
                controller.removeProductFromCart(produto.getIdCart(), home.userId, produto.getId());
                stopCellEditing();
                readJTableCart();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuyCart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAdminAddBtn;
    private javax.swing.JMenuItem jMenuItemAdminDeleteBtn;
    private javax.swing.JMenuItem jMenuItemAdminEditBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelCart;
    private javax.swing.JPanel jPanelCategory;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelStore;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPnlHome;
    private javax.swing.JTable jTableCart;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTextField jTextField1;
    private java.awt.List listCategories;
    private javax.swing.JTextField txtFieldSearch;
    // End of variables declaration//GEN-END:variables
}
