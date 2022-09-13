
package com.fc.fc.Dto;

import javax.validation.constraints.NotBlank;




public class dtoBan {
    
      @NotBlank
    private String nombreE;

    public dtoBan() {
    }

    public dtoBan(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
    
}
