<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
  <title></title>
</head>
<body>
  <input type="text" name="" id="msg">
  <button onclick="sendMsg();">send</button>

  <button onclick="closeWebSocket();">close</button>
</body>
<script src="./assets/vendor_components/jquery/dist/jquery.js"></script>
<script type="text/javascript">
      $.ajax({
        type: 'POST',
        url: '/api/login',
        data: {
          "username": "es",
          "password": "1"
        },
        contentType: 'application/json',
        dataType: 'json',
        success: function(data) {
          console.log(data);
        },
        error: function(e) {
          console.log(e);        
        }
      });
</script>
</html>