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
        jSeparator2 = new javax.swing.JSeparator();

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

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel01)
                                                .addGap(22, 22, 22))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel02)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelCPF)
                                            .addComponent(jLabelEndereco)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel03)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNasc)
                                        .addGap(3, 3, 3)))))
                        .addGap(119, 119, 119)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel05)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCelular))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel07)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTelefone))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel04)
                                .addGap(24, 24, 24)
                                .addComponent(jLabelEmail)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelNome)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel01)
                            .addComponent(jLabelEndereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel02)
                            .addComponent(jLabelCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel03)
                            .addComponent(jLabelNasc))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel05)
                            .addComponent(jLabelCelular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel07)
                            .addComponent(jLabelTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel04)
                            .addComponent(jLabelEmail)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}