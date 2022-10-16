package com.mintic.reto3.controller;

import com.mintic.reto3.model.Library;
import com.mintic.reto3.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController /* Recibe las peticiones de postman, movil etc*/
@RequestMapping("/api/Library") /* Mapeo de la peticion. Se establece la URL */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/all")
    public List<Library> getLibraries(){
        return  libraryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Library> getLibrary(@PathVariable ("id") int id){
        return  libraryService.getLibrary(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Library save(@RequestBody Library l){
        return  libraryService.save(l);
    }

}
