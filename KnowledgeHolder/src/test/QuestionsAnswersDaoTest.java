package test;

import java.util.List;

import dao.QuestionsAnswersDao;
import model.QuestionAnswer;

public class QuestionsAnswersDaoTest {
	public static void main(String[] args) {
		QuestionsAnswersDao dao = new QuestionsAnswersDao();
		/*
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
		*/

		// question()のテスト　que_id=1 User_id=1のリストを検索
		System.out.println("---------- question()のテスト----------");
		List<QuestionAnswer> queList = dao.questions(new QuestionAnswer(2, "", "","", "", 2, 0, 0,"", 0, "", "", "", ""));
		for (QuestionAnswer que : queList) {
			System.out.println(que.getQue_id());
			System.out.println(que.getQue_category());
			System.out.println(que.getQue_title());
			System.out.println(que.getQue_contents());
			System.out.println(que.getQue_file());
			System.out.println(que.getUser_id());
			System.out.println(que.getF_tag());
			System.out.println(que.getQue_count());
			System.out.println(que.getQue_date());
			System.out.println(que.getUser_name());
		}

		// answers()のテスト　que_id=1 User_id=1のリストを検索
		System.out.println("---------- answers()のテスト----------");
		List<QuestionAnswer> ansList = dao.answers(new QuestionAnswer(2, "", "","", "", 1, 0, 0,"", 0, "", "", "", ""));
		for (QuestionAnswer ans : ansList) {
			System.out.println(ans.getUser_id());
			System.out.println(ans.getAns_id());
			System.out.println(ans.getAns_contents());
			System.out.println(ans.getAns_file());
			System.out.println(ans.getAns_date());
			System.out.println(ans.getUser_name());
		}

	}
}
