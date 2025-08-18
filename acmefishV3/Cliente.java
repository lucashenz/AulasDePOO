import java.util.ArrayList;

public class Cliente {

    private String nome;

    private ArrayList<Peixe> peixesComprados;

    public Cliente(String nome) {

    }

    public String getNome() {
        return null;
    }

    public void adicionarPeixe(Peixe p) {
        peixesComprados.add(p);
    }

    public ArrayList<Peixe> consultarPeixesComprados() {

        ArrayList<Peixe> lista = new ArrayList<>();

        for (Peixe p : peixesComprados) { // para caida peixe p que estiver no arraylist peixes
            lista.add(p);
        }
        return lista;
    }


    }
