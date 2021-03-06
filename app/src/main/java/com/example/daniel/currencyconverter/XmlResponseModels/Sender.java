package com.example.daniel.currencyconverter.XmlResponseModels;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniel on 2017-11-10.
 */
@Root(name = "Sender")
public class Sender {
    @Element(name="name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "name='" + name + '\'' +
                '}';
    }
}
