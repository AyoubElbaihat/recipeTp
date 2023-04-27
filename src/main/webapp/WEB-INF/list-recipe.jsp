<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ayoub
  Date: 19/04/2023
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Recipse</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
    <h1>List Recipes</h1>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
        <c:forEach var="r" items="${recipes}">
            <div class="col">
                <div class="card">
                    <img class="bd-placeholder-img card-img-top" width="100%" height="180" src="${r.imageRecipe}" alt="${r.recipeName}">
                    <div class="card-body">
                        <h5 class="card-title">${r.recipeName}</h5>
                        <p class="card-text"> <strong>Category:</strong> ${r.category.nameCategory}</p>
                        <p class="card-text"> <strong>Difficulty:</strong> ${r.difficulty} </p>
                        <p class="card-text"> <strong>Preparation Time:</strong> ${r.preparationTime} min </p>
                        <p class="card-text"> <strong>Date of Creation:</strong>
                        <fmt:parseDate value="${r.dateCreation}" pattern="yyyy-MM-dd'T'HH:mm" var="postDate" type="date"/>
                        <fmt:formatDate pattern="dd MMMM yyyy hh:mm" value="${postDate}"/> </p>
                        <div class="mx-auto">
                            <a href="${pageContext.request.contextPath}/recipe-detail?id=${r.getId()}" class="btn btn-primary mx-auto">Details</a>
                        </div>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/js/bootstrap.min.js"></script>
</body>
</html>
