package com.mintic.reto3.repository.crud;

import com.mintic.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
