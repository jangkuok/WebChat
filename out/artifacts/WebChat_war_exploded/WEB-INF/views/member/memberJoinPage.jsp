<%--
  Created by IntelliJ IDEA.
  User: USER-PC
  Date: 2024-11-20
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>회원가입</title>
    <link rel="stylesheet" href="https://me2.do/5BvBFJ57">
</head>
<body>
    <div style="display: flex; justify-content: center; align-items: center; margin-top:200px;">
        <div style="display: flex; justify-content: center; align-items: center; border:2px solid; width:300px;height:400px;">
            <div>
                <form id="memberJoin" action="/memberJoin" method="post">
                    <div>
                        <h1 style="text-align: center;">회원가입</h1>
                    </div>
                    <span>
                        아이디
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
                    <span>
                        닉네임
                    </span>
                    <div>
                        <input id="nickName" name="nickName" placeholder="닉네임">
                    </div>
                   <input type="submit" value="가입하기" style="width: 195px; height: 25px; margin-top: 10px;">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
