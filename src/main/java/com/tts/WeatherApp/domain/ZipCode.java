package com.tts.WeatherApp.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZipCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String zipCode;
    private String city;

    public ZipCode() {

    }

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ZipCode(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "id=" + id +
                ", zipCode=" + zipCode +
                '}';
    }
}
