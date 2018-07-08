<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resource/js/jquery-3.2.1.js"></script>

<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">

<link
    href="resource/vendors/form-helpers/css/bootstrap-formhelpers.min.css"
    rel="stylesheet">
<link href="resource/vendors/select/bootstrap-select.min.css"
    rel="stylesheet">

<link href="resource/css/forms.css" rel="stylesheet">

<script src="resource/bootstrap/js/bootstrap.min.js"></script>

<script
    src="resource/vendors/form-helpers/js/bootstrap-formhelpers.min.js"></script>

<script src="resource/vendors/select/bootstrap-select.min.js"></script>
</head>
<body>
    <div class="col-md-6">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">添加用户</div>
                <div class="panel-options">
                    <a href="#" data-rel="collapse"><i
                        class="glyphicon glyphicon-refresh"></i></a>
                </div>
            </div>
            <div class="panel-body">
                <form method="post" action="userAction_save">
                    <fieldset>
                        <div class="form-group">
                            <label>登录名(*)<span style="color:red;">${msg1 }</span></label> <input
                                class="form-control" placeholder="用户登录名" name="user.loginName"
                                id="user.loginName" type="text" value="">
                        </div>
                        <div class="form-group">
                            <label>密码(*)<span style="color:red;">${msg2 }</span></label> <input
                                class="form-control" placeholder="用户密码" name="user.password"
                                id="user.password" type="password" value="">
                        </div>
                        <div class="form-group">
                            <label>用户名(*)</label> <input class="form-control"
                                placeholder="用户名" name="user.name" id="user.name" type="text"
                                value="">
                        </div>
                        <div class="form-group">
                            <label>身份证</label> <input class="form-control" placeholder="身份证"
                                name="user.idcard" id="user.idcard" type="text" value="">
                        </div>
                        <div class="form-group">
                            <label>出生日期</label> <input class="form-control"
                                placeholder="出生日期" name="user.birthday" id="user.birthday"
                                type="date" value="">
                        </div>
                        <label>用户性别</label>
                        <p>
                            <select class="form-control" name="user.sex" id="user.sex">
                                <option value="男" selected>男</option>
                                <option value="女"selected'}>女</option>
                            </select>
                        </p>
                        <label>用户角色 <s:if test="%{roleName==1?'1':'2' }"></s:if></label>
                        <p>
                            <select class="form-control" name="user.role.roleId"
                                id="user.role.roleId">
                                <c:forEach var="role" items="${roles}">
                                    <option value="${role.roleId}"
                                        <c:if test="${param.roleId==role.roleId}"> selected="selected"</c:if>>${role.roleName}</option>
                                </c:forEach>
                            </select>
                        </p>
                        <div class="form-group">
                            <label>用户类别<s:property value="#idcard" /></label>
                            <p>
                                <select class="form-control" name="user.userType"
                                    id="user.userType">
                                    <option value="1">教师</option>
                                    <option value="2" selected>学生</option>
                                </select>
                            </p>
                            <div class="form-group">
                                <label>部门</label>
                                <p>
                                    <select class="form-control" name="user.department.deptId"
                                        id="user.department.deptId">
                                        <c:forEach var="d" items="${departments}">
                                            <option value="${d.deptId}">${d.deptName}</option>
                                        </c:forEach>
                                    </select>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>班级</label>
                                <p>
                                    <select class="form-control" name="user.classes.classId">
                                        <c:forEach var="c" items="${classes}">
                                            <option value="${c.classId}">${c.className}</option>
                                        </c:forEach>
                                    </select>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>电话</label> <input class="form-control" placeholder="电话"
                                    name="user.telephone" id="user.telephone" type="text">
                            </div>
                    </fieldset>
                    <div>
                        <button class="btn btn-info"
                            onclick="return confirm('您确认添加用户该用户吗？')">
                            <i class="glyphicon glyphicon-refresh"></i> 添加用户
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>