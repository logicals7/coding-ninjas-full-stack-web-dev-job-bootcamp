<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<html>

    <h1>This is the Attendent Page</h1>

    <h3>Attendent Name:</h3>
    <%= request.getAttribute("attendantName") %>

    <h3>Speciality:</h3>
    <%= request.getAttribute("speciality") %>

</html>
