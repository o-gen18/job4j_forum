<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Forum</title>
</head>
<body>
<div class="container mt-3">
    <div class="header">
        <h4>Forum job4j</h4>
        <span style="font-size: 150%; color: blue">Logged in as : ${user.username}</span>
        <a class="btn btn-outline-dark" href="<c:url value='/logout'/>" style="float: right; display: inline">Log out</a>
    </div>
    <div class="row">
        <table class="table" style="table-layout: fixed">
            <thead>
            <tr>
                <th scope="col">Topic</th>
                <th scope="col">Created</th>
                <th scope="col">Author</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td><a title="press to look through" href="<c:url value='/post?id=${post.id}'/>" style="text-decoration: none"><c:out value="${post.name}"/></a></td>
                    <td style="width:150px; overflow: auto"><c:out value="${post.created.time}"/></td>
                    <td><c:out value="${post.author.username}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>