package com.AutoHero;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by olena on 2/14/19.
 */
public class Car {

    private double price;
    private String title;
    private Date date;
    private String fuel;
    private String mileage;
    private String transmission;
    private String power;
    private String emission;
    private String consumption;

    public void setPrice(double price){
        this.price = price;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDate(String date){

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
//        LocalDate dateTime = LocalDate.parse(date, formatter);
//        System.out.println(dateTime.format(formatter));
          try {
            this.date = new SimpleDateFormat("MM/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(sDate1+"\t"+date1);this.date = date;
    }

    public void setFuel(String fuel){
        this.fuel = fuel;
    }

    public void setMileage(String mileage){
        this.mileage = mileage;
    }

    public void setTransmission(String transmission){
        this.transmission = transmission;
    }

    public void setPower(String power){
        this.power = power;
    }

    public void setEmission(String emission){
        this.emission = emission;
    }

    public void setConsumption(String consumption){
        this.consumption = consumption;
    }

    public Date getDate(){return date;}
    public Double getPrice(){return price;}

    @Override
    public String toString() {
        return "(" + this.title + ", " + this.price + ", " + this.date + ")";
    }

}
