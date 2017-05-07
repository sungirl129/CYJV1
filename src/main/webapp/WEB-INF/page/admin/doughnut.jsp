<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Doughnut Chart</title>
    <script src="/resources/js/Chart.bundle.js"></script>
    <script src="/resources/js/utils.js"></script>
    <style>
    canvas {
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
    }
    </style>
</head>

<body>
    <div id="canvas-holder" style="width:40%">
        <canvas id="chart-area" />
    </div>
    <script>
    var config = {
        type: 'doughnut',
        data: {
            datasets: [{
                data: [
                    ${season[0]},
                    ${season[1]},
                    ${season[2]},
                    ${season[3]},
                ],
                backgroundColor: [
                    window.chartColors.red,
                    window.chartColors.orange,
                    window.chartColors.yellow,
                    window.chartColors.green,
                ],
                label: '${gname}'
            }],
            labels: [
                "第一季度",
                "第二季度",
                "第三季度",
                "第四季度",
            ]
        },
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: '环形图'
            },
            animation: {
                animateScale: true,
                animateRotate: true
            }
        }
    };

    window.onload = function() {
        var ctx = document.getElementById("chart-area").getContext("2d");
        window.myDoughnut = new Chart(ctx, config);
    };
    </script>
</body>

</html>
