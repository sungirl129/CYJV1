<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pie Chart</title>
    <script src="/resources/js/Chart.bundle.js"></script>
    <script src="/resources/js/utils.js"></script>
</head>
<body>
<div id="canvas-holder" style="width:40%">
    <canvas id="chart-area" />
</div>

    <script>
    var config = {
        type: 'pie',
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
                label: '${gname}采购'
            },{
                data: [
                    ${season1[0]},
                    ${season1[1]},
                    ${season1[2]},
                    ${season1[3]},
                ],
                backgroundColor: [
                    window.chartColors.red,
                    window.chartColors.orange,
                    window.chartColors.yellow,
                    window.chartColors.green,
                ],
                label: '${gname}完成'
            }],
            labels: [
                "第一季度",
                "第二季度",
                "第三季度",
                "第四季度",
            ]
        },
        options: {
            responsive: true
        }
    };

    window.onload = function() {
        var ctx = document.getElementById("chart-area").getContext("2d");
        window.myPie = new Chart(ctx, config);
    }
    </script>
</body>

</html>
