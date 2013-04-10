<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vote or Oppose</title>
</head>
<body>
name : ${name} <br>

<form action="voteOrOppose" method="GET">
    <label>
        <select name="param">
            <option value="vote">VOTE</option>
            <option value="oppose">OPPOSE</option>
        </select>
    </label>

    <input type="submit" name="name" value="${name}"/>
</form>

<form action="getScore" method="GET">
    <input type="submit" name="name" value="${name}"/>
</form>

</body>
</html>

