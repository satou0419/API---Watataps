package com.towerofwords.Watataps.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table (name = "tbl_user_archive")
public class UserArchiveEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIDRef;
	
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIDRef")
    @JsonIgnore
    private UserEntity user;
    

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "tbl_user_archive_words",
        joinColumns = @JoinColumn(name = "user_archive_entity_useridref"),
        inverseJoinColumns = @JoinColumn(name = "words_word_id")
    )
    private List<WordEntity> words;

	public UserArchiveEntity() {
		super();
	}

	public UserArchiveEntity(int userIDRef, UserEntity user, List<WordEntity> words) {
		super();
		this.userIDRef = userIDRef;
		this.user = user;
		this.words = words;
	}

	public int getUserIDRef() {
		return userIDRef;
	}

	public void setUserIDRef(int userIDRef) {
		this.userIDRef = userIDRef;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<WordEntity> getWords() {
		return words;
	}

	public void setWords(List<WordEntity> words) {
		this.words = words;
	}
    
    
}