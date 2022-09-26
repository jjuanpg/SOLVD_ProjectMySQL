package com.solvd.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Dom {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        Document dom = documentBuilder.parse(Dom.class.getClassLoader().getResourceAsStream("car.xml"));

        List<Car> cars = new ArrayList<>();
        for(int i=0; i<dom.getElementsByTagName("model").getLength(); i++){
            Car car = new Car();
            car.setId(i+1);
            car.setBrand(dom.getElementsByTagName("brand").item(i).getTextContent());
            car.setModel(dom.getElementsByTagName("model").item(i).getTextContent());
            car.setYear(Integer.parseInt(dom.getElementsByTagName("year").item(i).getTextContent()));
            car.setPlate(dom.getElementsByTagName("plate").item(i).getTextContent());
            car.setDos(Date.valueOf(dom.getElementsByTagName("dos").item(i).getTextContent()));
            cars.add(car);

            //System.out.println(dom.getElementsByTagName("brand").item(i).getTextContent()); //Print all the brands
            //System.out.println(dom.getElementsByTagName("model").item(i).getTextContent()); //Print all the models
            //System.out.println(dom.getElementsByTagName("year").item(i).getTextContent());  //Print all the years
            //System.out.println(dom.getElementsByTagName("plate").item(i).getTextContent()); //Print all the plates
            //System.out.println(dom.getElementsByTagName("dos").item(i).getTextContent()); //Print all the dos
        }
        for (Car c : cars){
            System.out.println(c);
        }
    }
}
