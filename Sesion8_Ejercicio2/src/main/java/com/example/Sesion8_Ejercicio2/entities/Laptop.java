package com.example.Sesion8_Ejercicio2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int memoriaMegas;
    private int hardDiskMegas;

    //constructores
    public Laptop() {
    }

    public Laptop(Long id, String marca, String modelo, int memoriaMegas, int hardMiskMegas) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.memoriaMegas = memoriaMegas;
        this.hardDiskMegas = hardMiskMegas;
    }
    // Getter y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMemoriaMegas() {
        return memoriaMegas;
    }

    public void setMemoriaMegas(int memoriaMegas) {
        this.memoriaMegas = memoriaMegas;
    }

    public int getHardDiskMegas() {
        return hardDiskMegas;
    }

    public void setHardDiskMegas(int hardDiskMegas) {
        this.hardDiskMegas = hardDiskMegas;
    }

    //ToString

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", MemoriaMegas=" + memoriaMegas +
                ", hardMiskMegas=" + hardDiskMegas +
                '}';
    }
}
