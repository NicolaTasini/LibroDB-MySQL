package com.Tasini.Domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libro { //pojo --> plain old java object
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String titolo;
    String autore;
    LocalDate data_pubblicazione;

    public Libro() {
    }

    public Libro(Long id, String titolo, String autore, LocalDate data_pubblicazione) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.data_pubblicazione = data_pubblicazione;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public LocalDate getData_pubblicazione() {
        return this.data_pubblicazione;
    }

    public void setData_pubblicazione(LocalDate data_pubblicazione) {
        this.data_pubblicazione = data_pubblicazione;
    }

    public Libro id(Long id) {
        setId(id);
        return this;
    }

    public Libro titolo(String titolo) {
        setTitolo(titolo);
        return this;
    }

    public Libro autore(String autore) {
        setAutore(autore);
        return this;
    }

    public Libro data_pubblicazione(LocalDate data_pubblicazione) {
        setData_pubblicazione(data_pubblicazione);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, autore, data_pubblicazione);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titolo='" + getTitolo() + "'" +
            ", autore='" + getAutore() + "'" +
            ", data_pubblicazione='" + getData_pubblicazione() + "'" +
            "}";
    }


    


    
}
