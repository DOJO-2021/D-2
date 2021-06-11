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

	//一覧表示
	public List<QuestionAnswer> Allselect(QuestionAnswer param) {
		Connection conn = null;
		List<QuestionAnswer> QuestionAllList = new ArrayList<QuestionAnswer>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "select q.que_id, q.que_category, q.que_title, q.que_contents, q.que_file, q.user_id, q. f_tag, q.que_count, q.que_date, a.ans_id, a.que_id, a.ans_contents, a.ans_file, a.ans_date, u.user_name	FROM QUESTIONS  q INNER JOIN ANSWERS a ON q.QUE_ID  = a.QUE_ID INNER JOIN USERS ON q.user_id  = u.user_id WHERE q.que_id = ?, q.user_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //データーがある限り
				QuestionAnswer question = new QuestionAnswer(
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
				QuestionAllList.add(question);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				QuestionAllList = null;
			}
			//データベースがない場合のエラー
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				QuestionAllList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						QuestionAllList = null;
					}
				}
			}

			// 結果を返す
			return QuestionAllList;
		}

}
