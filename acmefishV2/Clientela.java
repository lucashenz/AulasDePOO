import java.util.ArrayList;

public class Clientela {

    private ArrayList<Cliente> c;

    public Clientela () {

    }

    public boolean adicionarCliente (Cliente c) {

            Cliente novoCliente = new Cliente(nome);
    }

    public Cliente consultarClientePorNome (String nome) {
        for (Cliente c : c) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

}
