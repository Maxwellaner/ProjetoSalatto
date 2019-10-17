package View.visualizadores.listas;

import Controller.EmpresaDAO;
import Model.Empresa;
import View.visualizadores.VisualizarEmpresa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class listaEmpresas extends javax.swing.JDialog {

    List<Empresa> empresas;
    java.awt.Frame pai;
    
    public listaEmpresas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        preencherLista();
    }
    
    private void preencherLista() {
        try {
            empresas = new ArrayList<>(EmpresaDAO.listarEmpresas());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            this.jComboBoxEmpresas.setModel(dfmodel);
            empresas.forEach((e) -> {
                dfmodel.addElement(e.getNomeFantasia() + " - " + e.getCnpj() + " - " + e.getEndereco() + " - "
                        + e.getCelularComercial() + "/" + e.getTelefoneComercial());
            });
        } catch (Exception ex) {
            Logger.getLogger(listaEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxEmpresas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel1.setText("Empresas");

        jComboBoxEmpresas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/abrir-pasta-com-documento.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Empresa emp = empresas.get(this.jComboBoxEmpresas.getSelectedIndex());
        VisualizarEmpresa ve = new VisualizarEmpresa(pai, true, emp);
        ve.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxEmpresas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
