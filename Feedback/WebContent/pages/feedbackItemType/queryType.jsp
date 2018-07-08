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
                <div class="panel-title">查询反馈类别</div>
                <form action="typeAction_queryByCond">
                <div class="col-md-3">
                    <select class="form-control" name="condName" id="condName" >
                        <option value="fitId" ${condName == 'fitId'?'selected':''  }>反馈类别ID</option>
                        <option value="fitName" ${condName == 'fitName'?'selected':''  }>反馈类别名</option>
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
                    <fieldset>
                       <div class="form-group">
                            <label>反馈类别ID <span style="color:red;">${msg }</span></label> 
                            <input class="form-control" placeholder="反馈类别ID" type="text" value="${requestScope.type.fitId }" readonly="readonly">
                        </div>

                        <div class="form-group">
                            <label>反馈类别类型</label>
                            <p>
                              <input class="form-control" placeholder="反馈类别名" type="text"  value="${requestScope.type.fitName }" readonly="readonly">
                            </p>
                        </div>
                    </fieldset>
            </div>
        </div>
    </div>

</body>
</html>