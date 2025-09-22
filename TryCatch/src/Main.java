import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int numero, somador, quantidade = 0;

        somador = 0;
        numero = -1;

        try {
            while (numero != 0) {
                try {
                    System.out.println("Digite um numero (0 para sair)");
                    numero = tec.nextInt();
                    if (numero != 0) {
                        somador = somador + numero;
                        quantidade++;
                    }
                } catch (Exception e) {
                    System.out.println("Digite um numero " + e);
                    tec.nextLine();
                }
            }
            System.out.println("Sua média aritmetica ficou: " + quantidade / somador);
        }
        catch(Exception e) { // "e" é um objeto, logo tem seus metodos proprios;
            System.out.println(e.getCause());
        }
    }
}