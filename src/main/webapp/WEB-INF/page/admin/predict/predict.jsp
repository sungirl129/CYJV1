<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/5
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>predict</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
    <canvas id="chart-area-line"></canvas>
</div>
<script>
    var chartData = {
        labels: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
        datasets: [{
            type: 'line',
            label: '采购个数',
            borderColor: window.chartColors.blue,
            borderWidth: 2,
            fill: false,
            data: [
                ${plan[0]},
                ${plan[1]},
                ${plan[2]},
                ${plan[3]},
                ${plan[4]},
                ${plan[5]},
                ${plan[6]},
                ${plan[7]},
                ${plan[8]},
                ${plan[9]},
                ${plan[10]},
                ${plan[11]}
            ],
        }]
    };

    window.onload = function() {
//        var ctx = document.getElementById("chart-area").getContext("2d");
//        window.myPie = new Chart(ctx, config);
        var ctx1 = document.getElementById("chart-area-line").getContext("2d");
        window.myMixedChart = new Chart(ctx1, {
            type: 'bar',
            data: chartData,
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: '采购预测'
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
