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
        <canvas id="chart-area-line"></canvas>
    </div>
    <%--<button id="randomizeData">Randomize Data</button>--%>
    <script>

        var chartData = {
            labels: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
            datasets: [{
                type: 'line',
                label: '采购个数',
                backgroundColor: window.chartColors.blue,
                data: [
                    ${purchaseNumber[0]},
                    ${purchaseNumber[1]},
                    ${purchaseNumber[2]},
                    ${purchaseNumber[3]},
                    ${purchaseNumber[4]},
                    ${purchaseNumber[5]},
                    ${purchaseNumber[6]},
                    ${purchaseNumber[7]},
                    ${purchaseNumber[8]},
                    ${purchaseNumber[9]},
                    ${purchaseNumber[10]},
                    ${purchaseNumber[11]}
                ],
                borderColor: 'white',
                borderWidth: 2
            },{
                type: 'line',
                label: '完成个数',
                backgroundColor: window.chartColors.purple,
                data: [
                    ${applyNumber[0]},
                    ${applyNumber[1]},
                    ${applyNumber[2]},
                    ${applyNumber[3]},
                    ${applyNumber[4]},
                    ${applyNumber[5]},
                    ${applyNumber[6]},
                    ${applyNumber[7]},
                    ${applyNumber[8]},
                    ${applyNumber[9]},
                    ${applyNumber[10]},
                    ${applyNumber[11]}
                ],
                borderColor: 'white',
                borderWidth: 2
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
                        text: '${gname}'
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
