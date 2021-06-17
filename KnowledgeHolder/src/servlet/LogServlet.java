package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnswersDao;
import dao.QuestionsAnswersDao;
import dao.QuestionsDao;
import model.Answer;
import model.Question;
import model.QuestionAnswer;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインしていなければlogin.jspを表示
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("//KnowledgeHolder/LoginServlet");
			return;
		}
		// 自分のuser_idを取得
		int user_id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));

		// 過去に質問したデータを取得
		QuestionsDao qDao = new  QuestionsDao();
		List<Question> q_logList = qDao.question_log(new Question(0, "", "", "", "", user_id, 0, 0,""));

		// 過去に回答したデータを取得
		AnswersDao aDao = new  AnswersDao();
		List<Answer> a_logList = aDao.answer_log(new Answer(0, 0, "", "", user_id, ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("q_logList", q_logList);
		request.setAttribute("a_logList", a_logList);

		// 履歴ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/log.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	//  */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインしていなければlogin.jspを表示
			HttpSession session = request.getSession();
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("//KnowledgeHolder/LoginServlet");
				return;
			}
			// 自分のuser_idを取得
			int user_id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));


		 // 質問更新ページにフォワードする
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/log.jsp");
	 	//dispatcher.forward(request, response);


	 	// リクエストパラメータを取得する
	 	request.setCharacterEncoding("UTF-8");

	 	QuestionsAnswersDao qaDao = new QuestionsAnswersDao();

	 	// プルダウンによって処理を変える
	 	List<QuestionAnswer> SortList =null;

	 	//登録日（降順）
	 	if (request.getParameter("status").equals("登録順(降順)")) {
	 		SortList = qaDao.datedesc_sort(new QuestionAnswer(0, "", "","", "",  user_id, 0, 0,"", 0, "", "", "", ""));
	 	}
	 	//登録日（昇順）
	 	else if(request.getParameter("status").equals("登録順(昇順)")){
	 		SortList = qaDao.dateasc_sort(new QuestionAnswer(0, "", "","", "",  user_id, 0, 0,"", 0, "", "", "", ""));
	 	}
	 	//アクセス数
	 	else if (request.getParameter("status").equals("アクセス数")){
	 		 SortList = qaDao.access_sort(new QuestionAnswer(0, "", "","", "",  user_id, 0, 0,"", 0, "", "", "", ""));
	 	}
	 	//完了
	 	else if (request.getParameter("status").equals("完了済み")){
	 		SortList = qaDao.datedesc_sort(new QuestionAnswer(0, "", "","", "",  user_id, 0, 0,"", 0, "", "", "", ""));
	 	}
	 	//未完了
	 	else if (request.getParameter("status").equals("未完了")){
	 		SortList = qaDao.datedesc_sort(new QuestionAnswer(0, "", "","", "",  user_id, 0, 0,"", 0, "", "", "", ""));
	 	}
	 	request.setAttribute("q_logList", SortList);
	 	request.setAttribute("a_logList", SortList);
	 	//結果をページに表示
	 	//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/log.jsp");
	 	dispatcher.forward(request, response);

	 }

}
