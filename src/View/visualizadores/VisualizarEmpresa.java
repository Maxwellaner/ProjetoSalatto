package View.visualizadores;

import Model.Empresa;

public class VisualizarEmpresa extends javax.swing.JDialog {

    public VisualizarEmpresa(java.awt.Frame parent, boolean modal, Empresa empresa) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        preencher(empresa);
    }
    
    private void preencher(Empresa empresa) {
        this.jLabelNome.setText(empresa.getNomeFantasia());
        this.jLabelCNPJ.setText(empresa.getCnpj());
        this.jLabelEmail.setText(empresa.getEmailComercial());
        this.jLabelCelular.setText(empresa.getCelularComercial());
        this.jLabelDataContrato.setText(empresa.getDataContrato().toString());
        this.jLabelEndereco.setText(empresa.getEndereco());
        this.jLabelTelefone.setText(empresa.getTelefoneComercial());
        this.jLabelRazaoSocial.setText(empresa.getRazaoSocial());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelCNPJ = new javax.swing.JLabel();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jLabelDataContrato = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCelular = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNome.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabelNome.setText("Nome");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 96, 685, 10));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel1.setText("Endereço:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel2.setText("CNPJ:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 184, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Razão Social:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 218, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Data do Contrato:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 252, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("E-mail:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Celular:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 184, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Telefone:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 218, -1, -1));

        jLabelEndereco.setText("end");
        getContentPane().add(jLabelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 151, -1, -1));

        jLabelCNPJ.setText("jLabel8");
        getContentPane().add(jLabelCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 185, -1, -1));

        jLabelRazaoSocial.setText("jLabel8");
        getContentPane().add(jLabelRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 219, -1, -1));

        jLabelDataContrato.setText("jLabel8");
        getContentPane().add(jLabelDataContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 253, -1, -1));

        jLabelEmail.setText("jLabel8");
        getContentPane().add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 151, -1, -1));

        jLabelCelular.setText("jLabel8");
        getContentPane().add(jLabelCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 185, -1, -1));

        jLabelTelefone.setText("jLabel8");
        getContentPane().add(jLabelTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 219, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelDataContrato;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
