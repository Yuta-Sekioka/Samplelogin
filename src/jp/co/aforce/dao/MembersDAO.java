package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Members;

public class MembersDAO extends DAO{
	public Members search(String login,String password)	//テーブルから検索するためのseachメソッドのみ定義
		throws Exception{
		Members members=null;	
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(//？に引数を渡す
				"select * from members where login=? and password=?");	
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {//結果をBeanに保存
			members=new Members();
			members.setId(rs.getInt("id"));
			members.setLogin(rs.getString("login"));
			members.setPassword(rs.getString("password"));
		}
		st.close();
		con.close();
		return members;
	}
	
//	public int insert(Members members)throws Exception{
//	Connection con=getConnection();
//	
//	PreparedStatement st=con.prepareStatement(
//			"insert into product values(null,?,?)");
//			st.setString(1,members.getLogin());
//			st.setString(2,members.getPassword());
//			int line=st.executeUpdate();
//			
//			st.close();
//			con.close();
//			return line;
//}	
}
