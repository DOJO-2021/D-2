package model;
import java.io.Serializable;

public class User implements  Serializable {
	private int user_id;
	private String user_name;
	private String user_pw;
	private String user_mail;

	public User(int user_id, String user_name, String user_pw, String user_mail) {
		  this.user_id =  user_id;
		  this.user_name = user_name;
		  this.user_pw = user_pw;
		  this.user_mail = user_mail;
	}

	// 引数がないコンストラクタ（デフォルトコンストラクタ）
	public User() {
		super();
		this.user_id = 0;
		this.user_name = "";
		this.user_pw = "";
		this.user_mail = "";
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

}
