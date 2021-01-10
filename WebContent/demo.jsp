<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title></title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


</head>
<body>
demo

<c:forEach items="${list2}" var="s">
         <div>${s}</div>

</c:forEach>



 <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="address" id="address" class="form-control" >
               <c:forEach items="${list2}" var="s">
                    <option value="${s}" selected>${s}</option>
               </c:forEach>
            </select>
</div>




</body>
</html>