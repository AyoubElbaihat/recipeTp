<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .navbar-nav .nav-link {
        color: #1ed3a6;
    }
</style>
<header class="mb-4">
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/list-recipe"><img src="https://www.sauvageboris.fr/training/javaee/recipeEE/resources/logo/60.png" width="60"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/list-recipe">Home</a>
                    </li>

                    <c:if test="${empty sessionScope.username}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/signup">SignUp</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.username}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle show" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="true">
                                Search
                            </a>
                            <ul class="dropdown-menu " data-bs-popper="static">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/auth/add-car">By category</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/auth/add-category">By keyword</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/update">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>

