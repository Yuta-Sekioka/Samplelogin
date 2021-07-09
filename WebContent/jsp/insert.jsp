<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<p>ログイン名とパスワードを入力してください。</p>
<form action="Insert.action"method="post">
<p>ログイン名<input type="text"name="login"></p>
パスワード<input type="text"name="password">　　
<input type="submit" value="新規登録">
</form>

<%@include file="../footer.html" %>
