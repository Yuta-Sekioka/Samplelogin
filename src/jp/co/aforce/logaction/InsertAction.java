package jp.co.aforce.logaction;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Members;
import jp.co.aforce.dao.MembersDAO;
import jp.co.aforce.tool.Action;

public class InsertAction extends Action{
	public String execute(
			HttpServletRequest request,HttpServletResponse response
		)throws Exception{
			
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			
			Members p=new Members();
			p.setLogin(login);
			p.setPassword(password);
			MembersDAO dao=new MembersDAO();
			dao.insert(p);
			
//			List<Members> list=dao.search("");
//			request.setAttribute("list", list);
////			
			return ;
		}
	
}
