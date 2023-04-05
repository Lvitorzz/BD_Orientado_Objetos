package bdoo;


public class Menu {
    private int choice;
    
    public void menuPrincipal(){
        System.out.println("1 -  Adicionar Veiculo");
        System.out.println("2 - Buscar Veiculo");
        System.out.println("3 - Visualizar todos os veiculos");
        System.out.println("4 - Deletar Veiculo");
        System.out.println("5 - Fechar sistema");
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
