/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.chat;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ChatBean {
    private List<String> listaInformacji = new ArrayList<>();
    private String nowaInformacja;
    
    public void dodajInformacje(){
        if (nowaInformacja != null && !nowaInformacja.trim().isEmpty()){
            listaInformacji.add(nowaInformacja);
            nowaInformacja="";
        }
    }
    public List<String> getListaInformacji(){
        return listaInformacji;
    }
    public String getNowaInformacja(){
        return nowaInformacja;
    }
    public void setNowaInformacja(String nowaInformacja){
        this.nowaInformacja = nowaInformacja;
    }
    
}
