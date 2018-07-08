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
</head>
<body>
    <div class="col-md-6">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">${param.type==1?'添加':'修改' }班级</div>
                <div class="panel-options">
                    <a href="#" data-rel="collapse"><i
                        class="glyphicon glyphicon-refresh"></i></a>
                </div>
            </div>
            <div class="panel-body">
                <form action="classAction_update?type=${param.type}" method="post">
                    <fieldset>
                       <div class="form-group">
                            <label>班级ID</label> 
                            <input class="form-control" placeholder="班级ID" type="text" name="classes.classId" value="${requestScope.classes.classId }" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>班级名</label> 
                            <input class="form-control" placeholder="班级名" type="text" name="classes.className" value="${requestScope.classes.className }">
                        </div>

                        <div class="form-group">
                            <label>开班日期</label>
                            <p>
                             <input class="form-control" placeholder="开班日期"  type="date" name="classes.createDate" 
                             value='<fmt:formatDate value="${requestScope.classes.createDate }" pattern="yyyy-MM-dd" />'/>
                            </p>
                        </div>
                        <div class="form-group">
                            <label>班级状态</label>
                            <p>
                            <select class="form-control" name="classes.status" >
                                     <option value="1" selected>正常</option>
                                     <option value="0" ${requestScope.classes.status==0?'selected':'' }>注销</option>
                                     <option value="2" ${requestScope.classes.status==2?'selected':'' }>已毕业</option>
                             </select>
                            </p>
                        </div>
                        <div class="form-group">
                            <label>辅导员</label>
                            <p>
                            <select class="form-control" name="classes.users.userId" id="classes.users.userId">
                                    <c:forEach var="counselor" items="${counselors}">
                                        <option value="${counselor.userId}" 
                                        <c:if test="${requestScope.classes.users.userId==counselor.userId}"> selected="selected"</c:if>>${counselor.name}</option>
                                    </c:forEach>
                            </select>
                            </p>
                        </div>
                        <div class="form-group">
                            <label>基地名 </label>
                            <p>
                            <select class="form-control" name="classes.teachingBase.baseId" id="classes.teachingBase.baseId">
                                    <c:forEach var="base" items="${bases}">
                                        <option value="${base.baseId}"
                                        <c:if test="${requestScope.classes.teachingBase.baseId==base.baseId}"> selected="selected"</c:if>>${base.baseName}</option>
                                    </c:forEach>
                            </select>
                            </p>
                        </div>
                    </fieldset>
                    <div>
                        <button class="btn btn-info"
                            onclick="return confirm('您确认${param.type==1?'添加':'修改' }该班级吗？')">
                            <i class="glyphicon glyphicon-refresh"></i> ${param.type==1?'添加':'修改' }班级
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>

</body>
</html>