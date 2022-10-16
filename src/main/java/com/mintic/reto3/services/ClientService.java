package com.mintic.reto3.services;

import com.mintic.reto3.model.Client;
import com.mintic.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    /* Logica del Negocio*/
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> c1 = clientRepository.getClient(c.getIdClient());
            if(c1.isPresent()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Client update(Client c){
        if(c.getIdClient() != null){
            Optional<Client> caux = clientRepository.getClient(c.getIdClient());
            if(!caux.isEmpty()){
                if(c.getName() != null){
                    caux.get().setName(c.getName());
                }
                if(c.getAge()!= null){
                    caux.get().setAge(c.getAge());
                }
                if(c.getPassword()!= null){
                    caux.get().setPassword(c.getPassword());
                }
                clientRepository.save(caux.get());
                return caux.get();
            } else {
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        Boolean repuesta = getClient(id).map(c ->{
            clientRepository.delete(c);
            return true;
        }).orElse(false);
        return repuesta;
    }

}
