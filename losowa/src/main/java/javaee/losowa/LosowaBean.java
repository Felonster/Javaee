/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.losowa;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Random;

@Named
@SessionScoped
public class LosowaBean implements Serializable{
    private Integer podanaLiczba;
    
    public Integer getPodanaLiczba() {
        return podanaLiczba;
    }

    public void setPodanaLiczba(Integer podanaLiczba) {
        this.podanaLiczba = podanaLiczba;
    }
    public Integer  getLosowaLiczba(){
        if(podanaLiczba == null ){
            return null;
        }
        Random random = new Random();
        return random.nextInt(100) + podanaLiczba + 1;
    }
    public String przejdzDalej(){
        return "losowa?faces-redirect=true";
    }
}
