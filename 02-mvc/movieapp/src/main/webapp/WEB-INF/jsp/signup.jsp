<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <h1>User Registration:</h1>
    <form:form action="register" method="post" modelAttribute="user">

        <label for="userName">User Name: </label>
        <form:input path="userName"/> </br></br>

        <label for="email">Email: </label>
        <form:input type="email" path="email"/> </br></br>

        <label for="password">Password: </label>
        <form:password path="password"/> </br></br>

        <input type="submit" value="register"/> </br></br>
    </form:form>
</html>
