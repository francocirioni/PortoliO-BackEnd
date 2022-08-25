
package com.fc.fc.Dto;

import javax.validation.constraints.NotBlank;



public class dtoKys {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private int descripcionE;
     @NotBlank
    private int descripcionE2;
      @NotBlank
    private int descripcionE3;
       @NotBlank
    private int descripcionE4;
        @NotBlank
    private int descripcionE5;
            @NotBlank
    private int descripcionE6;

    public dtoKys() {
    }

    public dtoKys(String nombreE, int descripcionE, int descripcionE2, int descripcionE3, int descripcionE4, int descripcionE5, int descripcionE6) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.descripcionE2 = descripcionE2;
        this.descripcionE3 = descripcionE3;
        this.descripcionE4 = descripcionE4;
        this.descripcionE5 = descripcionE5;
          this.descripcionE5 = descripcionE6;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public int getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(int descripcionE) {
        this.descripcionE = descripcionE;
    }

    public int getDescripcionE2() {
        return descripcionE2;
    }

    public void setDescripcionE2(int descripcionE2) {
        this.descripcionE2 = descripcionE2;
    }

    public int getDescripcionE3() {
        return descripcionE3;
    }

    public void setDescripcionE3(int descripcionE3) {
        this.descripcionE3 = descripcionE3;
    }

    public int getDescripcionE4() {
        return descripcionE4;
    }

    public void setDescripcionE4(int descripcionE4) {
        this.descripcionE4 = descripcionE4;
    }

    public int getDescripcionE5() {
        return descripcionE5;
    }

    public void setDescripcionE5(int descripcionE5) {
        this.descripcionE5 = descripcionE5;
    }
    
       public int getDescripcionE6() {
        return descripcionE6;
    }

    public void setDescripcionE6(int descripcionE6) {
        this.descripcionE6 = descripcionE6;
    }
        
}
