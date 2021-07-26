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
        /* Center the image and position the close button */
        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
            position: relative;
        }
    </style>
</head>
<body>
<div class="imgcontainer">
<H1>Вы вошли в приложение</H1>
    <h3>тут должно быть отображение существующих списков покупок</h3>
    <br/>
    <h3>добавление новых списков а так же функция добавить к списку другого юзера  </h3>
<br/>
Введенное имя: ${userJSP.login};
<br/>
Введенный пороль: ${userJSP.password};
<br/>
<br/>
id: ${userJSP.id};
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
    <form method="post" modelAttribute="userJSP" action="shopList">

    <button>Shop List</button>
    </form>
</div>
</body>
</html>
