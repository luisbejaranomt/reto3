package com.mintic.reto3.services;

import com.mintic.reto3.model.Library;
import com.mintic.reto3.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    /* Logica del Negocio*/
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAll(){
        return libraryRepository.getAll();
    }

    public Optional<Library> getLibrary(int id){
        return libraryRepository.getLibrary(id);
    }

    public Library save(Library l){
        if(l.getId()==null){
            return libraryRepository.save(l);
        }else{
            Optional<Library> l1 = libraryRepository.getLibrary(l.getId());
            if(l1.isPresent()){
                return libraryRepository.save(l);
            }else{
                return l;
            }
        }
    }

    public Library update(Library l){
        if(l.getId() != null){
            Optional<Library> taux = LibraryRepository.getLibrary(l.getId());
            if(!taux.isEmpty()){
                if(l.getName() != null){
                    taux.get().setName(l.getName());
                }
                if(l.getTarget() != null){
                    taux.get().setTarget(l.getTarget());
                }
                if(l.getCapacity() != null){
                    taux.get().setCapacity(l.getCapacity());
                }
                if(l.getDescription() != null){
                    taux.get().setDescription(l.getDescription());
                }
                if(l.getCategory() != null){
                    taux.get().setCategory(l.getCategory());
                }
                LibraryRepository.save(taux.get());
                return taux.get();
            } else {
                return l;
            }
        }else{
            return l;
        }
    }

    public boolean delete(int id){
        Boolean respuesta = getLibrary(id).map(t ->{
            libraryRepository.delete(t);
            return true;
        }).orElse(false);
        return respuesta;
    }


}
