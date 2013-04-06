<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Watch Ur Back</title>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.6.1.min.js"></script>
    <script type="text/javascript">
        function searchPeople(input) {
            $.ajax({
                url: 'searchPeople',
                data: ({
                    keyword: input
                }),
                success: function (data) {
                    $("#abc").html(data);
                }
            });
        }
    </script>
</head>
<body>
<form:form method="POST" action="/WatchUrBack/voteOrOppose">
    <span>JoJo</span>
    <input type="submit" value="vote" name="param"/>
    <input type="submit" value="oppose" name="param"/>
</form:form>

<label>
    <input type="text" onkeyup="searchPeople(this.value)">
</label>
<span id="abc"></span>
</body>
</html>