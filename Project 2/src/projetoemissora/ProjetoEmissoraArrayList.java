/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoemissora;

import GestaoEmissora.EmissoraArrayList;
import GestaoEmissora.ProgramaArrayList;
import GestaoEmissora.Reporter;
import GestaoEmissora.ReporterArrayList;
import java.util.ArrayList;
import java.util.Scanner;


public class ProjetoEmissoraArrayList {

    public static void main(String[] args) {
        int opcao = 0;

        EmissoraArrayList E = new EmissoraArrayList(1, "Tabajara Organizações");
        ReporterArrayList R;
        ProgramaArrayList P;
        ArrayList<ReporterArrayList> ListaR = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do {
            opcao = MontaMenu();
            switch (opcao) {
                case 1:
                    //Cadastrar Reporter

                    LimpaTela();
                    for (int w = 0; w < 3; w++) {
                        R = new ReporterArrayList();
                        //Scanner sc = new Scanner(System.in);
                        System.out.print("Digite o nome do Reporter: ");
                        R.setIdSequecial(w);
                        R.setNome(sc.next());

                        ListaR.add(R);
                        System.out.println("Reporter cadastrado");
                    }
                    break;

                case 2:
                    // Associar Reporter a Emissora

                    if (ListaR.size() > 0) {
                        for (int x = 0; x < ListaR.size(); x++) {
                            System.out.println("Id: " + ListaR.get(x).getIdSequecial() + " Nome: " + ListaR.get(x).getNome());
                        }
                        System.out.println("Seleciona um dos Réporteres digitando seu id.");
                        System.out.print("Informe seu id: ");
                        int id = sc.nextInt();
                        if (VerificaReporterCadastro(id, ListaR)) {
                            E.AssociarReporter(ListaR);
                        } else {
                            System.out.println("Id Inválido");
                            sc.nextLine();
                        }

                    } else {
                        System.out.println("Não existe Reporteres cadastrados");
                        sc.nextLine();
                    }

                    break;

                case 3:
                    //Remover Reporter

                    if (ListaR.size() > 0) {
                        for (int a = 0; a < ListaR.size(); a++) {
                            System.out.println("Id: " + ListaR.get(a).getIdSequecial() + " Nome: " + ListaR.get(a).getNome());
                        }
                        System.out.println("Seleciona um dos Réporteres digitando seu id.");
                        System.out.print("Informe seu id: ");
                        int id = sc.nextInt();
                        if (VerificaReporterCadastro(id, ListaR)) {
                            E.RemoverReporter(id);
                            ListaR.remove(id);
                        } else {
                            System.out.println("Id Inválido");
                            sc.nextLine();
                        }
                    }

                    break;

                case 4:
                    //Listar Reporteres

                    E.ListadeReporteres();
                    break;

                case 5:
                    //Cadastrar Programas

                    LimpaTela();
                    for (int w = 0; w < 3; w++) {
                        P = new ProgramaArrayList();
                        //Scanner sc = new Scanner(System.in);
                        System.out.print("Digite o nome do Programa: ");
                        P.setIdSequencial(w);
                        P.setNome(sc.next());

                        E.InserirPrograma(P);
                        System.out.println("Programa cadastrado");
                    }

                    break;

                case 6:
                    //Remover Programas

                    E.ListadeProgramas();
                    System.out.println("Seleciona um dos Programas digitando seu id.");
                    System.out.print("Informe seu id: ");
                    int id = sc.nextInt();
                    E.RemoverPrograma(id);

                    break;

                case 7:
                    //Listar todos os Programas

                    E.ListadeProgramas();
                    break;

                case 8:
                    //Listar Programas por Reporter

                    E.ListadeReporteres();
                    E.ListadeProgramasporReporter(sc.nextInt());
                    break;
            }
        } while (opcao != 0);
    }

    private static int MontaMenu() {
        System.out.println("1 - Cadastrar Reporter.");
        System.out.println("2 - Associar Reporter a Emissora.");
        System.out.println("3 - Remover Reporter.");
        System.out.println("4 - Listar Reporteres.");
        System.out.println("5 - Cadastrar Programas.");
        System.out.println("6 - Remover Programas.");
        System.out.println("7 - Listar todos os Programas.");
        System.out.println("8 - Listar Programas por Reporter.\n");
        System.out.print("Informe a opção desejada: ");

        Scanner sc = new Scanner(System.in);
        int codAcao = sc.nextInt();

        return codAcao;
    }

    private static void LimpaTela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static boolean VerificaReporterCadastro(int id, ArrayList<ReporterArrayList> ArrayP) {
        // Verifica se o reporter está previamento cadastrado para poder associ-lo
        return id == ArrayP.get(id).getIdSequecial();
    }

    public void PopulandoLista() {
        //        ArrayList<String> X = new ArrayList<>();
//        X.add("Fulano");
//        X.add("Siclano");
//        X.add("Beltrano");
//
//        for (String s : X) {
//            System.out.println("Nome: " + s);
        ArrayList<Reporter> ListaReprter = new ArrayList<>();
        Reporter R = new Reporter();
        R.setIdSequecial(1);
        R.setNome("Fulano");
        ListaReprter.add(R);

        R = new Reporter();
        R.setIdSequecial(2);
        R.setNome("Ciclano");
        ListaReprter.add(R);

        for (Reporter s : ListaReprter) {
            System.out.println("------- " + s.getIdSequecial() + "° Dado " + " -------");
            System.out.println("Id: " + s.getIdSequecial());
            System.out.println("Nome: " + s.getNome() + "\n");
        }

        if (ListaReprter.contains(R)) {
            System.out.println("Lista contém: " + R.getNome());
        }

        ListaReprter.remove(R);

        for (Reporter s : ListaReprter) {
            System.out.println("------- " + s.getIdSequecial() + "° Dado " + " -------");
            System.out.println("Id: " + s.getIdSequecial());
            System.out.println("Nome: " + s.getNome() + "\n");
        }

    }
}
