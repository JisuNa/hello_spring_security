<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<form action="/login/action" method="POST">
    아이디<input type="text" name="username" value=""><br/>
    비밀번호<input type="text" name="password" value=""><br/>
    <input type="submit" value="로그인">
</form>
</html>