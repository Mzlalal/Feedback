<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resource/js/jquery-3.2.1.js"></script>
<link href="resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
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
				<div class="panel-title">${param.type==1?'添加':'修改' }课程</div>
				<div class="panel-options">
					<a href="#" data-rel="collapse"><i
						class="glyphicon glyphicon-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<form action="courseAction_update?type=${param.type}" method="post">
					<fieldset>
					   <div class="form-group">
                            <label>课程ID</label> 
                            <input class="form-control" placeholder="课程ID" type="text" name="course.courseId" value="${requestScope.course.courseId }" readonly="readonly">
                        </div>
						<div class="form-group">
							<label>课程名</label> 
							<input class="form-control" placeholder="课程名" type="text" name="course.courseName" value="${requestScope.course.courseName }">
						</div>

						<div class="form-group">
							<label>课程类型</label>
							<p>
	                         <select class="form-control" name="course.courseType" value="">
	                                 <option value="1" ${requestScope.course.courseType==1?'selected':'' }>纯理论授课</option>
	                                 <option value="2" ${requestScope.course.courseType==2?'selected':'' }>理论加上机</option>
	                                 <option value="3" ${requestScope.course.courseType==3?'selected':'' }>纯上机实践</option>
	                         </select>
							</p>
						</div>
					</fieldset>
					<div>
						<button class="btn btn-info"
							onclick="return confirm('您确认${param.type==1?'添加':'修改' }该课程吗？')">
							<i class="glyphicon glyphicon-refresh"></i> ${param.type==1?'添加':'修改' }课程
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>

</body>
</html>