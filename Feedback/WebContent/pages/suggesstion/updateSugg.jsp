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
      <div class="panel-title">修改个人建议</div>
      <div class="panel-options">
        <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
      </div>
    </div>
    <div class="panel-body">
      <form method="post" action="feedbackConAction_update">
        <fieldset>
        <div class="form-group">
            <label>个人建议ID </label>
            <p>
            	<input class="form-control" name="suggestion.sugId" value="${param.sId }" readonly>
            </p>
          </div>
          <div class="form-group">
            <label>反馈批次ID </label>
            <p>
            	<input class="form-control" name="suggestion.feedback.feedbackId" value="${param.fId }" readonly>
            </p>
          </div>
          <div class="form-group">
            <label>学生ID</label>
            <p>
                <input class="form-control" name="suggestion.usersByStudentId.userId" value="${param.stId }" readonly>
            </p>
          </div>
          <div class="form-group">
            <label>老师ID<s:property value="#idcard"/></label>
            <p>
            <input class="form-control" name="suggestion.usersByTeacherId.userId" value="${param.tId }" readonly>
            </p>
          </div>
          <div class="form-group">
            <label>建议内容</label><br/>
            <textarea rows="5" cols="40" placeholder="${param.sug }"  name="suggestion.sugContent"></textarea>
          </div>
          <div>
          <button class="btn btn-info" onclick="return confirm('您确认修改个人建议吗？')"><i class="glyphicon glyphicon-refresh"></i>确认修改</button>
        </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>