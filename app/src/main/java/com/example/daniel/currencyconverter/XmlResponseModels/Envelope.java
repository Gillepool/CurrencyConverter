package com.example.daniel.currencyconverter.XmlResponseModels;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniel on 2017-11-10.
 */
@Root(name="Envelope")
public class Envelope {

    @Element(name = "subject")
    private String subject;

    @Element(name = "Sender")
    private Sender sender;

    @Element(name = "Cube")
    private Cube Cube;



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Cube getCube() {return Cube;}

    public void setCube(Cube cube) {Cube = cube;}

    @Override
    public String toString() {
        return "Envelope{" +
                "subject='" + subject + '\'' +
                ", sender='" + sender + '\'' +
                ", Cube=" + Cube +
                '}';
    }
}
