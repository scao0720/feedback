<%-- 
    Document   : report
    Created on : Oct 28, 2014, 12:26:47 PM
    Author     : Sabina
--%>

<h2>Feedback report</h2>
<table border="1" class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Time</th>
            <th>Name</th>
            <th>Email</th>
            <th>Feedback Type</th>
            <th>Feedback</th>
            <th>Effect on Usage</th>
            <th>Other</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="feedback" items="${inputs}">
            <tr>    
                <td><c:out value="${feedback.id}" /></td>
                <td><fmt:formatDate value="${feedback.created}" pattern="yyyy-MM-dd"/></td>
                <td><fmt:formatDate value="${feedback.created}" pattern="HH:mm:ss"/></td>
                <td><c:out value="${feedback.name}" /></td>
                <td><c:out value="${feedback.email}" /></td>
                <td><c:out value="${feedback.typeId.name}" /></td>
                <td><c:out value="${feedback.comment}" /></td>
                <td><c:out value="${feedback.scale}" /></td>
                <td><c:out value="${feedback.other}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
