package com.example.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.lookify.models.Song;
import com.example.lookify.repository.LookifyRepository;

@Service
public class LookifyServices {
	
	private final LookifyRepository lookifyRepository;

	public LookifyServices(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
    
	public List<Song> allSongs() {
        return lookifyRepository.findAll();
    }
	
	public List<Song> topSongs() {
		return lookifyRepository.findTop10ByOrderByRatingDesc();
    }
		
	public Song createSong(Song b) {
        return lookifyRepository.save(b);
    }
	
	public Song findSong(Long id) {
        Optional<Song> optionalSong = lookifyRepository.findById(id);
        return (optionalSong.isPresent())? optionalSong.get(): null;
    }

	public Song updateSong(Song expense) {
		return lookifyRepository.save(expense);
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	
	public List<Song> findSongsByArtist (String artist){
		return lookifyRepository.findByArtist(artist);
	}
	

}
