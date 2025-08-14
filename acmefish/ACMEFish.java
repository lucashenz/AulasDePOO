// Classe da aplicacao

import java.util.ArrayList;
import java.util.Scanner;

public class ACMEFish {
    // Classe catalogo que armazena todos os peixes
    private Cardume cardume;
    // Entrada de dados (teclado)
    private Scanner entrada;

    /**
     * Construtor da aplicacao
     */
    public ACMEFish() {
        cardume = new Cardume();
        entrada = new Scanner(System.in);
    }

    /**
     * Execucao da aplicacao
     */
    public void executar() {
        System.out.println("Aplicacao ACMEFish!");
        int opcao = -1;
        while(opcao != 0) {
            System.out.println("========================");
            menu();
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            System.out.println("========================");
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastrarPeixe();
                    break;
                case 2:
                    consultarPeixePorEspecie();
                    break;
                case 3:
                    listarTodosPeixes();
                    break;

                case 8:
                    perguntarPeso();
                    break;
                case 99:
                    easterEgg();
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }

    }

    /**
     * Menu de opcoes para o usuario
     */
    private void menu() {
        System.out.println("Menu de opcoes");
        System.out.println("[0] Sair");
        System.out.println("[1] Cadastrar um peixe");
        System.out.println("[2] Consultar um peixe");
        System.out.println("[3] Listar todos os peixes");
        System.out.println("[8] Consultar peixe por peso");
    }

    /**
     * Cadastramento de um peixe
     */
    private void cadastrarPeixe() {
        System.out.println("Cadastrar um peixe");
        System.out.println("------------------");
        System.out.print("Digite a especie: ");
        String especie = entrada.nextLine();
        System.out.print("Digite o peso: ");
        double peso = entrada.nextDouble();
        entrada.nextLine();
        System.out.print("Peixe de agua doce? (S/N): ");
        String doce = entrada.nextLine();
        boolean isAguaDoce;
        if(doce.toUpperCase().equals("S"))
            isAguaDoce = true;
        else
            isAguaDoce = false;
        Peixe peixe = new Peixe(especie,peso,isAguaDoce);
        boolean resultado = cardume.adicionarPeixe(peixe);
        if(resultado)
            System.out.println("Peixe cadastrado!");
        else
            System.out.println("Especie repetida!");
    }


    /**
     * Consulta um peixe por especie
     */
    private void consultarPeixePorEspecie() {
        System.out.println("Consultar um peixe por especie");
        System.out.println("------------------------------");
        System.out.print("Digite a especie: ");
        String especie = entrada.nextLine();
        Peixe peixe = cardume.consultarPeixePorEspecie(especie);
        if(peixe == null)
            System.out.println("Peixe nao encontrado.");
        else {
            System.out.println("Especie: " + peixe.getEspecie());
            System.out.println("Peso: " + peixe.getPeso());
            System.out.println("Agua doce? " + peixe.isAguaDoce());
        }
    }

    /**
     * Lista todos os peixes cadastrados
     */
    private void listarTodosPeixes() {
        System.out.println("Listar todos os peixes");
        System.out.println("----------------------");
        ArrayList<Peixe> listaPeixes = cardume.listarTodosPeixes();
        if(listaPeixes.isEmpty())
            System.out.println("Nenhum peixe cadastrado.");
        else {
            for(int i=0; i<listaPeixes.size(); i++) {
                Peixe peixe = listaPeixes.get(i);
                System.out.println("Especie: " + peixe.getEspecie());
                System.out.println("Peso: " + peixe.getPeso());
                System.out.println("Agua doce? " + peixe.isAguaDoce());
                System.out.println("--------------------------");
            }
        }
    }

    /**
     * Opcao oculta
     * Pre-cadastra alguns peixes
     */
    private void easterEgg() {
        System.out.println("Easter egg!!!");
        Peixe peixe;
        peixe = new Peixe("Robalo",1.11,false);
        cardume.adicionarPeixe(peixe);
        peixe = new Peixe("Tilapia",2.22,true);
        cardume.adicionarPeixe(peixe);
        peixe = new Peixe("Dourado",3.33,true);
        cardume.adicionarPeixe(peixe);
        peixe = new Peixe("Tainha",4.44,false);
        cardume.adicionarPeixe(peixe);
    }

    private void perguntarPeso() {
        System.out.println("Qual peso você deseja consultar?");
        int peso = entrada.nextInt();
        ArrayList<Peixe> listarPeixePeso = cardume.listarPeixesPorPeso(peso);
        if(listarPeixePeso.isEmpty())
            System.out.println("Nenhum peixe cadastrado.");
        else {
            for(int i=0; i<listarPeixePeso.size(); i++) {
                Peixe peixe = listarPeixePeso.get(i);
                System.out.println("\n--------------------------");
                System.out.println("Especie: " + peixe.getEspecie());
                System.out.println("Peso: " + peixe.getPeso());
                System.out.println("Agua doce? " + peixe.isAguaDoce());
                System.out.println("--------------------------");
            }
        }

    }


}
