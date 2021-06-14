package test;

import java.util.List;

import dao.QuestionsAnswersDao;
import model.QuestionAnswer;

public class QuestionsAnswersDaoTest {
	public static void main(String[] args) {
		QuestionsAnswersDao dao = new QuestionsAnswersDao();

		// allselect()のテスト　que_id=1 User_id=1のリストを検索
		System.out.println("---------- allselect()のテスト----------");
		List<QuestionAnswer> allList = dao.allselect(new QuestionAnswer(1, "", "","", "", 1, 0, 0,"", 0, "", "", "", ""));
		for (QuestionAnswer all : allList) {
			System.out.println(all.getQue_id());
			System.out.println(all.getQue_category());
			System.out.println(all.getQue_title());
			System.out.println(all.getQue_contents());
			System.out.println(all.getQue_file());
			System.out.println(all.getUser_id());
			System.out.println(all.getF_tag());
			System.out.println(all.getQue_count());
			System.out.println(all.getQue_date());
			System.out.println(all.getAns_id());
			System.out.println(all.getAns_contents());
			System.out.println(all.getAns_file());
			System.out.println(all.getAns_date());
			System.out.println(all.getUser_name());
		}
	}
}
