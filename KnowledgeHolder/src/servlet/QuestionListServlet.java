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

import dao.QuestionsAnswersDao;
import dao.QuestionsDao;
import model.Question;
import model.QuestionAnswer;

/**
 * Servlet implementation class QuestionListServlet
 */
@WebServlet("/QuestionListServlet")
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/KnowledgeHolder/LoginServlet");
			return;
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}


		//search.jspからポストされたら質問内容表示回答内容表示

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int que_id = Integer.parseInt(request.getParameter("que_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String que_category = request.getParameter("que_category");

		// 検索処理を行う
			//joinを用いてデータベースを結合、そこからIdで一括検索
			QuestionsAnswersDao qaDao = new QuestionsAnswersDao();
			List<QuestionAnswer> allList = qaDao.allselect(new QuestionAnswer(que_id, "", "", "", "", user_id, 0, 0,"",0,"","","",""));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("allList", allList);


		//カテゴリをもとにランキングを検索
			//カテゴリが多いもののうち閲覧数が多い上位10位を検索
			QuestionsDao qDao = new QuestionsDao();
			List<Question> rankList = qDao.ranking(new Question(0, que_category, "", "", "", 0, 0, 0,""));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("rankList", rankList);


		//結果をページに表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
		dispatcher.forward(request, response);
	}

}
