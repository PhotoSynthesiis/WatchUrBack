<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Year', 'Sales', 'Expenses'],
                ['2004',  1000,      400],
                ['2005',  1170,      460],
                ['2006',  660,       1120],
                ['2007',  1030,      540]
            ]);
            var options = {
                title: 'Company Performance',
                hAxis: {title: 'Year',  titleTextStyle: {color: 'red'}}
            };

            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }

        function searchPeople(input) {
            $.ajax({
                        url: 'searchPeople',
                        data: ({
                            keyword: input
                        }),
                        success: function (data) {
                            alert(data);
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
<div id="chart_div" style="width: 900px; height: 500px;"></div>
Search People : <label>
    <input type="text" onkeyup="searchPeople(this.value)">
</label>

${first} ${second} ${third} ${fourth}
</body>
</html>