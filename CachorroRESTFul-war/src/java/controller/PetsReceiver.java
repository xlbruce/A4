package controller;

import com.br.lp3.dogs.model.Pet;
import com.br.lp3.dogs.sessionbean.StatelessJsonConsumerLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author bruce
 */
public class PetsReceiver {    
    StatelessJsonConsumerLocal statelessJsonConsumer = lookupStatelessJsonConsumerLocal();

    
    public List<Pet> getPetsList(String url) {
        return statelessJsonConsumer.getPetsList(url);
    }
    private StatelessJsonConsumerLocal lookupStatelessJsonConsumerLocal() {
        try {
            Context c = new InitialContext();
            return (StatelessJsonConsumerLocal) c.lookup("java:global/CachorroRESTFul/CachorroRESTFul-ejb/StatelessJsonConsumer!com.br.lp3.dogs.sessionbean.StatelessJsonConsumerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
       
    
}
