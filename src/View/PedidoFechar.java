package View;

import Controller.PedidoDAO;
import Model.Pedido;
import Model.Produto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PedidoFechar extends javax.swing.JDialog {

    private final Pedido pedido;

    public PedidoFechar(java.awt.Frame parent, boolean modal, Pedido pedido) {
        super(parent, modal);
        initComponents();
        this.pedido = pedido;
        this.setLocationRelativeTo(null);
        preencherView();
    }

    private void preencherView() {
        this.jLabelNumPedido.setText(Integer.toString(pedido.getId()));
        this.jLabelDataPedido.setText(pedido.getDataPedido().toString());
        this.jLabelDataEntrega.setText(pedido.getDataEntrega().toString());
        this.jLabelValor.setText(Double.toString(pedido.getValorTotal()));
        this.jLabelAdiantamento.setText(Double.toString(pedido.getAdiantamento()));

        if (pedido.getEmpresa() != null) {
            this.jLabelEndereco.setText(pedido.getEmpresa().getEndereco());
            this.jLabelEmail.setText(pedido.getEmpresa().getEmailComercial());
            this.jLabelNome.setText(pedido.getEmpresa().getNomeFantasia());
            this.jLabelContato.setText(pedido.getEmpresa().getCelularComercial() + "/" + pedido.getEmpresa().getTelefoneComercial());
        } else {
            this.jLabelEndereco.setText(pedido.getCliente().getEndereco());
            this.jLabelEmail.setText(pedido.getCliente().getEmail());
            this.jLabelNome.setText(pedido.getCliente().getNome());
            this.jLabelContato.setText(pedido.getCliente().getCelular() + "/" + pedido.getCliente().getTelefone());
        }
        DefaultTableModel dfmodel = (DefaultTableModel) jTableProdutos.getModel();

        for (int i = 0; i < pedido.getProdutos().size(); i++) {
            Produto produto = pedido.getProdutos().get(i);
            Object quantidade = pedido.getProdutos().get(i).getQuantidadePorPedido();
            Object[] dados = {produto.getNome(), quantidade};
            dfmodel.addRow(dados);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelNumPedido = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelContato = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jButtonImprimir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelAdiantamento = new javax.swing.JLabel();
        jLabelDataPedido = new javax.swing.JLabel();
        jLabelDataEntrega = new javax.swing.JLabel();
        jButtonFecharPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setText("Pedido nº: ");

        jLabelNumPedido.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabelNumPedido.setText("0");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel3.setText("Cliente/Empresa:");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel5.setText("Contato:");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel6.setText("E-mail:");

        jLabelNome.setText("Nome");

        jLabelEndereco.setText("endereco");

        jLabelContato.setText("conato");

        jLabelEmail.setText("email");

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableProdutos);
        if (jTableProdutos.getColumnModel().getColumnCount() > 0) {
            jTableProdutos.getColumnModel().getColumn(0).setResizable(false);
            jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(300);
            jTableProdutos.getColumnModel().getColumn(1).setResizable(false);
            jTableProdutos.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        jButtonImprimir.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jButtonImprimir.setText("Imprimir");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel2.setText("Valor:");

        jLabelValor.setText("valor");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel7.setText("Adiantamento:");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel8.setText("Data do pedido:");

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel9.setText("Data de entrega:");

        jLabelAdiantamento.setText("adiantamento");

        jLabelDataPedido.setText("datapedido");

        jLabelDataEntrega.setText("dataentrega");

        jButtonFecharPedido.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jButtonFecharPedido.setText("Fechar Pedido");
        jButtonFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelEndereco)
                    .addComponent(jLabelContato)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelAdiantamento)
                    .addComponent(jLabelDataPedido)
                    .addComponent(jLabelDataEntrega)
                    .addComponent(jLabelValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonImprimir)
                        .addGap(23, 23, 23)
                        .addComponent(jButtonFecharPedido))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNumPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNumPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonImprimir)
                            .addComponent(jButtonFecharPedido))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelEndereco))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabelContato))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabelEmail))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabelAdiantamento))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabelDataPedido))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabelDataEntrega))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabelValor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharPedidoActionPerformed
        try {
            PedidoDAO.fechaPedido(pedido.getId());
            JOptionPane.showMessageDialog(null, "Pedido fechado");
        } catch (Exception e) {
            System.out.println("Pedido não pôde ser fechado...");
        }
        this.dispose();
    }//GEN-LAST:event_jButtonFecharPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFecharPedido;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdiantamento;
    private javax.swing.JLabel jLabelContato;
    private javax.swing.JLabel jLabelDataEntrega;
    private javax.swing.JLabel jLabelDataPedido;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumPedido;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableProdutos;
    // End of variables declaration//GEN-END:variables
}
