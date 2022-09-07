
package com.fc.fc.Dto;

import javax.validation.constraints.NotBlank;

public class dtoFotoa {
    
      @NotBlank
    private String nombreE;

    public dtoFotoa() {
    }

    public dtoFotoa(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
      
      
    
    
    
    
}
