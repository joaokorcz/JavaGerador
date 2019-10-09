package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import Geradores.GerarClasseDeControle;
import Geradores.GerarClasseDeEntidade;
import Geradores.GerarClasseDeGUI;
import Geradores.GerarDateTextField;
import Geradores.GerarMain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import myTools.Ferramentas;

public class GUI extends JFrame {

    private Container cp;
    private JLabel labelNomeProjetoDestino = new JLabel("Projeto Destino");//onde serão gerados os códigos
    private JTextField textFieldProjetoDestino = new JTextField(50);
    private JPanel painelNorte = new JPanel(new GridLayout(3, 1));
    private JPanel painelNorteLinha2 = new JPanel();
    private JPanel painelNorteLinha1 = new JPanel();
    private JPanel painelNorteLinha3 = new JPanel();
    private JPanel painelSul = new JPanel();

    private JButton botaoEscolherProjetoDestino = new JButton("Escolher projeto destino");
    private JButton botaoGerarClasseEntidade = new JButton("Gerar Entidade");
    private JButton botaoGerarClasseControle = new JButton("Gerar Controle");
    private JButton botaoGerarClasseGUI = new JButton("Gerar GUI");
    private JButton botaoGerarDate = new JButton("Gerar DTTF");
    private JButton botaoGerarMain = new JButton("Gerar Main");

    private JLabel labelArqTexto = new JLabel("Nome do arquivo da entidade");
    private JLabel labelArqTexto2 = new JLabel("Nome do arquivo da entidade 2");
    private JTextField textFieldArquivoTexto = new JTextField(15);
    private JTextField textFieldArquivoTexto2 = new JTextField(15);

    private JFileChooser caixaDeDialogo = new JFileChooser();
    private String caminho = "/home";
    private List<String> arqUltimaExecucao = new ArrayList<>();
    Ferramentas ferramentas = new Ferramentas();

    public GUI() {

        //carregar arquivo da última execução
        arqUltimaExecucao = ferramentas.abrirArquivo("UltimaExecucao.dat");// 
        if (arqUltimaExecucao != null) {
            caminho = arqUltimaExecucao.get(0);
            //   System.out.println("caminho last " + caminho);
            textFieldProjetoDestino.setText(caminho);
        }

        setSize(1000, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gerador de código 2018");
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(painelNorte, BorderLayout.NORTH);
        cp.add(painelSul, BorderLayout.SOUTH);
        
        painelNorte.add(painelNorteLinha1);
        painelNorte.add(painelNorteLinha2);
        painelNorte.add(painelNorteLinha3);

        painelNorteLinha1.add(labelNomeProjetoDestino);
        painelNorteLinha1.add(textFieldProjetoDestino);
        painelNorteLinha1.add(botaoEscolherProjetoDestino);

        painelNorteLinha2.add(labelArqTexto);
        painelNorteLinha2.add(textFieldArquivoTexto);
        textFieldArquivoTexto.setText("Pessoa");
        painelNorteLinha2.add(labelArqTexto2);
        painelNorteLinha2.add(textFieldArquivoTexto2);
        textFieldArquivoTexto2.setText("genero");
        
        painelSul.add(botaoGerarClasseEntidade);
        painelSul.add(botaoGerarClasseControle);
        painelSul.add(botaoGerarClasseGUI);
        painelSul.add(botaoGerarDate);
        painelSul.add(botaoGerarMain);

        botaoEscolherProjetoDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("DIRETÓRIO", "..", "..");
                caixaDeDialogo.setFileFilter(filter);
                caixaDeDialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                File file = new File(caminho);
                if (file.exists()) {
                    caixaDeDialogo.setCurrentDirectory(file);
                } else {
                    file = new File("/home");
                    if (file.exists()) {
                        caixaDeDialogo.setCurrentDirectory(file);
                    } else {
                        caixaDeDialogo.setCurrentDirectory(null);
                    }

                }
                if (caixaDeDialogo.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                    caminho = caixaDeDialogo.getSelectedFile().getAbsolutePath();
                    textFieldProjetoDestino.setText(caminho);
                    arqUltimaExecucao = new ArrayList<>();
                    arqUltimaExecucao.add(caminho);
                    int arq = ferramentas.salvarArquivo("UltimaExecucao.dat", arqUltimaExecucao);

                    if (arqUltimaExecucao != null) {
                        caminho = arqUltimaExecucao.get(0);
                        textFieldProjetoDestino.setText(caminho);
                        // listaAtributo = new ArrayList();
                        textFieldProjetoDestino.setBackground(Color.green);
                    }
                }

            }
        });

        botaoGerarClasseEntidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    GerarClasseDeEntidade gerarClasseDeEntidade
                            = new GerarClasseDeEntidade(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    GerarClasseDeEntidade gerarClasseDeEntidade1 
                            = new GerarClasseDeEntidade(textFieldProjetoDestino.getText(), textFieldArquivoTexto2.getText());
                }
            }
        });
        
        botaoGerarDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    GerarDateTextField gerarDateTextField = new GerarDateTextField();
                    gerarDateTextField.gerarDateTextField(textFieldProjetoDestino.getText());
                }
            }
        });
        
        botaoGerarMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    GerarMain gerarMain = new GerarMain();
                    gerarMain.gerarMain(textFieldProjetoDestino.getText());
                }
            }
        });

        botaoGerarClasseControle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    Geradores.GerarClasseDeControle gcc
                            = new GerarClasseDeControle(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    Geradores.GerarClasseDeControle gcc2
                            = new GerarClasseDeControle(textFieldProjetoDestino.getText(), textFieldArquivoTexto2.getText());
                }
            }
        });
        
         botaoGerarClasseGUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    Geradores.GerarClasseDeGUI gcc
                            = new GerarClasseDeGUI(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText(), textFieldArquivoTexto2.getText());
                    Geradores.GerarClasseDeGUI gcc2
                            = new GerarClasseDeGUI(textFieldProjetoDestino.getText(), textFieldArquivoTexto2.getText(), textFieldArquivoTexto.getText());
                }
            }
        });

        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
