<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ attribute name="basket" required="true" type="be.kdg.tagfiles.model.Mandje" %>

<c:forEach items="${basket.aankopen}" var="item">
    ${item}<br/>
</c:forEach>