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
import model.Question;
import model.QuestionAnswer;

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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		//ログインしていなければログインページへ遷移
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/KnowledgeHolder/LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");

		// インスタンス化
		QuestionsDao qDao = new QuestionsDao();
		AnswersDao aDao = new AnswersDao();
		QuestionsAnswersDao qaDao = new QuestionsAnswersDao();

		// 質問の更新・削除・表示
		if (request.getParameter("q&a_submit").equals("q_update")) {
			int que_id = Integer.parseInt(request.getParameter("que_id"));
			// 検索処理を行う
			List<Question> up_view = qDao.question_up_view(new Question(que_id, "", "", "", "", 0, 0, 0, ""));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("up_view", up_view);

			// 質問更新ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_update.jsp");
			dispatcher.forward(request, response);

		} else if (request.getParameter("q&a_submit").equals("q_delete")) {
			int que_id = Integer.parseInt(request.getParameter("que_id"));
			if (qDao.delete(que_id)) {	// 削除成功
				// 成功時の処理
				aDao.delete_all(que_id); //回答も削除
				//履歴ページリダイレクトする
				 response.sendRedirect("/KnowledgeHolder/LogServlet");
				 return;
			}
			else {						// 削除失敗
				//失敗時のエラー処理

				//履歴ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/log.jsp");
				dispatcher.forward(request, response);
			}

		}/*s else if (request.getParameter("status").equals("0")){
			// Ajaxで渡されたテキストボックスの値を変数に格納
			String satus = request.getParameter("status");
	        // QuestionsDaoで更新処理を行う
		}*/

		// 回答の更新・削除・表示
		else if (request.getParameter("q&a_submit").equals("a_update")) {
			int ans_id = Integer.parseInt(request.getParameter("ans_id"));
			// 検索処理を行う
			List<QuestionAnswer> up_view = qaDao.answer_update(new QuestionAnswer(0, "", "", "","", 0,0,0, "",ans_id,"","","",""));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("up_view", up_view);

			// 回答更新ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer_update.jsp");
			dispatcher.forward(request, response);

		} else if (request.getParameter("q&a_submit").equals("a_delete")) {
			int ans_id = Integer.parseInt(request.getParameter("ans_id"));
			if (aDao.delete(ans_id)) {	// 削除成功
				// 成功時の処理

				//履歴ページリダイレクトする
				 response.sendRedirect("/KnowledgeHolder/LogServlet");
				 return;
			}
			else {						// 削除失敗
				//失敗時のエラー処理

				//履歴ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/log.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			//例外処理
		}
	}

}
