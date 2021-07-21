<%--
  Created by IntelliJ IDEA.
  User: alexander
  Date: 08.07.2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Breack</title>
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
<H1>Ошибка! </H1>
<br/>
<h2>неверный логин или пороль</h2>
<br/>
Введенное имя: ${userJSP.login};
<br/>
Введенный пороль: ${userJSP.password};
<br/>

<button onclick="location.href='main'" style="width:auto;">Main page</button>
</body>
</html>
