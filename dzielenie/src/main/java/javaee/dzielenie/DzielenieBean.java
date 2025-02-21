/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.dzielenie;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class DzielenieBean {
    private int licznik;
    private int mianownik;
    private Double wynik;
    
    public String oblicz() {
        if (mianownik == 0) {
            return "blad?faces-redirect=true"; // Fixed typo here
        }
        wynik = (double) licznik / mianownik;
        return null; // Stays on the same page
    }

    public int getLicznik() { // Correct method names
        return licznik;
    }
    public void setLicznik(int licznik) { // Setter with parameter
        this.licznik = licznik;
    }

    public int getMianownik() {
        return mianownik;
    }
    public void setMianownik(int mianownik) { // Fixed name and parameter
        this.mianownik = mianownik;
    }

    public Double getWynik() { // Use Double to match 'wynik' type
        return wynik;
    }
}
