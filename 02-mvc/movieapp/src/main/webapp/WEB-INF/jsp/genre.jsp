<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>

    <h1>Select genre:</h1>

    <%
        // 1. Retrieve the attributes from the Model (which become request attributes in the JSP)
        // Note: The 'genres' attribute is a List<String>, not a Map.
        List<String> genres = (List<String>) request.getAttribute("genres");
        String userId = (String) request.getAttribute("userId");
        String userName = (String) request.getAttribute("userName");
    %>

    <form:form action="recommend">

        <input type="hidden" name="id" value="<%= userId %>"/>
        <input type="hidden" name="name" value="<%= userName %>"/>

        <label for="genre">Genre: </label>
        <select name="genre">
            <%
                for (String genreName : genres) {
            %>
            <option value="<%= genreName %>">
                <%= genreName %>
            </option>
            <%
                }
            %>
        </select>

        <input type="submit" value="Get Recommendations"/>
    </form:form>

</html>