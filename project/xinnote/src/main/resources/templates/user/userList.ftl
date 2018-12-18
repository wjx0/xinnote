<div id="new1" >
<!DOCTYPE html>

<html lang="en">
<title>用户列表</title>
<#include "../common/common.ftl">

<script type="text/javascript" charset="UTF-8" src="../../static/js/back/user/userList.js"></script>
<body>
<form id="form">
    用户名：<input type="text" id="userName" name="userName" placeholder="User Name">
    姓名：<input type="text" name="name" placeholder="Name">
    角色：<input type="text" name="roleName" placeholder="Role Name"><br>
    类型：<select name="type">
    <option value="1">管理员</option>
    <option value="0">用户</option>
</select>
    状态：<select name="usingFlag">
    <option value="1">启用</option>
    <option value="0">停用</option>
</select>
    创建人：<input type="text" name="creator" placeholder="Creator"><br>
    创建时间：<input type="date" name="gmtCreateStart" placeholder="Create Data Start">
    - <input type="date" name="gmtCreateEnd" placeholder="Create Data End"><br>
<input id="find" type="button" value="查询" >
<input type="reset" value="重置" >
</form>
<table id="tab">
    <tr>
        <th>用户ID</th>
        <th>账号</th>
        <th>姓名</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>角色</th>
        <th>类型</th>
        <th>状态</th>
        <th>创建人</th>
        <th>创建时间</th>
    </tr>
    <#list userList as u>
        <tr>
            <td>${u.id}</td>
            <td>${u.userName}</td>
            <td>${u.name!''}</td>
            <td>${u.telePhone!''}</td>
            <td>${u.email!''}</td>
            <td>${u.roleName!''}</td>
            <td><#if "1" == u.type>管理员<#else>用户</#if></td>
            <td><#if "1" == u.usingFlag>启用<#else>停用</#if></td>
            <td>${u.creator!''}</td>
            <td>${u.gmtCreate?string('yyyy-MM-dd')}</td>
        </tr>
    </#list>

    <tfoot colspan="10">
        <input id="prePage" type="button" value="上一页"/>
        当前<span id="pageNo">${pageNo}</span>页
        <input id="nextPage" type="button" value="下一页"/>
        共<span id="pages">${pages!''}</span>页，
        共${total!''}条数据
    </tfoot>
</table>

</body>

</html>
</div>