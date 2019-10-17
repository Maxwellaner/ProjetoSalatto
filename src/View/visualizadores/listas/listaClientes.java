package View.visualizadores.listas;

import Controller.ClienteDAO;
import Model.Pessoa.Cliente;
import View.visualizadores.VisualizarCliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class listaClientes extends javax.swing.JDialog {

    List<Cliente> clientes;
    java.awt.Frame pai;
    
    public listaClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.pai = parent;
        initComponents();
        this.setLocationRelativeTo(null);
        preencherLista();
    }

    private void preencherLista() {
        try {
            clientes = new ArrayList<>(ClienteDAO.ListaClientes());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            this.jComboBoxClientes.setModel(dfmodel);
            clientes.forEach((c) -> {
                dfmodel.addElement(c.getNome() + " - " + c.getCPF() + " - " + c.getEndereco() + " - "
                        + c.getCelular() + "/" + c.getTelefone());
            });
        } catch (Exception ex) {
            Logger.getLogger(listaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        jLabel1.setText("Clientes");

        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cliente cliente = clientes.get(this.jComboBoxClientes.getSelectedIndex());
        VisualizarCliente vc = new VisualizarCliente(pai, true, cliente);
        vc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
