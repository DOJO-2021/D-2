package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionsUpdateDeleteServlet
 */
@WebServlet("/QuestionsUpdateDeleteServlet")
public class QuestionsUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 	// 質問更新ページにフォワードする
	// 	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_update.jsp");
	// 	dispatcher.forward(request, response);
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 質問内容表示ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
		dispatcher.forward(request, response);
	}

}
