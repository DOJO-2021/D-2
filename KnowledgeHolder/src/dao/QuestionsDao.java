package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;

public class QuestionsDao {


	public List<Question> selectByQue_categoryOrQue_titleOrQue_contents(String que_category, String keyword){
		Connection conn = null;
		List<Question> questionList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledgeHolder", "sa", "pass");
			//質問カテゴリ検索の有無を保持する。nullでも空文字でもなければ有効値


			boolean hasQue_category = que_category != null && !que_category.equals("");
			boolean hasKeyword = keyword != null && !keyword.equals("");

			String sql = " select * from questions where ";
			int added = 0;
			String[] categories = que_category.split(" ");
			//(category = '入力' AND category='入力2' )
			String whereCategory = "";
			//カテゴリ数分ループ
			for(String category : categories) {
				//(category = '入力' OR category='入力2' OR category = ''入力3 )
				if(added > 0) {
					whereCategory += " or ";
				}
				whereCategory += "que_category = ? ";
				added ++;
			}
			if(whereCategory.length() > 0) {
				whereCategory = "( " + whereCategory + ") ";
			}

			//キーワードループ
			int added1 = 0;
			String[] keywords = keyword.split(" ");
			//(category = '入力' AND category='入力2' )
			String whereKeyword = "";
			//キーワード数分ループ
			for(String keyword1 : keywords) {
				//( (title = '入力' OR content = '入力') AND (title = '入力2' OR content = '入力2') )
				if(added1 > 0) {
					whereKeyword += " and ";
				}
				whereKeyword += "( que_title = ? and que_contents = ?) ";
				added1 ++;
			}
			if(added1 > 1) {
				whereKeyword = "( " + whereKeyword + ") ";
			}



			if (hasQue_category && hasKeyword) {
				sql = sql + whereCategory + " and " + whereKeyword;
			} else if(hasQue_category) {
				sql = sql + whereCategory;
			} else if(hasKeyword) {
				sql = sql + whereKeyword;
			} else {
			 sql = "select * from questions";
			}
			System.out.println(sql);


			//ここまででSQL確定。ただし、パラメータ?の数は状況によって変わる。
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			//?がいくつあるかわからないので、カウンタで管理する。
			int num = 0;
			//カテゴリ1に対して?は１つ
			//例） カテゴリ2つの場合 1,2
			//カテゴリ数ぶんループ

			for(String category1 : categories) {
			pStmt.setString(num + 1, "%" + categories[num] + "%");
				 num += 1;
			}

			//キーワード1 に対して?は2つ
			//例）キーワード2つの場合 3,4 keywords[0]  5,6 keywords[1]
			//pStmt.setString(num + 1, "%" + keywords[num] + "%");
			int num1=0;
			for(String keywords2 : keywords) {
					pStmt.setString(num + 1 , "%" + keywords[num1] + "%");
					num += 1;
					pStmt.setString(num + 1, "%" + keywords[num1] + "%");
					num += 1;
			}


			//カウンタの初期化
/*
					pStmt.setString(1, "%" + categories[0] + "%");

					pStmt.setString(2, "%" + categories[1] + "%");
*/

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Question question = new Question(
						0,
						rs.getString("que_category"),
						rs.getString("que_title"),
						rs.getString("que_contents"),
						"",
						0,
						0,
						0,
						""
				);
				questionList.add(question);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			questionList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			questionList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					questionList = null;
				}
			}
		}
		// 結果を返す
		return questionList;
	}


	//検索ページデフォルトorプルダウンで登録日（降順）選択
	//質問を最新のものから表示
	public List<Question> datedesc_sort(Question param) {
		Connection conn = null;
		List<Question> SortList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select que_id, que_category, que_title, que_date FROM QUESTIONS order by que_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				Question sort = new Question(
					rs.getInt("que_id"),
					rs.getString("que_category"),
					rs.getString("que_title"),
					"",
					"",
					0,
					0,
					0,
					rs.getString("que_date")
					);
				SortList.add(sort);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			SortList = null;
		}
		//データベースがない場合のエラー
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			SortList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					SortList = null;
				}
			}
		}

		// 結果を返す
		return SortList;
	}


	//検索ページプルダウンで登録日（昇順）選択
	//質問を古いものから表示
	public List<Question> dateasc_sort(Question param) {
		Connection conn = null;
		List<Question> SortList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select que_id, que_category, que_title, que_date FROM QUESTIONS order by que_date ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				Question sort = new Question(
					rs.getInt("que_id"),
					rs.getString("que_category"),
					rs.getString("que_title"),
					"",
					"",
					0,
					0,
					0,
					rs.getString("que_date")
					);
				SortList.add(sort);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			SortList = null;
		}
		//データベースがない場合のエラー
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			SortList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					SortList = null;
				}
			}
		}

		// 結果を返す
		return SortList;
	}


	//検索ページプルダウンでアクセス数選択
	//質問をアクセス数が多いものから表示
	public List<Question> access_sort(Question param) {
		Connection conn = null;
		List<Question> SortList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select que_id, que_category, que_title, que_date FROM QUESTIONS order by que_count DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				Question sort = new Question(
					rs.getInt("que_id"),
					rs.getString("que_category"),
					rs.getString("que_title"),
					"",
					"",
					0,
					0,
					0,
					rs.getString("que_date")
					);
				SortList.add(sort);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			SortList = null;
		}
		//データベースがない場合のエラー
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			SortList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					SortList = null;
				}
			}
		}

		// 結果を返す
		return SortList;
	}


	//検索ページプルダウンで完了選択
	//質問を完了のもののうち、最新のものから表示
	public List<Question> closed_sort(Question param) {
		Connection conn = null;
		List<Question> SortList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select que_id, que_category, que_title, que_date FROM QUESTIONS where f_tag = 1 order by que_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				Question sort = new Question(
					rs.getInt("que_id"),
					rs.getString("que_category"),
					rs.getString("que_title"),
					"",
					"",
					0,
					0,
					0,
					rs.getString("que_date")
					);
				SortList.add(sort);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			SortList = null;
		}
		//データベースがない場合のエラー
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			SortList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					SortList = null;
				}
			}
		}

		// 結果を返す
		return SortList;
	}


	//検索ページプルダウンで完了選択
	//質問を完了のもののうち、最新のものから表示
	public List<Question> opened_sort(Question param) {
		Connection conn = null;
		List<Question> SortList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select que_id, que_category, que_title, que_date FROM QUESTIONS where f_tag = 0 order by que_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				Question sort = new Question(
					rs.getInt("que_id"),
					rs.getString("que_category"),
					rs.getString("que_title"),
					"",
					"",
					0,
					0,
					0,
					rs.getString("que_date")
					);
				SortList.add(sort);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			SortList = null;
		}
		//データベースがない場合のエラー
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			SortList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					SortList = null;
				}
			}
		}

		// 結果を返す
		return SortList;
	}

	//質問内容表示ページで利用
	//質問カテゴリをもとに同じカテゴリの上位10位を表示
	public List<Question> ranking(Question param) {
		Connection conn = null;
		List<Question> rankList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select que_id, que_category, que_title, que_count, que_date from questions where que_category = ? order by que_count DESC limit 10";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる（カテゴリを入力）
			pStmt.setString(1, param.getQue_category());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				Question rank = new Question(
					rs.getInt("que_id"),
					rs.getString("que_category"),
					rs.getString("que_title"),
					"",
					"",
					0,
					0,
					rs.getInt("que_count"),
					rs.getString("que_date")
					);
				rankList.add(rank);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			rankList = null;
		}
		//データベースがない場合のエラー
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			rankList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					rankList = null;
				}
			}
		}

		// 結果を返す
		return rankList;
	}

		public List<Question> question_up_view(Question param) {
		Connection conn = null;
		List<Question> up_view = new ArrayList<Question>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select * from questions where que_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, param.getQue_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Question question = new Question(
				rs.getInt("que_id"),
				rs.getString("que_category"),
				rs.getString("que_title"),
				rs.getString("que_contents"),
				rs.getString("que_file"),
				rs.getInt("user_id"),
				rs.getInt("f_tag"),
				rs.getInt("que_count"),
				rs.getString("que_date")
				);
				up_view.add(question);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			up_view = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			up_view = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					up_view = null;
				}
			}
		}
		return up_view;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Question question) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "insert into QUESTIONS values(null, ?, ?, ?, ?, ?, 0, 0,now())";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (question.getQue_category() != null) {
				pStmt.setString(1, question.getQue_category());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (question.getQue_title() != null) {
				pStmt.setString(2, question.getQue_title());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (question.getQue_contents() != null) {
				pStmt.setString(3, question.getQue_contents());
			}
			else {
					pStmt.setString(3, "null");
			}
			if (question.getQue_title() != null) {
				pStmt.setString(4, question.getQue_file());
			}
			else {
				pStmt.setString(4, "null");
			}

			if (question.getQue_title() != null) {
				pStmt.setInt(5, question.getUser_id());
			}
			else {
				pStmt.setString(5, "null");
			}


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}



	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Question question) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "update QUESTIONS set que_category=?, que_title=?, que_contents=?, que_file=?, user_id=?, f_tag=?, que_count=?, que_date=? where que_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (question.getQue_category() != null) {
				pStmt.setString(1, question.getQue_category());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (question.getQue_title() != null) {
				pStmt.setString(2, question.getQue_title());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (question.getQue_contents() != null) {
				pStmt.setString(3, question.getQue_contents());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (question.getQue_file() != null) {
				pStmt.setString(4, question.getQue_file());
			}
			else {
				pStmt.setString(4, "null");
			}

				pStmt.setInt(5, question.getUser_id());


				pStmt.setInt(6, question.getF_tag());

				pStmt.setInt(7, question.getQue_count());

			if (question.getQue_date() != null) {
				pStmt.setString(8, question.getQue_date());
			}
			else {
				pStmt.setString(8, "null");
			}

			pStmt.setInt(9, question.getQue_id());


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数questionで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update_status(Question question) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

				// SQL文を準備する
				String sql = "update QUESTIONS set f_tag=? where que_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, question.getF_tag());
				pStmt.setInt(2, question.getQue_id());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}



	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int que_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "delete from QUESTIONS where que_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, que_id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}


}
