package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QuestionAnswer;

public class QuestionsAnswersDao {

	/*//一覧表示
	public List<QuestionAnswer> allselect(QuestionAnswer param) {
		Connection conn = null;
		List<QuestionAnswer> allList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, q.que_contents, q.que_file, q.user_id, q. f_tag, q.que_count, q.que_date, a.ans_id, a.que_id, a.ans_contents, a.ans_file, a.ans_date, u.user_name	FROM QUESTIONS  q INNER JOIN ANSWERS a ON q.QUE_ID  = a.QUE_ID INNER JOIN USERS u ON q.user_id  = u.user_id where q.que_id = ? and q.user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, param.getQue_id());
			pStmt.setInt(2, param.getUser_id());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer all = new QuestionAnswer(
				rs.getInt("que_id"),
				rs.getString("que_category"),
				rs.getString("que_title"),
				rs.getString("que_contents"),
				rs.getString("que_file"),
				rs.getInt("user_id"),
				rs.getInt("f_tag"),
				rs.getInt("que_count"),
				rs.getString("que_date"),
				rs.getInt("ans_id"),
				rs.getString("ans_contents"),
				rs.getString("ans_file"),
				rs.getString("ans_date"),
				rs.getString("user_name")
				);
				allList.add(all);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				allList = null;
			}
			//データベースがない場合のエラー
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				allList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						allList = null;
					}
				}
			}

			// 結果を返す
			return allList;
		}
	*/

