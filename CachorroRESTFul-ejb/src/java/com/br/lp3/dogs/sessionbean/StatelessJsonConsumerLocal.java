package com.br.lp3.dogs.sessionbean;

import com.br.lp3.dogs.model.Pet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bruce
 */
@Local
public interface StatelessJsonConsumerLocal {

    List<Pet> getPetsList(String url);
    
}
