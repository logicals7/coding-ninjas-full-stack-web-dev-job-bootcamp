<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<html>
    <h1>Movie Recommendations</h1>
    <%
        List<String> recommendations = (List<String>) request.getAttribute("recommendations");
        String selectedGenre = (String) request.getAttribute("selectedGenre");
        String userName = (String) request.getAttribute("userName");
        String userId = (String) request.getAttribute("userId");

        boolean foundRecommendations = (recommendations != null &&
                                        !recommendations.isEmpty() &&
                                        !recommendations.get(0).equals("No values found for key genre"));
    %>

    <h2>Recommendations for <%= userName %></h1>
    <h3>Based on your selection of: **<%= selectedGenre %>**</h2>

    <% if (foundRecommendations) { %>

        <h3>Here are your recommended movies:</h3>
        <ul>
            <%
                for (String movieTitle : recommendations) {
            %>
                    <li><%= movieTitle %></li>
            <%
                }
            %>
        </ul>
    <% } else { %>
        <p>Sorry, no movie recommendations were found for the selected genre.</p>
    <% } %>

    <hr>

    <a href="/genre?id=<%= userId %>&name=<%= userName %>">Back to Genre Selection</a>
    <a href="/welcome">Go to Home Page</a>


</body>
</html>