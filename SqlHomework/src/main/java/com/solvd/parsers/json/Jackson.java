package com.solvd.parsers.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.parsers.Car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Jackson {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("""
                               1. Serialize simple object
                               2. Deserialize simple object
                               3. Serialize object list
                               4. Deserialize object list
                               0. Exit
                               """);
            option= sc.nextInt();

            switch (option){
                case 1 -> serializeSimpleObject();
                case 2 -> deserializeSimpleObject();
                case 3 -> serializeObjectList();
                case 4 -> deserializeObjectList();
            }
        }while (option != 0);
    }

    public static void serializeSimpleObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Date date = new Date();
        Car car = new Car();
        car.setId(1);
        car.setBrand("BMW");
        car.setModel("I8");
        car.setYear(2022);
        car.setPlate("AAA 123");
        car.setDos(date);

        objectMapper.writeValue(new File("src/main/resources/car.json"),car);
    }

    public static void deserializeSimpleObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(new File("src/main/resources/car.json"), Car.class);
        System.out.println(car);
    }

    public static void serializeObjectList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = new ArrayList<>();
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

        Car car2 = new Car();
        car2.setId(3);
        car2.setBrand("Lamborghini");
        car2.setModel("Gallardo");
        car2.setYear(2022);
        car2.setPlate("AAA 999");
        car2.setDos(date);

        Car car3 = new Car();
        car3.setId(4);
        car3.setBrand("Ferrari");
        car3.setModel("488");
        car3.setYear(2022);
        car3.setPlate("AAB 000");
        car3.setDos(date);

        //Add the cars to the list
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        objectMapper.writeValue(new File("src/main/resources/car_list.json"),cars);
    }

    public static void deserializeObjectList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = objectMapper.readValue(new File("src/main/resources/car_list.json"), new TypeReference<>(){});
        System.out.println("The amount of cars: "+cars.size());
        cars.forEach(System.out::println);
    }
}