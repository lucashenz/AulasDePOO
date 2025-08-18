import java.util.ArrayList;

public class Clientela {

    private ArrayList<Cliente> clientes;

    public Clientela() {
        clientes = new ArrayList<>();
    }

    public boolean adicionarCliente(Cliente c) {

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(c.getNome())) {
                return false;
            }
        }
        /*
        if (clientes.contains(c)) {
        return false }
         */
        clientes.add(c);
        return false;
    }

    public Cliente consultarClientePorNome(String nome) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

}