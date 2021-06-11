package model;
import java.io.Serializable;

public class Question implements Serializable {
  private int que_id;
  private String que_category;
  private String que_title;
  private String que_contents;
  private String que_file;
  private int user_id;
  private int f_tag;
  private int que_count;
  private String que_date;

  public Question() {}
  public Question(int que_id, String que_category, String que_title, String que_contents, String que_file, int user_id, int f_tag, int que_count, String que_date) {
	 this.que_id = que_id;
	 this.que_category = que_category;
	 this.que_title = que_title;
	 this.que_contents = que_contents;
	 this.que_file = que_file;
	 this.user_id = user_id;
	 this.f_tag = f_tag;
	 this.que_count = que_count;
	 this.que_date = que_date;
  }


  public Question(String que_title, String que_contents) {
	  	 this.que_title = que_title;
		 this.que_contents = que_contents;
  }
  public Question(String que_category) {
	  	 this.que_category = que_category;
}


public int getQue_id() {
	return que_id;
}
public void setQue_id(int que_id) {
	this.que_id = que_id;
}
public String getQue_category() {
	return que_category;
}
public void setQue_category(String que_category) {
	this.que_category = que_category;
}
public String getQue_title() {
	return que_title;
}
public void setQue_title(String que_title) {
	this.que_title = que_title;
}
public String getQue_contents() {
	return que_contents;
}
public void setQue_contents(String que_contents) {
	this.que_contents = que_contents;
}
public String getQue_file() {
	return que_file;
}
public void setQue_file(String que_file) {
	this.que_file = que_file;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getF_tag() {
	return f_tag;
}
public void setF_tag(int f_tag) {
	this.f_tag = f_tag;
}
public int getQue_count() {
	return que_count;
}
public void setQue_count(int que_count) {
	this.que_count = que_count;
}
public String getQue_date() {
	return que_date;
}
public void setQue_date(String que_date) {
	this.que_date = que_date;
}



}
