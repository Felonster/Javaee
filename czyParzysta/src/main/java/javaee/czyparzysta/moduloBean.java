/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.czyparzysta;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("moduloBean")
@SessionScoped
public class moduloBean implements Serializable {
    private Integer podanaLiczba;
    
    public Integer getPodanaLiczba(){
        return podanaLiczba;
    }
    public void setPodanaLiczba(Integer podanaLiczba){
        this.podanaLiczba=podanaLiczba;
    }
    public String sprawdzLiczbe(){
        if(podanaLiczba==null){
            return "index?faces-redirect=true";
            }
        if(podanaLiczba % 2 == 0){
            return "parzysta?faces-redirect=true";
        }else{
            return "nieparzysta?faces-redirect=true";
        }       
    }
    public boolean czyLiczbaPodana(){
        return podanaLiczba != null;
    }
}
