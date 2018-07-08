<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左侧导航栏</title>

<script src="resource/js/jquery-3.2.1.js"></script>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<script src="resource/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/js/custom.js"></script>
</head>
<body>
<div class="col-md-2">
  <div class="sidebar content-box" style="display: block;">
    <ul class="nav">
      <!-- Main menu -->
      <li class="submenu" style="${requestScope.menu_1==''?'display:none':'' }">
        <a href="#">
          <i class="glyphicon glyphicon-list"></i> 系统信息维护
          <span class="caret pull-right"></span>
        </a><ul> ${requestScope.menu_1 }</ul>
       
      </li>
      <li class="submenu" style="${requestScope.menu_2==''?'display:none':'' }">
        <a href="#">
          <i class="glyphicon glyphicon-list"></i> 基础信息维护
          <span class="caret pull-right"></span>
        </a>
        <ul> ${requestScope.menu_2 }</ul>
      </li>
      <li class="submenu" style="${requestScope.menu_3==''?'display:none':'' }">
        <a href="#">
          <i class="glyphicon glyphicon-list"></i> 教学反馈管理
          <span class="caret pull-right"></span>
        </a>
       <ul> ${requestScope.menu_3 }</ul>
      </li>
      <li class="submenu" style="${requestScope.menu_4==''?'display:none':'' }">
        <a href="#">
          <i class="glyphicon glyphicon-list"></i> 报表管理
          <span class="caret pull-right"></span>
        </a>
        <ul> ${requestScope.menu_4 }</ul>
      </li>
      <li class="submenu">
        <a href="#">
          <i class="glyphicon glyphicon-list"></i> 我的账户
          <span class="caret pull-right"></span>
        </a>
        <ul>
          <li><a href="userAction_updatePwd?id=${user.userId }" target="main">修改密码</a></li>
          <li><a href="userAction_logout.action" onclick="return confirm('您确认退出登陆吗?');">注销</a></li>
        </ul>
      </li>
    </ul>
  </div>
</div>
</body>
</html>