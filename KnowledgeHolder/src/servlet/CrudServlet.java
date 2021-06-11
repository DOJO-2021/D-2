package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrudServlet
 */
@WebServlet("/CrudServlet")
public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 質問の更新・削除・表示
		if (request.getParameter("q&a_submit").equals("q_update")) {
			// 質問更新ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_update.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("q&a_submit").equals("q_delete")) {
			// 質問削除ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/log.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("q&a_submit").equals("q_view")) {
			// 質問内容表示ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("status").equals("0")){
			// Ajaxで渡されたテキストボックスの値を変数に格納
	        String satus = request.getParameter("status");
	        // QuestionsDaoで更新処理を行う
		}


		// 回答の更新・削除・表示
		else if (request.getParameter("q&a_submit").equals("a_update")) {
			// 回答更新ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer_update.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("q&a_submit").equals("a_delete")) {
			// 回答削除ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/log.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("q&a_submit").equals("a_view")) {
			// 質問内容表示ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
			dispatcher.forward(request, response);
		} else {
			//例外処理
		}
	}

}
