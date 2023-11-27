package com.towerofwords.Watataps.Entity;
import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private String firstname;
    private String lastname;
    private String username;
    private String password;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserDetailsEntity userDetails;

	public UserEntity() {
		super();
	}

	public UserEntity(int userID, String firstname, String lastname, String username, String password,
			UserDetailsEntity userDetails) {
		super();
		this.userID = userID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.userDetails = userDetails;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}

	 public void setUserDetails(UserDetailsEntity userDetails) {
	        if (userDetails != null) {
	            userDetails.setUserIDRef(this.userID); // Set the userIDRef here
	        }
	        this.userDetails = userDetails;
	    }
    
}