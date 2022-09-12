
package com.fc.fc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAcercade {
    
     @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String imagenE;

    public dtoAcercade() {
    }

    public dtoAcercade(String nombreE, String descripcionE, String imagenE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imagenE = imagenE;
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
    
      public String getimagenE() {
        return imagenE;
    }

    public void setimagen(String imagenE) {
        this.imagenE = imagenE;
    }

  
    
    
}
