<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <form action="/account/join" method="POST">
        아이디<input type="text" name="accountId" value=""><br/>
        비밀번호<input type="text" name="password" value=""><br/>
        <input type="submit" value="회원가입">
    </form>
</html>