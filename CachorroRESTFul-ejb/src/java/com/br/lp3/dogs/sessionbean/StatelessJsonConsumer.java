package com.br.lp3.dogs.sessionbean;

import com.br.lp3.dogs.model.Pet;
import com.br.lp3.dogs.parser.PetParser;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author bruce
 */
@Stateless
public class StatelessJsonConsumer implements StatelessJsonConsumerLocal {

    @Override
    public List<Pet> getPetsList(String url) {
        try {
            return PetParser.parsePets(url);
        } catch (IOException ex) {
            Logger.getLogger(StatelessJsonConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
