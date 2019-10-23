package View.Cadastros;

import Controller.ClienteDAO;
import Controller.EmpresaDAO;
import Controller.PedidoDAO;
import Controller.ProdutoDAO;
import Model.Pessoa.Cliente;
import Model.Empresa;
import Model.Pedido;
import Model.Produto;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Util.Util;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.stream.IntStream;

public class CadastrarPedido extends javax.swing.JDialog {

    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Empresa> empresas;
    private double valorTotal;
    private List<Produto> listaCompras;
    private Pedido pedido;

    public CadastrarPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        preencherListaClientes();
        preencherListaEmpresas();
        preencherListaProdutos();
        escolhaComprador();
        this.valorTotal = 0;
        listaCompras = new ArrayList<>();
        evtTable();
    }

    public CadastrarPedido() {

    }

    private void escolhaComprador() {
        this.jComboBoxClientes.setEnabled(false);
        this.jComboBoxEmpresas.setEnabled(false);
        this.jButtonAdicionarProduto.setEnabled(false);
    }

    private void preencherListaClientes() {
        try {
            clientes = new ArrayList<Cliente>(ClienteDAO.ListaClientes());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            for (Cliente c : clientes) {
                dfmodel.addElement(c.getNome() + " - " + c.getEndereco() + " - " + c.getCelular());
            }
            this.jComboBoxClientes.setModel(dfmodel);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherListaEmpresas() {
        try {
            empresas = new ArrayList<Empresa>(EmpresaDAO.listarEmpresas());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            for (Empresa e : empresas) {
                dfmodel.addElement(e.getNomeFantasia() + " - " + e.getEndereco() + " - " + e.getTelefoneComercial());
            }
            this.jComboBoxEmpresas.setModel(dfmodel);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherListaProdutos() {
        try {
            produtos = new ArrayList<Produto>(ProdutoDAO.listarProdutos());
            DefaultComboBoxModel dfmodel = new DefaultComboBoxModel();
            for (Produto p : produtos) {
                dfmodel.addElement(p.getId() + ". " + p.getNome() + " - Estoque: " + p.getQuantidadeEstoque() + " - " + p.getDescricao());
            }
            this.jComboBoxListaProdutos.setModel(dfmodel);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxEmpresas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxListaProdutos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonAdicionarProduto = new javax.swing.JButton();
        jButtonCadastrarPedido = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabelValorTotal = new javax.swing.JLabel();
        jRadioButtonCliente = new javax.swing.JRadioButton();
        jRadioButtonEmpresa = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCompras = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtAdiantamento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDataEntrega = new javax.swing.JFormattedTextField(Util.Mascara("##/##/####"));
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButtonQuitado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pedidos");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 677));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setText("Cadastrar Pedido");

        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel2.setText("Cliente");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel3.setText("Empresa");

        jComboBoxEmpresas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Carrinho de Compras");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jLabel5.setText("Produtos");

        jComboBoxListaProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("Selecione o comprador (cliente ou empresa)");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel7.setText("Adicione os produtos ao carrinho de compras");

        jButtonAdicionarProduto.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/more.png"))); // NOI18N
        jButtonAdicionarProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAdicionarProduto.setOpaque(false);
        jButtonAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarProdutoActionPerformed(evt);
            }
        });

        jButtonCadastrarPedido.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCadastrarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar.png"))); // NOI18N
        jButtonCadastrarPedido.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonCadastrarPedido.setOpaque(false);
        jButtonCadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarPedidoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel8.setText("Quantidade");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setText("Valor Total : R$");

        jLabelValorTotal.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabelValorTotal.setText("0");

        jRadioButtonCliente.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jRadioButtonCliente.setText("Cliente");
        jRadioButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonClienteActionPerformed(evt);
            }
        });

        jRadioButtonEmpresa.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jRadioButtonEmpresa.setText("Empresa");
        jRadioButtonEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEmpresaActionPerformed(evt);
            }
        });

        /*TableColumn coluna = jTableCompras.getColumnModel().getColumn(1);
        coluna.setCellEditor(new jTableComprasCellEditor());

        class jTableComprasCellEditor extends AbstractCellEditor implements TableCellEditor {
            JComponent component = new jTextField();

            public boolean stopCellEditing() {
                String s = (String)getCellEditorValue();
                boolean valido = true;

                for (int i = 0; i < s.length(); i++) {
                    Charecter caractere = s.chars(i);
                    if(!Character.isDigit(caractere)) {
                        valido = false;
                        break;
                    }
                }
                if (!valido) {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                    return false;
                }
                return super.stopCellEditing();
            }
            public Component getTableCellEditorComponent(jTable table, Object value,
                boolean isSelected, int rowIndex, int collIndex) {
                if (isSelected) {

                }
                ((jTextField)component).setText((String)value);
                return component;
            }
            public Object getCellEditorValue() {
                return ((jTextField)component).getText();
            }
        }*/
        jTableCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCompras.getTableHeader().setReorderingAllowed(false);
        jTableCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableComprasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCompras);
        if (jTableCompras.getColumnModel().getColumnCount() > 0) {
            jTableCompras.getColumnModel().getColumn(0).setResizable(false);
            jTableCompras.getColumnModel().getColumn(0).setPreferredWidth(350);
            jTableCompras.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel10.setText("Adiantamento");

        txtAdiantamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdiantamentoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setText("Quitado");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel12.setText("Data de Entrega");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jRadioButtonQuitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonQuitadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonCliente)
                                    .addComponent(jRadioButtonEmpresa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAdicionarProduto)
                                .addGap(70, 70, 70)))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxListaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBoxClientes, javax.swing.GroupLayout.Alignment.LEADING, 0, 404, Short.MAX_VALUE)
                        .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdiantamento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jRadioButtonQuitado)
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataEntrega, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 50, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jRadioButtonCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonEmpresa)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxListaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabelValorTotal)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jRadioButtonQuitado))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAdiantamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(44, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonAdicionarProduto)
                                        .addGap(43, 43, 43))))))))
        );

        jLabelValorTotal.getAccessibleContext().setAccessibleName("jLabelValorTotal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarPedidoActionPerformed
        Produto produto = produtos.get(this.jComboBoxListaProdutos.getSelectedIndex());
        double adiantamento = 0;
        Date dataAtual = Util.dataAtual();
        int tableVazia = this.jTableCompras.getRowCount();
        System.out.println(tableVazia);
        if ("".equals(this.txtAdiantamento.getText())) {
            adiantamento = 0;
        } else {
            valorTotal = valorTotal - Double.parseDouble(this.txtAdiantamento.getText());
            Util.formatarValor(valorTotal);
            adiantamento = Double.parseDouble(this.txtAdiantamento.getText());
            Util.formatarValor(adiantamento);
        }
        if (this.jRadioButtonQuitado.isSelected()) {
            adiantamento = valorTotal;
            valorTotal = 0;
        }
        boolean pago = this.jRadioButtonQuitado.isSelected();

        if ("  /  /    ".equals(this.txtDataEntrega.getText()) || tableVazia == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo 'Data de Entrega' e adicione produtos no carrinho de compras!");
        } else {
            Date dataEntrega = Util.stringToDate(this.txtDataEntrega.getText());
            try {
                if (this.jRadioButtonCliente.isSelected()) {
                    Cliente cliente = clientes.get(this.jComboBoxClientes.getSelectedIndex());
                    pedido = new Pedido(cliente, listaCompras, pago,
                            adiantamento,
                            valorTotal, dataAtual, dataEntrega);
                } else {
                    Empresa empresa = empresas.get(this.jComboBoxEmpresas.getSelectedIndex());
                    pedido = new Pedido(empresa, listaCompras, pago,
                            adiantamento,
                            valorTotal, dataAtual, dataEntrega);
                }
            } catch (Exception e) {
                System.out.println("Erro ao instanciar o objeto 'pedido'.");
                System.out.println(e.getMessage());
            }

            try {
                PedidoDAO.cadastrarPedido(pedido, listaCompras);
                this.valorTotal = 0;
                this.jLabelValorTotal.setText(Util.formatarValor(valorTotal));
                this.dispose();
            } catch (Exception e) {
                System.out.println("Erro ao gravar dados do pedido");
                System.out.println(e.getMessage());
            }

        }

    }//GEN-LAST:event_jButtonCadastrarPedidoActionPerformed

    private void limpar() {
        this.txtDataEntrega.setText("");
        this.txtAdiantamento.setText("");
        this.txtQuantidade.setText("");
        while (this.jTableCompras.getModel().getRowCount() > 0) {
            ((DefaultTableModel) this.jTableCompras.getModel()).removeRow(0);
        }
    }

    private void jRadioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonClienteActionPerformed

        if (this.jRadioButtonCliente.isSelected()) {
            this.jRadioButtonEmpresa.setEnabled(false);
            this.jComboBoxClientes.setEnabled(true);
            this.jButtonAdicionarProduto.setEnabled(true);
        } else {
            this.jRadioButtonEmpresa.setEnabled(true);
            this.jComboBoxClientes.setEnabled(false);
            this.jButtonAdicionarProduto.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButtonClienteActionPerformed

    private void jRadioButtonEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEmpresaActionPerformed

        if (this.jRadioButtonEmpresa.isSelected()) {
            this.jRadioButtonCliente.setEnabled(false);
            this.jComboBoxEmpresas.setEnabled(true);
            this.jButtonAdicionarProduto.setEnabled(true);
        } else {
            this.jRadioButtonCliente.setEnabled(true);
            this.jComboBoxEmpresas.setEnabled(false);
            this.jButtonAdicionarProduto.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButtonEmpresaActionPerformed

    private void jButtonAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarProdutoActionPerformed
        Produto produto = produtos.get(this.jComboBoxListaProdutos.getSelectedIndex());
        DefaultTableModel dfmodel = (DefaultTableModel) jTableCompras.getModel();

        if (!this.listaCompras.contains(produto) && !"".equals(this.txtQuantidade.getText())
                && (produto.getQuantidadeEstoque() >= Integer.parseInt(this.txtQuantidade.getText()))) {
            produto.setQuantidadePorPedido(Integer.parseInt(this.txtQuantidade.getText()));
            this.listaCompras.add(produto);

            Object[] dados = {produto.getId() + ". " + produto.getNome(), produto.getQuantidadePorPedido()};
            dfmodel.addRow(dados);

            valorTotal += (double) (produto.getValorVenda() * Integer.parseInt(this.txtQuantidade.getText()));

            this.jLabelValorTotal.setText(Util.formatarValor(valorTotal));

        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.\n"
                    + "*Quantidade\n"
                    + "Verifique se a quantidade excedeu o estoque.");
        }
    }//GEN-LAST:event_jButtonAdicionarProdutoActionPerformed


    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        String s = ",;/asdfghjklçpoiuytrewqzxcvbnm!@#$%¨&*()_+=-\\[]{}º?°:><`´´ª.|";

        if (s.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void jTableComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableComprasMouseClicked
        jTableCompras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int linha = jTableCompras.getSelectedRow();
                    int coluna = jTableCompras.getSelectedColumn();
                    System.out.println(linha + " " + coluna);
                    Object valorCell = jTableCompras.getModel().getValueAt(linha, coluna);
                    String s = (String) valorCell;
                    String[] partes = s.split("");
                    int index = Integer.parseInt(partes[0]);
                    Produto produto = null;
                    int indiceProduto = 0;
                    for (int i = 0; i <= produtos.size() - 1; i++) {
                        if (produtos.get(i).getId() == index) {
                            produto = produtos.get(i);
                            indiceProduto = i;
                        }
                    }
                    listaCompras.remove(produto);
                    valorTotal = (double) valorTotal - (produto.getValorVenda() * produto.getQuantidadePorPedido());
                    DefaultTableModel dfmodel = (DefaultTableModel) jTableCompras.getModel();
                    dfmodel.removeRow(linha);
                }
            }
        });    
    }//GEN-LAST:event_jTableComprasMouseClicked

    private void jRadioButtonQuitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonQuitadoActionPerformed

        if (this.jRadioButtonQuitado.isSelected()) {
            this.txtAdiantamento.setEnabled(false);
        } else {
            this.txtAdiantamento.setEnabled(true);
        }

    }//GEN-LAST:event_jRadioButtonQuitadoActionPerformed

    private void txtAdiantamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdiantamentoKeyTyped
        String s = ",;/asdfghjklçpoiuytrewqzxcvbnm!@#$%¨&*()_+=-\\[]{}º?°:><`´´ª|";

        if (s.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAdiantamentoKeyTyped

    private void evtTable() {

        this.jTableCompras.addKeyListener(new KeyAdapter() {
            final int[] excessoes = {KeyEvent.VK_ENTER, KeyEvent.VK_DOWN, KeyEvent.VK_UP};

            @Override
            public void keyReleased(KeyEvent ke) {
                int linha = jTableCompras.getSelectedRow();
                int coluna = jTableCompras.getSelectedColumn();
                boolean semMovimento = IntStream.of(excessoes).filter(movimento -> movimento == ke.getKeyCode()).findFirst().orElse(Character.MAX_VALUE + 1) == Character.MAX_VALUE + 1;
                if (jTableCompras.getSelectedRow() > 0 && semMovimento) {
                    linha = jTableCompras.getSelectedRow();
                    coluna = jTableCompras.getSelectedColumn();
                } else {
                    atualizarValor(linha, coluna);
                }
            }

            @Override
            public void keyTyped(KeyEvent ke) {
                String s = ",;/asdfghjklçpoiuytrewqzxcvbnm!@#$%¨&*()_+=-\\[]{}º?°:><`´´ª|";

                if (s.contains(ke.getKeyChar() + "")) {
                    ke.consume();
                }
            }

        });
    }

    private void atualizarValor(int linha, int coluna) {
        Object valorCell = jTableCompras.getModel().getValueAt(linha, coluna);
        Produto produto = produtos.get(this.jComboBoxListaProdutos.getSelectedIndex());

        valorTotal += (double) (produto.getValorVenda() * Double.parseDouble((String) valorCell));
        this.jLabelValorTotal.setText(Util.formatarValor(valorTotal));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarProduto;
    private javax.swing.JButton jButtonCadastrarPedido;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JComboBox<String> jComboBoxEmpresas;
    private javax.swing.JComboBox<String> jComboBoxListaProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCliente;
    private javax.swing.JRadioButton jRadioButtonEmpresa;
    private javax.swing.JRadioButton jRadioButtonQuitado;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableCompras;
    private javax.swing.JTextField txtAdiantamento;
    private javax.swing.JFormattedTextField txtDataEntrega;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
