<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Individual Result</title>
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages: ["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Month', 'Bugs'],
                ['Jan', ${first}],
                ['Feb', ${second}],
                ['Mar', ${third}],
                ['Apr', ${fourth}]
            ]);
            var options = {
                title: 'Company Performance',
                hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}
            };

            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages: ["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
                ['Good code', ${vote}],
                ['Bad code', ${oppose}]
            ]);

            var options = {
                title: 'Percentage of good code'
            };

            var chart = new google.visualization.PieChart(document.getElementById('chart_div2'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
name : ${name} <br>
score : ${score} <br>
<a href="home">Back to homepage</a>

<div id="chart_div" style="width: 900px; height: 500px;"></div>
<div id="chart_div2" style="width: 900px; height: 500px;"></div>

</body>
</html>