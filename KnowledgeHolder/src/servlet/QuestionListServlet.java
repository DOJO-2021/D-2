package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;

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
		// リクエストパラメータを取得する(仮)
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String que_id = request.getParameter("que_id");
		String answer_id = request.getParameter("answer_id");

		// 検索処理を行う
		//joinを用いてデータベースを結合、そこからIdで一括検索
		QuestionsDao qDao = new QuestionsDao();


		// 検索結果をリクエストスコープに格納する


		// 結果をページに表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/quick.jsp");
		dispatcher.forward(request, response);



	}

}
