package com.example.songify.service;

import com.example.songify.DTO.WriterDTO;
import com.example.songify.models.Song;
import com.example.songify.models.Writer;
import com.example.songify.repositories.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WriterService {

    private final WriterRepository repository;

    public boolean createWriter(WriterDTO dto) {
          try {
            repository.save(dto.toWriter());
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public Iterable<WriterDTO> getAllWriters() {
        var writers = repository.findAll();
        var writerDTOs = new ArrayList<WriterDTO>();
        for (var writer : writers){
            var writerDTO = new WriterDTO(writer);
            writerDTOs.add(writerDTO);
    }

        return writerDTOs;
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
    public boolean deleteById(Long id){
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
