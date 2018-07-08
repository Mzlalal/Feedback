<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改用户</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script src="js/jquery-3.2.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
</head>

<body>
<!-- 导入头部 -->
<s:include value="navigation.jsp"></s:include>
<!-- 导入左侧导航栏 -->
<s:include value="leftNavigation.jsp"></s:include>


	<div class="col-md-6">
  <div class="content-box-large">
    <div class="panel-heading">
      <div class="panel-title">权限修改</div>

      <div class="panel-options">
        <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
      </div>
    </div>
    <div class="panel-body">
      <form class="form-horizontal" role="form">
      	<!-- 可读不可写 -->
      	<div class="form-group">
          <label class="col-sm-2 control-label">权限ID</label>
          <div class="col-sm-10">
            <span class="form-control">权限ID</span>
          </div>
        </div>
        
        <!-- 单行文本框 -->
        <div class="form-group">
          <label for="text-field" class="col-sm-2 control-label">权限名</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="text" placeholder="权限名">
          </div>
        </div>
        
        <!-- 单行文本框 -->
        <div class="form-group">
          <label for="text-field" class="col-sm-2 control-label">权限地址</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="text" placeholder="权限地址">
          </div>
        </div>
        
        <!-- 文本域 -->
        <div class="form-group">
          <label class="col-sm-2 control-label">权限描述</label>
          <div class="col-sm-10">
            <textarea class="form-control" placeholder="权限描述" rows="3"></textarea>
          </div>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">提交</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>