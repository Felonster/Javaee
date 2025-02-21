
package javaee.baza;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Anotacje @Named - Bean dostępny w JSF, @SessionScoped - dane przechowywane w sesji
@Named
@SessionScoped
public class OsobaBean implements Serializable {

    private String imie;
    private String adres;
    private String telefon;
    private List<OsobaBean> listaOsob = new ArrayList<>();

    // Gettery i settery (potrzebne do wiązania danych w JSF)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<OsobaBean> getListaOsob() {
        return listaOsob;
    }

    // Metoda do dodania nowej osoby do listy
    public void dodajOsobe() {
        listaOsob.add(new OsobaBean(imie, adres, telefon));
        // Czyszczenie pól formularza
        imie = "";
        adres = "";
        telefon = "";
    }

    // Konstruktor bezparametrowy (potrzebny w JSF)
    public OsobaBean() {}

    // Konstruktor z parametrami
    public OsobaBean(String imie, String adres, String telefon) {
        this.imie = imie;
        this.adres = adres;
        this.telefon = telefon;
    }
}
