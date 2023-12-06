package com.towerofwords.Watataps.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.towerofwords.Watataps.Entity.WordEntity;
import com.towerofwords.Watataps.Service.WordService;



@RestController
@RequestMapping("/word")
public class WordController {
	@Autowired
	WordService wserv;
	
	
	
	//C
	@PostMapping("/insertWord")
	public WordEntity insertWord(@RequestBody WordEntity word) {
		return wserv.insertWord(word);
	}
	
	//R
	@GetMapping("/getAllWord")
	public List<WordEntity> getAllWord(){
		return wserv.getAllWord();
	}
	
	//U
	@PutMapping("/updateWord")
	public WordEntity updateWord(@RequestParam int wordID, @RequestBody WordEntity newWordDetails) {
		return wserv.updateWord(wordID, newWordDetails);
	}
	
	//D
	@DeleteMapping("deleteWord/{wordID}")
	public String deleteWord(@PathVariable int wordID) {
		return wserv.deleteWord(wordID);
	}
}
