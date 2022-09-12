
package com.fc.fc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity


public class Kys {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private int descripcionE;
    private int descripcionE2;
    private int descripcionE3;
    private int descripcionE4;
    private int descripcionE5;
    private int descripcionE6;
    private int descripcionE7;
    private int descripcionE8;
    private int descripcionE9;
    private int descripcionE10;
    private int descripcionE11;
    private int descripcionE12;

    public Kys() {
    }

    public Kys(String nombreE, int descripcionE, int descripcionE2, int descripcionE3, int descripcionE4, int descripcionE5
            , int descripcionE6, int descripcionE7, int descripcionE8, int descripcionE9, int descripcionE10, int descripcionE11, int descripcionE12) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.descripcionE2 = descripcionE2;
        this.descripcionE3 = descripcionE3;
        this.descripcionE4 = descripcionE4;
        this.descripcionE5 = descripcionE5;
        this.descripcionE6 = descripcionE6;
        this.descripcionE6 = descripcionE7;
        this.descripcionE6 = descripcionE8;
        this.descripcionE6 = descripcionE9;
        this.descripcionE6 = descripcionE10;
        this.descripcionE6 = descripcionE11;
        this.descripcionE6 = descripcionE12;
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

    public int getDescripcionE7() {
        return descripcionE7;
    }

    public void setDescripcionE7(int descripcionE7) {
        this.descripcionE7 = descripcionE7;
    }

    public int getDescripcionE8() {
        return descripcionE8;
    }

    public void setDescripcionE8(int descripcionE8) {
        this.descripcionE8 = descripcionE8;
    }

    public int getDescripcionE9() {
        return descripcionE9;
    }

    public void setDescripcionE9(int descripcionE9) {
        this.descripcionE9 = descripcionE9;
    }

    public int getDescripcionE10() {
        return descripcionE10;
    }

    public void setDescripcionE10(int descripcionE10) {
        this.descripcionE10 = descripcionE10;
    }

    public int getDescripcionE11() {
        return descripcionE11;
    }

    public void setDescripcionE11(int descripcionE11) {
        this.descripcionE11 = descripcionE11;
    }

    public int getDescripcionE12() {
        return descripcionE12;
    }

    public void setDescripcionE12(int descripcionE12) {
        this.descripcionE12 = descripcionE12;
    }
    
    
    
    
    
    
    
}
