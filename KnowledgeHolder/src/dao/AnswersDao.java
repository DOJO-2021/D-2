package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;


public class AnswersDao {
/*	public List<Answer> select(Answer param) {
		Connection conn = null;
		List<Answer> answerList = new ArrayList<Answer>();
			//↑データをしまう入れ物を用意

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

		// SQL文を準備する
		String sql = "select ans_id, que_id, ans_contents, ans_file, user_id, ans_date from ANSWERS";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		if (param.getAns_contents() != null) {
			pStmt.setString(1, "%" + param.getAns_contents() + "%");
			// ↑用意した入れ物(pStmt)の1番目に入れるという操作
		}
		else {
			pStmt.setString(1, "%");
		}


		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			Answer answer = new Answer(
			rs.getInt("ans_id"),
			rs.getInt("que_id"),
			rs.getString("ans_contents"),
			rs.getString("ans_file"),
			rs.getInt("user_id"),
			rs.getString("ans_date")
			);
			answerList.add(answer);
		}
	}

	catch (SQLException e) {
		e.printStackTrace();
		answerList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		answerList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				answerList = null;
			}
		}
	}

	// 結果を返す
	return answerList;
}
*/
	//更新クリック時、更新ページを表示するメソッド
	public List<Answer> answer_up_view(Answer param) {
		Connection conn = null;
		List<Answer> up_view = new ArrayList<Answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select * from answers where ans_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, param.getAns_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Answer answer = new Answer(
				rs.getInt("ans_id"),
				rs.getInt("que_id"),
				rs.getString("ans_contents"),
				rs.getString("ans_file"),
				rs.getInt("user_id"),
				rs.getString("ans_date")
				);
				up_view.add(answer);
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

	public List<Answer> answer_log(Answer param) {
		Connection conn = null;
		List<Answer> log_list = new ArrayList<Answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select * from answers where user_id=? order by ans_id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, param.getUser_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Answer answer = new Answer(
				rs.getInt("ans_id"),
				rs.getInt("que_id"),
				rs.getString("ans_contents"),
				rs.getString("ans_file"),
				rs.getInt("user_id"),
				rs.getString("ans_date")
				);
				log_list.add(answer);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			log_list = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			log_list = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					log_list = null;
				}
			}
		}
		return log_list;
	}

	public List<Answer> answer_first(Answer param) {
		Connection conn = null;
		List<Answer> up_view = new ArrayList<Answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select * from answers where que_id=? limit 0";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, param.getQue_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Answer answer = new Answer(
				rs.getInt("ans_id"),
				rs.getInt("que_id"),
				rs.getString("ans_contents"),
				rs.getString("ans_file"),
				rs.getInt("user_id"),
				rs.getString("ans_date")
				);
				up_view.add(answer);
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

	public List<Answer> answer_multi(Answer param) {
		Connection conn = null;
		List<Answer> up_view = new ArrayList<Answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select * from answers where que_id=? limit 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, param.getQue_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Answer answer = new Answer(
				rs.getInt("ans_id"),
				rs.getInt("que_id"),
				rs.getString("ans_contents"),
				rs.getString("ans_file"),
				rs.getInt("user_id"),
				rs.getString("ans_date")
				);
				up_view.add(answer);
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
	public boolean insert(Answer answer) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

			// SQL文を準備する
			String sql = "insert into ANSWERS values(null, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setInt(1, answer.getQue_id());

			if (answer.getAns_contents() != null) {
				pStmt.setString(2, answer.getAns_contents());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (answer.getAns_file() != null) {
				pStmt.setString(3, answer.getAns_file());
			}
			else {
				pStmt.setString(3, "null");
			}

				pStmt.setInt(4, answer.getUser_id());

			if (answer.getAns_date() != null) {
				pStmt.setString(5, answer.getAns_date());
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
	public boolean update(Answer answer) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

			// SQL文を準備する
			String sql = "update ANSWERS set que_id =?, ans_contents=?, ans_file=?, user_id=?, ans_date=? where ans_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setInt(1, answer.getQue_id());

			if (answer.getAns_contents() != null) {
				pStmt.setString(2, answer.getAns_contents());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (answer.getAns_file() != null) {
				pStmt.setString(3, answer.getAns_file());
			}
			else {
				pStmt.setString(3, "null");
			}

				pStmt.setInt(4, answer.getUser_id());

			if (answer.getAns_date() != null) {
				pStmt.setString(5, answer.getAns_date());
			}
			else {
				pStmt.setString(5, "null");
			}

			pStmt.setInt(6, answer.getAns_id());


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
	public boolean delete(int ans_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

			// SQL文を準備する
			String sql = "delete from ANSWERS where ans_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, ans_id);

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
