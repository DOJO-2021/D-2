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

import dao.QuestionsDao;
import model.Question;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/KnowledgeHolder/LoginServlet");
			return;
		}

		//デフォルトで登録日降順に並び替える
		QuestionsDao qDao = new QuestionsDao();
		List<Question> SortList = qDao.default_sort(null);

		// 並び替え結果をリクエストスコープに格納する
		request.setAttribute("questionList", SortList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("submit").equals("検索")) {
			QuestionsDao qDao = new QuestionsDao();

			String que_category = request.getParameter("que_category");
			String keyword = request.getParameter("keyword");

			//1件取得できていればログイン後のページに移動
			HttpSession session = request.getSession();

			//ログインしていなければログインページへ遷移
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("//KnowledgeHolder/LoginServlet");
				return;
			}

			//id_nameの0番目のuser_idとuser_pwをセッションに格納
			session.setAttribute("que_category", que_category);
			session.setAttribute("keyword", keyword);

			// 検索処理を行う
			List<Question> questionList = qDao.selectByQue_categoryOrQue_titleOrQue_contents(que_category, keyword);

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("questionList", questionList);

		} else if(request.getParameter("submit").equals("並び替え")) {
			QuestionsDao qDao = new QuestionsDao();

			//1件取得できていればログイン後のページに移動
			HttpSession session = request.getSession();

			//ログインしていなければログインページへ遷移
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("//KnowledgeHolder/LoginServlet");
				return;
			}

			String sort_category = (String) session.getAttribute("que_category");
			String sort_keyword = (String) session.getAttribute("keyword");


			List<Question> SortList =null;

			//登録日（降順）
			if (request.getParameter("status").equals("登録順(降順)")) {
				SortList = qDao.datedesc_sort(sort_category, sort_keyword);
			}
			//登録日（昇順）
			else if(request.getParameter("status").equals("登録順(昇順)")){
				SortList = qDao.dateasc_sort(sort_category, sort_keyword);
			}
			//アクセス数
			else if (request.getParameter("status").equals("アクセス数")){
				 SortList = qDao.access_sort(sort_category, sort_keyword);
			}
			//完了
			else if (request.getParameter("status").equals("完了済み")){
				SortList = qDao.closed_sort(sort_category, sort_keyword);
			}
			//未完了
			else if (request.getParameter("status").equals("未完了")){
				SortList = qDao.opened_sort(sort_category, sort_keyword);
			}
			request.setAttribute("questionList", SortList);

		}

		//結果をページに表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

}
