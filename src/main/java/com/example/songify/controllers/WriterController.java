package com.example.songify.controllers;


import com.example.songify.models.Song;
import com.example.songify.models.Writer;
import com.example.songify.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/writers")
@RequiredArgsConstructor
public class WriterController {

    private final WriterService service;

    @PostMapping
    public ResponseEntity<String> createWriter(@RequestBody Writer writer){

        var created = service.createWriter(writer);
        if(created){
            return new ResponseEntity<>(" Writer Data created successfully" , HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Failed to create", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<Writer>> getAllWriters(){
        var writers = service.getAllWriters();
        return new ResponseEntity<>(writers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Writer> getWriterByID(@PathVariable String id){
        var writer = service.getWriterById(id);
        if (writer.isPresent()){
            return new ResponseEntity<>(writer.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateWriter(@PathVariable String id, @RequestBody Writer writer ){
        var isUpdated = service.updateWriter(id,writer);
        if (isUpdated){
            return new ResponseEntity<>("Writer Updated through Id ", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Fail to Update", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWriter(@PathVariable String id){
        var isDeleted = service.deleteById(id);
        if (isDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>("fail to delete", HttpStatus.NOT_FOUND);
        }
    }

}
