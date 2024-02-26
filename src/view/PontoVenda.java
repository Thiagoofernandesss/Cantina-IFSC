/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author gabri
 */
public class PontoVenda extends javax.swing.JFrame {

    /**
     * Creates new form PontoVenda
     */
    public PontoVenda() {
        initComponents();
    }

    public JButton getjButtonAdicionarCliente() {
        return jButtonAdicionarCliente;
    }

    public void setjButtonAdicionarCliente(JButton jButtonAdicionarCliente) {
        this.jButtonAdicionarCliente = jButtonAdicionarCliente;
    }

    public JButton getjButtonAdicionarFuncionario() {
        return jButtonAdicionarFuncionario;
    }

    public void setjButtonAdicionarFuncionario(JButton jButtonAdicionarFuncionario) {
        this.jButtonAdicionarFuncionario = jButtonAdicionarFuncionario;
    }

    public JButton getjButtonAdicionarProduto() {
        return jButtonAdicionarProduto;
    }

    public void setjButtonAdicionarProduto(JButton jButtonAdicionarProduto) {
        this.jButtonAdicionarProduto = jButtonAdicionarProduto;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonPesquisarCliente() {
        return jButtonPesquisarCliente;
    }

    public void setjButtonPesquisarCliente(JButton jButtonPesquisarCliente) {
        this.jButtonPesquisarCliente = jButtonPesquisarCliente;
    }

    public JButton getjButtonPesquisarFuncionario() {
        return jButtonPesquisarFuncionario;
    }

    public void setjButtonPesquisarFuncionario(JButton jButtonPesquisarFuncionario) {
        this.jButtonPesquisarFuncionario = jButtonPesquisarFuncionario;
    }

    public JButton getjButtonPesquisarProduto() {
        return jButtonPesquisarProduto;
    }

    public void setjButtonPesquisarProduto(JButton jButtonPesquisarProduto) {
        this.jButtonPesquisarProduto = jButtonPesquisarProduto;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public void setjButtonSair(JButton jButtonSair) {
        this.jButtonSair = jButtonSair;
    }

    public JButton getjButtonSalvar() {
        return jButtonSalvar;
    }

    public void setjButtonSalvar(JButton jButtonSalvar) {
        this.jButtonSalvar = jButtonSalvar;
    }

    public JTable getjTableDados() {
        return jTableDados;
    }

    public void setjTableDados(JTable jTableDados) {
        this.jTableDados = jTableDados;
    }

    public JLabel getLabelValorSubtotal() {
        return labelValorSubtotal;
    }

    public void setLabelValorSubtotal(String labelValorSubtotal) {
        this.labelValorSubtotal.setText(labelValorSubtotal);
    }


    public JTextField getjTextFieldDesconto() {
        return jTextFieldDesconto;
    }

    public void setjTextFieldDesconto(JTextField jTextFieldDesconto) {
        this.jTextFieldDesconto = jTextFieldDesconto;
    }

    public JTextField getjTextFieldFiltrarCliente() {
        return jTextFieldFiltrarCliente;
    }

    public void setjTextFieldFiltrarCliente(JTextField jTextFieldFiltrarCliente) {
        this.jTextFieldFiltrarCliente = jTextFieldFiltrarCliente;
    }

    public JTextField getjTextFieldFiltrarFuncionario() {
        return jTextFieldFiltrarFuncionario;
    }

    public void setjTextFieldFiltrarFuncionario(JTextField jTextFieldFiltrarFuncionario) {
        this.jTextFieldFiltrarFuncionario = jTextFieldFiltrarFuncionario;
    }

    public JTextField getjTextFieldFiltrarProduto() {
        return jTextFieldFiltrarProduto;
    }

    public void setjTextFieldFiltrarProduto(JTextField jTextFieldFiltrarProduto) {
        this.jTextFieldFiltrarProduto = jTextFieldFiltrarProduto;
    }

    public JTextField getjTextFieldNumCaixa() {
        return jTextFieldNumCaixa;
    }

    public void setjTextFieldNumCaixa(JTextField jTextFieldNumCaixa) {
        this.jTextFieldNumCaixa = jTextFieldNumCaixa;
    }

    public JTextField getjTextFieldStatusCaixa() {
        return jTextFieldStatusCaixa;
    }

    public void setjTextFieldStatusCaixa(JTextField jTextFieldStatusCaixa) {
        this.jTextFieldStatusCaixa = jTextFieldStatusCaixa;
    }

    public JLabel getLabelValorTotal() {
        return labelValorTotal;
    }

    public void setLabelValorTotal(String labelValorTotal) {
        this.labelValorTotal.setText(labelValorTotal);
    }

    public JLabel getjTextFieldTroco() {
        return jTextFieldTroco;
    }

    public void setjTextFieldTroco(JLabel jTextFieldTroco) {
        this.jTextFieldTroco = jTextFieldTroco;
    }
    
    public JTextField getjTextFieldValorRecebido() {
        return jTextFieldValorRecebido;
    }

    public void setjTextFieldValorRecebido(JTextField jTextFieldValorRecebido) {
        this.jTextFieldValorRecebido = jTextFieldValorRecebido;
    }

    public JPanel getjPanelBotoes() {
        return jPanelBotoes;
    }

    public void setjPanelBotoes(JPanel jPanelBotoes) {
        this.jPanelBotoes = jPanelBotoes;
    }

    public JPanel getjPanelDados() {
        return jPanelDados;
    }

    public void setjPanelDados(JPanel jPanelDados) {
        this.jPanelDados = jPanelDados;
    }

    public JPanel getjPanelFiltro() {
        return jPanelFiltro;
    }

    public void setjPanelFiltro(JPanel jPanelFiltro) {
        this.jPanelFiltro = jPanelFiltro;
    }

    public JPanel getjPanelTotalVenda() {
        return jPanelTotalVenda;
    }

    public void setjPanelTotalVenda(JPanel jPanelTotalVenda) {
        this.jPanelTotalVenda = jPanelTotalVenda;
    }

    public JPanel getjPanelTroco() {
        return jPanelTroco;
    }

    public void setjPanelTroco(JPanel jPanelTroco) {
        this.jPanelTroco = jPanelTroco;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFundo = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelFiltro = new javax.swing.JPanel();
        jLabelNomeCliente = new javax.swing.JLabel();
        jTextFieldFiltrarCliente = new javax.swing.JTextField();
        jButtonPesquisarCliente = new javax.swing.JButton();
        jButtonAdicionarCliente = new javax.swing.JButton();
        jLabelProduto = new javax.swing.JLabel();
        jTextFieldFiltrarProduto = new javax.swing.JTextField();
        jLabelNomeFuncionario = new javax.swing.JLabel();
        jTextFieldFiltrarFuncionario = new javax.swing.JTextField();
        jButtonPesquisarFuncionario = new javax.swing.JButton();
        jButtonAdicionarFuncionario = new javax.swing.JButton();
        jLabelStatusCaixa = new javax.swing.JLabel();
        jTextFieldNumCaixa = new javax.swing.JTextField();
        jLabelNumCaixa = new javax.swing.JLabel();
        jTextFieldStatusCaixa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonPesquisarProduto = new javax.swing.JButton();
        jButtonAdicionarProduto = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDados = new javax.swing.JTable();
        jPanelTroco = new javax.swing.JPanel();
        jLabelValorRecebido = new javax.swing.JLabel();
        jTextFieldValorRecebido = new javax.swing.JTextField();
        jLabelTroco = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTroco = new javax.swing.JLabel();
        jPanelTotalVenda = new javax.swing.JPanel();
        jLabelTotalVenda = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        jLabelSubtotal = new javax.swing.JLabel();
        jLabelDescontos = new javax.swing.JLabel();
        labelValorSubtotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1020, 660));
        setMinimumSize(new java.awt.Dimension(1020, 660));

        jPanelFundo.setBackground(new java.awt.Color(147, 216, 67));
        jPanelFundo.setMaximumSize(new java.awt.Dimension(950, 645));
        jPanelFundo.setMinimumSize(new java.awt.Dimension(950, 645));
        jPanelFundo.setPreferredSize(new java.awt.Dimension(950, 645));

        jPanelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(78, 124, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("PDV");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addContainerGap())
        );

