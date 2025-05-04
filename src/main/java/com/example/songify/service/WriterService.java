package com.example.songify.service;


import com.example.songify.models.Writer;
import com.example.songify.repositories.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WriterService {
    @Autowired
    private final WriterRepository repository;

    public boolean createWriter(Writer writer) {

        try {
            repository.save(writer);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Iterable<Writer> getAllWriter() {
        return repository.findAll();
    }
    public Optional<Writer> getWriterById(Long id) {
        return repository.findById(id);
    }

    public boolean updateWriter(Long id, Writer updateWriter) {
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
    public boolean deleteWriter(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    }

