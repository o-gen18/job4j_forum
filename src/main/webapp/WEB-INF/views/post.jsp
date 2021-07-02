<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Post</title>
</head>
<body>
<div class="container-fluid">
    <div class="card mx-auto" style="width: 70%">
        <div class="card-body">
            <h5 class="card-title">${post.name}</h5>
            <h6 class="card-subtitle mb-2 text-muted">By: ${post.author.username}</h6>
            <p class="card-text">${post.desc}</p>
            <p class="card-text"><small class="text-muted">Posted: ${post.created.time}</small></p>
            <hr/>
            <table class="table">
                <thead>
                <th scope="rowgroup">Comments: </th>
                </thead>
                <tbody>
                <c:forEach items="${comments}" var="comment">
                    <tr class="table-secondary">
                        <td>
                            <p class="card-text">${comment.text}</p>
                            <p class="mb-2 text-muted"><small>left by: ${comment.author.username} - date: ${comment.created.time}</small></p>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="#" class="btn btn-outline-warning">leave a comment</a>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

</body>
</html>
