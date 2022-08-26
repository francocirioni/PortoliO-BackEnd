
package com.fc.fc.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPerfil {
    
    
    @NotBlank
    private String nombreE;
    
     public dtoPerfil() {
    }

    public dtoPerfil(String nombreE, String descripcionE) {
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
