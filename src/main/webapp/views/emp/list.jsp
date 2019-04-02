<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1 0001
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/commons/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/js/jquery.min.js"/>" type="text/javascript"></script>

    <script type="text/javascript">
    
    $(function () {
        alert("")
    });
    
    function query() {
        var form=$("#getForm");
        form.submit();
    }
        
    </script>
</head>
<body>
    <div>
        <form action="<%=request.getContextPath()%>/emp/getAll" method="post" id="getForm">
            姓名：<input type="text" name="S_name" value="${query.name}">
            手机号：<input type="text" name="S_phone" value="${query.phone}"><br>
            性别：<select name="S_sex">
                    <option value="-1"  selected="selected">--请选择--</option>
                    <c:if test="${query.sex==0}">
                        <option value="0" selected="selected">男</option>
                        <option value="1">女</option>
                    </c:if>
                    <c:if test="${query.sex==1}">
                        <option value="0">男</option>
                        <option value="1"  selected="selected">女</option>
                    </c:if>
                    <c:if test="${query.sex==-1}">
                        <option value="0">男</option>
                        <option value="1">女</option>
                    </c:if>
                </select>
            部门：<select name="S_depaId">
                <option value="0">--请选择--</option>
                <c:forEach items="${deparList}" var="d">
                    <c:choose>
                        <c:when test="${d.id==query.depaId}">
                            <option value="${d.id}" selected="selected"><c:out value="${d.name}"/></option>
                        </c:when>

                        <c:otherwise>
                            <option value="${d.id}"><c:out value="${d.name}"/></option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                </select>

        </form>
        <input type="button" value="查询" onclick="query()">
    </div>


    <br>
    <br>

    <div>
        <table border="1">
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>手机号</th>
                <th>部门</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${empList}" var="emp">
                <tr>
                    <th><c:out value="${emp.name}"/></th>
                    <th><c:out value="${emp.sex==0?'男':'女'}"/></th>
                    <th><c:out value="${emp.age}"/></th>
                    <th><c:out value="${emp.phone}"/></th>
                    <th><c:out value="${emp.department.name}"/></th>
                    <th>
                        <a href="">删除</a>
                        <a href="">修改</a>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>

<br>
<br>

共<c:out value="${page.totalPages}"/>页<br>
<c:if test="${!page.firstPage}">
    <a href="<%=request.getContextPath()%>/emp/getAll?page=0"><<</a>
    <a href="<%=request.getContextPath()%>/emp/getAll?page=${page.number-1}"><</a>
</c:if>
    第<c:out value="${page.number+1}"/>页
<c:if test="${!page.lastPage}">
    <a href="<%=request.getContextPath()%>/emp/getAll?page=${page.number+1}">></a>
    <a href="<%=request.getContextPath()%>/emp/getAll?page=${page.totalPages-1}">>></a>
</c:if>

</body>
</html>