        jPanelFiltro.setBackground(new java.awt.Color(228, 228, 228));
        jPanelFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelFiltro.setMaximumSize(new java.awt.Dimension(950, 112));

        jLabelNomeCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeCliente.setText("Cliente");

        jTextFieldFiltrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFiltrarClienteActionPerformed(evt);
            }
        });

        jButtonPesquisarCliente.setText("...");

        jButtonAdicionarCliente.setText("+");

        jLabelProduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelProduto.setText("Produto");

        jTextFieldFiltrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFiltrarProdutoActionPerformed(evt);
            }
        });

        jLabelNomeFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNomeFuncionario.setText("Funcionário");

        jTextFieldFiltrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFiltrarFuncionarioActionPerformed(evt);
            }
        });

        jButtonPesquisarFuncionario.setText("...");

        jButtonAdicionarFuncionario.setText("+");

        jLabelStatusCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelStatusCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusCaixa.setText("Status do Caixa");

        jTextFieldNumCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumCaixaActionPerformed(evt);
            }
        });

        jLabelNumCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNumCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumCaixa.setText("N° do Caixa");

        jTextFieldStatusCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStatusCaixaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icones/ifsc-logo.png"))); // NOI18N

        jButtonPesquisarProduto.setText("...");

        jButtonAdicionarProduto.setText("+");

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jLabelNomeCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFiltrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarCliente))
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelProduto)
                            .addComponent(jLabelNomeFuncionario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                                .addComponent(jTextFieldFiltrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPesquisarFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAdicionarFuncionario))
                            .addComponent(jTextFieldFiltrarProduto))))
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabelNumCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNumCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarProduto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStatusCaixa)
                            .addComponent(jTextFieldNumCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNomeCliente)
                            .addComponent(jTextFieldFiltrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisarCliente)
                            .addComponent(jButtonAdicionarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNomeFuncionario)
                            .addComponent(jTextFieldFiltrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisarFuncionario)
                            .addComponent(jButtonAdicionarFuncionario)
                            .addComponent(jLabelNumCaixa)
                            .addComponent(jTextFieldStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonPesquisarProduto)
                                .addComponent(jButtonAdicionarProduto))
                            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldFiltrarProduto)
                                .addComponent(jLabelProduto))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelDados.setBackground(new java.awt.Color(228, 228, 228));
        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Cód. Barras", "Produto", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDados);

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        jPanelTroco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTroco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelValorRecebido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelValorRecebido.setText("Valor Recebido R$:");

        jTextFieldValorRecebido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValorRecebido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldValorRecebido.setText("0.00");
        jTextFieldValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorRecebidoActionPerformed(evt);
            }
        });

        jLabelTroco.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelTroco.setText("Troco:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("R$");

        jTextFieldTroco.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldTroco.setText("0.00");

        javax.swing.GroupLayout jPanelTrocoLayout = new javax.swing.GroupLayout(jPanelTroco);
        jPanelTroco.setLayout(jPanelTrocoLayout);
        jPanelTrocoLayout.setHorizontalGroup(
            jPanelTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrocoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrocoLayout.createSequentialGroup()
                        .addGap(0, 61, Short.MAX_VALUE)
                        .addComponent(jLabelTroco)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTroco))
                    .addGroup(jPanelTrocoLayout.createSequentialGroup()
                        .addComponent(jLabelValorRecebido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelTrocoLayout.setVerticalGroup(
            jPanelTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrocoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorRecebido)
                    .addComponent(jTextFieldValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTroco)
                        .addComponent(jLabel13))
                    .addComponent(jLabelTroco))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanelTotalVenda.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTotalVenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTotalVenda.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTotalVenda.setText("Total:");

        jTextFieldDesconto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDesconto.setText("0.00");

        jLabelSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSubtotal.setText("Subtotal:");

        jLabelDescontos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelDescontos.setText("Descontos R$:");

        labelValorSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelValorSubtotal.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("R$");

        labelValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelValorTotal.setText("0.00");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("R$");

        javax.swing.GroupLayout jPanelTotalVendaLayout = new javax.swing.GroupLayout(jPanelTotalVenda);
        jPanelTotalVenda.setLayout(jPanelTotalVendaLayout);
        jPanelTotalVendaLayout.setHorizontalGroup(
            jPanelTotalVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTotalVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTotalVendaLayout.createSequentialGroup()
                        .addComponent(jLabelSubtotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorSubtotal))
                    .addGroup(jPanelTotalVendaLayout.createSequentialGroup()
                        .addComponent(jLabelDescontos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
                        .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTotalVendaLayout.createSequentialGroup()
                        .addComponent(jLabelTotalVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorTotal)))
                .addGap(19, 19, 19))
        );
        jPanelTotalVendaLayout.setVerticalGroup(
            jPanelTotalVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalVendaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanelTotalVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubtotal)
                    .addComponent(labelValorSubtotal)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescontos))
                .addGap(9, 9, 9)
                .addGroup(jPanelTotalVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTotalVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelValorTotal)
                        .addComponent(jLabel12))
                    .addComponent(jLabelTotalVenda))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonSalvar.setBackground(new java.awt.Color(218, 255, 218));
        jButtonSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(0, 137, 0));
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icones/iconeSalvar.png"))); // NOI18N
        jButtonSalvar.setText("Receber [F2]");
        jButtonSalvar.setActionCommand("1");
        jButtonSalvar.setBorder(null);
        jButtonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonSalvar.setPreferredSize(new java.awt.Dimension(87, 28));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 215));
        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icones/iconeCancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setActionCommand("1");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonCancelar.setMaximumSize(new java.awt.Dimension(71, 28));
        jButtonCancelar.setMinimumSize(new java.awt.Dimension(71, 28));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(255, 210, 210));
        jButtonSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(255, 0, 0));
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icones/iconeSair.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setActionCommand("0");
        jButtonSair.setBorder(null);
        jButtonSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonSair.setMaximumSize(new java.awt.Dimension(71, 28));
        jButtonSair.setMinimumSize(new java.awt.Dimension(71, 28));
        jButtonSair.setPreferredSize(new java.awt.Dimension(87, 28));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addComponent(jPanelTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTotalVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFiltrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFiltrarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFiltrarProdutoActionPerformed

    private void jTextFieldNumCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumCaixaActionPerformed

    private void jTextFieldFiltrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFiltrarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFiltrarClienteActionPerformed

    private void jTextFieldFiltrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFiltrarFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFiltrarFuncionarioActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTextFieldStatusCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStatusCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStatusCaixaActionPerformed

    private void jTextFieldValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorRecebidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorRecebidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PontoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PontoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PontoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PontoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PontoVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarCliente;
    private javax.swing.JButton jButtonAdicionarFuncionario;
    private javax.swing.JButton jButtonAdicionarProduto;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonPesquisarCliente;
    private javax.swing.JButton jButtonPesquisarFuncionario;
    private javax.swing.JButton jButtonPesquisarProduto;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabelDescontos;
    private javax.swing.JLabel jLabelNomeCliente;
    private javax.swing.JLabel jLabelNomeFuncionario;
    private javax.swing.JLabel jLabelNumCaixa;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelStatusCaixa;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotalVenda;
    private javax.swing.JLabel jLabelTroco;
    private javax.swing.JLabel jLabelValorRecebido;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelFiltro;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JPanel jPanelTotalVenda;
    private javax.swing.JPanel jPanelTroco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDados;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldFiltrarCliente;
    private javax.swing.JTextField jTextFieldFiltrarFuncionario;
    private javax.swing.JTextField jTextFieldFiltrarProduto;
    private javax.swing.JTextField jTextFieldNumCaixa;
    private javax.swing.JTextField jTextFieldStatusCaixa;
    private javax.swing.JLabel jTextFieldTroco;
    private javax.swing.JTextField jTextFieldValorRecebido;
    private javax.swing.JLabel labelValorSubtotal;
    private javax.swing.JLabel labelValorTotal;
    // End of variables declaration//GEN-END:variables
}
