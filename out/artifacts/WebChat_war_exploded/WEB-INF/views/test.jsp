<%--
  Created by IntelliJ IDEA.
  User: USER-PC
  Date: 2024-11-19
  Time: 오전 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
</head>
<body>
<h1>WebSocket <small>chat</small></h1>

<div>
    <div class="group">
        <label>닉네임</label>
        <input type="text" name="name" id="name" class="short">
    </div>
</div>

<div>
    <button type="button" class="in">들어가기</button>
</div>
</body>
<script>

    $('.in').click(function(e) {
        let name = $('#name').val();

        if ($(e.target).data('name') != null && $(e.target).data('name') != '') {
            name = $(e.target).data('name');
        }

        let child = window.open('/chatRoom', 'chat', 'width=405', 'height=510');

        child.addEventListener('load', function() {
            //자식창 다 뜨고 나면 발생
            child.connect(name);
        });

        //비활성화
        $('.in').css('opacity', .5).prop('disabled', true);
        $('#name').prop('readOnly', true);
    });

</script>
</html>
