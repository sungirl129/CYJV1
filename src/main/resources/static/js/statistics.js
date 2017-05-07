/**
 * Created by zhuangqf on 4/30/17.
 */
var chart;
var config = {
    type: 'doughnut',
    options: {
        responsive: true,
        animation: {
            animateScale: true,
            animateRotate: true
        },
        title: {
            display: true,
        }
    }
};

function parseResult(resultString) {
    var result = JSON.parse(resultString);
    console.log(result);
    var newDataset = {
        backgroundColor: [],
        data: [],
        label: result.title
    };
    var newLable = [];
    var i = 0;
    for(var key in result.data){
        newDataset.data.push(result.data[key]);
        newDataset.backgroundColor.push(window.colors[i]);
        newLable.push(key);
        i++;
    }
    console.log(newDataset);
    console.log(newLable);
    var newData = {
        datasets:[newDataset],
        labels: newLable
    };
    console.log(newData);
    config.data = newData;
    config.options.title.text = result.title;
}

function query() {
    $.ajax({
        cache: true,
        type: "POST",
        url:"/admin/pieData",
        data:$('#myForm').serialize(),
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(result) {
            parseResult(result);
            if(chart==undefined) {
                chart = new Chart(window.ctx, config);
            }else {
                chart.update();
            }
        } 
    });
}