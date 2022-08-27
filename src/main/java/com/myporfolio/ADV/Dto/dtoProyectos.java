
package com.myporfolio.ADV.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyectos {
    @NotBlank  // indica que no pueden estar vacios los campos
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    @NotBlank
    private String urlimg;
    
    //Constructores sin y con parametros

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreE, String descripcionE, String urlimg) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlimg = urlimg;
    }
    //Getters and Setters

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

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

