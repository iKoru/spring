<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- 
	EL(Expression Language)�̶�?
	session�̳� request ���� ��ü�� ��ϵ� �����͸� JSP ȭ�鿡 ����ϱ� ���� ǥ����
	
	JSTL(JSP Standard Tag Library)�̶�?
	if, for, switch ��� ���� �ڹ� �ڵ带 JSP ���Ͽ��� ��ü�ϴ� ǥ�� �±� 
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main title</title>
</head>
<body>
<center>
<h1>main title</h1>
<h3><font color="green">test</font>welcome......
<a href="logout.do">Log-out</a></h3>

<!-- �˻� ���� -->
<form action="getBoardList.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<option value="TITLE">title
			<option value="CONTENT">content
			</select>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="submit"/>
		</td>
	</tr>
	</table>
</form>
<!-- �˻� ���� -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">seq</th>
	<th bgcolor="orange" width="200">title</th>
	<th bgcolor="orange" width="150">writer</th>
	<th bgcolor="orange" width="150">regDate</th>
	<th bgcolor="orange" width="100">cnt</th>
</tr>

<c:forEach var="board" items="${boardList }">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
	<td>${board.writer }</td>
	<td><f:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>

</table>
<br>
<a href="insertBoard.jsp">insert new posting</a>
</center>
</body>
</html>



