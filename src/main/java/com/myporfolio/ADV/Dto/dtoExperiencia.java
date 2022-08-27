
package com.myporfolio.ADV.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank  // indica que no pueden estar vacios los campos
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    //Constructores sin y con parametros

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    //Getters and Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}

