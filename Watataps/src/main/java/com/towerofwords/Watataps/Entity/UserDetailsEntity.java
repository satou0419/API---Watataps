package com.towerofwords.Watataps.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_user_details")
public class UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIDRef;
    private int progress;
    private int credit;


    
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIDRef")
    private UserEntity user;

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