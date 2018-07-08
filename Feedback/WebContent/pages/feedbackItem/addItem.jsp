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
				<div class="panel-title">添加反馈条目</div>
				<div class="panel-options">
					<a href="#" data-rel="collapse"><i
						class="glyphicon glyphicon-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<form action="itemAction_save" method="post">
					<fieldset>
					   <div class="form-group">
                            <label>反馈条目ID</label> 
                            <input class="form-control" placeholder="反馈条目ID" type="text" name="feedbackItem.fiId" >
                        </div>
						<div class="form-group">
							<label>反馈条目名</label> 
							<input class="form-control" placeholder="反馈条目名" type="text" name="feedbackItem.fiName" >
						</div>
						<div class="form-group">
                            <label>反馈条目分值</label> 
                            <input class="form-control" placeholder="反馈条目分值" type="text" name="feedbackItem.itemValue" >
                        </div>

						<div class="form-group">
							<label>反馈类别</label>
							<p>
	                         <select class="form-control" name="feedbackItem.feedbackItemType.fitId" value="">
	                                 <option value="1" ${requestScope.feedbackItem.feedbackItemType.fitId==1?'selected':'' }>理论授课</option>
	                                 <option value="2" ${requestScope.feedbackItem.feedbackItemType.fitId==2?'selected':'' }>上级实践</option>
	                         </select>
							</p>
						</div>
					</fieldset>
					<div>
						<button class="btn btn-info"
							onclick="return confirm('您确认修改该反馈条目吗？')">
							<i class="glyphicon glyphicon-refresh"></i> ${param.type==1?'添加':'修改' }反馈条目
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>

</body>
</html>