<!DOCTYPE html>

<html lang="en">

<body>


<form action="doLogin" method="post">
    <p>账号：<input type="text" name="username" value="Kevin"/></p>
    <p>密码：<input type="text" name="password" value="111111"/></p>
    <p><input type="submit" value="登录"/></p><p><input type="checkbox" name="rememberMe" />记住我,下次自动登录</p>
</form>
<#if msg?exists>错误信息：${msg!""}</#if>
</body>

</html>
