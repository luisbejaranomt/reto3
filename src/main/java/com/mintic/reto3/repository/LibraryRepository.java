package com.mintic.reto3.repository;

import com.mintic.reto3.model.Client;
import com.mintic.reto3.model.Library;
import com.mintic.reto3.repository.crud.LibraryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository {
    @Autowired
    private static LibraryCrudRepository libraryCrudRepository;

    public List<Library> getAll(){
        return (List<Library>) libraryCrudRepository.findAll();
    }

    public static Optional<Library> getLibrary(int id){
        return libraryCrudRepository.findById(id);
    }

    public static Library save(Library l){
        return libraryCrudRepository.save(l);
    }
    public void delete(Library c){
        libraryCrudRepository.delete(c);
    }

}
