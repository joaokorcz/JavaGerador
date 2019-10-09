/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geradores;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

/**
 *
 * @author radames
 */
public class GerarClasseDeControle {

    String projetoDestino;
    String nomeClasse;

    public GerarClasseDeControle(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        gerarClasseControle();
    }

    private void gerarClasseControle() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        //fazer a classe de controle de lista
        codigoGerado.clear();
        codigoGerado.add("package Main;\n"
                + "\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n");
        
        codigoGerado.add("import java.text.SimpleDateFormat;\n"
                + "import java.util.Date;");

        //import java.util.Date;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].equals("Date")) {
                codigoGerado.add("import java.util.Date;\n"
                        + "import java.text.SimpleDateFormat;");
            }
        }

        String na = "";
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            na += aux[1] + ", ";
        }
        na = na.substring(0, na.length() - 2);
        String[] nav = na.split(",");

        codigoGerado.add("public class " + nomeClasse + "Controle {\n");

        codigoGerado.add("SimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"dd/MM/yyyy\");\n"
                + "\n"
                + "    public String converteDeDateParaString(Date data) {\n"
                + "\n"
                + "        try {\n"
                + "            return simpleDateFormat.format(data);\n"
                + "        } catch (Exception e) {\n"
                + "            return null;\n"
                + "        }\n"
                + "    }");

        codigoGerado.add("  List<" + nomeClasse + "> lista = new ArrayList<>();\n\n");

        String tipos = "";
        String tipo = "int";
        for (int i = 0; i < arquivoBase.size(); i++) {
            String[] t = arquivoBase.get(i).split(";");
            tipos+=t[0]+";";
            if (i == 0) {
                if (t[0].equals("String")) {
                    tipo = "String";
                }
                if (t[0].equals("long")) {
                    tipo = "long";
                }
            }
        }
        String[] tipos2 = tipos.split(";");
        System.out.println(tipo);
        if (tipo.equals("String")) {
            codigoGerado.add("public " + nomeClasse + " buscar(String chave){\n"
                    + "        for (int i = 0; i < lista.size(); i++) {\n"
                    + "            if (chave.equals(lista.get(i).get" + ferramentas.plMaius(nav[0]) + "())) {\n"
                    + "                return lista.get(i);\n"
                    + "            }\n"
                    + "        }\n"
                    + "        return null;\n"
                    + "    }\n");

        }
        if (tipo.equals("int")) {
            codigoGerado.add("public " + nomeClasse + " buscar(int chave){\n"
                    + "        for (int i = 0; i < lista.size(); i++) {\n"
                    + "            if (chave==lista.get(i).get" + ferramentas.plMaius(nav[0]) + "()) {\n"
                    + "                return lista.get(i);\n"
                    + "            }\n"
                    + "        }\n"
                    + "        return null;\n"
                    + "    }\n");
        }
        if (tipo.equals("long")) {
            codigoGerado.add("public " + nomeClasse + " buscar(long chave){\n"
                    + "        for (int i = 0; i < lista.size(); i++) {\n"
                    + "            if (chave==lista.get(i).get" + ferramentas.plMaius(nav[0]) + "()) {\n"
                    + "                return lista.get(i);\n"
                    + "            }\n"
                    + "        }\n"
                    + "        return null;\n"
                    + "    }\n");
        }

        codigoGerado.add("public void inserir(" + nomeClasse + " " + nomeClasse.toLowerCase() + "){\n"
                + "    lista.add(" + nomeClasse.toLowerCase() + ");\n"
                + "    }\n");

        codigoGerado.add("void alterar(" + nomeClasse + " " + nomeClasse.toLowerCase() + "Original, " + nomeClasse + " " + nomeClasse.toLowerCase() + "Alterado){\n"
                + "    lista.set(lista.indexOf(" + nomeClasse.toLowerCase() + "Original), " + nomeClasse.toLowerCase() + "Alterado);\n"
                + "    }\n");

        codigoGerado.add("   public void excluir(" + nomeClasse + " " + nomeClasse.toLowerCase() + "){\n"
                + "        lista.remove(" + nomeClasse.toLowerCase() + ");\n"
                + "    }");
        
        codigoGerado.add("    public List<String> listar() {\n"
                + "        List<String> ls = new ArrayList<>();\n"
                + "        for (int i = 0; i < lista.size(); i++) {\n"
                + "            ls.add(\"\"");

        for (int i = 0; i < nav.length; i++) {
            if (i != (nav.length) - 1) {
                if (tipos2[i].equals("Date")) {
                    codigoGerado.add("+ converteDeDateParaString(lista.get(i).get" + ferramentas.plMaius(nav[i]) + "()) + \";\"");
                } else {
                    codigoGerado.add("+ lista.get(i).get" + ferramentas.plMaius(nav[i]) + "() + \";\"");                    
                }
            }
            if (i == (nav.length) - 1) {
                if (tipos2[i].equals("Date")) {
                    codigoGerado.add("+ converteDeDateParaString(lista.get(i).get" + ferramentas.plMaius(nav[i]) + "())");
                } else {
                    codigoGerado.add("+ lista.get(i).get" + ferramentas.plMaius(nav[i]) + "()");                    
                }
            }
        }
        codigoGerado.add(" \n"
                + "            );\n"
                + "        }\n"
                + "        return ls;\n"
                + "    }");

        codigoGerado.add("}");

        String cc = projetoDestino + "/src/Main/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + nomeClasse + "Controle.java", codigoGerado);
    }
}
