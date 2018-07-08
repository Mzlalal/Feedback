<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>修改密码</title>
    	<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    	<link href="resource/css/styles.css" rel="stylesheet">
    	<link href="resource/css/forms.css" rel="stylesheet">
    	<script type="text/javascript">
    		 function check()
				 {
				   var value1=document.getElementById("input1").value;
				   var value2=document.getElementById("input2").value;
				   if(value1!=value2)
				   {
				    document.getElementById('see').innerText="两次密码不一致，请重输。";
				    document.getElementById("input1").value="";
				    document.getElementById("input2").value="";
				    document.getElementById("input1").focus();
				    return false;
				   }
				   return true;
				 }
				
    	</script>
</head>
<body>
        <div class="col-md-6">
            <div class="content-box-large">
                <div class="panel-heading">
                    <div class="panel-title">修改密码</div>
                    <div class="panel-options">
                        <a href="#" data-rel="collapse"><i
                            class="glyphicon glyphicon-refresh"></i></a>
                    </div>
                </div>
                <div class="panel-body">
                    <form action="userAction_updatePwding">
                        <fieldset>
                             <input type="hidden" value="${userId }" name="uId">
                            <div class="form-group">
                                <label>请输入旧密码</label> <input class="form-control"
                                    placeholder="请输入旧密码" type="password" name="pwd" id="pwd1" >
                            </div>
                            <div class="form-group">
                                <label>请输入新密码</label> <input class="form-control"
                                    placeholder="请输入新密码" type="password" name="input1" id="input1">
                            </div>
                            <div class="form-group">
                                <label>重复输入新密码</label> <input class="form-control"
                                    placeholder="重复输入新密码" type="password" name="input2" id="input2" onBlur="check()">
                            </div>
                            <div  id="see" name="see"></div>
                        </fieldset>
                        <div>
                            <button class="btn btn-info" onclick="return confirm('您确认修改该用户吗?')" type="submit">
                                <i class="glyphicon glyphicon-refresh"></i> 修改用户
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>