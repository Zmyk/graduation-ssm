package beans;

public class User {
	
	private String u_phone;
	private String u_name;
	private String u_password;
	private int state;
	
	
	public User() {
		
	}

	public User(String u_phone, String u_name, String u_password,int state) {
		super();
		this.u_phone = u_phone;
		this.u_name = u_name;
		this.u_password = u_password;
		this.state = state;
	}
	
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
