/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.testws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author sterie
 */
@XmlRootElement(name = "person")
@XmlType(propOrder={"id", "fullName", "age"})
public class Person {

    private int id;
    private String fullName;
    private int age;

    public Person() {
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
