package jp.co.aforce.tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"*.action"})	//末尾actionで終わるURLに対応付け
public class FrontController extends HttpServlet {

	protected void doPost(	//Postリクエストを処理するメソッド
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String path=request.getServletPath().substring(1);		//パス取得	substring(1)先頭の一文字を削除
			String name="jp.co.aforce.logaction." + path.replace(".a","A").replace('/','.');	//パス加工
			Action action=(Action)Class.forName(name).
				getDeclaredConstructor().newInstance();			//アクション生成
			
			String url=action.execute(request, response);		//アクション実行 urlを返す
			request.getRequestDispatcher(url).					//フォワードの実行
				forward(request,response);
		}catch(Exception e) {
			e.printStackTrace(out);
		}
	}
	
	public void doget(	//Getリクエストの場合も同じ処理
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		doPost(request,response);	//doPost呼びだし
	}
}
