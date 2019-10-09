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
public class GerarMain {

    String projetoDestino;
    String nomeClasse;

    public void gerarMain(String projetoDestino) {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        codigoGerado.add("\n"
                + "package Main;\n"
                + "\n"
                + "import java.text.ParseException;\n"
                + "\n"
                + "\n"
                + "public class Main {\n"
                + "\n"
                + "    \n"
                + "    public static void main(String[] args) throws ParseException {\n"
                + "        \n"
                + "        GUIMenu guiMenu = new GUIMenu();\n"
                + "\n"
                + "    }\n"
                + "\n"
                + "}");

        String cc = projetoDestino + "/src/Main/" + "Main" + ".java";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc, codigoGerado);

    }

}
