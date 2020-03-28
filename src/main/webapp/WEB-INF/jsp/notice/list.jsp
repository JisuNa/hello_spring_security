<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>

        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <form action="/login/action" method="POST">
                        <table>
                            <thead>
                            <tr>
                                <td>No</td>
                                <td>제목</td>
                                <td>등록자</td>
                                <td>조회수</td>
                                <td>등록시간</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${empty list}">
                                <tr>
                                    <td colspan="5">데이터가 없네영</td>
                                </tr>
                            </c:if>
                            <c:forEach items="${list}" var="rs">
                                <tr>
                                    <td>0</td>
                                    <td>${rs.title}</td>
                                    <td>${rs.admin_seq}</td>
                                    <td>${rs.hit}</td>
                                    <td>${rs.created_at}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>