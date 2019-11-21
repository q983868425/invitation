<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:import url="common.jsp"></c:import>
</head>
<body>

	<c:import url="nav.jsp"></c:import>
	<div style="margin: 0 5%">
		<form action="delete.action" method="post">
			<table class="table table-hover">
				<tr>
					<th>
						<input type="checkbox" />
					</th>
					<th>id</th>
					<th>title</th>
					<th>author</th>
					<th>createdate</th>
					<th>option</th>
				</tr>
				<c:forEach var="inv" items="${list }">
					<tr>
						<td>
							<input name="ids" type="checkbox" value="${inv.id }" />
						</td>
						<td>${inv.id }</td>
						<td>
							<a href="findById.action?id=${inv.id }">${inv.title }</a>
						</td>
						<td>${inv.author }</td>
						<td>${inv.createdate }</td>
						<td>
							<input onclick="javascript:location.href='toupdate.action?id=${inv.id }'" value="修改" type="button" />
						</td>
					</tr>
				</c:forEach>
				<tr align="center">
					<td colspan="4">
						<input onclick="javascript:location.href='toadd.action'" value="添加" type="button" />
						<input value="删除" type="submit" />
					</td>
					<td colspan="2">
						第
						<span id="page">${page}</span>
						页/共
						<span>${totalpage}</span>
						页/
						<c:if test="${page!=1}">
							<a onclick="beforepage()" style="cursor: pointer;">上一页/</a>
						</c:if>
						<c:if test="${page!=totalpage}">
							<a onclick="nextpage()" style="cursor: pointer;">下一页</a>
						</c:if>
						/跳转到
						<input id="topage" style="width: 3em">
						页
						<a onclick="topage()" style="cursor: pointer;">Go</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function nextpage() {
			var p = $("#page").text();
			var page = parseInt(p) + 1;
			window.location.href = "list.action?page=" + page;
		}
		function beforepage() {
			var p = $("#page").text();
			var page = parseInt(p) - 1;
			window.location.href = "list.action?page=" + page;
		}
		function topage() {
			var p = $("#topage").val();
			var page = parseInt(p);
			window.location.href = "list.action?page=" + page;
		}
	</script>

</body>
</html>