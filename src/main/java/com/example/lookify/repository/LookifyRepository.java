package com.example.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	// this method retrieves all the books from the database
    List<Song> findAll();
    // this method finds books with descriptions containing the search string
    // List<Song> findByDescriptionContaining(String search);
    // this Song counts how many titles contain a certain string
    // Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    // Long deleteByTitleStartingWith(String search);
}
