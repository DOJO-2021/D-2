package model;
import java.io.Serializable;

public class Answer implements Serializable {
	private int ans_id;
	private int que_id;
	private String ans_contents;
	private String ans_file;
	private int user_id;
	private String ans_date;

	public Answer () {}
	public Answer (int ans_id, int que_id, String ans_contents, String ans_file, int user_id, String ans_date) {
		this.ans_id = ans_id;
		this.que_id = que_id;
		this.ans_contents = ans_contents;
		this.ans_file = ans_file;
		this.user_id = user_id;
		this.ans_date = ans_date;
	}
	public int getAns_id() {
		return ans_id;
	}
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}
	public int getQue_id() {
		return que_id;
	}
	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}
	public String getAns_contents() {
		return ans_contents;
	}
	public void setAns_contents(String ans_contents) {
		this.ans_contents = ans_contents;
	}
	public String getAns_file() {
		return ans_file;
	}
	public void setAns_file(String ans_file) {
		this.ans_file = ans_file;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAns_date() {
		return ans_date;
	}
	public void setAns_date(String ans_date) {
		this.ans_date = ans_date;
	}


}
