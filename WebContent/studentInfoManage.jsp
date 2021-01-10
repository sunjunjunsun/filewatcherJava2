<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body style="margin: 5px;">


	<form id="fm1" action="borderList" method="post">
	
		&nbsp;线别：&nbsp;<select class="easyui-combobox" id="s_sex" name="testerName" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="V810-8086S2">P12</option>
			<option value="V810-3325S2EX">Q12</option>
			<option value="V810-8088S2">R12</option>
		</select>
		&nbsp;测试时间：&nbsp;<input class="easyui-datebox" name="s_bbirthday" id="s_bbirthday" editable="false" size="10"/>-><input class="easyui-datebox" name="s_ebirthday" id="s_ebirthday" editable="false" size="10"/>
		&nbsp;机种名：&nbsp;
		     <select class="easyui-combobox" id="s_sex" name="boardType" editable="false" panelHeight="auto">
               <c:forEach items="${list2}" var="s">
                    <option value="${s}" selected>${s}</option>
               </c:forEach>
            </select>
		    
		<!-- <a href="javascript:searchStudent()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div> -->
	    <input type="submit" class="easyui-linkbutton" iconCls="icon-search" value="搜索" />
	</form>
</body>
</html>