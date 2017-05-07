<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Combo Bar-Line Chart</title>
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
    <div style="width: 75%">
        <canvas id="canvas"></canvas>
    </div>
    <%--<button id="randomizeData">Randomize Data</button>--%>
    <script>
        var chartData = {
            labels: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
            datasets: [{
                type: 'bar',
                label: '${gname}',
                backgroundColor: window.chartColors.blue,
                data: [
                    ${number[0]},
                    ${number[1]},
                    ${number[2]},
                    ${number[3]},
                    ${number[4]},
                    ${number[5]},
                    ${number[6]},
                    ${number[7]},
                    ${number[8]},
                    ${number[9]},
                    ${number[10]},
                    ${number[11]}
                ],
                borderColor: 'white',
                borderWidth: 2
            }]
        };
        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myMixedChart = new Chart(ctx, {
                type: 'bar',
                data: chartData,
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '数据统计'
                    },
                    tooltips: {
                        mode: 'index',
                        intersect: true
                    }
                }
            });
        };

//        document.getElementById('randomizeData').addEventListener('click', function() {
//            chartData.datasets.forEach(function(dataset) {
//                dataset.data = dataset.data.map(function() {
//                    return randomScalingFactor();
//                });
//            });
//            window.myMixedChart.update();
//        });
    </script>
</body>

</html>
