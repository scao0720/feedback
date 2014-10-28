<%-- 
    Document   : form
    Created on : Oct 28, 2014, 11:52:40 AM
    Author     : Sabina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback</title>
    </head>
    <body>
        <form action="" method="post">
            <p>Name: <input type="text" name="name" value="" /></p>
            <p> Email: <input type="text" name="email" value="" /></p>
            <p>Feedback type: <select name="type">
                    <option>Content</option>
                    <option>Bug Report</option>
                    <option>Comment</option>
                    <option>Other</option>
                </select></p>
            <p>Specific feedback:</p> 
            <p><textarea name="comment" rows="4" cols="20">
                </textarea></p>
            <p>On a scale of 1 to 5, how much did this affect your usage of the site?</p> 
            <p>1 = No effect. 5 = Could not use site at all.</p>
            <table border="0" cellspacing="5">
                <thead>
                    <tr>
                        <th>1</th>
                        <th>2</th>
                        <th>3</th>
                        <th>4</th>
                        <th>5</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="radio" name="scale" value="1" /> </td>
                        <td><input type="radio" name="scale" value="2" /></td>
                        <td><input type="radio" name="scale" value="3" /></td>
                        <td><input type="radio" name="scale" value="4" /></td>
                        <td><input type="radio" name="scale" value="5" /></td>
                    </tr>
                </tbody>
            </table>
            <p>Any other comments, concerns, or questions?</p>
            <p> <textarea name="other" rows="4" cols="20">
                </textarea></p>
        </form>
    </body>
</html>