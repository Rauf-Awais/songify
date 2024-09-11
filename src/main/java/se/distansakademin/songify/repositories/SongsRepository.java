package se.distansakademin.songify.repositories;

import org.springframework.data.repository.CrudRepository;
import se.distansakademin.songify.models.Songs;

public interface SongsRepository extends CrudRepository <Songs,String>{
}
