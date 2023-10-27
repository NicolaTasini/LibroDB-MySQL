package com.Tasini.Domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "libri")
public class Libro { //pojo --> plain old java object
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String titolo;
    String autore;

    public Libro() {
    }

    public Libro(Long id, String titolo, String autore) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }

        //criterio per stabilire l'equivalenza dipende solo dal campo ID
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titolo='" + getTitolo() + "'" +
            ", autore='" + getAutore() + "'" +
            "}";
    }
    


    
}
