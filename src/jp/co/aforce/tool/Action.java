package jp.co.aforce.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
		public abstract String execute( //executeを含むので、抽象クラス
			HttpServletRequest request,HttpServletResponse response
		)throws Exception;
}
