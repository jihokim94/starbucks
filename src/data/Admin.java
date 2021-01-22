package data;

import java.util.Date;

public class Admin {
	private int id; //관리번호 <<PK>>
	private String login; //이름  <<UQ>>
	private String pw;
	private String name;
	private Date regDay;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDay() {
		return regDay;
	}
	public void setRegDay(Date regDay) {
		this.regDay = regDay;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String login, String pw, String name) {
		this(0, login, pw, name, null);
	}
	public Admin(int id, String login, String pw, String name, Date regDay) {
		super();
		this.id = id;
		this.login = login;
		this.pw = pw;
		this.name = name;
		this.regDay = regDay;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", pw=" + pw + ", name=" + name + ", regDay=" + regDay + "]";
	}
	
	
}