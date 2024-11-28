<%--
  Created by IntelliJ IDEA.
  User: USER-PC
  Date: 2024-11-26
  Time: 오후 3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>채팅 목록</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/roomStyles.css">
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<body>
    <div class="chat-container">
        <header class="chat-header">
            <h2>채팅방</h2>
        </header>
        <div class="chat-list">
            <c:forEach var="chatRoom" items="${chatRoom}" varStatus="st">
                <div class="chat-item" id="roomNo_${chatRoom.roomNo}" name="roomNo_${chatRoom.roomNo}">
                    <div class="profile-img"></div>
                    <div class="chat-info">
                        <input type="hidden" name="roomName_${chatRoom.roomNo}" id="roomName_${chatRoom.roomNo}" value="${chatRoom.roomName}">
                        <input type="hidden" name="name" id="name" value="${sessionScope.id}">
                        <h3 class="name">${chatRoom.roomName}</h3>
                    <c:forEach var="chatRoomMessage" items="${chatRoom.chatRoomMessageVoList}" varStatus="st">
                            <p class="message">${chatRoomMessage.content}</p>
                    </c:forEach>
                    </div>
                    <c:forEach var="chatRoomMessage" items="${chatRoom.chatRoomMessageVoList}" varStatus="st">
                        <span class="time">${chatRoomMessage.sendDate}</span>
                    </c:forEach>
                </div>
            </c:forEach>
        </div>
        <header class="chat-header" id="logout" name="logout">
            <h2 style="text-align: center;cursor:pointer;" >로그아웃</h2>
        </header>
    </div>

</body>
<script type="text/javascript">


    $('.chat-list').on('click','.chat-item',function() {
        const roomNo = $(this).attr('id').replace('roomNo_','');

        const roomName = $('#roomName_' + roomNo).val();

        let name = $('#name').val();

        console.log(name)

        let child = window.open('/chat/chatRoomMessage/' + roomNo, 'chat/chatRoomMessage/' + roomNo, 'width=100', 'height=200');

        child.addEventListener('load', function() {
            //자식창 다 뜨고 나면 발생s
            child.connect(name);
        });

        //비활성화
        $('.in').css('opacity', .5).prop('disabled', true);
        $('#name').prop('readOnly', true);

    });

    $('#logout').click(function (e){
        location.href="${pageContext.request.contextPath}/logout"
    });

</script>
</html>
