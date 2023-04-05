package bdoo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.Scanner;

public class BDOO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        boolean system = true;
        
        BDVeiculos carroDB = new BDVeiculos();
        
        while(system){
            menu.menuPrincipal();
            menu.setChoice(input.nextInt());           
            switch(menu.getChoice()){
                case 1 -> {
                    System.out.println("Digite a placa do carro: ");
                    String placa = input.next();
                    System.out.println("Digite a marca do carro: ");
                    String marca = input.next();
                    System.out.println("Digite o modelo do carro: ");
                    String modelo = input.next();
                    System.out.println("Digite a quantidade de portas do carro: ");
                    int portas = input.nextInt();
                    carroDB.abrirDB();
                    Carro carro = new Carro(placa, marca, modelo, portas);
                    carroDB.salvarCarro(carro);
                    carroDB.fecharDB();
                }
                case 2 -> {
                    System.out.println("Qual a placa do carro que deseja visualizar: ");
                    String placaConsulta = input.next();
                    carroDB.abrirDB();
                    Carro carroConsulta = carroDB.consultarCarro(placaConsulta);
                    System.out.println(carroConsulta.getMarca() + ": " + carroConsulta.getModelo());
                    carroDB.fecharDB();
                }
                case 3 -> {
                    ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "carros.db4o");
                    ObjectSet<Carro> result = db.queryByExample(Carro.class);
                    while(result.hasNext()) {
                        Carro carro = result.next();
                        System.out.println("============================");
                        System.out.println("Marca: " + carro.getMarca());
                        System.out.println("Modelo: " + carro.getModelo());
                        System.out.println("Placa: " + carro.getPlaca());
                        System.out.println("Portas: " + carro.getQuantPortas());
                        System.out.println("============================");
                    }
                    db.close();
                }
                case 4 -> {
                    ObjectContainer db = Db4oEmbedded.openFile("carros.db4o");
                    try {
                        System.out.println("Digite a placa do carro que deseja remover: ");
                        String placaRemover = input.next();
                        Query query = db.query();
                        query.constrain(Carro.class);
                        query.descend("placa").constrain(placaRemover);
                        ObjectSet<Carro> result = query.execute();
                        if (result.hasNext()) {
                            Carro carro = result.next();
                            db.delete(carro);
                            db.commit();
                            System.out.println("Carro removido com sucesso");
                        } else {
                            System.out.println("Carro nao encontrado");
                        }
                    } finally {
                        db.close();
                    }
                }
                case 5 -> {
                    System.out.println("Sistema fechado");
                    system = false;
                }
            }    
        }       
    }    
}
