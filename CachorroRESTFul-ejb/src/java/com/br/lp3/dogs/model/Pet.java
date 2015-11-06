package com.br.lp3.dogs.model;

/**
 *
 * @author bruce
 */
public class Pet {

    private String name, photo, description, age, race,
            city;
    private Country country;
    private State state;

    public Pet() {
    }

    public Pet(String name, String photo, String description, String age, String race, String city, Country country, State state) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.age = age;
        this.race = race;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Pet{" + "name=" + name + ", photo=" + photo + ", description=" + description + ", age=" + age + ", race=" + race + ", city=" + city + ", country=" + country + ", state=" + state + '}';
    }

}
