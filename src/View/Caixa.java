package View;

import Controller.DespesasDAO;
import Controller.PedidoDAO;
import Model.Pedido;
import java.util.List;
import Util.Util;
import View.Cadastros.CadastrarPedido;
import View.visualizadores.VisualizarPedido;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class Caixa extends javax.swing.JDialog {

    private List<Pedido> pedidos;
    private double valorTotal;
    private double despesas;
    private double lucro;
    java.awt.Frame pai;

    public Caixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.jLabelDataAtual.setText(Util.dataAtualFormatada());
        preencherListaPedidos();
        informacoes();
        exibir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPedidosFechados = new javax.swing.JList<>();
        jButtonFecharCaixa = new javax.swing.JButton();
        jLabelValorTotal = new javax.swing.JLabel();
        jLabelDespesas = new javax.swing.JLabel();
        jLabelLucro = new javax.swing.JLabel();
        jLabelDataAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setText("Caixa");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel3.setText("Valor total: R$");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel4.setText("Despesas Diárias: R$");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel5.setText("Lucro do dia: R$");

        jListPedidosFechados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos Fechados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 3, 18))); // NOI18N
        jListPedidosFechados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListPedidosFechados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPedidosFechadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListPedidosFechados);

        jButtonFecharCaixa.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButtonFecharCaixa.setText("Fechar Caixa");
        jButtonFecharCaixa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelValorTotal.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabelValorTotal.setText("0");

        jLabelDespesas.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabelDespesas.setText("0");

        jLabelLucro.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabelLucro.setText("0");

        jLabelDataAtual.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabelDataAtual.setText("Data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFecharCaixa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelDespesas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelLucro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDataAtual)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelDataAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelValorTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelDespesas))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabelLucro))
                        .addGap(271, 271, 271)
                        .addComponent(jButtonFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListPedidosFechadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPedidosFechadosMouseClicked
        Pedido pedido = null;
        pedidos = new ArrayList<>(PedidoDAO.pedidosHoje());
        pedido = pedidos.get(jListPedidosFechados.getSelectedIndex());
        VisualizarPedido pv = new VisualizarPedido(pai, true, pedido);
        pv.setVisible(true);
    }//GEN-LAST:event_jListPedidosFechadosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFecharCaixa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDataAtual;
    private javax.swing.JLabel jLabelDespesas;
    private javax.swing.JLabel jLabelLucro;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JList<String> jListPedidosFechados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void preencherListaPedidos() {
        try {
            pedidos = new ArrayList<>(PedidoDAO.pedidosFechadosHoje());
            DefaultListModel dfmodel = new DefaultListModel();
            this.jListPedidosFechados.setModel(dfmodel);
            pedidos.forEach((p) -> {
                if (p.getIdCliente() != 0) {
                    dfmodel.addElement(p.getCliente().getNome() + " - Endereço: " + p.getCliente().getEndereco()
                            + " - Valor total: R$ " + Util.formatarValor(p.getValorTotal()));
                } else {
                    dfmodel.addElement(p.getEmpresa().getNomeFantasia() + " - Endereço: " + p.getEmpresa().getEndereco()
                            + " - Valor total: R$ " + Util.formatarValor(p.getValorTotal()));
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void informacoes() {

        double valor = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            double valorPedido = pedido.getValorTotal();
            valor += valorPedido;
        }
        valorTotal = valor;
        
        despesas = DespesasDAO.despesaDoDia();
        
        double lucroDiario = valorTotal - despesas;
        lucro = lucroDiario;
    }

    private void exibir() {
        this.jLabelValorTotal.setText(Util.formatarValor(valorTotal));
        this.jLabelLucro.setText(Util.formatarValor(lucro));
        this.jLabelDespesas.setText(Util.formatarValor(despesas));
    }
}
