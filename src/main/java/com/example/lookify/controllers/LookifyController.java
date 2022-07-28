package com.example.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lookify.models.Song;
import com.example.lookify.services.LookifyServices;


@Controller
public class LookifyController {
	private final LookifyServices lookifyServices;

	public LookifyController(LookifyServices lookifyServicess) {
		this.lookifyServices = lookifyServicess;
	}
	
	//open dashboard page directly when access the website
	@RequestMapping("")
	public String index() {
		return "redirect:/dashboard";
	}
	
	// main page
	@RequestMapping("dashboard")
	public String dashboard(Model model) {
		List<Song> songs = lookifyServices.allSongs();
		model.addAttribute("songs", songs);
		return "/index.jsp";
	}
	
	// show form page to add a new song 
	@RequestMapping(value="/songs/new")
	public String add(Model model) {
		if (!model.containsAttribute("song")) {
			model.addAttribute("song",new Song());
		}
		return "/new.jsp";
	}
	
	// add new song
	@PostMapping(value="/songs/new")
	public String add(Model model, @Valid @ModelAttribute("song") Song song, BindingResult result, RedirectAttributes redirectAttributes ) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("song",song);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.song",result);
			return "redirect:/songs/new";
        } 
		lookifyServices.createSong(song);
    	redirectAttributes.addFlashAttribute("success", "Song was created successfully");
        return "redirect:/dashboard";
        
	}
	
	// show song details
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable(value="id") Long id, Model model) {
		Song song = lookifyServices.findSong(id);
        model.addAttribute("song", song);
		return "/show_song.jsp";
	}

	
	// search by artist name
	@PostMapping(value="/search")
	public String search(
			@RequestParam(value = "search") String search ,
			Model model ,
			RedirectAttributes redirectAttributes) {
		
		if (search.isEmpty()) {
			return "redirect:/dashboard";
		}
		List<Song> songs = lookifyServices.findSongsByArtist(search);
		if (songs.isEmpty()) {
			redirectAttributes.addFlashAttribute("error", "Artist "+search+" is not found");
			return "redirect:/dashboard";
		}
        return "redirect:/search/"+search;
        
	}
	
	// show the results of the search 
	@GetMapping(value="/search/{search}")
	public String dsplaySearch(@PathVariable(value = "search") String search , Model model ) {
		List<Song> songs = lookifyServices.findSongsByArtist(search);
		model.addAttribute("songs",songs);
		model.addAttribute("artist",search);
        return "/search.jsp";
	}
	
	// bonus: top ten songs in database
	@RequestMapping(value="/search/topten")
	public String dsplaytop(Model model ) {
		List<Song> songs = lookifyServices.topSongs();
		model.addAttribute("songs",songs);
        return "/topten.jsp";
	}
	
	// delete song 
	@DeleteMapping(value="/songs/{id}")
	public String destroy(@PathVariable(value="id") Long id,RedirectAttributes redirectAttributes) {
		lookifyServices.deleteSong(id);
		redirectAttributes.addFlashAttribute("success", "Song was deleted successfully");
		return "redirect:/dashboard";
	    }

}
