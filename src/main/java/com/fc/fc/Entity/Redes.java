
package com.fc.fc.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity



public class Redes {
    
    
    
    
    
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String descripcionE2;
    private String descripcionE3;
     private String descripcionE4;

    public Redes() {
    }

    public Redes(String nombreE, String descripcionE, String descripcionE2, String descripcionE3, String descripcionE4) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.descripcionE2 = descripcionE2;
        this.descripcionE3 = descripcionE3;
        this.descripcionE4 = descripcionE4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
