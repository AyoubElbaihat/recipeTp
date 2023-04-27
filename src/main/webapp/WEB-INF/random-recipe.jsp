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
    <title>Random Recipse</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<body>
<c:import url="header.jsp"></c:import>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8 offset-lg-2">
            <div class="card">
                <img src="${randomRecipe.imageRecipe}" class="card-img-top img-fluid rounded mx-auto d-block" alt="Image Description" style="max-height: 300px;">
                <div class="card-body">
                    <h5 class="card-title text-center">${randomRecipe.recipeName}</h5>
                    <p class="card-text"> <strong>Category:</strong> ${randomRecipe.category.nameCategory}</p>
                    <p class="card-text"> <strong>Ingrdient:</strong> ${randomRecipe.description}</p>
                    <p class="card-text"> <strong>Difficulty:</strong> ${randomRecipe.difficulty} </p>
                    <p class="card-text"> <strong>Preparation Time:</strong> ${randomRecipe.preparationTime} min </p>
                    <p class="card-text"> <strong>Date of Creation:</strong>
                        <fmt:parseDate value="${randomRecipe.dateCreation}" pattern="yyyy-MM-dd'T'HH:mm" var="postDate" type="date"/>
                        <fmt:formatDate pattern="dd MMMM yyyy hh:mm" value="${postDate}"/> </p>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/js/bootstrap.min.js"></script>
</body>
</html>
