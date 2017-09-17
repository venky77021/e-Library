<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
</head>
<body>
	<%@ include file="LogOutHeader.jsp"%>
	
	<form action="uploadFile" method="post" enctype="multipart/form-data">
		Select File to Upload : <input type="file" name="fileName" /><br/> <input
			type="submit" value="Upload">
	</form>

	<c:forEach items="${files}" var="file">
		<tr>
			<a href="${file}">${file}</a>
		</tr>
	</c:forEach>

</body>
</html>