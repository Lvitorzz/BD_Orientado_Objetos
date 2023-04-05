package bdoo;

import com.db4o.*;
import com.db4o.query.Query;

public class BDVeiculos {
    private ObjectContainer bd = null;

    public void abrirDB() {
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "carros.db4o");
    }
    
    public void fecharDB() {
        bd.close();
    }

    public void salvarCarro(Carro carro) {
        bd.store(carro);
    }

    public Carro consultarCarro(String placa) {
        Query query = bd.query();
        query.constrain(Carro.class);
        query.descend("placa").constrain(placa);
        ObjectSet<Carro> result = query.execute();
        if (result.hasNext()) {
            return result.next();
        } else {
            return null;
        }
    }
}

