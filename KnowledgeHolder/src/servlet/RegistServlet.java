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
import javax.servlet.http.Part;



@WebServlet("/RegistServlet")
@MultipartConfig
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 登録成功時、検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
		*/

		//ここから改造加えています。

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
		String uploadFolder = "C:\\Users\\sep-other\\Desktop\\ImageSample\\ImageSample\\WebContent\\img\\uploaded\\";

		//名前が決まってから画像を処理するために、Partを保持しておく
		Part imgPart = null;

		for(Part part:parts){ //partsから１つずつ取り出す
			String contentType = part.getContentType();
			if ( contentType == null) {
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
				part.write(uploadFolder + uploadFileName);

				//みなさんのシステムでは、AIを使っている場合、名前がまだ決まらない
				imgPart = part;
			}
		}

		//値の取り方
		//getParameter()の代わりにmapから、画面のHTMLで設定したname属性で取得する
		String que_title = map.get("que-title");
		String que_category = map.get("que-category");
		String que_contents = map.get("que-contents");

		//ここでdaoを使って１行作成する

	}



	private String getFileName(Part part) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}




}