package View.visualizadores.listas;

import Controller.ProdutoDAO;
import Model.Produto;
import View.visualizadores.VisualizarProduto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class listaProdutos extends javax.swing.JDialog {

    List<Produto> produtos;
    java.awt.Frame pai;
    
    public listaProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        preencherLista();
    }
    
    public void preencherLista() {
        try {
            produtos = new ArrayList<>(ProdutoDAO.listarProdutos());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            this.jComboBoxProdutos.setModel(dfmodel);
            produtos.forEach((p) -> {
                dfmodel.addElement(p.getId() + ". " + p.getNome() + " - " + p.getQuantidadeEstoque());
            });
        } catch (Exception ex) {
            Logger.getLogger(listaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxProdutos = new javax.swing.JComboBox<>();
        jButtonAbrirProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setText("Produtos");

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAbrirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/abrir-pasta-com-documento.png"))); // NOI18N
        jButtonAbrirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAbrirProduto)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButtonAbrirProduto)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbrirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirProdutoActionPerformed
        Produto p = produtos.get(this.jComboBoxProdutos.getSelectedIndex());
        VisualizarProduto vp = new VisualizarProduto(pai, true, p);
        vp.setVisible(true);
    }//GEN-LAST:event_jButtonAbrirProdutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirProduto;
    private javax.swing.JComboBox<String> jComboBoxProdutos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
