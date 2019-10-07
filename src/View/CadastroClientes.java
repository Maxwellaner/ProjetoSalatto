package View;

import Controller.ClienteDAO;
import Model.Pessoa.Cliente;
import Util.Util;
import javax.swing.JOptionPane;

public class CadastroClientes extends javax.swing.JDialog {

    public CadastroClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    CadastroClientes() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtEnderecoCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        jButtonCadastroCliente = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField(Util.Mascara("###.###.###-##"));
        txtNascimentoCliente = new javax.swing.JFormattedTextField(Util.Mascara("##/##/####"));
        txtCelularCliente = new javax.swing.JFormattedTextField(Util.Mascara("(##)########"));
        txtTelefoneCliente = new javax.swing.JFormattedTextField(Util.Mascara("(##)########"));
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(310, 40, 238, 32);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(116, 80, 686, 10);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel2.setText("Nome proprietário *");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(231, 145, 140, 19);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel4.setText("CPF *");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(231, 193, 40, 19);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel5.setText("Endereço *");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(231, 241, 80, 19);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel7.setText("Data nascimento");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(231, 436, 130, 19);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel8.setText("Telefone");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(231, 340, 59, 19);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel9.setText("Celular/WhatsApp * ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(231, 292, 150, 19);

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel10.setText("E-mail *");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(231, 388, 60, 19);

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel14.setText("Proprietário (Pessoa física)");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(310, 100, 235, 24);

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });
        txtNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtNomeCliente);
        txtNomeCliente.setBounds(231, 167, 365, 20);
        jPanel1.add(txtEnderecoCliente);
        txtEnderecoCliente.setBounds(231, 266, 365, 20);
        jPanel1.add(txtEmailCliente);
        txtEmailCliente.setBounds(231, 410, 365, 20);

        jButtonCadastroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar.png"))); // NOI18N
        jButtonCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCadastroCliente);
        jButtonCadastroCliente.setBounds(706, 504, 57, 33);
        jPanel1.add(txtCPF);
        txtCPF.setBounds(231, 215, 365, 20);
        jPanel1.add(txtNascimentoCliente);
        txtNascimentoCliente.setBounds(231, 458, 365, 20);
        jPanel1.add(txtCelularCliente);
        txtCelularCliente.setBounds(231, 314, 365, 20);
        jPanel1.add(txtTelefoneCliente);
        txtTelefoneCliente.setBounds(231, 362, 365, 20);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jLabel3.setText("* Campos obrigatórios");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(490, 500, 110, 15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed

    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void jButtonCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroClienteActionPerformed
        Cliente cliente = new Cliente();
        if ("".equalsIgnoreCase(this.txtNomeCliente.getText()) || "".equalsIgnoreCase(this.txtCPF.getText()) || 
                "".equalsIgnoreCase(this.txtEnderecoCliente.getText()) || "".equalsIgnoreCase(this.txtCelularCliente.getText()) 
                || "".equalsIgnoreCase(this.txtEmailCliente.getText())) { 
            JOptionPane.showMessageDialog(null, "Preencha corretamente os campos marcados com *");
        } else {
            cliente.setNome(this.txtNomeCliente.getText());
            cliente.setCPF(this.txtCPF.getText());
            cliente.setEndereco(this.txtEnderecoCliente.getText());
            cliente.setCelular(this.txtCelularCliente.getText());
            cliente.setEmail(this.txtEmailCliente.getText());
            cliente.setNascimento(Util.stringToDate(this.txtNascimentoCliente.getText()));
            cliente.setTelefone(this.txtTelefoneCliente.getText());
            
            ClienteDAO.cadastraCliente(cliente);
        }

        limpar();
    }//GEN-LAST:event_jButtonCadastroClienteActionPerformed

    private void txtNomeClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeClienteKeyTyped
        String s = "0123456789";

        if (s.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNomeClienteKeyTyped

    private void limpar() {
        this.txtCPF.setText("");
        this.txtNomeCliente.setText("");
        this.txtEnderecoCliente.setText("");
        this.txtCelularCliente.setText("");
        this.txtTelefoneCliente.setText("");
        this.txtEmailCliente.setText("");
        this.txtNascimentoCliente.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastroCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCelularCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEnderecoCliente;
    private javax.swing.JFormattedTextField txtNascimentoCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JFormattedTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
