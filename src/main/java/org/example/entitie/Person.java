package org.example.entitie;

import org.example.entitie.enums.Gender;
import org.example.entitie.enums.MaritalStatus;

import java.util.Objects;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file Person
 * @since 29/09/2025 - 23:06
 * --------------------
 * Person class
 * --------------------
 */
public class Person {

    private Integer id;
    private String name;
    private Gender gender;
    private MaritalStatus maritalStatus;

    public Person() {
    }

    //Without ID
    public Person(String name, Gender gender, MaritalStatus maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public Person(Integer id, String name, Gender gender, MaritalStatus maritalStatus) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
