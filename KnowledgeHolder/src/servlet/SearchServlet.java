package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//デフォルトで登録日降順に並び替える
		QuestionsDao qDao = new QuestionsDao();
		List<Question> SortList = qDao.datedesc_sort(null);

		// 並び替え結果をリクエストスコープに格納する
		request.setAttribute("SortList", SortList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String que_category = request.getParameter("que_category");
		//String keyword = request.getParameter("keyword");

		QuestionsDao qDao = new QuestionsDao();

		// プルダウンによって処理を変える
		List<Question> SortList =null;

			//登録日（降順）
			if (request.getParameter("status").equals("登録順(降順)")) {
				SortList = qDao.datedesc_sort(null);
			}
			//登録日（昇順）
			else if(request.getParameter("status").equals("登録順(昇順)")){
				SortList = qDao. dateasc_sort(null);
			}
			//アクセス数
			else if (request.getParameter("status").equals("アクセス数")){
				 SortList = qDao.access_sort(null);
			}
			//完了
			else if (request.getParameter("status").equals("完了済み")){
				SortList = qDao.datedesc_sort(null);
			}
			//未完了
			else if (request.getParameter("status").equals("未完了")){
				SortList = qDao.datedesc_sort(null);
			}

		// 検索処理を行う
		//List<Question> questionList = qDao.selectByQue_categoryOrQue_titleOrQue_contents(que_category, keyword);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("SortList", SortList);
		//request.setAttribute("questionList", questionList);

		//結果をページに表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

}
