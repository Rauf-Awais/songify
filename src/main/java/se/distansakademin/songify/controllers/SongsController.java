package se.distansakademin.songify.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.distansakademin.songify.models.Songs;
import se.distansakademin.songify.service.SongsService;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongsController {
    private final SongsService service;

    @PostMapping
    public ResponseEntity<String> createSongs(@RequestBody Songs songs){

        var created = service.createSong(songs);
        if(created){
            return new ResponseEntity<>(" New Song created successfully" , HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Failed to create Song", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<Songs>> getAllSongs(){
        var songs = service.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}
