package com.mintic.reto3.controller;

import com.mintic.reto3.model.Category;
import com.mintic.reto3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController /* Recibe las peticiones de postman, movil etc*/
@RequestMapping("/api/Category") /* Mapeo de la peticion. Se establece la URL */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /*
    @GetMapping("/all")
    public List<Category> getCategories(){
        return  categoryService.getAll();
    }
    */
    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getAll();
    }//C4

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable ("id") int id){
        return  categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){
        return  categoryService.save(c);
    }

}
