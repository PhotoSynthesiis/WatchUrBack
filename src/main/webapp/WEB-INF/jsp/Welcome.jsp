<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Watch Your Back</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/WatchUrBack/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="../../WatchUrBack/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" media="screen">
    <script src="../../WatchUrBack/bootstrap/js/bootstrap.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        function searchPeople(input) {
            $.ajax({
                        url: 'searchPeople',
                        data: ({
                            keyword: input
                        }),
                        success: function (data) {
                            var arrs = data.split(',');
                            for (var i = 0; i < arrs.length; i++) {
                                var link = $('<a href="handleIndividual?name=' + arrs[i] + '" id="' +
                                        arrs[i] + '_link"><div class="btnText">' + arrs[i] + '</div></a>');
                                $('body').append(link);
                            }
                        }
                    }
            )
        }
    </script>
</head>
<body>
<div class="hero-unit">
    <h1>Watch Your Back</h1>
    <blockquote>
        <p>The difference between the right word and the almost right word is the difference between lightning and a
            lightning bug</p>
        <small><cite title="Source Title">Mark Twain</cite></small>
    </blockquote>
</div>


Welcome : ${username}<br>

DEV RANKS :<br>
<table>
    <c:forEach items="${devList}" var="dev">
        <tr>
            <td>${dev.name} : ${dev.score}</td>
        </tr>
    </c:forEach>
</table>

----------------------------------------------------------------<br>


QA RANKS :<br>
<table>
    <c:forEach items="${qaList}" var="dev">
        <tr>
            <td>${dev.name} : ${dev.score}</td>
        </tr>
    </c:forEach>
</table>

<label>
    Search People : <input type="text" onkeyup="searchPeople(this.value)">
</label>
</body>
</html>