package entities;

public class User {
	
	private String email;
	private String phone;
	private String password;
	private String city;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String email, String phone, String password, String city, boolean ismember) {
		super();
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", phone=" + phone + ", password=" + password + ", city=" + city + "]";
	}
	
	
}
