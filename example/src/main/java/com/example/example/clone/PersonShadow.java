package com.example.example.clone;

public class PersonShadow implements Cloneable {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonShadow(Address address) {
        this.address = address;
    }

    @Override
    public PersonShadow clone(){
        try {
            PersonShadow personShadow = (PersonShadow) super.clone();
            return personShadow;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
