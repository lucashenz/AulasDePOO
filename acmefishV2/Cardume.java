import java.util.ArrayList;

/**
 * Classe catalogo de Peixe
 * CRUD de Peixe
 */

public class Cardume {

    // Colecao de peixes
    private ArrayList<Peixe> peixes;

    /**
     * Construtor da classe catalogo
     */
    public Cardume() {
        peixes = new ArrayList<Peixe>(100);
    }

    /**
     * C - Create
     * Cadastrar um peixe; nao permite especie repetida
     * @param p novo peixe
     * @return true se cadastrou o peixe; false em caso contrario
     */
    public boolean adicionarPeixe(Peixe p) {
        String especie = p.getEspecie();
        Peixe aux = consultarPeixePorEspecie(especie);
        if(aux == null) { // Especie nao cadastrada
            peixes.add(p);
            return true;
        }
        else
            return false;
    }

    /**
     * R - Retrieve - consulta peixe de uma especie
     * Retorna null se nao encontrar
     * @param especie
     * @return peixe da especie ou null
     */
    public Peixe consultarPeixePorEspecie(String especie) {
        // Loop iterado (for each)
        for(Peixe p : peixes) {
            if(p.getEspecie().equals(especie))
                return p;
        }
        return null;

/*       Loop contado
 for(int i=0; i<peixes.size(); i++) {
            Peixe p = peixes.get(i);
            if(p.getEspecie().equals(especie))
                return p;
        }
        return null;
*/
    }

    /**
     * R - Retrieve
     * Consulta todos os peixes cadastrados
     * @return
     */
    public ArrayList<Peixe> listarTodosPeixes() {
        // ArrayList auxiliar para o retorno
        ArrayList<Peixe> aux = new ArrayList<>();
        for(int i=0; i< peixes.size(); i++) {
            Peixe peixe = peixes.get(i);
            aux.add(peixe);
        }
        return aux;
    }

}
