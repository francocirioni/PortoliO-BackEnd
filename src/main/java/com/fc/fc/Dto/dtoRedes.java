
package com.fc.fc.Dto;

import javax.validation.constraints.NotBlank;



public class dtoRedes {
    
    
    
     @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
     @NotBlank
    private String descripcionE2;
     
      @NotBlank
    private String descripcionE3;
      
       @NotBlank
    private String descripcionE4;

    public dtoRedes() {
    }

    public dtoRedes(String nombreE, String descripcionE, String descripcionE2, String descripcionE3, String descripcionE4) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.descripcionE2 = descripcionE2;
        this.descripcionE3 = descripcionE3;
        this.descripcionE4 = descripcionE4;
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

    public String getDescripcionE2() {
        return descripcionE2;
    }

    public void setDescripcionE2(String descripcionE2) {
        this.descripcionE2 = descripcionE2;
    }

    public String getDescripcionE3() {
        return descripcionE3;
    }

    public void setDescripcionE3(String descripcionE3) {
        this.descripcionE3 = descripcionE3;
    }

    public String getDescripcionE4() {
        return descripcionE4;
    }

    public void setDescripcionE4(String descripcionE4) {
        this.descripcionE4 = descripcionE4;
    }
    
    
    
    
    
    
}
