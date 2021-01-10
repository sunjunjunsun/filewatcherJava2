<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link type="text/css" rel="stylesheet" href="test/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="skin/jedate.css">
   
<script type="text/javascript" src="js/jedate.js"></script>

</head>
<body>
<form action="hello" method="post" >

&nbsp;线别：&nbsp;<select class="easyui-combobox" id="s_sex" name="testerName" editable="false" panelHeight="auto">
			<option value="V810-8086S2">P12</option>
			<option value="V810-3325S2EX">Q12</option>
			<option value="V810-8088S2">R12</option>
		</select>

		
		
    <label class="jelabel">开始时间 :</label>
    <div class="jeinpbox">
        <input type="text" class="jeinput" id="testico" placeholder="YYYY-MM-DD" name="bbirthday" />
        <div class="icons jebtns" onclick="jeDate('#testico',{trigger:false,format: 'YYYY-MM-DD hh:mm:ss'})"></div>
    </div>
     <label class="jelabel">结束时间 :</label>
    <div class="jeinpbox">
        <input type="text" class="jeinput" id="testico1" placeholder="YYYY-MM-DD" name="ebirthday" />
        <div class="icons jebtns" onclick="jeDate('#testico1',{trigger:false,format: 'YYYY-MM-DD hh:mm:ss'})"></div>
    </div>
		
		
		
		
		机种:
		
		     <select class="easyui-combobox" id="s_sex" name="boardType" editable="false" panelHeight="auto">
               <c:forEach items="${list2}" var="s">
                    <option value="${s}" selected>${s}</option>
               </c:forEach>
            </select>

<!--         Fail Or Pass :
          
<select class="easyui-combobox" id="s_sex" name="testStatus" editable="false" panelHeight="auto">
			<option value="Repaired">Fail</option>
			<option value="Reviewed Passed">Pass</option>
		</select>
 -->
    <input type="hidden" name="testStatus" value="Repaired" />
    
    
    <input type="submit" value="提交" />

</form>
<hr/>
<br/>
机种名称不输入的时候，默认查询的是整条线的良率，
<a href="${pageContext.request.contextPath}/" style="color:blue;text-decoration: underline;">整条线的良率</a>
<br/>
<hr/>
点击这儿，查询对应的机种和线别的良率;
<a href="index" style="color:blue;text-decoration: underline;">带有机种</a>















    <script type="text/javascript">
  

    jeDate("#testico",{
        isinitVal:true,
        festival: true,
        skinCell:"jedateblue",                      //日期风格样式，默认蓝色
        format:"YYYY-MM-DD hh:mm:ss"
    });
    
    jeDate("#testico1",{
        isinitVal:true,
        festival: true,
        skinCell:"jedateblue",                      //日期风格样式，默认蓝色
        format:"YYYY-MM-DD hh:mm:ss"
    });
    
    
    </script>
</body>
</html>