public class ACMEFish {
    //todo software necessita de uma aplicação, neste caso, esta é a classe de aplicação

    private Cardume cardume;

    public ACMEFish() {
        cardume = new Cardume();
    }

    public void executar() {
        System.out.println("Executando fish");
    }
}
