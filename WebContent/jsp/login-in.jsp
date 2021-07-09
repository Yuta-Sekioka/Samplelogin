<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html"%>


<form action="../Login.action"method="post">	<!--アクション指定-->
<div style="text-align:center;"><br><br>
<p>ログイン名<input type="text" name="login"></p>
<p>パスワード<input type="password" name="password"></p>	<!-- 非表示 -->
<p><a href="insert.jsp">新規登録</a>　　　　　　
<input type="submit"value="ログイン"></p>
</div>
</form>

<%@include file="../footer.html"%>