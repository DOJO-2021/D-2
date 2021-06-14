package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_mail = request.getParameter("user_mail");
		String user_pw = request.getParameter("user_pw");

		UsersDao uDao = new UsersDao();
		List<User> id_name = uDao.user_request(new User(0, "", user_mail, user_pw));

//		if(id_name.size() == 0) { //ログイン失敗時
//			//0件ならログインエラー
//			//ログインページにフォワード
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//			dispatcher.forward(request, response);
//		}else { //ログイン成功時
//			//1件取得できていればログイン後のページに移動
//			HttpSession session = request.getSession();
//			//id_nameの0番目のuser_idとuser_pwをセッションに格納
//			session.setAttribute("user_id", id_name.get(0).getUser_id());
//			session.setAttribute("user_name", id_name.get(0).getUser_name());
//
//			//SearchServletにリダイレクト
//			response.sendRedirect("/KnowledgeHolder/SearchServlet");
//		}
		//SearchServletにリダイレクト
		response.sendRedirect("/KnowledgeHolder/SearchServlet");
	}
}
