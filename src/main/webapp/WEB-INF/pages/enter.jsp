<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }
        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>

<H1>Вы вошли в приложение</H1>
<img src="img_avatar_gomer.png" alt="Avatar">
<br/>
Введенное имя: ${userJSP.login};
<br/>
Введенный пороль: ${userJSP.password};
<br/>
<br/>
email: ${userJSP.email};
<br/>
firstName: ${userJSP.firstName};
<br/>
lastName: ${userJSP.lastName};
<br/>
nickName: ${userJSP.nickName};
<br/>
<button onclick="location.href='main'" style="width:auto;">Main page</button>
</body>
</html>
