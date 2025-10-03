<%--
  Created by IntelliJ IDEA.
  User: josea
  Date: 30/09/2025
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="../../images/icons/login-ico.png" type="image/x-icon">
        <link rel="stylesheet" href="../../style/login.css"/>
        <title>Login</title>
    </head>
<body>
    <div class="login-section">
        <div class="tittle">
            <hr class="line">
            <img src="../../images/user-image.png" alt="Silhueta de uma pessoa">
            <hr class="line">
        </div>
        
        <form action="${pageContext.request.contextPath}/login" method="post" >

            <label for="login">LOGIN:</label>
            <input class="login-input" type="text" name="login" id="login" required autofocus>

            <br>

            <label for="password">SENHA:</label>
            <input class="pwrd-input" type="password" name="password" id="password" required>

            <button class="btn" type="submit">ENTRAR</button>
        </form>

        <a href="${pageContext.request.contextPath}/resetPassword">Esqueci minha senha!</a>
    </div>
</body>
</html>
