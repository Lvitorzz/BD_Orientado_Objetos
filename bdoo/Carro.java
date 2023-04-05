package bdoo;


public class Carro extends Veiculo {
    private int quantPortas;

    
    public Carro(String placa, String marca, String modelo, int quantPortas){
        super(placa, marca, modelo);
        this.quantPortas = quantPortas;
    }

    public int getQuantPortas() {
        return quantPortas;
    }

    public void setQuantPortas(int quantPortas) {
        this.quantPortas = quantPortas;
    }

}
