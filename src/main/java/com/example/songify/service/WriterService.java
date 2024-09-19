package com.example.songify.service;

import com.example.songify.models.Song;
import com.example.songify.models.Writer;
import com.example.songify.repositories.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WriterService {

    private final WriterRepository repository;

    public boolean createWriter(Writer writer) {
          try {
            repository.save(writer);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public Iterable<Writer> getAllWriters() {

        return repository.findAll();
    }
    public Optional<Writer> getWriterById(String id) {
        return repository.findById(id);
    }

    public boolean updateWriter(String id, Writer updateWriter) {
        Optional<Writer> existingWriter = repository.findById(id);
        if (existingWriter.isPresent()) {
            Writer writer = existingWriter.get();

            writer.setName(writer.getName());
            writer.setDateOfBirth(writer.getDateOfBirth());
            writer.setEmail(writer.getEmail());
            repository.save(writer);
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteById(String id){
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
