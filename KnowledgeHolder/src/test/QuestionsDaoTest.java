package test;
import java.util.List;

import dao.QuestionsDao;
import model.Question;

public class QuestionsDaoTest {
	public static void main(String[] args) {
		QuestionsDao qDao = new QuestionsDao();


		// select()のテスト
				System.out.println("---------- select()のテスト ----------");
				List<Question> questionList =  qDao.selectByQue_categoryOrQue_titleOrQue_contents("Java css","コード ソース");
				for (Question question : questionList) {
					//System.out.println("ID：" + card.get());
					System.out.println(question.getQue_category());
				}
  }
}
