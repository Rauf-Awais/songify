package com.example.songify.service;

import com.example.songify.models.Song;
import com.example.songify.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongService {
    @Autowired
    private final SongRepository repository;

    public boolean createSong(Song song) {

        try {
            repository.save(song);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public Iterable<Song> getAllSongs() {
        return repository.findAll();
    }
    public Optional<Song> getSongById(Long id) {
        return repository.findById(id);
    }

    public boolean updateSong(Long id, Song updateSong) {
        Optional<Song> existingSong = repository.findById(id);
        if (existingSong.isPresent()) {
            Song song = existingSong.get();

            song.setTitle(song.getTitle());
            song.setType(song.getType());
            song.setLength(song.getLength());
            repository.save(song);
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
