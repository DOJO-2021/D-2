package test;
import java.util.List;

import dao.QuestionsDao;
import model.Question;

public class QuestionsDaoTest {
	public static void main(String[] args) {
		QuestionsDao qDao = new QuestionsDao();


		// select()のテスト
				System.out.println("---------- select()のテスト ----------");
				List<Question> questionList =  qDao.selectByQue_categoryOrQue_titleOrQue_contents("css TEST","");
				for (Question question : questionList) {
					//System.out.println("ID：" + card.get());
					System.out.println(question.getQue_id());
					System.out.println(question.getQue_category());
					System.out.println(question.getQue_title());
					System.out.println(question.getF_tag());
					System.out.println(question.getQue_date());

				}
  }
}

/*
this.que_id = que_id;
	 this.que_category = que_category;
	 this.que_title = que_title;
	 this.que_contents = que_contents;
	 this.que_file = que_file;
	 this.user_id = user_id;
	 this.f_tag = f_tag;
	 this.que_count = que_count;
	 this.que_date = que_date;
*/
