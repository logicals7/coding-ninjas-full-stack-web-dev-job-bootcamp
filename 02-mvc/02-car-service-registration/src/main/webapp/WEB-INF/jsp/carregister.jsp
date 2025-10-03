<%@ page contentType="text/html;charset=UTF-8" language="java" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       <html>
       <head>
           <title>Signup Page</title>
       </head>
       <body>
           <h1>This is the signup page</h1>
           <%-- Use Spring's form tag library to bind to the "car" object in the model --%>
               <form:form action="done" method="post" modelAttribute="car">
               <label for="registrationNumber">Car Number:</label>
               <form:input path="registerationNumber" id="registrationNumber"/><br/><br/>

               <label for="carName">Car Name:</label>
               <form:select path="CarName" id="carName">
                   <form:option value="Seltos" label="Seltos"/>
                   <form:option value="Sonet" label="Sonet"/>
               </form:select><br/><br/>

               <label for="carDetails">Covered In Warranty:</label>
               <form:select path="CarDetails" id="carDetails">
                   <form:option value="YES" label="YES"/>
                   <form:option value="NO" label="NO"/>
               </form:select><br/><br/>

               <label for="carWork">Any remarks :</label>
               <form:input path="CarWork" id="carWork"/><br/><br/>

               <input type="submit" value="Submit"/>
           </form:form>



       </body>
       </html>