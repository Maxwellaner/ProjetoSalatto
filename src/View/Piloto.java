package View;

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

public class Piloto extends javax.swing.JFrame {

    private List<Pedido> pedidosHoje;
    private List<Pedido> pedidosFazer;

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
        jButtonVisualizarVendas = new javax.swing.JButton();
        jButtonVisualizarPedidos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jButtonRelatorioVendas = new javax.swing.JButton();
        jButtonRelatorioPedidos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jButtonGraficoVendas = new javax.swing.JButton();
        jButtonGraficoPedidos = new javax.swing.JButton();
        jLabelData = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jButtonAbrirPedido = new javax.swing.JButton();
        jMenuPiloto = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenuItem();
        jMenuMateriaPrima = new javax.swing.JMenuItem();
        jMenuCadastroEmpresa = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuLancamentos = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salatto");
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jListPedidosHoje.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListPedidosHoje);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(57, 205, 422, 318);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setText("Pedidos do dia");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(57, 178, 117, 21);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(327, 172, 0, 0);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(204, 58, 0, 0);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salatto.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(61, 11, 137, 108);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(11, 156, 975, 10);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("A fazer");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(518, 178, 57, 21);

        jListPedidosFazer.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListPedidosFazer);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(518, 205, 420, 318);

        jButtonVisualizarVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sale-tag32px.png"))); // NOI18N
        jButtonVisualizarVendas.setName(""); // NOI18N
        getContentPane().add(jButtonVisualizarVendas);
        jButtonVisualizarVendas.setBounds(360, 70, 67, 41);

        jButtonVisualizarPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido32px.png"))); // NOI18N
        getContentPane().add(jButtonVisualizarPedidos);
        jButtonVisualizarPedidos.setBounds(430, 70, 67, 41);

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Visualizar");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(400, 40, 80, 16);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(340, 60, 188, 10);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Relatórios");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(610, 40, 90, 16);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(550, 60, 188, 10);

        jButtonRelatorioVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sale-tag32px.png"))); // NOI18N
        jButtonRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioVendasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRelatorioVendas);
        jButtonRelatorioVendas.setBounds(570, 70, 67, 41);

        jButtonRelatorioPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido32px.png"))); // NOI18N
        getContentPane().add(jButtonRelatorioPedidos);
        jButtonRelatorioPedidos.setBounds(640, 70, 67, 41);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel8.setText("Gráficos");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(830, 40, 70, 16);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(760, 60, 182, 10);

        jButtonGraficoVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sale-tag32px.png"))); // NOI18N
        jButtonGraficoVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficoVendasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGraficoVendas);
        jButtonGraficoVendas.setBounds(780, 70, 67, 40);

        jButtonGraficoPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido32px.png"))); // NOI18N
        jButtonGraficoPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficoPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGraficoPedidos);
        jButtonGraficoPedidos.setBounds(850, 70, 67, 40);

        jLabelData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelData.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(jLabelData);
        jLabelData.setBounds(820, 590, 90, 50);

        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelHora);
        jLabelHora.setBounds(910, 590, 80, 50);

        jButtonAbrirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/abrir-pasta-com-documento.png"))); // NOI18N
        jButtonAbrirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAbrirPedido);
        jButtonAbrirPedido.setBounds(440, 550, 40, 40);

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

        jMenu2.setText("Vendas");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/venda.png"))); // NOI18N
        jMenuItem3.setText("Adicionar venda");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relatorio (1).png"))); // NOI18N
        jMenuItem4.setText("Relatório de vendas");
        jMenu2.add(jMenuItem4);

        jMenuPiloto.add(jMenu2);

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

        jMenuPiloto.add(jMenuLancamentos);

        setJMenuBar(jMenuPiloto);

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

    private void jButtonAbrirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirPedidoActionPerformed
        
    }//GEN-LAST:event_jButtonAbrirPedidoActionPerformed

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
    private javax.swing.JButton jButtonAbrirPedido;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JList<String> jListPedidosFazer;
    private javax.swing.JList<String> jListPedidosHoje;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuCadastroEmpresa;
    private javax.swing.JMenuItem jMenuClientes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu jMenuLancamentos;
    private javax.swing.JMenuItem jMenuMateriaPrima;
    private javax.swing.JMenuBar jMenuPiloto;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
