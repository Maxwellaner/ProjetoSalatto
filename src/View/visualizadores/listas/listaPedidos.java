package View.visualizadores.listas;

import Controller.PedidoDAO;
import Model.Pedido;
import Util.Util;
import View.visualizadores.VisualizarPedido;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class listaPedidos extends javax.swing.JDialog {

    List<Pedido> pedidos;
    java.awt.Frame pai;

    public listaPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.setLocationRelativeTo(null);
        preencher();
    }

    private void preencher() {
        try {
            pedidos = new ArrayList<>(PedidoDAO.pedidos());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            this.jComboBoxPedidos.setModel(dfmodel);
            pedidos.forEach((p) -> {
                if (p.getIdCliente() != 0) {
                    dfmodel.addElement("Pedido n° " + p.getId() + " - " +p.getCliente().getNome() + " - Endereço: " + p.getCliente().getEndereco()
                            + " - Valor total: R$ " + Util.formatarValor(p.getValorTotal()));
                } else {
                    dfmodel.addElement("Pedido n° " + p.getId() + " - " +p.getEmpresa().getNomeFantasia() + " - Endereço: " + p.getEmpresa().getEndereco()
                            + " - Valor total: R$ " + Util.formatarValor(p.getValorTotal()));
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(listaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxPedidos = new javax.swing.JComboBox<>();
        jButtonAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setText("Pedidos");

        jComboBoxPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/abrir-pasta-com-documento.png"))); // NOI18N
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBoxPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAbrir)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed
        Pedido pedido = pedidos.get(this.jComboBoxPedidos.getSelectedIndex());
        VisualizarPedido vp = new VisualizarPedido(pai, true, pedido);
        vp.setVisible(true);
    }//GEN-LAST:event_jButtonAbrirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JComboBox<String> jComboBoxPedidos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
