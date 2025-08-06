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
    public double getPeso() {
        return peso;
    }
    public boolean getAguaDoce() {
        return aguaDoce;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setAguaDoce(boolean aguaDoce) {
        this.aguaDoce = aguaDoce;
    }

}

