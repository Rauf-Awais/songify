package se.distansakademin.songify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.distansakademin.songify.models.Songs;
import se.distansakademin.songify.repositories.SongsRepository;

@Service
@RequiredArgsConstructor
public class SongsService {
    private final SongsRepository repository;

    @XRayTimed(segmentName = "create Song")
    public boolean createSong(Songs songs) {
        try {
            repository.save(songs);
            return true;
        } catch (Exception e) {

            return false;
        }

    }
    @XRayTimed(segmentName = "getAllSongs")
    public Iterable<Songs> getAllSongs() {
        return repository.findAll();
    }

}
