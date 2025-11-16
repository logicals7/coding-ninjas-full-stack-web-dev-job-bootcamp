<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <h1>!!Create Account for Movie Recommendation!! </h1>
    <h3>Please enter your details to signup: </h3>

    <form:form action="/register" modelAttribute="user">

        <form:label path="userName">User Name:</form:label>
        <form:input path="userName" required="true"/>

        <form:label path="email">Email:</form:label>
        <form:input type="email" path="email" required="true"/>

        <form:label path="password">Password:</form:label>
        <form:password path="password" required="true"/>

        <button type="submit" class="submit-btn">Sign-up</button>

    </form:form>


</html>