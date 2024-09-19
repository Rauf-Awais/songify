package com.example.songify.repositories;

import com.example.songify.models.SongWriter;
import org.springframework.data.repository.CrudRepository;

public interface SongWriterRepository extends CrudRepository<SongWriter,String> {
}
