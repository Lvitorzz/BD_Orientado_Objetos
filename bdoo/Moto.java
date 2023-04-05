package bdoo;

public class Moto extends Veiculo{
    private String categoria;
    
    public Moto(String placa, String marca, String modelo, String categoria){
        super(placa, marca, modelo);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }     
}
