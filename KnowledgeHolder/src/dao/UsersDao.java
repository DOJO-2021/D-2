package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UsersDao {
	// ログインできるならtrueを返す
		public boolean isLoginOK(String user_mail, String user_pw) {
			// connは接続？
			Connection conn = null;
			boolean loginResult = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/knowledge", "sa", "pass");

				// SELECT文を準備する
				String sql = "select count(*) from Users where user_mail = ? and user_pw = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, user_mail);
				pStmt.setString(2, user_pw);

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					loginResult = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				loginResult = false;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				loginResult = false;
				// JDBCが見つからなかったときなど
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						loginResult = false;
					}
				}
			}

			// 結果を返す
			return loginResult;
		}

	public List<User> user_request(User param) {
		Connection conn = null;
		List<User> name_id = new ArrayList<User>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:C:/pleiades/workspace/D-2/KnowledgeHolder/data/KnowledgeHolder", "sa", "pass");

			// SQL文を準備する
			String sql = "select * from users where user_mail = ? and user_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, param.getUser_mail());
			pStmt.setString(2, param.getUser_pw());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				User menu = new User(
				rs.getInt("user_id"),
				rs.getString("user_name"),
				rs.getString("user_pw"),
				rs.getString("user_mail")
				);
				name_id.add(menu);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			name_id = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			name_id = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					name_id = null;
				}
			}
		}

		return name_id;
	}
}
