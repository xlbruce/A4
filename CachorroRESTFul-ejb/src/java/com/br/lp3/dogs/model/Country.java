package com.br.lp3.dogs.model;

/**
 *
 * @author bruce
 */
public class Country {
    
    private String name, initials;

    public Country() {
    }

    public Country(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + name + ", initials=" + initials + '}';
    }
}
