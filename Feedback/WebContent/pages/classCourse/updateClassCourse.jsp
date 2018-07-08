<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
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
<script type="text/javascript">
    $(function(){
    	 if ("${classCourse.schoolYear }"=="") { 
             var date = new Date().getFullYear();
             $("#schoolYear").val(date);
         }
        $("#btn").on('click',function(){
            if($("#schoolYear").val() != "" && $("#schoolYear").val().length>0){
                $("#form").submit();
            }else{
                alert("学年不能为空!");
            }
        })
    })
</script>
</head>
<body>
	<div class="col-md-6">
		<div class="content-box-large">
			<div class="panel-heading">
				<div class="panel-title">${param.type==null?'添加':'修改' }班级课程</div>
				<div class="panel-options">
					<a href="#" data-rel="collapse">
					<i class="glyphicon glyphicon-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<form id="form" action="ccAction_update?type=${param.type}" method="post">
					<fieldset>
					   <div class="form-group">
                            <label>班级课程ID</label> 
                            <input class="form-control" placeholder="班级课程ID" type="text" name="classCourse.ccId" value="${param.id }" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>班级名</label>
                            <p>
                             <select class="form-control" name="classCourse.classes.classId">
                                <c:forEach var="c" items="${classes }">
                                     <option value="${c.classId }" ${classCourse.classes.classId==c.classId?'selected':'' }>${c.className }</option>
                                </c:forEach>
                             </select>
                            </p>
                        </div>
						<div class="form-group">
                            <label>班级课程名</label>
                            <p>
                             <select class="form-control" name="classCourse.course.courseId">
                                <c:forEach var="course" items="${courses}">
                                     <option value="${course.courseId }" ${classCourse.course.courseId==course.courseId?'selected':'' }>${course.courseName }</option>
                                </c:forEach>
                             </select>
                            </p>
                        </div>
                        
                        <div class="form-group">
                            <label>教师</label>
                            <p>
                             <select class="form-control" name="classCourse.users.userId">
                                <c:forEach var="teacher" items="${teachers }">
                                     <option value="${teacher.userId }" ${classCourse.users.userId==teacher.userId?'selected':'' }>${teacher.name }</option>
                                </c:forEach>
                             </select>
                            </p>
                        </div>

						<div class="form-group">
							<label>学年(*)</label>
							<input class="form-control" id="schoolYear" placeholder="学年" type="text" name="classCourse.schoolYear" value="${classCourse.schoolYear }" >
						</div>
						<div class="form-group">
                            <label>学期</label>
                            <p>
                             <select class="form-control" name="classCourse.semester" >
                                     <option value="1" ${param.courseType==1?'selected':'' }>上学期</option>
                                     <option value="2" ${param.courseType==2?'selected':'' }>下学期</option>
                             </select>
                            </p>
                        </div>
					</fieldset>
					<div>
						<a href="javascript:;" id="btn" class="btn btn-info" onclick="return confirm('您确认${param.type==null?'添加':'修改' }该课程吗？')">
							<i class="glyphicon glyphicon-refresh"></i> ${param.type==null?'添加':'修改' }课程
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>

</body>
</html>