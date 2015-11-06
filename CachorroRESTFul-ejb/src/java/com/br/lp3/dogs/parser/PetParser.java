package com.br.lp3.dogs.parser;

import com.br.lp3.dogs.model.Country;
import com.br.lp3.dogs.model.Pet;
import com.br.lp3.dogs.model.State;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author bruce
 */
public class PetParser {

    public static List<Pet> parsePets(String urlPath) throws MalformedURLException, IOException {
        try {
            URL url = new URL(urlPath);
            Scanner sc = new Scanner(url.openStream());
            String jsonContent = "";
            while(sc.hasNextLine()) {
                jsonContent += sc.nextLine();
            }
            JsonReader reader = Json.createReader(new StringReader(jsonContent));
            JsonObject obj = reader.readObject();
            List<Pet> pets = new ArrayList<>();
            
            if (obj.getInt("success") == 1) {
                JsonArray objArr = obj.getJsonArray("pets");
                for (int i = 0; i < objArr.size(); i++) {
                    JsonObject petObj = objArr.getJsonObject(i);
                    Pet pet = parsePet(petObj.toString());
                    pets.add(pet);
                }
                
            }
            return pets;
        } catch (MalformedURLException ex) {
            throw new MalformedURLException(ex.getMessage());
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    private static Pet parsePet(String content) {
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject obj = reader.readObject();
        String name = obj.getString("name");
        String photoUrl = obj.getString("photo");
        String description = obj.getString("description");
        String age = obj.getString("age");
        String race = obj.getString("race");
        String city = obj.getString("city");
        State state = parseState(obj.getJsonObject("state")
                .toString());
        Country country = parseCountry(obj.getJsonObject("country")
                .toString());
        Pet pet = new Pet(name, photoUrl, description, age, race, city, country, state);
        return pet;
    }

    private static State parseState(String content) {
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject obj = reader.readObject();

        String name = obj.getString("name");
        String initials = obj.getString("initials");
        State state = new State(name, initials);
        return state;
    }

    private static Country parseCountry(String content) {
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject obj = reader.readObject();

        String name = obj.getString("name");
        String initials = obj.getString("initials");
        Country country = new Country(name, initials);
        return country;
    }

}
