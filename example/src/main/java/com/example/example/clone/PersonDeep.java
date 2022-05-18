package com.example.example.clone;

public class PersonDeep implements Cloneable {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonDeep(Address address) {
        this.address = address;
    }

    @Override
    public PersonDeep clone() {
        try {
            PersonDeep personDeep = (PersonDeep) super.clone();
            personDeep.setAddress(personDeep.getAddress().clone());
            return personDeep;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
