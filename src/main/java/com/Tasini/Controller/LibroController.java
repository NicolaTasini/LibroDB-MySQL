package com.Tasini.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.Tasini.Domain.Libro;
import com.Tasini.Repository.LibroRepo;
import com.Tasini.Service.LibroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LibroController {
    
    @Autowired
    LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> getAll(){
        return ResponseEntity.ok().body(libroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getById(@PathVariable Long id){
        //se trovo il libro tramite id allora restituisco il libro
        //altrimenti non trovato (http status 404)
        Optional<Libro> opt = libroService.getById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok().body(opt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping
    public ResponseEntity<Libro> saveLibro(@RequestBody Libro libro) {
        Optional<Libro> opt = libroService.saveLibro(libro);
        return ResponseEntity.ok().body(opt.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteLibroById(@PathVariable Long id){
        if(libroService.deleteById(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    

}
