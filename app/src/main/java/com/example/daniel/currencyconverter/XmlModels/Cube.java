package com.example.daniel.currencyconverter.XmlModels;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Daniel on 2017-11-10.
 */
@Root(name = "Cube")
public class Cube {

    @ElementList(name = "Cube")
    private ArrayList<Cubes> cubes;

    @Attribute(name = "time", required = false)
    private String time;

    public ArrayList<Cubes> getCubes() {
        return cubes;
    }

    public void setCubes(ArrayList<Cubes> cubes) {
        this.cubes = cubes;
    }

    @Override
    public String toString() {
        return cubes.toString();
    }
}
