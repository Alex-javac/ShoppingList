
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>Error</title>
</head>
<body>
<h2>Во время регистрации произошла ошибка</h2>
<br/>
<h4>возможные причины:</h4>
<br/>
<h4>1)такой email уже используется</h4>
<br/>
<h4>2)......</h4>
<br/>
<h4>3)......</h4>
<button onclick="location.href='register'" style="width:auto;">Sign up</button>
<button onclick="location.href='main'" style="width:auto;">Main page</button>
</body>
</html>
