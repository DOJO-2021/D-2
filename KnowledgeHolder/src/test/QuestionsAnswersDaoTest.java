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
		List<QuestionAnswer> ansList = dao.answers(new QuestionAnswer(2, "", "","", "", 0, 0, 0,"", 0, "", "", "", ""));
		for (QuestionAnswer ans : ansList) {
			System.out.println(ans.getUser_id());
			System.out.println(ans.getAns_id());
			System.out.println(ans.getAns_contents());
			System.out.println(ans.getAns_file());
			System.out.println(ans.getAns_date());
			System.out.println(ans.getUser_name());
		}

		// datedesc_id_sortque()のテスト　User_id=2のリストを検索
		System.out.println("---------- datedesc_id_sortque()のテスト----------");
		List<QuestionAnswer> sort1List = dao.datedesc_id_sortque(2);
		for (QuestionAnswer sort : sort1List) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getF_tag());
			System.out.println(sort.getQue_date());
			System.out.println(sort.getUser_name());
		}

		// dateasc_id_sortque()のテスト　User_id=2のリストを検索
		System.out.println("---------- datedesc_id_sortque()のテスト----------");
		List<QuestionAnswer> sort2List = dao.dateasc_id_sortque(2);
		for (QuestionAnswer sort : sort2List) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getF_tag());
			System.out.println(sort.getQue_date());
			System.out.println(sort.getUser_name());
		}

		// access_id_sortque()のテスト　User_id=2のリストを検索
		System.out.println("---------- access_id_sortque()のテスト----------");
		List<QuestionAnswer> sort3List = dao.access_id_sortque(2);
		for (QuestionAnswer sort : sort3List) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getF_tag());
			System.out.println(sort.getQue_date());
			System.out.println(sort.getUser_name());
		}

		// closed_id_sortque()のテスト　User_id=2のリストを検索
		System.out.println("---------- closed_id_sortque()のテスト----------");
		List<QuestionAnswer> sort4List = dao.closed_id_sortque(2);
		for (QuestionAnswer sort : sort4List) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getF_tag());
			System.out.println(sort.getQue_date());
			System.out.println(sort.getUser_name());
		}

		// opened_id_sortque()のテスト　User_id=2のリストを検索
		System.out.println("---------- opened_id_sortque()のテスト----------");
		List<QuestionAnswer> sort5List = dao.opened_id_sortque(2);
		for (QuestionAnswer sort : sort5List) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getF_tag());
			System.out.println(sort.getQue_date());
			System.out.println(sort.getUser_name());
		}

		// datedesc_id_sortans()のテスト　User_id=2のリストを検索
				System.out.println("---------- datedesc_id_sortans()のテスト----------");
				List<QuestionAnswer> sort6List = dao.datedesc_id_sortans(2);
				for (QuestionAnswer sort : sort6List) {
					System.out.println(sort.getQue_id());
					System.out.println(sort.getQue_category());
					System.out.println(sort.getQue_title());
					System.out.println(sort.getAns_id());
					System.out.println(sort.getAns_contents());
					System.out.println(sort.getAns_date());
					System.out.println(sort.getUser_name());
				}

				// dateasc_id_sortans()のテスト　User_id=2のリストを検索
				System.out.println("---------- datedesc_id_sortque()のテスト----------");
				List<QuestionAnswer> sort7List = dao.dateasc_id_sortans(2);
				for (QuestionAnswer sort : sort7List) {
					System.out.println(sort.getQue_id());
					System.out.println(sort.getQue_category());
					System.out.println(sort.getQue_title());
					System.out.println(sort.getAns_id());
					System.out.println(sort.getAns_contents());
					System.out.println(sort.getAns_date());
					System.out.println(sort.getUser_name());
				}

				// access_id_sortans()のテスト　User_id=2のリストを検索
				System.out.println("---------- access_id_sortans()のテスト----------");
				List<QuestionAnswer> sort8List = dao.access_id_sortans(2);
				for (QuestionAnswer sort : sort8List) {
					System.out.println(sort.getQue_id());
					System.out.println(sort.getQue_category());
					System.out.println(sort.getQue_title());
					System.out.println(sort.getAns_id());
					System.out.println(sort.getAns_contents());
					System.out.println(sort.getAns_date());
					System.out.println(sort.getUser_name());
				}

				// closed_id_sortans()のテスト　User_id=2のリストを検索
				System.out.println("---------- closed_id_sortans()のテスト----------");
				List<QuestionAnswer> sort9List = dao.closed_id_sortans(2);
				for (QuestionAnswer sort : sort9List) {
					System.out.println(sort.getQue_id());
					System.out.println(sort.getQue_category());
					System.out.println(sort.getQue_title());
					System.out.println(sort.getAns_id());
					System.out.println(sort.getAns_contents());
					System.out.println(sort.getAns_date());
					System.out.println(sort.getUser_name());
				}

				// opened_id_sortans()のテスト　User_id=2のリストを検索
				System.out.println("---------- opened_id_sortans()のテスト----------");
				List<QuestionAnswer> sort10List = dao.opened_id_sortans(2);
				for (QuestionAnswer sort : sort10List) {
					System.out.println(sort.getQue_id());
					System.out.println(sort.getQue_category());
					System.out.println(sort.getQue_title());
					System.out.println(sort.getAns_id());
					System.out.println(sort.getAns_contents());
					System.out.println(sort.getAns_date());
					System.out.println(sort.getUser_name());
				}
	}
}
