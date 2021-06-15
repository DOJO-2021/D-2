package test;

import java.util.List;

import dao.QuestionsDao;
import model.Question;


public class sampleTest {
	public static void main(String[] args) {
		QuestionsDao dao = new QuestionsDao();

		// datedesc_sort()のテスト
		System.out.println("---------- datedesc_sort()のテスト----------");
		List<Question> datedesc_sortList = dao.datedesc_sort(null);
		for (Question sort : datedesc_sortList) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getQue_date());
			System.out.println();
			System.out.println();

		}

		// dateasc_sort()のテスト
		System.out.println("---------- dateasc_sort()のテスト----------");
		List<Question> dateasc_sortList = dao.dateasc_sort(null);
		for (Question sort : dateasc_sortList) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getQue_date());
			System.out.println();
			System.out.println();
		}

		// access_sort()のテスト
		System.out.println("---------- access_sort()のテスト----------");
		List<Question> access_sortList = dao.dateasc_sort(null);
		for (Question sort :access_sortList) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getQue_date());
			System.out.println();
			System.out.println();
		}

		// closed_sort()のテスト
		System.out.println("---------- closed_sort()のテスト----------");
		List<Question> closed_sortList = dao.closed_sort(null);
		for (Question sort :closed_sortList) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getQue_date());
			System.out.println();
			System.out.println();
		}

		// opened_sort()のテスト
		System.out.println("---------- opened_sort()のテスト----------");
		List<Question> opened_sortList = dao.opened_sort(null);
		for (Question sort :opened_sortList) {
			System.out.println(sort.getQue_id());
			System.out.println(sort.getQue_category());
			System.out.println(sort.getQue_title());
			System.out.println(sort.getQue_date());
			System.out.println();
			System.out.println();
		}

		// ranking()のテスト
		System.out.println("---------- ranking()のテスト----------");
		List<Question> rankList = dao.ranking(new Question(0, "css", "", "", "", 0, 0, 0,""));
		for (Question rank :rankList) {
			System.out.println(rank.getQue_id());
			System.out.println(rank.getQue_category());
			System.out.println(rank.getQue_title());
			System.out.println(rank.getQue_count());
			System.out.println(rank.getQue_date());
			System.out.println();
			System.out.println();
		}

		//question_up_view()のテスト
		System.out.println("---------- question_up_view()のテスト----------");
		List<Question> question_up_viewList = dao.ranking(new Question(0, "css", "", "", "", 0, 0, 0,""));
		for (Question view :question_up_viewList) {
			System.out.println(view.getQue_id());
			System.out.println(view.getQue_category());
			System.out.println(view.getQue_title());
			System.out.println(view.getQue_contents());
			System.out.println(view.getQue_file());
			System.out.println(view.getUser_id());
			System.out.println(view.getF_tag());
			System.out.println(view.getQue_count());
			System.out.println(view.getQue_date());
			System.out.println();
			System.out.println();
		}


		// insert()のテスト
		System.out.println("---------- insert()のテスト----------");
		Question insRec = new Question(60, "TEST", "TEST", "TEST", "TEST", 0, 0, 0,"2021-01-08");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}else {
			System.out.println("登録失敗！");
		}

		/*保留

		//挿入したレコードのIDを取得する（この後で更新と削除をするため）
		int insId = dao.selectByQue_categoryOrQue_titleOrQue_contents("TEST","TEST").get(0).getQue_id();
		*/

		// update()のテスト
		System.out.println("---------- update()のテスト----------");
		Question upRec = new Question(30, "TEST", "TEST", "TEST", "TEST", 0, 0, 0,"2021-02-08");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

		// update_status()のテスト
		System.out.println("---------- update_status()のテスト----------");
		Question up_sRec = new Question(30, "", "", "", "", 0, 1, 0,"");
		if (dao.update(up_sRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト----------");
		if (dao.delete(30)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}

}
