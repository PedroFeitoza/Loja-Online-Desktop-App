package view;

import controller.ProductController;
import controller.interfaces.IProductController;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.enums.Operation;

public class ProductManagerModal extends javax.swing.JInternalFrame {

    private HomePage home;
    private Operation operation;

    public ProductManagerModal(HomePage home, Operation op) {
        this.home = home;
        this.operation = op;
        initComponents();
        setupModal();
    }

    private void setupModal() {
        this.setTitle(this.getTitle() + " " + operation);

        // Configurações dos campos com base na operação
        switch (operation) {
            case Add:
                jTextFieldId.setEnabled(false);
                break;
            case Edit:
                // Configure as opções necessárias para edição
                break;
            case Delete:
                disableFieldsForDeletion();
                break;
            default:
                throw new AssertionError("Operação não suportada: " + operation);
        }
    }

    private void disableFieldsForDeletion() {
        jTextFieldImage.setEnabled(false);
        jTextFieldDescription.setEnabled(false);
        jTextFieldName.setEnabled(false);
        jTextFieldPrice.setEnabled(false);
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
        jButtonSave = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldImage = new javax.swing.JTextField();
        jTextFieldDescription = new javax.swing.JTextField();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Product Manager");
        setInheritsPopupMenu(true);
        setVisible(true);

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Description");

        jLabel2.setText("Image Path");

        jLabel3.setText("Name");

        jLabel4.setText("Price");

        jLabel5.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSave)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addContainerGap(262, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldImage, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSave))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        IProductController controller = new ProductController();

        if (!validateFields()) {
            return;
        }

        switch (operation) {
            case Add:
                controller.createProduct(
                        jTextFieldName.getText(),
                        jTextFieldImage.getText(),
                        jTextFieldDescription.getText(),
                        Double.parseDouble(jTextFieldPrice.getText())
                );
                break;
            case Edit:
                controller.updateProduct(
                        Integer.parseInt(jTextFieldId.getText()),
                        jTextFieldName.getText(),
                        jTextFieldImage.getText(),
                        jTextFieldDescription.getText(),
                        Double.parseDouble(jTextFieldPrice.getText())
                );
                break;
            case Delete:
                controller.deleteProduct(Integer.parseInt(jTextFieldId.getText()));
                break;
            default:
                break;
        }

        JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        this.home.updateProductTable();
    }

    private boolean validateFields() {
        if (operation == Operation.Add || operation == Operation.Edit) {
            if (!isFieldNotEmpty(jTextFieldName, "Nome do produto é obrigatório!")
                || !isFieldNotEmpty(jTextFieldImage, "Imagem do produto é obrigatória!")
                || !isFieldNotEmpty(jTextFieldDescription, "Descrição do produto é obrigatória!")
                || !isFieldNotEmpty(jTextFieldPrice, "Preço do produto é obrigatório!")
                || !isPriceValid(jTextFieldPrice.getText())) {
                return false;
            }
        }

        if (operation == Operation.Edit && !isFieldNotEmpty(jTextFieldId, "Id é obrigatório!")) {
            return false;
        }
        return true;
    }

    private boolean isFieldNotEmpty(JTextField field, String errorMessage) {
        if (field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return false;
        }
        return true;
    }

    private boolean isPriceValid(String price) {
        try {
            double value = Double.parseDouble(price);
            if (value <= 0) {
                JOptionPane.showMessageDialog(this, "O preço deve ser um valor positivo!", "Erro", JOptionPane.ERROR_MESSAGE);
                jTextFieldPrice.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O preço deve ser um valor numérico!", "Erro", JOptionPane.ERROR_MESSAGE);
            jTextFieldPrice.requestFocus();
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldImage;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPrice;
    // End of variables declaration//GEN-END:variables
}
