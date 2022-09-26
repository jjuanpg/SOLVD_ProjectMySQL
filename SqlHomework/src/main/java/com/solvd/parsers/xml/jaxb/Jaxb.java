package com.solvd.parsers.xml.jaxb;

import com.solvd.parsers.Car;
import com.solvd.parsers.Cars;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Jaxb {

    public static void main(String[] args) throws JAXBException {
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                               1. Marshal one object of car
                               2. Unmarshal car
                               3. Marshal a list of cars
                               4. Unmarshal list of cars
                               0. Exit
                               """);
            option = sc.nextInt();
            switch (option){
                case 1 -> marshallExample();
                case 2 -> UnmarshallExample();
                case 3 -> marshalListExample();
                case 4 -> UnmarshallListExample();
            }
        }while (option != 0);
    }

    public static void UnmarshallExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Car car = (Car) jaxbUnmarshaller.unmarshal( new File("src/main/resources/marshalled_car.xml") );
        System.out.println(car);
    }

    public static void marshallExample() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller jaxbMarshaller = context.createMarshaller();
        Date date = new Date();

        Car car = new Car();
        car.setId(1);
        car.setBrand("BMW");
        car.setModel("I8");
        car.setYear(2022);
        car.setPlate("AAA 123");
        car.setDos(date);

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the cars list in console
        jaxbMarshaller.marshal(car, System.out);

        //Marshal the cars list in file
        jaxbMarshaller.marshal(car, new File("src/main/resources/marshalled_car.xml"));
    }

    public static void UnmarshallListExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Cars.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        Cars cars = (Cars) jaxbUnmarshaller.unmarshal( new File("src/main/resources/marshalled_carList.xml") );

        for(Car c : cars.getCars()) {
            System.out.println(c);
        }
    }

    public static void marshalListExample() throws JAXBException {
        Cars cars = new Cars();
        cars.setCars(new ArrayList<>());
        Date date = new Date();

        //Create car examples
        Car car = new Car();
        car.setId(1);
        car.setBrand("BMW");
        car.setModel("I8");
        car.setYear(2022);
        car.setPlate("AAA 123");
        car.setDos(date);

        Car car1 = new Car();
        car1.setId(2);
        car1.setBrand("Audi");
        car1.setModel("A7");
        car1.setYear(2022);
        car1.setPlate("AAA 124");
        car1.setDos(date);

        //Add the cars to the list
        cars.getCars().add(car);
        cars.getCars().add(car1);

        //Marshalling
        JAXBContext jaxbContext = JAXBContext.newInstance(Cars.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the cars list in console
        jaxbMarshaller.marshal(cars, System.out);

        //Marshal the cars list in file
        jaxbMarshaller.marshal(cars, new File("src/main/resources/marshalled_carList.xml"));
    }
}