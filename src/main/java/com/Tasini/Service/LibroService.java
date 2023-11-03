package com.Tasini.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tasini.Domain.Libro;
import com.Tasini.Repository.LibroRepo;


//controlli sugli attributi e gestione dei metodi
@Service
public class LibroService {
    
    //ooggetto che ci consente di gestire i dati
    @Autowired
    LibroRepo libroRepo;

    public List<Libro> getAll(){
        return libroRepo.findAll();
    }

    public Optional<Libro> getById(Long id){
        return libroRepo.findById(id);
    }

    public Optional<Libro> saveLibro(Libro libro){
        //se l'istanza libro è fornita senza ID
        //allora il campo ID di Libro assumerà 
        //un nuovo valore.   
        libroRepo.save(libro);
        Optional<Libro> opt = Optional.of(libroRepo.save(libro));
        return opt;
        //altrimenti se il codice della chiave
        //primaria esiste aggiorna la tupla
        //(riga/record) esistente.
    }

    public Boolean deleteById(Long id){
        Optional<Libro> opt = libroRepo.findById(id);
        boolean result = false;
        if(opt.isPresent()){
            libroRepo.deleteById(id);
            //opt = Optional.empty();
            result = true;
        }
        return result;
    }

}
