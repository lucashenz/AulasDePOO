// Classe base da aplicacao
public class Peixe {
    private String especie;
    private double peso;
    private boolean aguaDoce;

    public Peixe(String especie, double peso, boolean aguaDoce) {
        this.especie = especie;
        this.peso = peso;
        this.aguaDoce = aguaDoce;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isAguaDoce() {
        return aguaDoce;
    }

    public void setAguaDoce(boolean aguaDoce) {
        this.aguaDoce = aguaDoce;
    }

    @Override
    public String toString() {
        return "Peixe{" +
                "especie='" + especie + '\'' +
                ", peso=" + peso +
                ", aguaDoce=" + aguaDoce +
                '}';
    }
}
