package com.example.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	// this method retrieves all the books from the database
    List<Song> findAll();
    
    // find all books of particular artist
    List<Song> findByArtist(String artist);
    
    // find top ten songs by rating descending
    List<Song> findTop10ByOrderByRatingDesc();

}
