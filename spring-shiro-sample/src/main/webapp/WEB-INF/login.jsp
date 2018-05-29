<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        $(document).ready(function () {
            $("#login").click(function () {
                var login = $('input[name="login"]').val();
                var password = $('input[name="password"]').val();
                $.post("/auth",
                    {
                        login: login,
                        password: password
                    },
                    function (data, status) {
                        console.log("数据: \n" + data + "\n状态: " + status);
                        var result = JSON.parse(data);
                        window.location = result.url;
                    });
            });
        });
    </script>
</head>
<body>
<h2>登录页面!</h2>
<form>
    <label> name： <input type="text" name="login" value="user"> </label>
    <label> password： <input type="password" name="password" value="123"> </label>
    <input type="button" value="login" id="login">
</form>
</body>
</html>
