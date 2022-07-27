package com.example.lookify.services;

import java.util.ArrayList;
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
	
	public List<Song> allSongsByArList(String artist) {
		List<Song> songs = lookifyRepository.findAll();
		List<Song> matchSongs = new ArrayList<>();
		for (Song song: songs) {
			if (song.getArtist().equals(artist)) {
				matchSongs.add(song);
			}
		}
		return matchSongs;
    }
	
	public List<Song> topSongs() {
		List<Song> songs = lookifyRepository.findAll();
		songs.sort((o1, o2)
                -> o2.getRating().compareTo(
                        o1.getRating()));
		if (songs.size()<=10)
			return songs;
		return songs.subList(0, 10);
    }
		
	public Song createSong(Song b) {
        return lookifyRepository.save(b);
    }
	
	public Song findSong(Long id) {
        Optional<Song> optionalLanguage = lookifyRepository.findById(id);
        return (optionalLanguage.isPresent())? optionalLanguage.get(): null;
    }

	public Song updateSong(Song expense) {
		return lookifyRepository.save(expense);
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	

}
