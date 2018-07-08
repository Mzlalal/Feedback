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

</script>
</head>
<body>

    <div class="col-md-10">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">查询班级课程</div>
                <form action="ccAction_queryByCond">
                <div class="col-md-3">
                    <select class="form-control" name="condName" id="condName" >
                        <option value="ccId" ${condName == 'ccId'?'selected':''  }>班级课程ID</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <input class="form-control" placeholder="查询条件" type="text" name="condValue" >
                </div>
                <div class="col-md-2">
                <button class="btn btn-primary" onclick="submit();">
                    <i class="glyphicon glyphicon-zoom-in"></i> 查询
                </button>
                </div>
                
                <c:if test="${condValue != null && condValue != '' }">
                <div class="col-md-2">
                    <a class="btn btn-success" href="ccAction_insert?type=2&id=${cc[11] }">
                        <i class="glyphicon glyphicon-zoom-out"></i> 修改
                    </a>
                </div>
                </c:if>
                
                </form>
            </div>
            <div class="panel-body">
                    <fieldset>
                       <div class="form-group">
                            <label>班级课程ID <span style="color:red;">${msg }</span></label> 
                            <input class="form-control" placeholder="班级课程ID" type="text" value="${requestScope.cc[11] }" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>班级名</label> 
                            <input class="form-control" placeholder="班级名" type="text"  
                             value="${request.cc[1] }"
                             readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>辅导员</label> 
                            <input class="form-control" placeholder="辅导员" type="text"  
                           value="${request.cc[2] }"
                            readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>课程名</label> 
                            <input class="form-control" placeholder="课程名" type="text"  value="${request.cc[4] }" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>课程类型</label> 
                            <input class="form-control" placeholder="课程类型" type="text"   value="${requestScope.cc[6]}" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>教师名</label> 
                            <input class="form-control" placeholder="教师名" type="text" value="${request.cc[7] }" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>学年</label> 
                            <input class="form-control" placeholder="学年" type="text"  value="${request.cc[8] }" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>学期</label> 
                            <input class="form-control" placeholder="学期" type="text"  value="${request.cc[9] }" readonly="readonly">
                        </div>

                    </fieldset>
                </form>
            </div>
        </div>
    </div>

</body>
</html>