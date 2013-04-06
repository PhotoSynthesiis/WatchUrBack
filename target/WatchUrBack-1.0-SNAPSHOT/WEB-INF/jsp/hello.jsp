<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<html>
<head>
    <title>Spring Ajax Demo</title>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.6.1.min.js"></script>
    <%--<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>--%>

    <script type="text/javascript">
        function doAjax() {
            $.ajax({
                url: 'time',
                data: ({
                    name: "Vidya Sagar"
                }),
                success: function (data) {
                    $('#time').html(data);
                }
            });
        }
    </script>
</head>
<body>
${message}
<button id="demo" onclick="doAjax()" title="Button">Get the
    time!
</button>
<div id="time"></div>
</body>
</html>