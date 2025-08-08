import java.util.Scanner;

public class ACMEFish {
    //todo software necessita de uma aplicação, neste caso, esta é a classe de aplicação

    Scanner tc = new Scanner(System.in);
    private Cardume cardume;

    public ACMEFish() {
        cardume = new Cardume();
    }

    public void executar() {
        System.out.println("Opçao> ");
        int opcao = tc.nextInt();
    }

    public void Menu() {
        System.out.println("Menu de Opcoes \n [1] Cadastrar uma fish");
    }
}

