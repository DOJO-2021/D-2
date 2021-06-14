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
/*	public List<Question> select(Question param) {
		Connection conn = null;
		List<Question> questionList = new ArrayList<Question>();
			//↑データをしまう入れ物を用意

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

		// SQL文を準備する
		String sql = "select que_id, que_category, que_title, que_contents, que_file, user_id, f_tag, que_count, que_date";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		if (param.getQue_category() != null) {
			pStmt.setString(1, "%" + param.getQue_category() + "%");
			// ↑用意した入れ物(pStmt)の1番目に入れるという操作
		}
		else {
			pStmt.setString(1, "%");
		}


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
*/


	//名前または住所を指定して検索する。
	//nullまたは空文字の場合は条件指定しない。
	public List<Question> selectByQue_categoryOrQue_titleOrQue_contents(String que_category, String que_title, String que_contents){
		Connection conn = null;
		List<Question> questionList = new ArrayList<Question>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");
			//質問カテゴリ検索の有無を保持する。nullでも空文字でもなければ有効値
			boolean hasQue_category = que_category != null && !que_category.equals("");
			//質問タイトル検索の有無を保持する。nullでも空文字でもなければ有効値
			boolean hasQue_title = que_title != null && !que_title.equals("");
			//質問内容検索の有無を保持する。nullでも空文字でもなければ有効値
			boolean hasQue_contents = que_contents != null && !que_contents.equals("");
			//追加した条件数を保持する変数
			int added = 0;
			// SQL文を準備する
			String sql = "select QUE_CATEGORY, QUE_TITLE, QUE_CONTENTS from QUESTIONS ";
			//名前、または住所の指定があれば条件検索を行う
			if(hasQue_category || hasQue_title || hasQue_contents) {
				sql += "WHERE ";
			}
			if(hasQue_category) {
				if(added > 0) {
					sql += "AND ";
				}
				sql += "QUE_CATEGORY LIKE ? ";
				added ++;
			}
			if(hasQue_title) {
				if(added > 0) {
					sql += "AND ";
				}
				sql += "QUE_TITLE LIKE ? ";
				added ++;
			}
			if(hasQue_contents) {
				if(added > 0) {
					sql += "AND ";
				}
				sql += "QUE_CONTENTS LIKE ? ";
				added ++;
			}
			//ここまででSQL確定。ただし、パラメータ?の数は状況によって変わる。
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			//?がいくつあるかわからないので、カウンタで管理する。
			//カウンタの初期化
			added = 0;
			if(hasQue_category) {
				added ++;
				pStmt.setString(added, "%" + que_category + "%");
			}
			if(hasQue_title) {
				added ++;
				pStmt.setString(added, "%" + que_title + "%");
			}
			if(hasQue_contents) {
				added ++;
				pStmt.setString(added, "%" + que_contents + "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Question question = new Question(
						rs.getString("QUE_CATEGORY"),
						rs.getString("QUE_TITLE"),
						rs.getString("QUE_CONTENTS")
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
			String sql = "";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる（カテゴリを入力）
			pStmt.setInt(1, param.getQue_id());


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
			String sql = "insert into QUESTIONS values(null, ?, ?, ?, ?, 0, 0, 0,now())";
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
					conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

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
