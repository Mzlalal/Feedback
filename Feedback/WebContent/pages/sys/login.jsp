<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教学反馈系统</title>
<meta charset="UTF-8">
<script src="resource/js/jquery-3.2.1.js"></script>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<script src="resource/js/login.js"></script>
</head>
<script>
     //更换验证码
	function anotherImg() {
		var obj = document.getElementById("codeImg");
		obj.src = "pages/util/rand.jsp?rnd=" + Math.random();
	}
     // 跳转登陆页面
	if (top.location != self.location) {  
        top.location = self.location;  
    }  
</script>

<body class="login-bg">
	<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
					<div class="box">
						<div class="content-wrap">
							<h6>教学反馈系统</h6>
							<div class="alert"> ${msg == null ? "" : msg }</div>
							<form action="loginCheck" method="post" id="login">
								<input class="form-control" id="id" type="text"
									name="user.loginName" placeholder="登录名"> 
								<input class="form-control" id="pwd" type="password"
									name="user.password" placeholder="密码">
								<div class="vrf">
									<input style="width: 60%" class="form-control vrf_text"
										name="code" id="vrf_text" type="text" placeholder="验证码">
									<img id="codeImg" align="middle" height="36px " src="pages/util/rand.jsp"
										style="cursor:pointer;float: right;" onClick="anotherImg();" title="点击刷新" />
								</div>
							</form>
							<div class="action">
								<button class="btn btn-primary signup" href="javascript:;">登录</button>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="graybox"></div>
</body>
</html>