<%-- 
    Document   : new
    Created on : Oct 28, 2014, 12:26:20 PM
    Author     : Sabina
--%>
<h2>Feedback form</h2>
<form action="${pageContext.request.contextPath}/feedback/" method="post">
    <p>Name: <input type="text" name="name" value="" /></p>
    <p>Email: <input type="text" name="email" value="" /></p>
    <p>Feedback type: 
        <select name="type">
            <c:forEach var="type" items="${types}">
                <option value="${type.id}">${type.name}</option>   
            </c:forEach>
        </select></p>
    <p>Specific feedback:</p> 
    <p><textarea name="comment" rows="4" cols="20"></textarea></p>
    <p>On a scale of 1 to 5, how much did this affect your usage of the site?</p> 
    <p>1 = No effect. 5 = Could not use site at all.</p>
    <p><table border="0" table-layout="fixed">
        <thead>
            <tr>
                <th style="width: 40px">1</th>
                <th style="width: 40px">2</th>
                <th style="width: 40px">3</th>
                <th style="width: 40px">4</th>
                <th style="width: 40px">5</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="radio" name="scale" value="1" /></td>
                <td><input type="radio" name="scale" value="2" /></td>
                <td><input type="radio" name="scale" value="3" /></td>
                <td><input type="radio" name="scale" value="4" /></td>
                <td><input type="radio" name="scale" value="5" /></td>
            </tr>
        </tbody>
    </table></p>
    <p>Any other comments, concerns, or questions?</p>
    <p> <textarea name="other" rows="4"></textarea></p>
    <input type="submit" value="Submit" />
</form>
