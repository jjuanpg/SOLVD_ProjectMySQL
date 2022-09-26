package com.solvd.xml;


import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "car")
@XmlAccessorType (XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private int id;
    private String brand;
    private String model;
    private int year;
    private String plate;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dos; // Date of sell

    public int getId(){
        return id;
    }


    public void setId(int id){
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    //@XmlElement(name ="brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    //@XmlElement(name ="model")
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    //@XmlElement(name ="year")
    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    //@XmlElement(name ="plate")
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getDos(){
        return dos;
    }

    //@XmlElement(name ="dos")
    public void setDos(Date date){
        this.dos = date;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", plate='" + plate + '\'' +
                ", dos=" + dos +
                '}';
    }
}
