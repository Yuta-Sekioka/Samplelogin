package jp.co.aforce.logaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Members;
import jp.co.aforce.dao.MembersDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action{
	public String execute(
			HttpServletRequest request,HttpServletResponse response
		)throws Exception{
		
			HttpSession session=request.getSession();	//id.passを取得
		
			String login=request.getParameter("login");	//DAOからデータベースから検索
			String password=request.getParameter("password");
			MembersDAO dao=new MembersDAO();
			Members members=dao.search(login,password);
		
			if(members!=null) {	//ログイン成功時の処理
				session.setAttribute("members", members);
				return "jsp/login-out.jsp";
			}
		return "jsp/login-error.jsp";	//ログイン失敗時の処理
	}
}