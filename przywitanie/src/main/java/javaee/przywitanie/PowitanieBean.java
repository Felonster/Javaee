/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.przywitanie;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class PowitanieBean implements Serializable {
    private String imie;
    private String nazwisko;
    
    public String getImie(){
        return imie;
    }
    public void setImie(String imie){
        this.imie=imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public void setNazwisko(String nazwisko){
        this.nazwisko=nazwisko;
    }
    public String przejdzDoPowitania(){
        return "powitanie?faces-redirect=true";
    }
    public boolean czyPodanoDane(){
        return imie != null && !imie.isEmpty() && nazwisko != null && !nazwisko.isEmpty(); 
    }
}
