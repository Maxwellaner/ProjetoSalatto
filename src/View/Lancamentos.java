package View;

import View.Cadastros.CadastrarPedido;
import Controller.MateriaPrimaDAO;
import Controller.ProdutoDAO;
import Model.MateriaPrima;
import Model.Produto;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Lancamentos extends javax.swing.JDialog {

    private List<Produto> produtos = new ArrayList<>();
    private List<MateriaPrima> materiais = new ArrayList<>();

    public Lancamentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        preencherListaProdutos();
        preencherListaMaterial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButtonLancamentoProduto = new javax.swing.JButton();
        jButtonLancamentoMeterial = new javax.swing.JButton();
        jButtonBaixaProduto = new javax.swing.JButton();
        jButtonBaixaMaterial = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxProdutos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldQntLancProduto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxMateriaPrima = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldQntLancMaterial = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxProdutosBaixa = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldQntBaixaProduto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxMateriaPrimaBaixa = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldQntBaixaMaterial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamentos");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel1.setText("Lançamento de Produtos");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel2.setText("Lançamento de Materiais");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel3.setText("Baixa de Produtos");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel4.setText("Lançamentos em Estoque");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel5.setText("Baixa de Materiais");

        jButtonLancamentoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right-arrow.png"))); // NOI18N
        jButtonLancamentoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLancamentoProdutoActionPerformed(evt);
            }
        });

        jButtonLancamentoMeterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right-arrow.png"))); // NOI18N
        jButtonLancamentoMeterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLancamentoMeterialActionPerformed(evt);
            }
        });

        jButtonBaixaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right-arrow.png"))); // NOI18N
        jButtonBaixaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaixaProdutoActionPerformed(evt);
            }
        });

        jButtonBaixaMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right-arrow.png"))); // NOI18N
        jButtonBaixaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaixaMaterialActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Produto");

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Quantidade");

        jTextFieldQntLancProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQntLancProdutoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel8.setText("Material");

        jComboBoxMateriaPrima.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel9.setText("Quantidade");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel10.setText("Produto");

        jComboBoxProdutosBaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel11.setText("Quantidade");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel12.setText("Material");

        jComboBoxMateriaPrimaBaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel13.setText("Quantidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(jButtonLancamentoProduto))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(jButtonBaixaProduto))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQntLancProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jComboBoxProdutosBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldQntBaixaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jButtonLancamentoMeterial))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jButtonBaixaMaterial))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jComboBoxMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldQntLancMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jComboBoxMateriaPrimaBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jTextFieldQntBaixaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(316, 316, 316))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQntLancProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jButtonLancamentoProduto)
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxProdutosBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQntBaixaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonBaixaProduto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQntLancMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLancamentoMeterial)
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMateriaPrimaBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQntBaixaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonBaixaMaterial))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLancamentoMeterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLancamentoMeterialActionPerformed
        try {
            int quantidade = Integer.parseInt(this.jTextFieldQntLancMaterial.getText());
            MateriaPrima mp = materiais.get(this.jComboBoxMateriaPrima.getSelectedIndex());
            int idMaterial = mp.getId();
            MateriaPrimaDAO.lancarMaterialEstoque(quantidade, idMaterial);
            JOptionPane.showMessageDialog(null, "Lançado com sucesso!");
            limpar();
            preencherListaProdutos();
            preencherListaMaterial();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algo errado!");
            System.out.println("Não foi possível lançar Material");
        }
    }//GEN-LAST:event_jButtonLancamentoMeterialActionPerformed

    private void jTextFieldQntLancProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQntLancProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQntLancProdutoActionPerformed

    private void jButtonLancamentoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLancamentoProdutoActionPerformed
        try {
            int quantidade = Integer.parseInt(this.jTextFieldQntLancProduto.getText());
            Produto produto = produtos.get(this.jComboBoxProdutos.getSelectedIndex());
            int idProduto = produto.getId();
            ProdutoDAO.lancamentoProdutoEstoque(quantidade, idProduto);
            JOptionPane.showMessageDialog(null, "Lançado com sucesso!");
            limpar();
            preencherListaProdutos();
            preencherListaMaterial();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algo errado!");
            System.out.println("Não foi possível lançar Produto");
        }
    }//GEN-LAST:event_jButtonLancamentoProdutoActionPerformed

    private void jButtonBaixaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaixaProdutoActionPerformed
        try {
            int quantidade = Integer.parseInt(this.jTextFieldQntBaixaProduto.getText());
            Produto produto = produtos.get(this.jComboBoxProdutosBaixa.getSelectedIndex());
            int idProduto = produto.getId();
            ProdutoDAO.baixaProdutoEstoque(quantidade, idProduto);
            JOptionPane.showMessageDialog(null, "Baixa com sucesso!");
            limpar();
            preencherListaProdutos();
            preencherListaMaterial();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algo errado!");
            System.out.println("Não foi possível dar baixa em Produto");
        }
    }//GEN-LAST:event_jButtonBaixaProdutoActionPerformed

    private void jButtonBaixaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaixaMaterialActionPerformed
        try {
            int quantidade = Integer.parseInt(this.jTextFieldQntBaixaMaterial.getText());
            MateriaPrima mp = materiais.get(this.jComboBoxMateriaPrimaBaixa.getSelectedIndex());
            int idMaterial = mp.getId();
            MateriaPrimaDAO.baixaMaterialEstoque(quantidade, idMaterial);
            JOptionPane.showMessageDialog(null, "Baixa com sucesso!");
            limpar();
            preencherListaProdutos();
            preencherListaMaterial();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algo errado!");
            System.out.println("Não foi possível dar baixa em Material");
        }
    }//GEN-LAST:event_jButtonBaixaMaterialActionPerformed

    private void limpar() {
        this.jTextFieldQntBaixaMaterial.setText("");
        this.jTextFieldQntBaixaProduto.setText("");
        this.jTextFieldQntLancMaterial.setText("");
        this.jTextFieldQntLancProduto.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBaixaMaterial;
    private javax.swing.JButton jButtonBaixaProduto;
    private javax.swing.JButton jButtonLancamentoMeterial;
    private javax.swing.JButton jButtonLancamentoProduto;
    private javax.swing.JComboBox<String> jComboBoxMateriaPrima;
    private javax.swing.JComboBox<String> jComboBoxMateriaPrimaBaixa;
    private javax.swing.JComboBox<String> jComboBoxProdutos;
    private javax.swing.JComboBox<String> jComboBoxProdutosBaixa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextFieldQntBaixaMaterial;
    private javax.swing.JTextField jTextFieldQntBaixaProduto;
    private javax.swing.JTextField jTextFieldQntLancMaterial;
    private javax.swing.JTextField jTextFieldQntLancProduto;
    // End of variables declaration//GEN-END:variables

    private void preencherListaProdutos() {

        try {
            produtos = new ArrayList<>(ProdutoDAO.listarProdutos());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            produtos.forEach((p) -> {
                dfmodel.addElement(p.getNome() + " - " + p.getQuantidadeEstoque());
            });
            this.jComboBoxProdutos.setModel(dfmodel);
            this.jComboBoxProdutosBaixa.setModel(dfmodel);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void preencherListaMaterial() {
        try {
            materiais = new ArrayList<>(MateriaPrimaDAO.listarMateriaPrima());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            materiais.forEach((mp) -> {
                dfmodel.addElement(mp.getNome() + " - " + mp.getMarca() + " - " + mp.getQuantidadeEstoque());
            });
            this.jComboBoxMateriaPrima.setModel(dfmodel);
            this.jComboBoxMateriaPrimaBaixa.setModel(dfmodel);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
