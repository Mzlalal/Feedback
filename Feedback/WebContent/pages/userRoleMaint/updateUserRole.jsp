<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script src="resource/js/jquery-3.2.1.js"></script>

  <link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="resource/css/styles.css" rel="stylesheet">

  <link href="resource/vendors/form-helpers/css/bootstrap-formhelpers.min.css" rel="stylesheet">
  <link href="resource/vendors/select/bootstrap-select.min.css" rel="stylesheet">

  <link href="resource/css/forms.css" rel="stylesheet">

  <script src="resource/bootstrap/js/bootstrap.min.js"></script>

  <script src="resource/vendors/form-helpers/js/bootstrap-formhelpers.min.js"></script>

  <script src="resource/vendors/select/bootstrap-select.min.js"></script>
</head>
<body>
<div class="col-md-6">
  <div class="content-box-large">
    <div class="panel-heading">
      <div class="panel-title">修改用户角色</div>
      <div class="panel-options">
        <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
      </div>
    </div>
    <div class="panel-body">
      <form method="post" action="userroleAction_update">
        <fieldset>
          <div class="form-group">
            <label>用户ID(*)</label>
            <input class="form-control" placeholder="用户ID" id="user.userId" name ="userId" type="text" value="<c:out value="${u.userId}" />" readonly="readonly">
          </div>
          <div class="form-group">
            <label>登录名(*)</label>
            <input class="form-control" placeholder="登录名" name="user.loginName" id="user.loginName" type="text" value="<c:out value="${u.loginName}" />" readonly="readonly">
          </div>
          <div class="form-group">
            <label>用户名(*)</label>
            <input class="form-control" placeholder="用户名" name="user.name" id="user.name" type="password" value="<c:out value="${u.loginName}" />" readonly="readonly">
          </div>
          <div class="form-group">
            <label>角色ID(*)</label>
            <input class="form-control" placeholder="角色ID" name="role.roleId" id="role.roleId" type="text" value="<c:out value="${r.roleId}" />" readonly="readonly">
          </div>
          <div class="form-group">
            <label>用户角色</label>
            <p>
              <select class="form-control" name="role.roleName" id="role.roleName" >
               <c:forEach var="role" items="${role}">
	                        <option  value="${role.roleId}"
	                        <c:if test="${r.roleId==role.roleId}"> selected="selected"</c:if>>
	                        ${role.roleName}
	                         </option>
	           </c:forEach>
	           </select>
            </p>
          </div>
        </fieldset>
        <div>
          <button class="btn btn-info" onclick="return confirm('您确认修改该用户角色吗？')"><i class="glyphicon glyphicon-refresh"></i> 修改用户角色</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>