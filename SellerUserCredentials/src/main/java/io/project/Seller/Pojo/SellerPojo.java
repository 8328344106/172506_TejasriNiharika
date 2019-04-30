package io.project.Seller.Pojo;

import org.springframework.data.annotation.Id;

public class SellerPojo {

		@Id
		String id;
		String username;
		String email;
		String mobilenumber;
		String password;
		String repeatpassword;
		String answer;
			
		
		public SellerPojo(String id, String username, String email, String mobilenumber, String password,
				String repeatpassword, String answer) {
			super();
			this.id = id;
			this.username = username;
			this.email = email;
			this.mobilenumber = mobilenumber;
			this.password = password;
			this.repeatpassword = repeatpassword;
			this.answer = answer;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobilenumber() {
			return mobilenumber;
		}
		public void setMobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRepeatpassword() {
			return repeatpassword;
		}
		public void setRepeatpassword(String repeatpassword) {
			this.repeatpassword = repeatpassword;
		}



}
