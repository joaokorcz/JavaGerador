/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geradores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import myTools.Ferramentas;

/**
 *
 * @author radames
 */
public class GerarClasseDeGUI {

    String projetoDestino;
    String nomeClasse;
    String nomeClasse2;

    public GerarClasseDeGUI(String projetoDestino, String nomeClasse, String nomeClasse2) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        this.nomeClasse2 = nomeClasse2;
        gerarClasseGUI();
    }

    private void gerarClasseGUI() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        //fazer a classe de controle de lista
        codigoGerado.clear();
        codigoGerado.add(
                "package Main;\n"
                + "\n"
                + "import java.util.ArrayList;\n"
                + "import java.text.SimpleDateFormat;\n"
                + "import javax.swing.JCheckBox;\n"
                + "import java.util.List;\n"
                + "import myTools.Ferramentas;\n"
                + "import java.awt.BorderLayout;\n"
                + "import java.awt.CardLayout;\n"
                + "import java.awt.Color;\n"
                + "import java.awt.Container;\n"
                + "import java.awt.FlowLayout;\n"
                + "import java.awt.GridLayout;\n"
                + "import java.awt.Image;\n"
                + "import java.awt.event.ActionEvent;\n"
                + "import java.awt.event.ActionListener;\n"
                + "import java.awt.event.WindowAdapter;\n"
                + "import java.awt.event.WindowEvent;\n"
                + "import java.awt.event.WindowListener;\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import javax.swing.JButton;\n"
                + "import javax.swing.JFrame;\n"
                + "import javax.swing.JLabel;\n"
                + "import javax.swing.JOptionPane;\n"
                + "import javax.swing.JPanel;\n"
                + "import javax.swing.JScrollPane;\n"
                + "import javax.swing.JTable;\n"
                + "import javax.swing.JTextArea;\n"
                + "import javax.swing.JTextField;\n"
                + "import javax.swing.table.DefaultTableModel;\n"
                + "import javax.swing.text.DefaultCaret;\n"
                + "import myTools.UsarGridBagLayout;\n"
                + "import java.awt.LayoutManager;\n"
                + "import java.awt.event.MouseAdapter;\n"
                + "import java.awt.event.MouseEvent;\n"
                + "import java.io.File;\n"
                + "import java.text.ParseException;\n"
                + "import java.util.logging.Level;\n"
                + "import java.util.logging.Logger;\n"
                + "import java.util.Date;\n"
                + "import javax.swing.JComboBox;\n"
                + "import java.util.Date;\n"
                + "import java.text.SimpleDateFormat;\n"
                + "import java.util.Date;\n"
                + "import java.text.SimpleDateFormat;\n"
                + "import javax.swing.ImageIcon;\n"
                + "import javax.swing.JFileChooser;"
                + "\n"
                + "import myTools.CopiaImagem;");
        //import java.util.Date;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].equals("Date")) {
                codigoGerado.add("import java.util.Date;\n"
                        + "import java.text.SimpleDateFormat;");
            }
        }

        codigoGerado.add("public class " + nomeClasse + "GUI extends JFrame{\n\n"
                + "SimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"dd/MM/yyyy\");\n"
                + "\n"
                + "    public Date converteDeStringParaDate(String s) {\n"
                + "        try {\n"
                + "            return simpleDateFormat.parse(s);\n"
                + "        } catch (Exception e) {\n"
                + "            return null;\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "    public String converteDeDateParaString(Date data) {\n"
                + "        try {\n"
                + "            return simpleDateFormat.format(data);\n"
                + "        } catch (Exception e) {\n"
                + "            return null;\n"
                + "        }\n"
                + "    }"
                + "private Ferramentas ferramentas = new Ferramentas();\n"
                + "private " + nomeClasse + " " + nomeClasse.toLowerCase() + ";\n"
                + "private " + nomeClasse + "Controle " + nomeClasse.toLowerCase() + "controle = new " + nomeClasse + "Controle();"
                + "private " + nomeClasse2 + "Controle " + nomeClasse2.toLowerCase() + "controle = new " + nomeClasse2 + "Controle();"
                + "\n\n\n");

        codigoGerado.add("private Container cp;\n");

        codigoGerado.add("private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));\n"
                + "private JPanel pnCentro = new JPanel(new FlowLayout(FlowLayout.LEFT));\n"
                + "private JPanel pnOeste = new JPanel();\n"
                + "private JPanel pnLeste = new JPanel();"
                + "\n\n");

        codigoGerado.add("private CardLayout CardLayout = new CardLayout();\n\n");

        codigoGerado.add("private JPanel pnSul = new JPanel(CardLayout);\n"
                + "private JPanel pnSulMsg = new JPanel();\n"
                + "private JPanel pnSulListagem = new JPanel(new GridLayout(1,1));"
                + "\n\n");

        codigoGerado.add("private JButton btVoltar = new JButton(\"Menu\");\n"
                + "private JButton btBuscar = new JButton(\"Buscar\");\n"
                + "private JButton btInserir = new JButton(\"Inserir\");\n"
                + "private JButton btAlterar = new JButton(\"Alterar\");\n"
                + "private JButton btExcluir = new JButton(\"Excluir\");\n"
                + "private JButton btListar = new JButton(\"Listar\");\n"
                + "private JButton btSalvar = new JButton(\"Salvar\");\n"
                + "private JButton btCancelar = new JButton(\"Cancelar\");\n"
                + "private JButton btLimpar = new JButton(\"Limpar\");\n"
                + "private JButton btGravar = new JButton();\n\n");

        String nomes = "";
        String tipos = "";
        int qt = 0;
        String ler = "";

        String lbnomes = "";
        String tfnomes = "";

        String cb = "";

        for (int i = 0; i < arquivoBase.size(); i++) {
            String tipo, nome;
            String[] t = arquivoBase.get(i).split(";");
            tipo = t[0];
            tipos += tipo + ",";
            nome = t[1];
            switch (tipo) {
                case "int":
                    if (i != arquivoBase.size()) {
                        ler += "Integer.valueOf(aux[" + i + "]), ";
                    }
                    break;
                case "long":
                    if (i != arquivoBase.size()) {
                        ler += "Long.valueOf(aux[" + i + "]), ";
                    }
                    break;
                case "String":
                    if (i != arquivoBase.size()) {
                        ler += "aux[" + i + "], ";
                    }
                    break;
                case "double":
                    if (i != arquivoBase.size()) {
                        ler += "Double.valueOf(aux[" + i + "]), ";
                    }
                    break;
                case "Date":
                    if (i != arquivoBase.size()) {
                        ler += "converteDeStringParaDate(aux[" + i + "]), ";
                    }
                    break;
                case "boolean":
                    if (i != arquivoBase.size()) {

                        ler += "aux[" + i + "].equalsIgnoreCase(\"true\")?true:false, ";
                    }
                    break;
                case "combo":
                    if (i != arquivoBase.size()) {

                        ler += "Integer.valueOf(aux[" + i + "]), ";
                    }
                    break;
                default:
                    System.out.println("tipo noa tradadat");
            }
            qt += 1;
            nomes += "\"" + nome + "\"" + ",";
            if (tipo.equals("boolean")) {
                codigoGerado.add("private JLabel lb" + nome + " = new JLabel(\"" + nome + "\");\n"
                        + "private JCheckBox tf" + nome + " = new JCheckBox();\n");
                lbnomes += "lb" + nome + ";";
                tfnomes += "tf" + nome + ";";
            } else if (tipo.equals("Date")) {
                codigoGerado.add("private JLabel lb" + nome + " = new JLabel(\"" + nome + "\");\n"
                        + "private DateTextField tf" + nome + " = new DateTextField();\n");
                lbnomes += "lb" + nome + ";";
                tfnomes += "tf" + nome + ";";
            } else if (tipo.equals("combo")) {
                codigoGerado.add("private JLabel lb" + nome + " = new JLabel(\"" + nome + "\");\n"
                        + "    private JComboBox cb" + nome + "  = new JComboBox();");
                lbnomes += "lb" + nome + ";";
                tfnomes += "cb" + nome + ";";
                cb = "cb" + nome;
            } else {
                if (i == 0) {
                    codigoGerado.add("private JLabel lb" + nome + " = new JLabel(\"" + nome + "\");\n"
                            + "private JTextField tf" + nome + " = new JTextField(6);\n");
                    lbnomes += "lb" + nome + ";";
                    tfnomes += "tf" + nome + ";";
                } else {
                    codigoGerado.add("private JLabel lb" + nome + " = new JLabel(\"" + nome + "\");\n"
                            + "private JTextField tf" + nome + " = new JTextField(30);\n");
                    lbnomes += "lb" + nome + ";";
                    tfnomes += "tf" + nome + ";";
                }
            }
        }

        codigoGerado.add("JLabel labelFoto = new JLabel(\"\");\n"
                + "    String acao = \"\";\n"
                + "    Image imagemAux;\n"
                + "    String origem;\n"
                + "    String destino = \"src/imagens/\";");

        nomes = nomes.substring(0, nomes.length() - 1);
        String nomesno = nomes.replace("\"", "");
        String[] nms = nomesno.split(",");
        ler = ler.substring(0, ler.length() - 2);
        tipos = tipos.substring(0, tipos.length() - 1);
        tfnomes = tfnomes.substring(0, tfnomes.length() - 1);
        lbnomes = lbnomes.substring(0, lbnomes.length() - 1);
        String[] lbNm = lbnomes.split(";");
        String[] tfNm = tfnomes.split(";");
        String[] tps = tipos.split(",");

        codigoGerado.add("private String[] colunas = new String[]{" + nomes + "};\n"
                + "private String[][] dados = new String[0][" + qt + "];\n");

        codigoGerado.add("private DefaultTableModel model = new DefaultTableModel(dados, colunas);\n"
                + "    private JTable tabela = new JTable(model);\n"
                + "  \n"
                + "    private JScrollPane scrollList = new JScrollPane();\n"
                + "\n"
                + "    private JScrollPane scrollMensagem = new JScrollPane(); \n"
                + "\n"
                + "    private JTextArea textAreaMsg = new JTextArea(6, 150); \n"
                + "    \n"
                + "    private DefaultCaret caret = (DefaultCaret) textAreaMsg.getCaret();\n"
                + "    \n"
                + "    private void setLog(String msg) {\n"
                + "        textAreaMsg.append(msg + \"\\n\");\n"
                + "        textAreaMsg.setCaretPosition(textAreaMsg.getDocument().getLength());\n"
                + "    }"
                + "    private boolean inserindo;");

        codigoGerado.add("    private void travar(boolean campo) {");
        codigoGerado.add(tfNm[0] + ".setEditable(campo);");
        for (int i = 0; i < (tfNm.length) - 1; i++) {
            codigoGerado.add(tfNm[i + 1] + ".setEnabled(!campo);");
        }
        codigoGerado.add("if (!campo) {\n"
                + "            " + tfNm[1] + ".requestFocus();\n"
                + "            " + tfNm[1] + ".selectAll();\n"
                + "        }\n"
                + "    }");

        codigoGerado.add("private void travariD(boolean campo){\n"
                + "        " + tfNm[0] + ".setEditable(!campo);\n"
                + "    }");

        codigoGerado.add("private void pintarAchou(){");
        for (int i = 0; i < tfNm.length; i++) {
            codigoGerado.add(tfNm[i] + ".setBackground(Color.DARK_GRAY);");
        }
        codigoGerado.add("}");

        codigoGerado.add("private void pintarNao(){");
        for (int i = 0; i < tfNm.length; i++) {
            codigoGerado.add(tfNm[i] + ".setBackground(Color.WHITE);");
        }
        codigoGerado.add("}");

        codigoGerado.add("    private void limpar() {");
        for (int i = 0; i < tfNm.length; i++) {
            if (tps[i].equals("combo")) {
                codigoGerado.add(tfNm[i] + ".setSelectedIndex(0);");
            } else if (tps[i].equals("Date")) {
                codigoGerado.add(tfNm[i] + ".setText(\"dd/mm/aaaa\");");
            } else {
                codigoGerado.add(tfNm[i] + ".setText(\"\");");
            }
        }
        codigoGerado.add("}");

        codigoGerado.add("  public " + nomeClasse + "GUI() throws ParseException {\n"
                + "List<String> listaAuxiliar = ferramentas.abrirArquivo(\"" + nomeClasse.toLowerCase() + ".txt\");\n"
                + "        if (listaAuxiliar != null) {\n"
                + "            for (int i = 0; i < listaAuxiliar.size(); i++) {\n"
                + "                String aux[] = listaAuxiliar.get(i).split(\";\");\n"
                + "               " + nomeClasse + " c = new " + nomeClasse + "(" + ler + ");\n"
                + "               " + nomeClasse.toLowerCase() + "controle" + ".inserir(c);\n"
                + "            }\n"
                + "        }");

        codigoGerado.add(cb + ".addItem(\"---\");");

        codigoGerado.add("List<String> listaAuxiliar2 = ferramentas.abrirArquivo(\"" + nomeClasse2.toLowerCase() + ".txt\");\n"
                + "String g=\"\";\n"
                + "        if (listaAuxiliar2 != null) {\n"
                + "            for (int i = 0; i < listaAuxiliar2.size(); i++) {\n"
                + "                String aux = listaAuxiliar2.get(i);\n"
                + "                String[] lg =aux.split(\";\");\n"
                + "                " + cb + ".addItem(lg[1]);\n"
                + "                g+=aux+\";\";"
                + "            }\n"
                + "        }");

        codigoGerado.add("setSize(800, 600);\n"
                + "        setDefaultCloseOperation(DISPOSE_ON_CLOSE);\n"
                + "        cp = getContentPane();\n"
                + "        cp.setLayout(new BorderLayout());\n"
                + "        setTitle(\"Sistema\");\n"
                + "        \n"
                + "        cp.add(pnOeste, BorderLayout.WEST);\n"
                + "        \n"
                + "        cp.add(pnLeste, BorderLayout.EAST);\n"
                + "                \n"
                + "        cp.add(pnSul, BorderLayout.SOUTH);\n"
                + "        \n"
                + "        cp.add(pnNorte, BorderLayout.NORTH);\n"
                + "        \n"
                + "        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/home.png\")));\n"
                + "        pnNorte.add(btVoltar);\n"
                + "        btVoltar.setToolTipText(\"Voltar ao menu principal\");\n"
                + "        pnNorte.add(" + lbNm[0] + ");\n"
                + "        pnNorte.add(" + tfNm[0] + ");\n"
                + "        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/src.png\")));\n"
                + "        pnNorte.add(btBuscar);\n"
                + "        btBuscar.setToolTipText(\"Buscar\");\n"
                + "        btListar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/list.png\")));\n"
                + "        pnNorte.add(btListar);\n"
                + "        btListar.setToolTipText(\"Listar\");\n"
                + "        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/in.png\")));\n"
                + "        pnNorte.add(btInserir);\n"
                + "        btInserir.setToolTipText(\"Inserir\");\n"
                + "        btInserir.setVisible(false);\n"
                + "        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/change.png\")));\n"
                + "        pnNorte.add(btAlterar);\n"
                + "        btAlterar.setToolTipText(\"Alterar\");\n"
                + "        btAlterar.setVisible(false);\n"
                + "        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/rem.png\")));\n"
                + "        pnNorte.add(btExcluir);\n"
                + "        btExcluir.setToolTipText(\"Excluir\");\n"
                + "        btExcluir.setVisible(false);\n"
                + "        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/save.png\")));\n"
                + "        pnNorte.add(btSalvar);\n"
                + "        btSalvar.setToolTipText(\"Salvar\");\n"
                + "        btSalvar.setVisible(false);\n"
                + "        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/imagens/cancel.png\")));\n"
                + "        pnNorte.add(btCancelar);\n"
                + "        btCancelar.setToolTipText(\"Cancelar\");\n"
                + "        btCancelar.setVisible(false);\n"
                + "        pnNorte.add(btLimpar);\n"
                + "        btLimpar.setToolTipText(\"Limpar\");\n"
                + "        btLimpar.setVisible(false);\n"
                + "        setLocationRelativeTo(null);\n"
                + "        setVisible(true);");

        codigoGerado.add("cp.add(pnCentro, BorderLayout.CENTER);\n"
                + "        pnCentro.setLayout(new GridLayout(" + ((tfNm.length) - 1) + ", 1));");

        for (int i = 0; i < (tfNm.length) - 1; i++) {
            codigoGerado.add("JPanel pnCentro" + (i + 1) + " = new JPanel(new FlowLayout(FlowLayout.RIGHT));\n"
                    + "        pnCentro" + (i + 1) + ".add(" + lbNm[i + 1] + ");\n"
                    + "        pnCentro" + (i + 1) + ".add(" + tfNm[i + 1] + ");\n"
                    + "pnCentro.add(pnCentro" + (i + 1) + ");");
        }

        codigoGerado.add("pnOeste.add(labelFoto);");

        codigoGerado.add("try {\n"
                + "            origem = \"/imagens/0.png\";\n"
                + "            ImageIcon icone = new ImageIcon(getClass().getResource(origem));\n"
                + "            imagemAux = icone.getImage();\n"
                + "            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));\n"
                + "            labelFoto.setIcon(icone);\n"
                + "\n"
                + "        } catch (Exception e) {\n"
                + "            System.out.println(\"erro ao carregar a imagem\");\n"
                + "        }");

        for (int i = 0; i < (tfNm.length); i++) {
            if (i != 0) {
                codigoGerado.add(tfNm[i] + ".setEnabled(false);");
            }
        }

        codigoGerado.add(" pnNorte.setBackground(Color.ORANGE);\n"
                + "\n"
                + "        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);\n"
                + "        scrollMensagem.setViewportView(textAreaMsg);\n"
                + "        scrollMensagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);\n"
                + "\n"
                + "        UsarGridBagLayout usarGridBagLayoutSul = new UsarGridBagLayout(pnSulMsg);\n"
                + "        usarGridBagLayoutSul.add(new JLabel(\"log\"), scrollMensagem);\n"
                + "        pnSul.add(pnSulMsg, \"pnMsg\");\n"
                + "        pnSul.add(pnSulListagem, \"pnLst\");\n"
                + "\n"
                + "        btGravar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                List<String> listaStr = " + nomeClasse.toLowerCase() + "controle.listar();\n"
                + "                ferramentas.salvarArquivo(\"" + nomeClasse.toLowerCase() + ".txt\", listaStr);\n"
                + "            }\n"
                + "        });");

        String bsb = "(";
        if (tps[0].equals("int")) {
            bsb = "Integer.valueOf(";
        }
        if (tps[0].equals("double")) {
            bsb = "Double.valueOf(";
        }
        if (tps[0].equals("long")) {
            bsb = "Long.valueOf(";
        }

        codigoGerado.add("btBuscar.addActionListener((ActionEvent e) -> {\n"
                + "            if (" + tfNm[0] + ".getText().trim().equals(\"\")) {\n"
                + "                JOptionPane.showMessageDialog(cp, \"Nada informado\");\n"
                + "            } else {\n"
                + "                try {\n"
                + "                    " + tfNm[0] + ".setBackground(Color.GREEN);\n"
                + "                     " + nomeClasse.toLowerCase() + " = " + nomeClasse.toLowerCase() + "controle.buscar(" + bsb + tfNm[0] + ".getText()));\n"
                + "                    if (" + nomeClasse.toLowerCase() + " == null) {\n"
                + "                        btInserir.setVisible(true);\n"
                + "                        btAlterar.setVisible(false);\n"
                + "                        btExcluir.setVisible(false);\n"
                + "                        JOptionPane.showMessageDialog(cp, \"Não achou na lista, pode inserir se quiser!\");\n"
                + "                        pintarNao();"
                + "                        CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                        setLog(\"Não achou na lista, pode inserir se quiser\");\n"
                + "                    } else {\n"
                + "btLimpar.setVisible(true);\n"
                + "                        btAlterar.setVisible(true);\n"
                + "                        btInserir.setVisible(false);\n"
                + "                        btExcluir.setVisible(true);\n"
                + "                        " + tfNm[0] + ".setText(String.valueOf(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[0]) + "()));");

        for (int i = 0; i < (tfNm.length) - 1; i++) {
            if (tps[i + 1].equals("boolean")) {
                codigoGerado.add(tfNm[i + 1] + ".setSelected(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[i + 1]) + "());");
            } else if (tps[i + 1].equals("Date")) {
                codigoGerado.add(tfNm[i + 1] + ".setText(converteDeDateParaString(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[i + 1]) + "()));");
            } else if (tps[i + 1].equals("combo")) {
                codigoGerado.add(tfNm[i + 1] + ".setSelectedIndex(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[i + 1]) + "());");
            } else {
                codigoGerado.add(tfNm[i + 1] + ".setText(String.valueOf(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[i + 1]) + "()));");
            }

        }

        codigoGerado.add(
                "\n"
                + "                        CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                        setLog(\"Achou (\" + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[0]) + "());\n"
                + "                        travar(true);\n"
                + "                        travariD(true);\n"
                + "                        pintarAchou();"
                + "                        String aux = String.valueOf(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[0]) + "());"
                + "                        origem = \"src/imagens/\" + aux + \".png\";\n"
                + "                        File img = new File(origem);//ler novamente a imagem\n"
                + "                        ImageIcon icone;\n"
                + "                        if (img.exists()) {\n"
                + "                            icone = new javax.swing.ImageIcon(img.getAbsolutePath());\n"
                + "\n"
                + "                        } else {\n"
                + "                            origem = \"src/imagens/0.png\";\n"
                + "                            img = new File(origem);//ler novamente a imagem\n"
                + "                            icone = new javax.swing.ImageIcon(img.getAbsolutePath());\n"
                + "                        }\n"
                + "                        //fim da modificação\n"
                + "\n"
                + "                        Image imagemAux;\n"
                + "                        imagemAux = icone.getImage();\n"
                + "                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));\n"
                + "                        labelFoto.setIcon(icone);"
                + "                    }\n"
                + "                } catch (Exception x) {\n"
                + "                    " + tfNm[0] + ".selectAll();\n"
                + "                    " + tfNm[0] + ".requestFocus();\n"
                + "                    " + tfNm[0] + ".setBackground(Color.RED);\n"
                + "                    limpar();"
                + "                    CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                    setLog(\"Erro no tipo de dados da chave. (\" + x.getMessage() + \")\");\n"
                + "                }\n"
                + "            }\n"
                + "            " + tfNm[0] + ".selectAll();\n"
                + "            " + tfNm[0] + ".requestFocus();\n"
                + "        });");

        codigoGerado.add(
                "btVoltar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent ae) {\n"
                + "                GUIMenu guiMenu = new GUIMenu();  \n"
                + "                dispose();\n"
                + "            }\n"
                + "        });");

        codigoGerado.add(
                "btInserir.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                " + tfNm[0] + ".requestFocus();\n"
                + "                btInserir.setVisible(false);\n"
                + "                btSalvar.setVisible(true);\n"
                + "                btCancelar.setVisible(true);\n"
                + "                btBuscar.setVisible(false);\n"
                + "                btListar.setVisible(false);\n"
                + "                inserindo = true;\n"
                + "                travar(false);\n"
                + "                CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                setLog(\"Inserindo um novo registro\");\n"
                + "acao = \"insert\";"
                + "origem = \"/imagens/0.png\";\n"
                + "            ImageIcon icone = new ImageIcon(getClass().getResource(origem));\n"
                + "            imagemAux = icone.getImage();\n"
                + "            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));\n"
                + "            labelFoto.setIcon(icone);"
                + "            }\n"
                + "        });");

        codigoGerado.add(
                "btSalvar.addActionListener((ActionEvent e) -> {\n"
                + "            " + nomeClasse + " " + nomeClasse.toLowerCase() + "Original = " + nomeClasse.toLowerCase() + ";\n"
                + "            try{"
                + "            if (inserindo) {\n"
                + "                " + nomeClasse.toLowerCase() + " = new " + nomeClasse + "();\n"
                + "            }");

        codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[0]) + "(" + bsb + tfNm[0] + ".getText()));");
        for (int i = 1;
                i < nms.length;
                i++) {
            System.out.println(tps[i]);
            System.out.println(nms[i]);
            System.out.println(tfNm[i]);
            if (tps[i].equals("String")) {
                codigoGerado.add("try{");
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[i]) + "(" + tfNm[i] + ".getText());");
                codigoGerado.add("} catch (Exception " + tfNm[i] + ") {\n"
                        + "                setLog(\"Erro no tipo de dados da chave. (\" + " + tfNm[i] + ".getMessage() + \")\");\n"
                        + "            inserindo = false;\n"
                        + "btCancelar.doClick();\n"
                        + "                JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");}");
            } else if (tps[i].equals("boolean")) {
                codigoGerado.add("try{");
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[i]) + "(" + tfNm[i] + ".isSelected());");
                codigoGerado.add("} catch (Exception " + tfNm[i] + ") {\n"
                        + "                setLog(\"Erro no tipo de dados da chave. (\" + " + tfNm[i] + ".getMessage() + \")\");\n"
                        + "            inserindo = false;\n"
                        + "btCancelar.doClick();\n"
                        + "                JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");}");
            } else if (tps[i].equals("double")) {
                codigoGerado.add("try{");
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[i]) + "(Double.valueOf(" + tfNm[i] + ".getText()));");
                codigoGerado.add("} catch (Exception " + tfNm[i] + ") {\n"
                        + "                setLog(\"Erro no tipo de dados da chave. (\" + " + tfNm[i] + ".getMessage() + \")\");\n"
                        + "            inserindo = false;\n"
                        + "btCancelar.doClick();\n"
                        + "                JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");}");
            } else if (tps[i].equals("long")) {
                codigoGerado.add("try{");
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[i]) + "(Long.valueOf(" + tfNm[i] + ".getText()));");
                codigoGerado.add("} catch (Exception " + tfNm[i] + ") {\n"
                        + "                setLog(\"Erro no tipo de dados da chave. (\" + " + tfNm[i] + ".getMessage() + \")\");\n"
                        + "            inserindo = false;\n"
                        + "btCancelar.doClick();\n"
                        + "                JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");}");
            } else if (tps[i].equals("int")) {
                codigoGerado.add("try{");
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[i]) + "(Integer.valueOf(" + tfNm[i] + ".getText()));");
                codigoGerado.add("} catch (Exception " + tfNm[i] + ") {\n"
                        + "                setLog(\"Erro no tipo de dados da chave. (\" + " + tfNm[i] + ".getMessage() + \")\");\n"
                        + "            inserindo = false;\n"
                        + "btCancelar.doClick();\n"
                        + "                JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");}");
            } else if (tps[i].equals("Date")) {
                codigoGerado.add("try {");
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[i]) + "(converteDeStringParaDate(" + tfNm[i] + ".getText()));");
                codigoGerado.add("} catch (Exception ex) {\n"
                        + "                Logger.getLogger(" + nomeClasse + "GUI.class.getName()).log(Level.SEVERE, null, ex);\n"
                        + "            inserindo = false;\n"
                        + "btCancelar.doClick();\n"
                        + "                JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");}");
            } else if (tps[i].equals("combo")) {
                codigoGerado.add("try {");
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(nms[i]) + "((" + cb + ".getSelectedIndex())-1);");
                codigoGerado.add("} catch (Exception ex) {\n"
                        + "                Logger.getLogger(" + nomeClasse + "GUI.class.getName()).log(Level.SEVERE, null, ex);\n"
                        + "            inserindo = false;\n"
                        + "btCancelar.doClick();\n"
                        + "                JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");}");
            }

            System.out.println("deu");
        }

        codigoGerado.add(
                "if (inserindo) {\n"
                + "                " + nomeClasse.toLowerCase() + "controle.inserir(" + nomeClasse.toLowerCase() + ");\n"
                + "                CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                setLog(\"Inseriu (\" + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[0]) + "());\n"
                + "            } else {\n"
                + "                " + nomeClasse.toLowerCase() + "controle.alterar(" + nomeClasse.toLowerCase() + "Original, " + nomeClasse.toLowerCase() + ");\n"
                + "                CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                setLog(\"Alterou (\" + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[0]) + "());\n"
                + "            }");

        codigoGerado.add("destino = destino + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[0]) + "()+ \".png\";\n"
                + "//                    System.out.println(\"origem =>\" + origem);\n"
                + "//                    System.out.println(\"destino =>\" + destino);\n"
                + "                CopiaImagem.copiar(origem, destino);\n"
                + "                destino = \"src/imagens/\";");

        codigoGerado.add(
                "" + tfNm[0] + ".requestFocus();\n"
                + "            " + tfNm[0] + ".selectAll();\n"
                + "            btSalvar.setVisible(false);\n"
                + "            btCancelar.setVisible(false);\n"
                + "btLimpar.setVisible(false);\n"
                + "            btBuscar.setVisible(true);\n"
                + "            btListar.setVisible(true);\n"
                + "            btGravar.doClick();\n"
                + "            limpar();\n"
                + "            " + tfNm[0] + ".setText(\"\");\n"
                + "            travar(true);\n"
                + "            inserindo = false;\n");
        codigoGerado.add(
                "} catch (Exception abx) {");
        codigoGerado.add(
                "JOptionPane.showMessageDialog(cp, \"ERRO NO TIPO DE DADOS POR FAVOR INFORME OS CAMPOS CORRETAMENTE\");"
                + "btCancelar.doClick();");
        codigoGerado.add(
                "}});");

        codigoGerado.add(
                "btAlterar.addActionListener((ActionEvent e) -> {\n"
                + "            " + tfNm[0] + ".requestFocus();\n"
                + "            btSalvar.setVisible(true);\n"
                + "            btCancelar.setVisible(true);\n"
                + "            btBuscar.setVisible(false);\n"
                + "            btAlterar.setVisible(false);\n"
                + "            btExcluir.setVisible(false);\n"
                + "            btListar.setVisible(false);\n"
                + "btLimpar.setVisible(false);\n"
                + "            pintarNao();\n"
                + "            travar(false);\n"
                + "            CardLayout.show(pnSul, \"pnMsg\");\n"
                + "            setLog(\"Alterando um registro existente\");\n"
                + "\n"
                + "                acao = \"update\";"
                + "        });");

        codigoGerado.add(
                "btExcluir.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                int dialogResult = JOptionPane.showConfirmDialog(cp, \"Vai excluir (\"\n"
                + "                        + " + tfNm[1] + ".getText() + \")?\", \"Exclui da lista\", NORMAL);\n"
                + "                if (dialogResult == JOptionPane.YES_OPTION) {\n"
                + "                    " + nomeClasse.toLowerCase() + "controle.excluir(" + nomeClasse.toLowerCase() + ");\n"
                + "                    CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                    setLog(\"Excluiu (\" + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(nms[0]) + "());\n"
                + "                    btGravar.doClick();\n"
                + "                    limpar();\n"
                + "                    " + tfNm[0] + ".setText(\"\");\n"
                + "                    " + tfNm[0] + ".requestFocus();\n"
                + "                    pintarNao();\n"
                + "                    btExcluir.setVisible(false);\n"
                + "                    btLimpar.setVisible(false);\n"
                + "                    btAlterar.setVisible(false);\n"
                + "                    travar(true);\n"
                + "                    travariD(false);\n"
                + "                }\n"
                + "            }\n"
                + "        });");

        codigoGerado.add(
                "btLimpar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                limpar();\n"
                + "                travar(true);\n"
                + "                travariD(false);\n"
                + "                pintarNao();\n"
                + "                CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                setLog(\"Campos limpos\");\n"
                + "                btAlterar.setVisible(false);\n"
                + "                btCancelar.setVisible(false);\n"
                + "                btExcluir.setVisible(false);\n"
                + "                btInserir.setVisible(false);\n"
                + "                btLimpar.setVisible(false);\n"
                + "                btSalvar.setVisible(false);\n"
                + tfNm[0] + ".requestFocus();\n"
                + "            }\n"
                + "        });");

        codigoGerado.add(
                "btCancelar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                " + tfNm[0] + ".requestFocus();\n"
                + "                " + tfNm[0] + ".selectAll();\n"
                + "                btInserir.setVisible(false);\n"
                + "                btSalvar.setVisible(false);\n"
                + "                btLimpar.setVisible(false);\n"
                + "                btCancelar.setVisible(false);\n"
                + "                btBuscar.setVisible(true);\n"
                + "                btListar.setVisible(true);\n"
                + "                travar(true);\n"
                + "                limpar();\n"
                + "                " + tfNm[0] + ".setText(\"\");\n"
                + "                CardLayout.show(pnSul, \"pnMsg\");\n"
                + "                setLog(\"Cancelou a alteração ou inclusão do registro\");\n"
                + "            }\n"
                + "        });");

        String auxss = "";
        for (int i = 0;
                i < qt;
                i++) {
            auxss += "aux[" + i + "], ";
        }
        auxss = auxss.substring(0, auxss.length() - 2);

        codigoGerado.add(
                "btListar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                CardLayout.show(pnSul, \"pnLst\");\n"
                + "                scrollList.setPreferredSize(tabela.getPreferredSize());\n"
                + "                pnSulListagem.add(scrollList);\n"
                + "                scrollList.setViewportView(tabela);\n"
                + "                List<String> listaDeContatos = " + nomeClasse.toLowerCase() + "controle.listar();\n"
                + "                String[] aux;\n"
                + "                colunas = new String[]{" + nomes + "};\n"
                + "                dados = new String[0][" + qt + "];\n"
                + "                model.setDataVector(dados, colunas);\n"
                + "                for (int i = 0; i < listaDeContatos.size(); i++) {\n"
                + "                    aux = listaDeContatos.get(i).split(\";\");\n"
                + "                    String[] linha = new String[]{" + auxss + "};\n"
                + "                    model.addRow(linha);\n"
                + "                }\n"
                + "            }\n"
                + "        });");

        codigoGerado.add("labelFoto.addMouseListener(new MouseAdapter() {\n"
                + "            public void mouseReleased(MouseEvent e) {\n"
                + "                if (acao.equals(\"insert\") || acao.equals(\"update\")) {\n"
                + "                    JFileChooser fc = new JFileChooser();\n"
                + "                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);\n"
                + "                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {\n"
                + "                        File img = fc.getSelectedFile();\n"
                + "                        origem = fc.getSelectedFile().getAbsolutePath();\n"
                + "                        try {\n"
                + "                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());\n"
                + "                            Image imagemAux;\n"
                + "                            imagemAux = icone.getImage();\n"
                + "                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));\n"
                + "                            labelFoto.setIcon(icone);\n"
                + "\n"
                + "                        } catch (Exception ex) {\n"
                + "                            System.out.println(\"Erro: \" + ex.getMessage());\n"
                + "                        }\n"
                + "                    }\n"
                + "\n"
                + "                }\n"
                + "\n"
                + "            }\n"
                + "        });");

        codigoGerado.add(
                "addWindowListener(new WindowAdapter() {\n"
                + "            @Override\n"
                + "            public void windowClosing(WindowEvent e) {\n"
                + "                btGravar.doClick();\n"
                + "                dispose();\n"
                + "            }\n"
                + "        });\n"
                + "\n"
                + "        tabela.setEnabled(false);");

        codigoGerado.add(
                "}}");

        String cc = projetoDestino + "/src/Main/";

        System.out.println(
                "Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc
                + nomeClasse + "GUI.java", codigoGerado);
    }
}
