<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table border="1" width="70%" align="center" cellpadding="6"
		cellspacing="2">
		<tr>
			<td>序号</td>
			<td>老师姓名</td>
			<td>老师密码</td>
		</tr>
		<c:choose>
  			<c:when test="${not empty requestScope.TeacherBean.pageData}">
				<c:forEach var="teacher" items="${requestScope.TeacherBean.pageData }"
					varStatus="vs">
					<tr>
						<td>${vs.count}</td>
						<td>${teacher.name}</td>
						<td>${teacher.password}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3">对不起，没有你要找的数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="3" align="center">
				${pageContext.request.contextPath}
				当前${requestScope.TeacherBean.currentPage}/${requestScope.TeacherBean.totalPage}页
				<a
				href="${pageContext.request.contextPath}/TeacherServlet?currentPage=1">首页</a>
				<a
				href="${pageContext.request.contextPath}/TeacherServlet?currentPage=${requestScope.TeacherBean.currentPage-1}">上一页
			</a> <a
				href="${pageContext.request.contextPath}/TeacherServlet?currentPage=${requestScope.TeacherBean.currentPage+1}">下一页
			</a> <a
				href="${pageContext.request.contextPath}/TeacherServlet?currentPage=${requestScope.TeacherBean.totalPage}">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>