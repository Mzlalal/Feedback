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
	<div class="col-md-6">
		<div class="content-box-large">
			<div class="panel-heading">
				<div class="panel-title">修改用户</div>
				<div class="panel-options">
					<a href="#" data-rel="collapse"><i
						class="glyphicon glyphicon-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<form method="post" action="userAction_update">
					<fieldset>
						<div class="form-group">
							<label>用户ID(*)</label> <input class="form-control"
								placeholder="用户ID" type="text" id="user.userId" name="user.userId" value="${requestScope.user.userId}"
							    readonly="readonly">
						</div>
						<div class="form-group">
							<label>登录名(*)<span style="color:red;">${msg1 }</span></label> <input class="form-control"
								placeholder="用户登陆名" name="user.loginName" id="user.loginName"
								type="text" value="${requestScope.user.loginName}">
						</div>
						<div class="form-group">
							<label>密码(*)<span style="color:red;">${msg2 }</span></label> <input class="form-control"
								placeholder="用户密码" name="user.password" id="user.password"
								type="password" value="${requestScope.user.password}">
						</div>
						<div class="form-group">
							<label>用户名</label> <input class="form-control" placeholder="用户名"
								name="user.name" id="user.name" type="text"
								value="${requestScope.user.name}">
						</div>
						<div class="form-group">
							<label>身份证</label> <input class="form-control" placeholder="身份证"
								name="user.idcard" id="user.idcard" type="text"
								value="${requestScope.user.idcard}">
						</div>
						<div class="form-group">
							<label>出生日期</label> <input class="form-control"
								placeholder="出生日期" name="user.birthday" id="user.birthday"
								type="date" value='<fmt:formatDate value="${requestScope.user.birthday }" pattern="yyyy-MM-dd" />'>
						</div>
						<div class="form-group">
							<label>用户性别</label>
							<p>
								<select class="form-control" name="user.sex" id="user.sex">
									<option value="男" ${requestScope.user.sex=='男'?'selected':'' }>男</option>
									<option value="女" ${requestScope.user.sex=='女'?'selected':'' }>女</option>
								</select>
							</p>
						</div>
						<div class="form-group">
							<label>用户角色</label>
							<p>
								<select class="form-control" name="user.role.roleId"
									id="user.role.roleId">
									<c:forEach var="role" items="${roles}">
										<option value="${role.roleId}"
											<c:if test="${requestScope.user.role.roleId==role.roleId}"> selected="selected"</c:if>>${role.roleName}</option>
									</c:forEach>
								</select>
							</p>
						</div>
						<div class="form-group">
							<label>用户类别</label>
							<p>
								<select class="form-control" name="user.userType"
									id="user.userType">
									<option value="1"
										${requestScope.user.userType==1?'selected':'' }>教师</option>
									<option value="2"
										${requestScope.user.userType==2?'selected':'' }>学生</option>
								</select>
							</p>
						</div>
						<div class="form-group">
							<label>部门</label>
							<p>
								<select class="form-control" name="user.department.deptId"
									id="user.department.deptId">
									<c:forEach var="d" items="${departments}">
										<option value="${d.deptId}"
											<c:if test="${param.deptId==d.deptId}"> selected="selected"</c:if>>${d.deptName}</option>
									</c:forEach>
								</select>
							</p>
						</div>
						<div class="form-group">
							<label>班级</label>
							<p>
								<select class="form-control" name="user.classes.classId">
									<c:forEach var="c" items="${classes}">
										<option value="${c.classId}"
											<c:if test="${param.classId==c.classId}"> selected="selected"</c:if>>${c.className}</option>
									</c:forEach>
								</select>
							</p>
						</div>
						<div class="form-group">
                                <label>电话</label> <input class="form-control" placeholder="电话"
                                    name="user.telephone" id="user.telephone" type="text"
                                    value="${requestScope.user.telephone}" />
                        </div>
						
					</fieldset>
					<div>
						<button class="btn btn-info"
							onclick="return confirm('您确认修改用户该用户吗？')">
							<i class="glyphicon glyphicon-refresh"></i> 修改用户
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>