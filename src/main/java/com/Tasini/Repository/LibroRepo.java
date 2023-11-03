package com.Tasini.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tasini.Domain.Libro;

//questa interface consente di accedere alle API della
//java persistence, interfaccia per la gestione persistente dei dati

//l'identificatore di un LibroRepo è una JpaRepository tipizzata su Libro
//con la corrispondente PK tipizzata su Long(nel caso dell'id)
//i tipi Libro e Long sono i tipi che trasformano la classe jpaRepository
//da anonima a tipizzata

//JPA --> java persistance API
@Repository
public interface LibroRepo extends JpaRepository<Libro,Long> {



}
