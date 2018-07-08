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

    <div class="col-md-8">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">查询课程</div>
                <form action="itemAction_queryByCond">
                <div class="col-md-3">
                    <select class="form-control" name="condName" id="condName" >
                        <option value="fiId" ${condName == 'fitId'?'selected':''  }>课程ID</option>
                        <option value="fiName" ${condName == 'fitName'?'selected':''  }>课程名</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <input class="form-control" placeholder="查询条件" type="text" name="condValue" >
                </div>
                <div class="col-md-2">
                <button class="btn btn-primary" onclick="submit();">
                    <i class="glyphicon glyphicon-zoom-in"></i> 查询
                </button>
                </div>
                </form>
            </div>
            <div class="panel-body">
                <form action="courseAction_update?type=${param.type}" method="post">
                    <fieldset>
                       <div class="form-group">
                            <label>反馈条目ID</label> 
                            <input class="form-control" placeholder="反馈条目ID" type="text" name="feedbackItem.fiId" value="${requestScope.feedbackItem.fiId }" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>反馈条目名</label> 
                            <input class="form-control" placeholder="反馈条目名" type="text" name="feedbackItem.fiName" value="${requestScope.feedbackItem.fiName }">
                        </div>
                        <div class="form-group">
                            <label>反馈条目分值</label> 
                            <input class="form-control" placeholder="反馈条目分值" type="text" name="feedbackItem.itemValue" value="${requestScope.feedbackItem.itemValue }">
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
                </form>
            </div>
        </div>
    </div>

</body>
</html>