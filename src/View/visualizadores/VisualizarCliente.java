package View.visualizadores;

import Model.Pessoa.Cliente;

public class VisualizarCliente extends javax.swing.JDialog {

    public VisualizarCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        preencher(cliente);
    }
     
    private void preencher(Cliente cliente) {
        this.jLabelNome.setText(cliente.getNome());
        this.jLabelCPF.setText(cliente.getCPF());
        this.jLabelEmail.setText(cliente.getEmail());
        this.jLabelCelular.setText(cliente.getCelular());
        this.jLabelNasc.setText(cliente.getNascimento().toString());
        this.jLabelEndereco.setText(cliente.getEndereco());
        this.jLabelTelefone.setText(cliente.getTelefone());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel01 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel04 = new javax.swing.JLabel();
        jLabel05 = new javax.swing.JLabel();
        jLabel07 = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelNasc = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCelular = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNome.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabelNome.setText("Nome");

        jLabel01.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel01.setText("Endereço:");

        jLabel02.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel02.setText("CPF:");

        jLabel03.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel03.setText("Nascimento:");

        jLabel04.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel04.setText("E-mail:");

        jLabel05.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel05.setText("Celular:");

        jLabel07.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel07.setText("Telefone:");

        jLabelEndereco.setText("end");

        jLabelCPF.setText("cpf");

        jLabelNasc.setText("nas");

        jLabelEmail.setText("em");

        jLabelCelular.setText("cel");

        jLabelTelefone.setText("tel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel01)
                                    .addComponent(jLabel02)
                                    .addComponent(jLabel03))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEndereco)
                                    .addComponent(jLabelNasc)
                                    .addComponent(jLabelCPF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel04)
                                    .addComponent(jLabel05)
                                    .addComponent(jLabel07))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTelefone)
                                    .addComponent(jLabelEmail)
                                    .addComponent(jLabelCelular))
                                .addGap(101, 101, 101))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabelNome)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelNome)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel04)
                    .addComponent(jLabel01)
                    .addComponent(jLabelEndereco)
                    .addComponent(jLabelEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel02)
                    .addComponent(jLabel05)
                    .addComponent(jLabelCPF)
                    .addComponent(jLabelCelular))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel03)
                    .addComponent(jLabel07)
                    .addComponent(jLabelNasc)
                    .addComponent(jLabelTelefone))
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel04;
    private javax.swing.JLabel jLabel05;
    private javax.swing.JLabel jLabel07;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelNasc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}