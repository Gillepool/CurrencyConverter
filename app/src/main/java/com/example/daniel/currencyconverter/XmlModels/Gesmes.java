package com.example.daniel.currencyconverter.XmlModels;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniel on 2017-11-10.
 */
@Root(name="Envelope")
public class Gesmes {

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



    public Cube getCube() {
        return Cube;
    }

    public void setCube(Cube cube) {
        Cube = cube;
    }

    @Override
    public String toString() {
        return "Gesmes{" +
                "subject='" + subject + '\'' +
                ", sender='" + sender + '\'' +
                ", Cube=" + Cube +
                '}';
    }

/*
   <gesmes:Envelope xmlns:gesmes="http://www.gesmes.org/xml/2002-08-01" xmlns="http://www.ecb.int/vocabulary/2002-08-01/eurofxref">
<gesmes:subject>Reference rates</gesmes:subject>
<gesmes:Sender>
<gesmes:name>European Central Bank</gesmes:name>
</gesmes:Sender>
<Cube>
<Cube time="2017-11-09">
<Cube currency="USD" rate="1.1630"/>
<Cube currency="JPY" rate="131.75"/>
<Cube currency="BGN" rate="1.9558"/>
<Cube currency="CZK" rate="25.528"/>
<Cube currency="DKK" rate="7.4422"/>
<Cube currency="GBP" rate="0.88633"/>
<Cube currency="HUF" rate="312.08"/>
<Cube currency="PLN" rate="4.2346"/>
<Cube currency="RON" rate="4.6400"/>
<Cube currency="SEK" rate="9.7355"/>
<Cube currency="CHF" rate="1.1589"/>
<Cube currency="NOK" rate="9.4535"/>
<Cube currency="HRK" rate="7.5385"/>
<Cube currency="RUB" rate="69.0726"/>
<Cube currency="TRY" rate="4.4962"/>
<Cube currency="AUD" rate="1.5144"/>
<Cube currency="BRL" rate="3.7762"/>
<Cube currency="CAD" rate="1.4779"/>
<Cube currency="CNY" rate="7.7193"/>
<Cube currency="HKD" rate="9.0701"/>
<Cube currency="IDR" rate="15729.57"/>
<Cube currency="ILS" rate="4.0877"/>
<Cube currency="INR" rate="75.5600"/>
<Cube currency="KRW" rate="1299.91"/>
<Cube currency="MXN" rate="22.2416"/>
<Cube currency="MYR" rate="4.8790"/>
<Cube currency="NZD" rate="1.6715"/>
<Cube currency="PHP" rate="59.597"/>
<Cube currency="SGD" rate="1.5819"/>
<Cube currency="THB" rate="38.495"/>
<Cube currency="ZAR" rate="16.5306"/>
</Cube>
</Cube>
</gesmes:Envelope>
     */


}
