package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name="UsersDetails")

public class UserDetails {
	
		@Id
		@GeneratedValue
		int user_Id;
		public int getUser_Id() {
			return user_Id;
		}

		public void setUser_Id(int user_Id) {
			this.user_Id = user_Id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public boolean isEnabled() {
			return isEnabled;
		}

		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}

		public boolean isOnline() {
			return isOnline;
		}

		public void setOnline(boolean isOnline) {
			this.isOnline = isOnline;
		}

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}

		private String firstName;
		private String lastName;
		
		@Column(unique=true,nullable=false)
		private String userName;
		private String contact;
		
		@Column(unique=true,nullable=false)
		private String email;
		private String password;
		private String role;
		private boolean isEnabled;
		private boolean isOnline;
		
		@Lob
		private byte[] image;
}
