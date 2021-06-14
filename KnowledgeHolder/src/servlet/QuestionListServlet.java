package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.AnswersDao;
import dao.QuestionsAnswersDao;
import dao.QuestionsDao;
import model.Answer;
import model.Question;
import model.QuestionAnswer;

/**
 * Servlet implementation class QuestionListServlet
 */
@WebServlet("/QuestionListServlet")
@MultipartConfig
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


		//回答処理
			Collection<Part> parts = request.getParts();

			//送られたデータを（画像以外）すべて保持するためのHashMap
			HashMap<String,String> map = new HashMap<String,String>();

			//アップされたファイル名（forループの中で取得）
			String uploadFileName = "";
			//画像を保存するパス
			//ここでは、PCのデスクトップに保存して確認できるようにしている
			String uploadFolder = "C:\\uploaded\\";

			//名前が決まってから画像を処理するために、Partを保持しておく
			//Part imgPart = null;

			for(Part part:parts){ //partsから１つずつ取り出す
				String contentType = part.getContentType();
				System.err.print(contentType);
				if ( contentType == null ) {
					//ここは通常のテキストやチェックボックス、セレクトなどのケース

					try(InputStream inputStream = part.getInputStream()) {
						BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
						//実際のデータを取ってくる
						String val = (String)bufReader.lines().collect(Collectors.joining());
						//HTMLのnameとPOSTされたvalueをセットにして格納
						map.put(part.getName(), val);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}else{
					//アップロードされたファイルの処理

					uploadFileName = this.getFileName(part);
					//実際には、ファイル名を商品IDなどに置き換えることになる（同一ファイル名対策）
					//ここだけコピペじゃなく、自分で実装すること
					if(!uploadFileName.equals("")) {
						part.write(uploadFolder + uploadFileName );
					//みなさんのシステムでは、AIを使っている場合、名前がまだ決まらない
					//imgPart = part;
					}
				}
			}
			//int newId = 100;//作ったデータの新しいID
			//imgPart.write(uploadFolder + newId + ".jpg");


			//値の取り方
			//getParameter()の代わりにmapから、画面のHTMLで設定したname属性で取得する
			String ans_contents = map.get("que_contents");
			String ans_file = (uploadFolder + uploadFileName);
			int q_id =Integer.parseInt(map.get("que_id"));
			//登録処理を行う
			 AnswersDao aDao = new  AnswersDao();
			 if (aDao.insert(new Answer(0,q_id,ans_contents,ans_file,0,"" ))) {

				 //成功時質問内容表示ページにフォワードする
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
				 dispatcher.forward(request, response);
			 }
			 else {
				 //失敗時質問内容表示ページにフォワードする
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
				 dispatcher.forward(request, response);
			 }



		//結果をページに表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
		dispatcher.forward(request, response);
	}

	private String getFileName(Part part) {
	    String name = null;
	    for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	        if (dispotion.trim().startsWith("filename")) {
	            name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	            name = name.substring(name.lastIndexOf("\\") + 1);
	            break;
	        }
	    }
	    return name;
	}

}
