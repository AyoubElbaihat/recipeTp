<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Add Recipe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<body>
<c:import url="header.jsp"></c:import>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-sm-center h-100">
            <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
                <div class="text-center my-5">
                    <img src="https://www.sauvageboris.fr/training/javaee/recipeEE/resources/logo/100.png" alt="logo" width="100">
                </div>
                <div class="card shadow-lg">
                    <div class="card-body p-5">
                        <h1 class="fs-4 card-title fw-bold mb-4">Add recipe</h1>
                        <form action="${pageContext.request.contextPath}/auth/add-recipe" method="post">
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >recipe Name</label>
                                <input type="text" class="form-control" name="recipeName" placeholder="recipeName">
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Description</label>
                                <input type="text" class="form-control" name="description" placeholder="description">
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Url image Recipe</label>
                                <input type="text" class="form-control" name="imageRecipe" placeholder="imageRecipe">
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Difficulty</label>
                                <input type="text" class="form-control" name="difficulty" placeholder="difficulty">
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Preparation Time</label>
                                <input type="text" class="form-control" name="preparationTime" placeholder="preparationTime">
                            </div>
                            <div class="input-group mb-3">
                                <select name="idCategory" class="form-select">
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.id}">${category.nameCategory}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="d-flex align-items-center">
                                <button type="submit" class="btn btn-primary ms-auto">
                                    Submit
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<c:if test="${isError == true}">
    <p>Bad credentials.</p>
</c:if>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/js/bootstrap.min.js"></script>
</body>
</html>
