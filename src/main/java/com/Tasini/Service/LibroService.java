package com.Tasini.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tasini.Domain.Libro;
import com.Tasini.Repository.LibroRepo;

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
}
