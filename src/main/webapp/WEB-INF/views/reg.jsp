<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Registration</title>
</head>
<body>
<div class="container-fluid">
    <div class="card mx-auto border-0" style="width: 50%">
        <h2 class="h2 mx-auto" style="display: inline" align="center">Registration form</h2>
        <div class="card-body border border-primary rounded">
            <c:if test="${not empty errorMessage}">
                <div style="color: red; font-weight: bold; margin: 30px 0;" align="center">
                        ${errorMessage}
                </div>
            </c:if>
            <form name="registration" action="<c:url value='/reg'/>" method="POST">
                <table class="table">
                    <tr>
                        <td>User's name: </td>
                        <td><input class="form-control" type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>User's email: </td>
                        <td><input class="form-control" type="email" name="email"></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input class="form-control" type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="btn btn-outline-primary" name="submit" type="submit" value="Submit"></td>
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
