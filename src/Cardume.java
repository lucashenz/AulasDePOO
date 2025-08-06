import java.util.ArrayList;

public class Cardume
{
    private ArrayList<Peixe> peixes;


    //CREATE C
    public void adicionarPeixe(Peixe p) {
        peixes.add(p);
    }

    //RETRIEE R
    public Peixe consultaPeixePorEspecie(String especie) {
        for (int i = 0; i < peixes.size(); i++) {
                Peixe p = peixes.get(i);
                if (p.getEspecie().equals(especie)) {
                    return p;
            }
        }
        return null;
    }


}
