package com.towerofwords.Watataps.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.towerofwords.Watataps.Entity.WordEntity;
import com.towerofwords.Watataps.Repository.WordRepository;


@Service
public class WordService {
	@Autowired
	WordRepository wrepo;
	
	
	//C
	public WordEntity insertWord(WordEntity word) {
		return wrepo.save(word);
	}
	
	//R - read all record in tblword
	public List<WordEntity> getAllWord(){
		return wrepo.findAll();
	}
	
	//U - update word
	
	@SuppressWarnings("finally")
	public WordEntity updateWord(int wordID, WordEntity newWordDetails) {
		WordEntity word = new WordEntity();
		try {
			//search
			word = wrepo.findById(wordID).get();
			
			//
			word.setWord(newWordDetails.getWord());
			word.setAudioPath(newWordDetails.getAudioPath());
			word.setDefinition(newWordDetails.getDefinition());
			word.setPartOfSpeech(newWordDetails.getPartOfSpeech());
			word.setPronunciation(newWordDetails.getPronunciation());
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException ("Word " + wordID + "does not exist");
		}finally {
			return wrepo.save(word);
		}
	}
	
	//D - delete
	public String deleteWord(int wordID) {
		String msg = "";
		
		if (wrepo.findById(wordID) != null) {
			wrepo.deleteById(wordID);
			msg = "Word " + wordID + " is successfully deleted!";
		}else {
			msg = "Word " + wordID + " does not exist";
		}
		
		return msg;
	}
	
	
	
}
