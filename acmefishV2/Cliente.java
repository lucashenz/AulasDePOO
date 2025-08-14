import java.util.ArrayList;

public class Cliente {

    private ArrayList<Peixe> peixesComprados;
    private String nome;

    public Cliente (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void adicionarPeixe(Peixe peixesComprados, String nome) {
        this.peixesComprados.add(peixesComprados);
    }
    public ArrayList<Peixe> consultarPeixesComprados(Peixe p) {
        for (Peixe peixe : peixesComprados) {
            if (peixesComprados.contains(peixe)) {
                return peixesComprados;
            }
        }
        return null;
    }

}

