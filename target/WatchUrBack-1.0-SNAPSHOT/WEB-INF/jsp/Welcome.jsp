<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Watch Ur Back</title>
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

<label>
    Search People : <input type="text" onkeyup="searchPeople(this.value)">
</label>
</body>
</html>