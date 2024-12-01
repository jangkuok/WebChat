<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>대화창</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
     <link rel="stylesheet" href="https://me2.do/5BvBFJ57">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chatCSS.css" type="text/css">

</head>
<body>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <input type="hidden" id="name" name="name" value="${sessionScope.id}">
    <input type="hidden" id="roomNo" name="roomNo" value="${chatRoom.roomNo}">
    <div id="main" style="border:2px solid; width:300px;height:auto;">
        <div id="header"><h2>${chatRoom.roomName}</h2></div>
        <div id="list">
                <c:forEach var="message" items="${chatRoom.chatRoomMessageVoList}" varStatus="st">
                    <c:if test="${sessionScope.id == message.id}">
                        <div class="msg me item ">
                            <div>
                                <div>${''}</div>
                                <div>${message.content}</div>
                            </div>
                            <div>${message.sendDate}</div>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.id != message.id}">
                        <div class="msg other item ">
                            <div>
                                <div>${message.id}</div>
                                <div>${message.content}</div>
                            </div>
                            <div>${message.sendDate}</div>
                        </div>
                    </c:if>
                </c:forEach>
        </div>
        <input type="text" id="msg" placeholder = "대화 내용을 입력하세요.">
    </div>
</body>
<script type="text/javascript">
    let name;
    let ws;
    let messageNo = '0';
    const url = 'ws://localhost:8181/chatting';

    let nickName = $('#name').val();
    let roomNo = $('#roomNo').val();

    //시간 변환
    let timeFormat = { hour: "numeric", minute: "numeric" };

    function connect(name) {

        window.name = name;
        $('#header small').text(name);

        //서버와 연결 및 소켓 생성
        ws = new WebSocket(url);

        ws.onopen = function(e) {
            console.log('서버 연결 성공');

            let message = {
                messageNo: messageNo,
                code: '1',
                id: window.name,
                receiver: '',
                content: '',
                sendDate: new Date().toLocaleString()
            };

            //jOSN 문자열로 변환 후 전송
            ws.send(JSON.stringify(message));
            //print('', '<대화방에 참여했습니다.>' , 'me', 'state', "");

            $('#msg').focus();
        };

        //서버에서 클라이언트에게 전달한 메시지
        ws.onmessage = function(e) {
            let message = JSON.parse(e.data);

            if (message.code == '1') {
                print('', `<[\${message.id}]님이 들어왔습니다.>`, 'other', 'state', "",roomNo);
            }else if (message.code == '2') {
                print('', `<[\${message.id}]님이 나갔습니다.>`, 'other', 'state', "",roomNo);
            } else if (message.code == '3') {
                print(message.id, message.content, 'other', 'msg', message.sendDate,roomNo);
            }
        }
    };

    function log(msg) {
        console.log(`[\${new Date().toLocaleTimeString()}] \${msg}`);
    }

    //대화창 출력 메소드
    function print(name, msg, side, state, time) {

        if(nickName === name){
            let temp = `
				<div class="item \${state} \${side}">
					<div>
                       <div>\${''}</div>
						<div>\${msg}</div>
					</div>
	    				<div>\${time}</div>
				</div>`;

            $('#list').append(temp);
        }else if(nickName !== name){
            let temp = `
				<div class="item \${state} \${side}">
					<div>
                       <div>\${name}</div>
						<div>\${msg}</div>
					</div>
	    				<div>\${time}</div>
				</div>`;

            $('#list').append(temp);
        }

        //새로운 내용이 추가되면 스크롤을 바닥으로 내린다.
        scrollList();
    }

    $(window).on('beforeunload', function() {
        disconnect();
    });

    function disconnect() {
        let message = {
            messageNo: messageNo,
            code: '2',
            id: window.name,
            receiver: '',
            content: '',
            sendDate: new Date().toLocaleString()
        };

        ws.send(JSON.stringify(message));
    }


    $('#msg').keydown(function(e) {
        //엔터를 눌렀을 때, 입력한 대화 내용을 서버로 전달하기
        if (e.keyCode == 13) {	//엔터
            let message = {
                messageNo: messageNo,
                code: '3',
                id: window.name,
                receiver: '',
                content: $('#msg').val(),
                sendDate: new Date().toLocaleTimeString("ko-KR",timeFormat)
            };

            ws.send(JSON.stringify(message));

            $('#msg').val('').focus();

            print(window.name, message.content, 'me', 'msg', message.sendDate,roomNo);
        }
    });

    function scrollList() {
        $('#list').scrollTop($('#list').outerHeight() + 300);
    }
</script>
<style type="text/css">
    html, body {overflow:hidden;}
</style>
</html>
