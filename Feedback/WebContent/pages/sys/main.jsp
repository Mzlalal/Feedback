<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>教学反馈系统</title>
    <meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<frameset rows='120,*' frameborder='NO' border='0' framespacing='0'>
    <frame src='pages/sys/navigation.jsp' noresize='noresize' frameborder='NO' name='topFrame' scrolling='no' marginwidth='0'
           marginheight='0' target='main'/>
    <frameset cols='250,*' id='frame'>
        <frame src='getSysMenu' name='leftFrame' noresize='noresize' marginwidth='0' marginheight='0' frameborder='0'
               scrolling='auto' target='main'/>
        <frame src='pages/sys/index.jsp' name='main' marginwidth='0' marginheight='0' frameborder='0' scrolling='auto'
               target='_self'/>
    </frameset>
</frameset>
<noframes>
    <body></body>
</noframes>
</html>