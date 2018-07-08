<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="col-md-8">
		<div class="content-box-large">
			<div class="panel-heading">
				<div class="panel-title">查询用户</div>
				<form action="userAction_queryByCond">
					<div class="col-md-3">
						<select class="form-control" name="condName" id="condName">
							<option value="userId" selected>用户ID</option>
							<option value="">……</option>
						</select>
					</div>
					<div class="col-md-4">
						<input class="form-control" placeholder="查询条件" type="text"
							name="condValue">
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" onclick="submit();">
							<i class="glyphicon glyphicon-zoom-in"></i> 查询
						</button>
					</div>
				</form>
			</div>
			<div class="panel-body">
				<form method="post" action="userAction_update">
					<fieldset>
						<div class="form-group">
							<label>用户ID(*)<span style="color: red;">${msg }</span> </label> <input
								class="form-control" placeholder="用户ID" type="text"
								id="user.userId" name="user.userId"
								value="${requestScope.user.userId}" readonly="readonly">
						</div>
						<div class="form-group">
							<label>登录名(*)</label> <input class="form-control"
								placeholder="用户登陆名" name="user.loginName" id="user.loginName"
								type="text" value="${requestScope.user.loginName}"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label>密码(*)<span style="color: red;">${msg2 }</span> </label> <input
								class="form-control" placeholder="用户密码" name="user.password"
								id="user.password" type="password"
								value="${requestScope.user.password}" readonly="readonly">
						</div>
						<div class="form-group">
							<label>用户名</label> <input class="form-control" placeholder="用户名"
								name="user.name" id="user.name" type="text"
								value="${requestScope.user.name}" readonly="readonly">
						</div>
						<div class="form-group">
							<label>身份证</label> <input class="form-control" placeholder="身份证"
								name="user.idcard" id="user.idcard" type="text"
								value="${requestScope.user.idcard}" readonly="readonly">
						</div>
						<div class="form-group">
							<label>出生日期</label> <input class="form-control"
								placeholder="出生日期" name="user.birthday" id="user.birthday"
								
								type="date" value='<fmt:formatDate value="${requestScope.user.birthday }" pattern="yyyy-MM-dd" />'>
						</div>
						<div class="form-group">
							<label>用户性别</label> <input class="form-control" placeholder="用户性别"
								name="user.idcard" id="user.idcard" type="text"
								value="${requestScope.user.sex=='男'?'男':'女' }"
								readonly="readonly">
							<p></p>
						</div>
						<div class="form-group">
							<label>用户角色</label> <input class="form-control"
								placeholder="用户角色" type="text"
								<c:forEach var="role" items="${roles}">
								<c:if test="${requestScope.user.role.roleId==role.roleId}">
										value="${role.roleName}" 
								</c:if>
							</c:forEach>
								readonly="readonly">
						</div>
						<div class="form-group">
							<label>用户类别</label> <input class="form-control"
								placeholder="用户类别" name="user.idcard" id="user.idcard"
								type="text"
								value="${requestScope.user.userType==1?'教师':'学生' }"
								readonly="readonly">

						</div>
						<div class="form-group">
							<label>部门</label> <input class="form-control" placeholder="部门"
								type="text"
								<c:forEach var="d" items="${requestScope.departments}">
								<c:if test="${requestScope.user.department.deptId == d.deptId}">
										value="${d.deptName}" 
								</c:if>
							</c:forEach>
								readonly="readonly">

						</div>
						<div class="form-group">
							<label>班级</label> <input class="form-control" placeholder="班级"
								type="text"
								<c:forEach var="c" items="${requestScope.classes}">
								<c:if test="${requestScope.user.classes.classId == c.classId}"> 
										value="${c.className }" 
								</c:if>
								</c:forEach>
								readonly="readonly">
						</div>
						<div class="form-group">
                                <label>电话</label> <input class="form-control" placeholder="电话"
                                    name="user.telephone" id="user.telephone" type="text"
                                    value="${requestScope.user.telephone}" readonly="readonly"/>
                        </div>
					</fieldset>

				</form>
			</div>
		</div>
	</div>

</body>
</html>