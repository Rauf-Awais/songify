package com.example.songify.repositories;

import com.example.songify.models.Writer;
import org.springframework.data.repository.CrudRepository;

public interface WriterRepository extends CrudRepository<Writer,String> {
}