	//質問表示
	public List<QuestionAnswer> questions(QuestionAnswer param) {
		Connection conn = null;
		List<QuestionAnswer> queList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, q.que_contents, q.que_file, q.user_id, q. f_tag, q.que_count, q.que_date, u.user_name	FROM QUESTIONS q INNER JOIN USERS u ON q.user_id  = u.user_id where q.que_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, param.getQue_id());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer que = new QuestionAnswer(
				rs.getInt("que_id"),
				rs.getString("que_category"),
				rs.getString("que_title"),
				rs.getString("que_contents"),
				rs.getString("que_file"),
				rs.getInt("user_id"),
				rs.getInt("f_tag"),
				rs.getInt("que_count"),
				rs.getString("que_date"),
				0,
				"",
				"",
				"",
				rs.getString("user_name")
				);
				queList.add(que);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				queList = null;
			}
			//データベースがない場合のエラー
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				queList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						queList = null;
					}
				}
			}

			// 結果を返す
			return queList;
		}


	public List<QuestionAnswer> answers(QuestionAnswer param) {
		Connection conn = null;
		List<QuestionAnswer> ansList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select a.ans_id, a.ans_contents, a.ans_file, a.user_id, a.ans_date, u.user_name	FROM ANSWERS a INNER JOIN USERS u ON a.user_id  = u.user_id where a.que_id = ? order by a.ans_date asc limit 1;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, param.getQue_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer ans = new QuestionAnswer(
				0,
				"",
				"",
				"",
				"",
				rs.getInt("user_id"),
				0,
				0,
				"",
				rs.getInt("ans_id"),
				rs.getString("ans_contents"),
				rs.getString("ans_file"),
				rs.getString("ans_date"),
				rs.getString("user_name")
				);
				ansList.add(ans);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ansList = null;
			}
			//データベースがない場合のエラー
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ansList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ansList = null;
					}
				}
			}

			// 結果を返す
			return ansList;
		}

	//回答表示
	public List<QuestionAnswer> multi_answers(QuestionAnswer param) {
		Connection conn = null;
		List<QuestionAnswer> ansList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select a.ans_id, a.ans_contents, a.ans_file, a.user_id, a.ans_date, u.user_name	FROM ANSWERS a INNER JOIN USERS u ON a.user_id  = u.user_id where a.que_id = ? offset 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, param.getQue_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer ans = new QuestionAnswer(
				0,
				"",
				"",
				"",
				"",
				rs.getInt("user_id"),
				0,
				0,
				"",
				rs.getInt("ans_id"),
				rs.getString("ans_contents"),
				rs.getString("ans_file"),
				rs.getString("ans_date"),
				rs.getString("user_name")
				);
				ansList.add(ans);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ansList = null;
			}
			//データベースがない場合のエラー
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ansList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ansList = null;
					}
				}
			}

			// 結果を返す
			return ansList;
		}



	//履歴ページデフォルトorプルダウンで登録日（降順）選択
	//ユーザidで検索した質問を最新のものから表示
	public List<QuestionAnswer> datedesc_id_sortque(int user_id) {
		Connection conn = null;
			List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

				// SQL文を準備する
				String sql = "select q.que_id, q.que_category, q.que_title, q. f_tag, q.que_date, u.user_name FROM QUESTIONS q INNER JOIN USERS u ON q.user_id = u.user_id where q.user_id = ? order by que_date DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる（user_idを入力）
				pStmt.setInt(1, user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) { //データーがある限り
					QuestionAnswer sort = new QuestionAnswer(
							rs.getInt("que_id"),
							rs.getString("que_category"),
							rs.getString("que_title"),
							"",
							"",
							0,
							rs.getInt("f_tag"),
							0,
							rs.getString("que_date"),
							0,
							"",
							"",
							"",
							rs.getString("user_name")
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

	//履歴ページプルダウンで登録日（昇順）選択
	//ユーザidで検索した質問を古いものから表示
	public List<QuestionAnswer> dateasc_id_sortque(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, q. f_tag, q.que_date, u.user_name FROM QUESTIONS q INNER JOIN USERS u ON q.user_id = u.user_id where q.user_id = ? order by que_date ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						rs.getInt("f_tag"),
						0,
						rs.getString("que_date"),
						0,
						"",
						"",
						"",
						rs.getString("user_name")
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


	//履歴ページプルダウンでアクセス数選択
	//ユーザidで検索した質問をアクセス数が多いものから表示
	public List<QuestionAnswer> access_id_sortque(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, q. f_tag, q.que_date, u.user_name FROM QUESTIONS q INNER JOIN USERS u ON q.user_id = u.user_id where q.user_id = ? order by que_count DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						rs.getInt("f_tag"),
						0,
						rs.getString("que_date"),
						0,
						"",
						"",
						"",
						rs.getString("user_name")
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


	//履歴ページプルダウンで完了選択
	//ユーザidで検索した質問を完了のもののうち、最新のものから表示
	public List<QuestionAnswer> closed_id_sortque(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, q. f_tag, q.que_date, u.user_name FROM QUESTIONS q INNER JOIN USERS u ON q.user_id = u.user_id where f_tag = 1 and q.user_id = ? order by que_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						rs.getInt("f_tag"),
						0,
						rs.getString("que_date"),
						0,
						"",
						"",
						"",
						rs.getString("user_name")
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


	//履歴ページプルダウンで完了選択
	//ユーザidで検索した質問を完了のもののうち、最新のものから表示
	public List<QuestionAnswer> opened_id_sortque(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, q. f_tag, q.que_date, u.user_name FROM QUESTIONS q INNER JOIN USERS u ON q.user_id = u.user_id where f_tag = 0 and q.user_id = ? order by que_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						rs.getInt("f_tag"),
						0,
						rs.getString("que_date"),
						0,
						"",
						"",
						"",
						rs.getString("user_name")
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


	//履歴ページデフォルトorプルダウンで登録日（降順）選択
	//ユーザidで検索した回答を最新のものから表示
	public List<QuestionAnswer> datedesc_id_sortans(int user_id) {
		Connection conn = null;
			List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

				// SQL文を準備する
				String sql = "select q.que_id, q.que_category, q.que_title, a.ans_id, a.ans_contents, a.ans_date, u.user_name FROM  ANSWERS a INNER JOIN  QUESTIONS q ON q.que_id = a.que_id INNER JOIN USERS u ON a.user_id = u.user_id where q.user_id = ? order by que_date DESC;";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる（user_idを入力）
				pStmt.setInt(1, user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) { //データーがある限り
					QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						0,
						0,
						"",
						rs.getInt("ans_id"),
						rs.getString("ans_contents"),
						"",
						rs.getString("ans_date"),
						rs.getString("user_name")
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

	//履歴ページプルダウンで登録日（昇順）選択
	//ユーザidで検索した回答を古いものから表示
	public List<QuestionAnswer> dateasc_id_sortans(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, a.ans_id, a.ans_contents, a.ans_date, u.user_name FROM  ANSWERS a INNER JOIN  QUESTIONS q ON q.que_id = a.que_id INNER JOIN USERS u ON a.user_id = u.user_id where q.user_id = ? order by que_date ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						0,
						0,
						"",
						rs.getInt("ans_id"),
						rs.getString("ans_contents"),
						"",
						rs.getString("ans_date"),
						rs.getString("user_name")
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


	//履歴ページプルダウンでアクセス数選択
	//ユーザidで検索した回答をアクセス数が多いものから表示
	public List<QuestionAnswer> access_id_sortans(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, a.ans_id, a.ans_contents, a.ans_date, u.user_name FROM  ANSWERS a INNER JOIN  QUESTIONS q ON q.que_id = a.que_id INNER JOIN USERS u ON a.user_id = u.user_id where q.user_id = ? order by que_count DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						0,
						0,
						"",
						rs.getInt("ans_id"),
						rs.getString("ans_contents"),
						"",
						rs.getString("ans_date"),
						rs.getString("user_name")
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


	//履歴ページプルダウンで完了選択
	//ユーザidで検索した回答を完了のもののうち、最新のものから表示
	public List<QuestionAnswer> closed_id_sortans(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, a.ans_id, a.ans_contents, a.ans_date, u.user_name FROM  ANSWERS a INNER JOIN  QUESTIONS q ON q.que_id = a.que_id INNER JOIN USERS u ON a.user_id = u.user_id where f_tag = 1 and q.user_id = ? order by que_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						0,
						0,
						"",
						rs.getInt("ans_id"),
						rs.getString("ans_contents"),
						"",
						rs.getString("ans_date"),
						rs.getString("user_name")
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


	//履歴ページプルダウンで完了選択
	//ユーザidで検索した回答を完了のもののうち、最新のものから表示
	public List<QuestionAnswer> opened_id_sortans(int user_id) {
		Connection conn = null;
		List<QuestionAnswer> SortList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, a.ans_id, a.ans_contents, a.ans_date, u.user_name FROM  ANSWERS a INNER JOIN  QUESTIONS q ON q.que_id = a.que_id INNER JOIN USERS u ON a.user_id = u.user_id where f_tag = 0 and q.user_id = ? order by que_date DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（user_idを入力）
			pStmt.setInt(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						0,
						0,
						"",
						rs.getInt("ans_id"),
						rs.getString("ans_contents"),
						"",
						rs.getString("ans_date"),
						rs.getString("user_name")
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

	public List<QuestionAnswer> ranking(QuestionAnswer param) {
		Connection conn = null;
		List<QuestionAnswer> rankList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			String sql = "select q.que_id, q.que_category, q.que_title, q.que_contents, q.que_file, q.user_id, q. f_tag, q.que_count, q.que_date, u.user_name	FROM QUESTIONS q INNER JOIN USERS u ON q.user_id  = u.user_id where q.que_category = ? order by que_count DESC";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる（カテゴリを入力）
			pStmt.setString(1, param.getQue_category());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer rank = new QuestionAnswer(
				rs.getInt("que_id"),
				rs.getString("que_category"),
				rs.getString("que_title"),
				rs.getString("que_contents"),
				rs.getString("que_file"),
				rs.getInt("user_id"),
				rs.getInt("f_tag"),
				rs.getInt("que_count"),
				rs.getString("que_date"),
				0,
				"",
				"",
				"",
				rs.getString("user_name")
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

	public List<QuestionAnswer> answer_update(QuestionAnswer param) {
		Connection conn = null;
		List<QuestionAnswer> up_view = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");
			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title,q.que_count, a.ans_id, a.ans_contents, a.ans_file  FROM  ANSWERS a INNER JOIN  QUESTIONS q ON q.que_id = a.que_id where a.ans_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（ans_idを入力）
			pStmt.setInt(1, param.getAns_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer sort = new QuestionAnswer(
						rs.getInt("que_id"),
						rs.getString("que_category"),
						rs.getString("que_title"),
						"",
						"",
						0,
						0,
						rs.getInt("que_count"),
						"",
						rs.getInt("ans_id"),
						rs.getString("ans_contents"),
						rs.getString("ans_file"),
						"",
						""
						);
				up_view.add(sort);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			up_view = null;
		}
		//データベースがない場合のエラー
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

		// 結果を返す
		return up_view;
	}


}
