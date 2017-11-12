package com.example.daniel.currencyconverter.XmlResponseModels;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Collection;

/**
 * Created by Daniel on 2017-11-12.
 */

@Root(name = "Cube")
public class TimeCube {
    @Attribute(name="time")
    private String time;

    @ElementList(entry = "Cube", inline = true)
    private Collection<CurrencyCube> cubes;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Collection<CurrencyCube> getCubes() {return cubes;}

    public void setCubes(Collection<CurrencyCube> cubes) {this.cubes = cubes;}

    @Override
    public String toString() {
        return "TimeCube{" +
                "time='" + time + '\'' +
                ", CurrencyCubes=" + cubes +
                '}';
    }
}
