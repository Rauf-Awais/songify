package com.example.songify.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.songify.models.Song;
import com.example.songify.service.SongService;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongsController {
    private final SongService service;

    @PostMapping
    public ResponseEntity<String> createSongs(@RequestBody Song song){

        var created = service.createSong(song);
        if(created){
            return new ResponseEntity<>(" New Song created successfully" , HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Failed to create Song", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<Song>> getAllSongs(){
        var songs = service.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Song> getSongByID(@PathVariable String id){
        var song = service.getSongById(id);
        if (song.isPresent()){
            return new ResponseEntity<>(song.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateSong(@PathVariable String id, @RequestBody Song song ){
        var isUpdated = service.updateSong(id,song);
        if (isUpdated){
            return new ResponseEntity<>("Song Updated ", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Update failed", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable String id){
        var isDeleted = service.deleteById(id);
        if (isDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>("failed to delete", HttpStatus.NOT_FOUND);
        }
    }

}
