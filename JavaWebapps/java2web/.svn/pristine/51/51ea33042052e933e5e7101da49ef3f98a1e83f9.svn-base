<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ attribute name="items" required="true" type="java.util.Collection" %>
<%@ attribute name="selectUrl" required="true" %>

<form method="post" action="${selectUrl}" >
    <c:forEach items="${items}" var="item">
        <input type="radio" name="item" value="${item}"/>${item}<br/>
    </c:forEach>
    <input type="submit" name="submit" value="Koop">
</form>