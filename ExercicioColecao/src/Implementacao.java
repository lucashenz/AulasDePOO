import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Implementacao {

    public String inverteString(String palavra) {
        Stack<Character> pilha = new Stack<>();
        Stack<Character> pilha2 = new Stack<>();

        for (int i=0; i<palavra.length(); i++) {
            Character c = palavra.charAt(i);
            //System.out.println(pilha);
            pilha.push(c);
        }
       while(!pilha.isEmpty()) {
           pilha2.push(pilha.pop());
           //System.out.println(pilha2);
       }

       return pilha2.toString();
    }

    public String retornaConsoantes(String palavra) {
        Queue fila = new LinkedList();
        for(int i = 0; i < palavra.length(); i++) {
            Character c = palavra.charAt(i);
            fila.add(c);
        }
        System.out.println("fila: " + fila);
        String consoantes;

        while(!fila.isEmpty()) {
            
        }

        return null;
    }
}
