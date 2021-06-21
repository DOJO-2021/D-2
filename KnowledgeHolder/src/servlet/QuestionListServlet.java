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
	/*private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		Integer count = 0;
		ServletContext application = config.getServletContext();
		application.setAttribute("que_count", count);
		System.out.println("ini()が実行されました");
	}*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
		int user_id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
		int user_id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));
		//search.jspからポストされたら質問内容表示回答内容表示
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int que_id = Integer.parseInt(request.getParameter("que_id"));
		String que_category = request.getParameter("que_category");
		if (request.getParameter("submit").equals("詳細表示")) {
			//ServletContext application = this.getServletContext();
			//Integer count = (Integer)application.getAttribute("que_count");
			int count = Integer.parseInt(request.getParameter("que_count"));
			count++;
			request.setAttribute("que_count", count);
			//application.setAttribute("que_count", count);
			QuestionsDao qDao = new QuestionsDao();
			qDao.update(new Question(que_id,count));
		//検索処理を行う
		QuestionsAnswersDao qaDao = new QuestionsAnswersDao();
		// 質問の検索処理を行う
		List<QuestionAnswer> queList = qaDao.questions(new QuestionAnswer(que_id, "", "", "", "", user_id, 0, 0,"",0,"","","",""));
		// 最初の回答の検索処理を行う
		List<QuestionAnswer> ansList = qaDao.answers(new QuestionAnswer(que_id, "", "", "", "", 0, 0, 0,"",0,"","","",""));
		// その他回答の検索処理を行う
		List<QuestionAnswer> multi_ansList = qaDao.multi_answers(new QuestionAnswer(que_id, "", "", "", "", 0, 0, 0,"",0,"","","",""));
		//カテゴリをもとにランキングを検索
		//カテゴリが多いもののうち閲覧数が多い上位10位を検索
		List<QuestionAnswer> rankList = qaDao.ranking(new QuestionAnswer(0, que_category, "", "", "", 0, 0, 0,"",0,"","","",""));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("queList", queList);
		request.setAttribute("ansList", ansList);
		request.setAttribute("multi_ansList", multi_ansList);
		request.setAttribute("rankList", rankList);
		//結果をページに表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
		dispatcher.forward(request, response);
		} else if (request.getParameter("submit").equals("回答する")) {
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
						part.write(uploadFolder + uploadFileName + user_id + que_id);
					//みなさんのシステムでは、AIを使っている場合、名前がまだ決まらない
					//imgPart = part;
					}
				}
			}
			//int newId = 100;//作ったデータの新しいID
			//imgPart.write(uploadFolder + newId + ".jpg");
			//値の取り方
			//getParameter()の代わりにmapから、画面のHTMLで設定したname属性で取得する
			String ans_contents = map.get("ans_contents");
			String ans_file = (uploadFolder + uploadFileName + user_id + que_id);
			//登録処理を行う
			AnswersDao aDao = new  AnswersDao();
			if (aDao.insert(new Answer(0,que_id,ans_contents,ans_file,user_id,"" ))) {
				//成功時質問内容表示ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
				dispatcher.forward(request, response);
			}
			else {
				//失敗時質問内容表示ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
				dispatcher.forward(request, response);
			}
		}
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