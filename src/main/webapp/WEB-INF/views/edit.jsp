<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Editing</title>
</head>
<body>
<div class="container-fluid">
    <a href="<c:url value='/'/>" class="btn btn-outline-secondary" style="position: absolute">Home page</a>
    <div class="card mx-auto border-0" style="width: 50%">
        <h2 class="h2 mx-auto" style="display: inline" align="center">
            <c:choose>
                <c:when test="${empty post}">
                    Create a post.
                </c:when>
                <c:otherwise>
                    Edit the post.
                </c:otherwise>
            </c:choose>
        </h2>
        <div class="card-body border border-primary rounded">
            <form name="create post" action="<c:url value='/save'/>" method="POST">
                <table class="table">
                    <c:if test="${not empty post}">
                        <input hidden name="id" value="<c:out value="${post.id}"/>">
                    </c:if>
                    <tr>
                        <td>Post's name: </td>
                        <td><input class="form-control" type="text" name="name" value="<c:out value='${post.name}'/>" required></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td>
                            <textarea class="form-control" name="description" required><c:out value='${post.description}'/></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input class="btn btn-outline-primary" name="submit" type="submit" value="Submit">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>
