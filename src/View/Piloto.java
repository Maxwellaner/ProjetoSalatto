package View;

import View.Cadastros.CadastroProdutos;
import View.Cadastros.CadastroMateriaPrima;
import View.Cadastros.CadastroEmpresa;
import View.Cadastros.CadastroClientes;
import View.Cadastros.CadastrarPedido;
import Controller.PedidoDAO;
import View.Relatorios.GerarRelatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import Model.Pedido;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import Util.Util;
import View.Graficos.Grafico;
import View.visualizadores.listas.listaClientes;
import View.visualizadores.listas.listaEmpresas;
import View.visualizadores.listas.listaPedidos;

public class Piloto extends javax.swing.JFrame {

    private List<Pedido> pedidosHoje;
    private List<Pedido> pedidosFazer;
    Pedido pedido = new Pedido();

    public Piloto() {
        initComponents();
        this.setLocationRelativeTo(null);
        preencherListaPedidosHoje();
        preencherListaPedidosFazer();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conexao1 = new Controller.Conexao();
        conexao2 = new Controller.Conexao();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButtonVisualizarVendas = new javax.swing.JButton();
        jButtonVisualizarPedidos = new javax.swing.JButton();
        jButtonRelatorioVendas = new javax.swing.JButton();
        jButtonGraficoPedidos = new javax.swing.JButton();
        jButtonRelatorioPedidos = new javax.swing.JButton();
        jButtonGraficoVendas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPedidosHoje = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPedidosFazer = new javax.swing.JList<>();
        jLabelData = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jButtonAtualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuPiloto = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenuItem();
        jMenuMateriaPrima = new javax.swing.JMenuItem();
        jMenuCadastroEmpresa = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuRelatorioPedidos = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItemCaixa = new javax.swing.JMenuItem();
        jMenuLancamentos = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemVisualizarClientes = new javax.swing.JMenuItem();
        jMenuItemVisualizarEmpresas = new javax.swing.JMenuItem();
        jMenuItemVisualizarPedidos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salatto");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/salatto-icone.png")).getImage());
        setPreferredSize(new java.awt.Dimension(1270, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setOpaque(false);

        jButtonVisualizarVendas.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVisualizarVendas.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButtonVisualizarVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caixa.png"))); // NOI18N
        jButtonVisualizarVendas.setText("Visualizar Caixas");
        jButtonVisualizarVendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonVisualizarVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVisualizarVendas.setName(""); // NOI18N
        jButtonVisualizarVendas.setOpaque(false);
        jButtonVisualizarVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonVisualizarPedidos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVisualizarPedidos.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButtonVisualizarPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido32px.png"))); // NOI18N
        jButtonVisualizarPedidos.setText("Visualizar Pedidos");
        jButtonVisualizarPedidos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonVisualizarPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVisualizarPedidos.setOpaque(false);
        jButtonVisualizarPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonRelatorioVendas.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRelatorioVendas.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButtonRelatorioVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sale-tag32px.png"))); // NOI18N
        jButtonRelatorioVendas.setText("Relatório de Vendas");
        jButtonRelatorioVendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonRelatorioVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelatorioVendas.setOpaque(false);
        jButtonRelatorioVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioVendasActionPerformed(evt);
            }
        });

        jButtonGraficoPedidos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGraficoPedidos.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButtonGraficoPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido32px.png"))); // NOI18N
        jButtonGraficoPedidos.setText("Relatório de Pedidos");
        jButtonGraficoPedidos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonGraficoPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGraficoPedidos.setOpaque(false);
        jButtonGraficoPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGraficoPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficoPedidosActionPerformed(evt);
            }
        });

        jButtonRelatorioPedidos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRelatorioPedidos.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButtonRelatorioPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido32px.png"))); // NOI18N
        jButtonRelatorioPedidos.setText("Gráfico de Pedidos");
        jButtonRelatorioPedidos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonRelatorioPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelatorioPedidos.setOpaque(false);
        jButtonRelatorioPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatorioPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioPedidosActionPerformed(evt);
            }
        });

        jButtonGraficoVendas.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGraficoVendas.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButtonGraficoVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sale-tag32px.png"))); // NOI18N
        jButtonGraficoVendas.setText("Gráfico de Vendas");
        jButtonGraficoVendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonGraficoVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGraficoVendas.setOpaque(false);
        jButtonGraficoVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGraficoVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficoVendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButtonVisualizarVendas)
                .addGap(18, 18, 18)
                .addComponent(jButtonVisualizarPedidos)
                .addGap(18, 18, 18)
                .addComponent(jButtonRelatorioVendas)
                .addGap(18, 18, 18)
                .addComponent(jButtonGraficoPedidos)
                .addGap(18, 18, 18)
                .addComponent(jButtonGraficoVendas)
                .addGap(18, 18, 18)
                .addComponent(jButtonRelatorioPedidos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGraficoVendas)
                    .addComponent(jButtonRelatorioPedidos)
                    .addComponent(jButtonGraficoPedidos)
                    .addComponent(jButtonRelatorioVendas)
                    .addComponent(jButtonVisualizarPedidos)
                    .addComponent(jButtonVisualizarVendas))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jButtonVisualizarVendas.getAccessibleContext().setAccessibleDescription("");

        jListPedidosHoje.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListPedidosHoje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPedidosHojeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListPedidosHoje);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setText("Pedidos do dia");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salatto.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("A fazer");

        jListPedidosFazer.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListPedidosFazer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPedidosFazerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListPedidosFazer);

        jLabelData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelData.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonAtualizar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao-de-atualizacao.png"))); // NOI18N
        jButtonAtualizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAtualizar.setOpaque(false);
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caixa.png"))); // NOI18N
        jButton1.setText("Caixa");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setOpaque(false);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("F6 Pedidos");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("F7 Caixa");

        jMenuPiloto.setBackground(new java.awt.Color(255, 255, 255));
        jMenuPiloto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuPiloto.setForeground(new java.awt.Color(255, 255, 255));

        jMenuCadastro.setText("Cadastro");

        jMenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/silhueta-de-varios-usuarios.png"))); // NOI18N
        jMenuClientes.setText("Clientes");
        jMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClientesActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuClientes);

        jMenuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/torta.png"))); // NOI18N
        jMenuProdutos.setText("Produtos");
        jMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuProdutos);

        jMenuMateriaPrima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estado-da-materia.png"))); // NOI18N
        jMenuMateriaPrima.setText("Matéria prima");
        jMenuMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMateriaPrimaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuMateriaPrima);

        jMenuCadastroEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/factory.png"))); // NOI18N
        jMenuCadastroEmpresa.setText("Empresa");
        jMenuCadastroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroEmpresaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadastroEmpresa);

        jMenuPiloto.add(jMenuCadastro);

        jMenu1.setText("Pedidos");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido.png"))); // NOI18N
        jMenuItem1.setText("Adicionar pedido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relatorio (1).png"))); // NOI18N
        jMenuItem2.setText("Relatório de pedidos");
        jMenu1.add(jMenuItem2);

        jMenuPiloto.add(jMenu1);

        jMenuRelatorioPedidos.setText("Vendas");
        jMenuRelatorioPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioPedidosActionPerformed(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relatorio (1).png"))); // NOI18N
        jMenuItem4.setText("Relatório de Pedidos");
        jMenuRelatorioPedidos.add(jMenuItem4);

        jMenuItemCaixa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItemCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caixa16px.png"))); // NOI18N
        jMenuItemCaixa.setText("Caixa");
        jMenuItemCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCaixaActionPerformed(evt);
            }
        });
        jMenuRelatorioPedidos.add(jMenuItemCaixa);

        jMenuPiloto.add(jMenuRelatorioPedidos);

        jMenuLancamentos.setText("Lançamentos");
        jMenuLancamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLancamentosActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Lançamentos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuLancamentos.add(jMenuItem5);

        jMenuItem6.setText("Despesas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuLancamentos.add(jMenuItem6);

        jMenuPiloto.add(jMenuLancamentos);

        jMenu3.setText("Visualizar");

        jMenuItemVisualizarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/silhueta-de-varios-usuarios.png"))); // NOI18N
        jMenuItemVisualizarClientes.setText("Clientes");
        jMenuItemVisualizarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVisualizarClientesActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemVisualizarClientes);

        jMenuItemVisualizarEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/factory.png"))); // NOI18N
        jMenuItemVisualizarEmpresas.setText("Empresas");
        jMenuItemVisualizarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVisualizarEmpresasActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemVisualizarEmpresas);

        jMenuItemVisualizarPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relatorio (1).png"))); // NOI18N
        jMenuItemVisualizarPedidos.setText("Pedidos");
        jMenuItemVisualizarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVisualizarPedidosActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemVisualizarPedidos);

        jMenuPiloto.add(jMenu3);

        setJMenuBar(jMenuPiloto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(270, 270, 270)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1))
                            .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelHora, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClientesActionPerformed
        CadastroClientes cadastroCli = new CadastroClientes(this, true);
        cadastroCli.setVisible(true);
    }//GEN-LAST:event_jMenuClientesActionPerformed

    private void jMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosActionPerformed
        CadastroProdutos cadastroPro = new CadastroProdutos(this, true);
        cadastroPro.setVisible(true);
    }//GEN-LAST:event_jMenuProdutosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CadastrarPedido pedido = new CadastrarPedido(this, true);
        pedido.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuCadastroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroEmpresaActionPerformed
        CadastroEmpresa cadastroEmp = new CadastroEmpresa(this, true);
        cadastroEmp.setVisible(true);
    }//GEN-LAST:event_jMenuCadastroEmpresaActionPerformed

    private void jMenuMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMateriaPrimaActionPerformed
        CadastroMateriaPrima materia = new CadastroMateriaPrima(this, true);
        materia.setVisible(true);
    }//GEN-LAST:event_jMenuMateriaPrimaActionPerformed

    private void jButtonRelatorioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioVendasActionPerformed
        try {
            GerarRelatorio.gerarPDF("RelatorioTeste");
        } catch (Exception ex) {
            Logger.getLogger(Piloto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRelatorioVendasActionPerformed

    private void jMenuLancamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLancamentosActionPerformed

    }//GEN-LAST:event_jMenuLancamentosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Lancamentos lanc = new Lancamentos(this, true);
        lanc.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Date dataSistema = new Date(System.currentTimeMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.jLabelData.setText(formato.format(dataSistema));

        Timer timer = new Timer(1000, new hora());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void jButtonGraficoVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficoVendasActionPerformed

    }//GEN-LAST:event_jButtonGraficoVendasActionPerformed

    private void jButtonGraficoPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficoPedidosActionPerformed
        Grafico.graficoPizza();
    }//GEN-LAST:event_jButtonGraficoPedidosActionPerformed

    private void jListPedidosHojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPedidosHojeMouseClicked
        /*jListPedidosHoje.addMouseListener(new MouseAdapter() {         
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    pedido = pedidosHoje.get(jListPedidosHoje.getSelectedIndex());
                    System.out.println("chegou aqui");
                }
            } 
        });*/
        pedidosHoje = new ArrayList<>(PedidoDAO.pedidosHoje());
        pedido = pedidosHoje.get(jListPedidosHoje.getSelectedIndex());
        PedidoFechar pv = new PedidoFechar(this, true, pedido);
        pv.setVisible(true);
    }//GEN-LAST:event_jListPedidosHojeMouseClicked

    private void jListPedidosFazerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPedidosFazerMouseClicked
        pedidosFazer = new ArrayList<>(PedidoDAO.pedidosFazer());
        pedido = pedidosFazer.get(jListPedidosFazer.getSelectedIndex());
        PedidoFechar pv = new PedidoFechar(this, true, pedido);
        pv.setVisible(true);
    }//GEN-LAST:event_jListPedidosFazerMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Caixa caixa = new Caixa(this, true);
        caixa.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DespesasDiarias d = new DespesasDiarias(this, true);
        d.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButtonRelatorioPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioPedidosActionPerformed
        
    }//GEN-LAST:event_jButtonRelatorioPedidosActionPerformed

    private void jMenuItemVisualizarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVisualizarClientesActionPerformed
        listaClientes lc = new listaClientes(this, true);
        lc.setVisible(true);
    }//GEN-LAST:event_jMenuItemVisualizarClientesActionPerformed

    private void jMenuItemVisualizarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVisualizarEmpresasActionPerformed
        listaEmpresas le = new listaEmpresas(this, true);
        le.setVisible(true);
    }//GEN-LAST:event_jMenuItemVisualizarEmpresasActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        preencherListaPedidosHoje();
        preencherListaPedidosFazer();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jMenuItemVisualizarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVisualizarPedidosActionPerformed
        listaPedidos lp = new listaPedidos(this, true);
        lp.setVisible(true);
    }//GEN-LAST:event_jMenuItemVisualizarPedidosActionPerformed

    private void jMenuRelatorioPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioPedidosActionPerformed
        
    }//GEN-LAST:event_jMenuRelatorioPedidosActionPerformed

    private void jMenuItemCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCaixaActionPerformed
        Caixa caixa = new Caixa(this, true);
        caixa.setVisible(true);
    }//GEN-LAST:event_jMenuItemCaixaActionPerformed

    private void preencherListaPedidosHoje() {
        try {
            pedidosHoje = new ArrayList<>(PedidoDAO.pedidosHoje());
            DefaultListModel dfmodel = new DefaultListModel();
            this.jListPedidosHoje.setModel(dfmodel);
            pedidosHoje.forEach((p) -> {
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

    private void preencherListaPedidosFazer() {
        try {
            pedidosHoje = new ArrayList<>(PedidoDAO.pedidosFazer());
            DefaultListModel dfmodel = new DefaultListModel();
            this.jListPedidosFazer.setModel(dfmodel);
            pedidosHoje.forEach((p) -> {
                if (p.getIdCliente() != 0) {
                    dfmodel.addElement(p.getDataEntrega() + " - " + p.getCliente().getNome() + " - Endereço: " + p.getCliente().getEndereco()
                            + " - Valor total: R$ " + Util.formatarValor(p.getValorTotal()));
                } else {
                    dfmodel.addElement(p.getDataEntrega() + " - " + p.getEmpresa().getNomeFantasia() + " - Endereço: " + p.getEmpresa().getEndereco()
                            + " - Valor total: R$ " + Util.formatarValor(p.getValorTotal()));
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(CadastrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar calendario = Calendar.getInstance();
            jLabelHora.setText(String.format("%1$tH:%1$tM:%1$tS", calendario));
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Piloto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controller.Conexao conexao1;
    private Controller.Conexao conexao2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonGraficoPedidos;
    private javax.swing.JButton jButtonGraficoVendas;
    private javax.swing.JButton jButtonRelatorioPedidos;
    private javax.swing.JButton jButtonRelatorioVendas;
    private javax.swing.JButton jButtonVisualizarPedidos;
    private javax.swing.JButton jButtonVisualizarVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JList<String> jListPedidosFazer;
    private javax.swing.JList<String> jListPedidosHoje;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuCadastroEmpresa;
    private javax.swing.JMenuItem jMenuClientes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemCaixa;
    private javax.swing.JMenuItem jMenuItemVisualizarClientes;
    private javax.swing.JMenuItem jMenuItemVisualizarEmpresas;
    private javax.swing.JMenuItem jMenuItemVisualizarPedidos;
    private javax.swing.JMenu jMenuLancamentos;
    private javax.swing.JMenuItem jMenuMateriaPrima;
    private javax.swing.JMenuBar jMenuPiloto;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JMenu jMenuRelatorioPedidos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}