
package com.fc.fc.Dto;

import javax.validation.constraints.NotBlank;

public class dtoFotopro {
    @NotBlank
    private String nombreE;
 
    public dtoFotopro() {
    }

    public dtoFotopro(String nombreE) {
        this.nombreE = nombreE;
       
    }
    //Getters & Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

  

    
}
