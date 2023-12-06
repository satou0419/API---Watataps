package com.towerofwords.Watataps.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="tblword")
public class WordEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "word_id")
	private int wordID;
	
	@Column(name = "word")
	private String word;
	
	@Column(name = "audio_path")
	private String audioPath;
	
	@Column(name = "definition")
	private String definition;
	
	@Column(name = "part_of_speech")
	private String partOfSpeech;
	
	@Column(name = "pronunciation")
	private String pronunciation;
	
	@ManyToMany(mappedBy = "words")
    private List<UserArchiveEntity> userArchives;
	
	

	
	//Constructor
	public WordEntity() {
		super();
	}
	public WordEntity(int wordID, String word, String audioPath, String definition, String partOfSpeech,
			String pronunciation) {
		super();
		this.wordID = wordID;
		this.word = word;
		this.audioPath = audioPath;
		this.definition = definition;
		this.partOfSpeech = partOfSpeech;
		this.pronunciation = pronunciation;
	}




	//GET and SET
	




	public int getWordID() {
		return wordID;
	}


	
	public void setWordID(int wordID) {
		this.wordID = wordID;
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String getAudioPath() {
		return audioPath;
	}


	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}


	public String getDefinition() {
		return definition;
	}


	public void setDefinition(String definition) {
		this.definition = definition;
	}


	public String getPartOfSpeech() {
		return partOfSpeech;
	}


	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}


	public String getPronunciation() {
		return pronunciation;
	}


	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}
	
	
}