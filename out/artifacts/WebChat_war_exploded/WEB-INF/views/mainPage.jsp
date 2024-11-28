<%--
  Created by IntelliJ IDEA.
  User: USER-PC
  Date: 2024-11-20z
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>메인 페이지</title>
</head>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<body>
    <c:if test="${sessionScope.id != null}">
        <div style="display: flex; justify-content: center; align-items: center; margin-top:200px;">
            <div style="display: flex; justify-content: center; align-items: center; border:2px solid; width:300px;height:auto;min-height:400px;">
                <div>
                    <div>
                        <button style="width: 195px; height: 25px;" onclick="location.href='chat/chatRoom'">채팅목록</button>
                    </div>
                    <div>
                        <button style="width: 195px; height: 25px; margin-top: 10px;" onclick="location.href='logout'">로그아웃</button>
                    </div>
                </div>
            </div>
        </div>

    </c:if>
    <c:if test="${sessionScope.id == null}">
        <div style="display: flex; justify-content: center; align-items: center; margin-top:200px;">
            <div style="display: flex; justify-content: center; align-items: center; border:2px solid; width:300px;height:300px;">
                <div>
                    <form id="login" action="/login" method="post">
                        <span>
                            아 이 디
                        </span>
                        <div>
                            <input type="text" id="id" name="id" placeholder="아이디">
                        </div>
                        <span>
                            비밀번호
                        </span>
                        <div>
                            <input type="password" id="pw" name="pw" placeholder="비밀번호">
                        </div>
                        <div>
                            <input type="submit" value="로그인" style="width: 195px; height: 25px; margin-top: 10px;">
                        </div>
                    </form>
                    <button style="width: 195px; height: 25px;" onclick="location.href='joinPage'">회원가입</button>
                </div>
            </div>
        </div>
    </c:if>
</body>
</html>
