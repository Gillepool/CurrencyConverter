package com.example.daniel.currencyconverter.XmlResponseModels;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Daniel on 2017-11-10.
 */
@Root(name="Cube")
public class Cube implements Serializable {

    @Element(name="Cube")
    private TimeCube timeCube;

    public TimeCube getTimeCube() {
        return timeCube;
    }

    public void setTimeCube(TimeCube timeCube) {
        this.timeCube = timeCube;
    }

    @Override
    public String toString() {
        return timeCube.toString();
    }
}
