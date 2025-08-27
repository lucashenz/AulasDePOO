public class VeiculoEletrico extends Veiculo{

    private double cargaDaBateria;

    public VeiculoEletrico(String placa, double valor, double cargaDaBateria) {
        super(placa, valor);
        this.cargaDaBateria = valor;
    }

    public double getCargaDaBateria() {
        return cargaDaBateria;
    }

    @Override
    public double calculaIPVA() { // reescrevendo o metodo de IPVA
        return 0.0;
    }

    @Override
    public String geraDescricao() {
        String descricao = "";
        descricao += "Placa: "+ placa + "\n";
        descricao += "Valor: " + valor + "\n";
        descricao += "Imposto: "+ calculaIPVA() + "\n";
        descricao += "Carga Da bateria: " + cargaDaBateria + "\n";
        return descricao;
    }
}
