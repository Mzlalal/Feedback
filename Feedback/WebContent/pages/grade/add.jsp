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
<script src="resource/js/grade.js" type="text/javascript"></script>
</head>
<body>
    <div class="col-md-6">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">添加评分</div>
                <div class="panel-options">
                    <a href="#" data-rel="collapse"><i
                        class="glyphicon glyphicon-refresh"></i></a>
                </div>
            </div>
            <div class="panel-body">
                <form method="post" action="gradeAction_grade">
                    <fieldset>
                            <div class="form-group">
                                <label>批次</label>
                                <p>
                                    <select class="form-control" name="feedbackScores.feedback.feedbackName"
                                        id="feedbackScores.feedback.feedbackName">
                                         <c:forEach var="list" items="${feedbacks}">
                                         	<option value="${list[0]}">${list[1]}</option>
		                            	</c:forEach>
                                    </select>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>学生</label>
                                <p>
                                    <input type="text" class="form-control" value="${sessionScope.user.name }" readonly/>
                                </p>
                            </div>
                             <div class="form-group">
                                <label>班级</label>
                                <p>
                                    <input type="text" class="form-control" value="${sessionScope.user.classes.className }" readonly/>
                                </p>
                            </div>
                          
                            <div class="form-group">
                                <label>教师----课程</label>
                                <p>
                                <select class="form-control" name="teacherId">
                             		 <c:forEach var="classCourse" items="${classCourse }">
                                   		 <option value="${classCourse[9]}" >${classCourse[7]} + ${classCourse[4]}</option>
                                      </c:forEach>
                                </select>
                                </p>
                            </div>
                         
                    </fieldset>
                    <div>
                        <button class="btn btn-info" href="javascript:;"
                            onclick="start()">
                           		进入评分
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>