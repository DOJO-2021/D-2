package model;
import java.io.Serializable;

public class User implements  Serializable {
  private int his_id;
  private int user_id;
  private int que_id;
  private int ans_id;

  public User () {}
  public User(int his_id, int user_id, int que_id, int ans_id) {
	  this.his_id = his_id;
	  this.user_id = user_id;
	  this.que_id = que_id;
	  this.ans_id = ans_id;
  }
public int getHis_id() {
	return his_id;
}
public void setHis_id(int his_id) {
	this.his_id = his_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getQue_id() {
	return que_id;
}
public void setQue_id(int que_id) {
	this.que_id = que_id;
}
public int getAns_id() {
	return ans_id;
}
public void setAns_id(int ans_id) {
	this.ans_id = ans_id;
}


}
