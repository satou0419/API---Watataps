package com.towerofwords.Watataps.Entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_user_details")
public class UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIDRef;
    private int progress;
    private int credit;


    
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIDRef")
    private UserEntity user;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<UserItemEntity> userItems;

    

	public List<UserItemEntity> getUserItems() {
		return userItems;
	}

	public void setUserItems(List<UserItemEntity> userItems) {
		this.userItems = userItems;
	}

	public UserDetailsEntity() {
		super();
	}

	public UserDetailsEntity(int userIDRef, int progress, int credit, UserEntity user) {
		super();
		this.userIDRef = userIDRef;
		this.progress = progress;
		this.credit = credit;
		this.user = user;
	}

	public int getUserIDRef() {
		return userIDRef;
	}

	public void setUserIDRef(int userIDRef) {
		this.userIDRef = userIDRef;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}