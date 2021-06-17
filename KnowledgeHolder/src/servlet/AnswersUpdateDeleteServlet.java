package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
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
import model.Answer;

/**
 * Servlet implementation class AnswersUpdateDeleteServlet
 */
@WebServlet("/AnswersUpdateDeleteServlet")
@MultipartConfig
public class AnswersUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 	// 質問更新ページにフォワードする
	// 	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer_update.jsp");
	// 	dispatcher.forward(request, response);
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
			request.setCharacterEncoding("UTF-8");
			int user_id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));


			//更新または削除
			if (request.getParameter("submit").equals("回答内容を更新する")) {
				int ans_id = Integer.parseInt(request.getParameter("ans_id"));

				//一度削除
				AnswersDao aDao = new  AnswersDao();
				aDao.delete(ans_id);
				//登録

				//リクエスト領域の情報を取得するための処理
				Collection<Part> parts = request.getParts();
				//普通のformからとる場合
				//String ar = request.getParameter("nameの中身");

				//受け取りたいもの
				// uploadfile:画像データとファイル名 , item1:値 , item2:値 , item3:値

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
							int id =Integer.parseInt(map.get("que_id"));
							part.write(uploadFolder + uploadFileName + user_id + id);
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
				int q_id =Integer.parseInt(map.get("que_id"));
				String ans_file = (uploadFolder + uploadFileName + user_id + q_id);

				//更新処理を行う
				 if (aDao.insert (new Answer(ans_id,q_id,ans_contents,ans_file,user_id,"" ))) {

					 //更新成功時質問内容表示ページにフォワードする
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
					 dispatcher.forward(request, response);
				 }
				 else {
					 //更新失敗時質問内容表示ページにフォワードする
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
					 dispatcher.forward(request, response);
				 }
			}
			//削除
			else {
				int ans_id = Integer.parseInt(request.getParameter("ans_id"));
				AnswersDao aDao = new  AnswersDao();
				if(aDao.delete(ans_id)) { //削除成功
					 //削除成功時質問内容表示ページにフォワードする
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
					 dispatcher.forward(request, response);


				}
				else {
					 //削除失敗時質問内容表示ページにフォワードする
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
