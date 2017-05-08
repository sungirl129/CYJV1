function exportExcel(_this,formId,exportURL) {
    // console.log(exportURL);
    $.ajax({
        cache: true,
        type: "POST",
        url:exportURL,
        data:$('#'+formId).serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
            console.log(request);
        },
        success: function(data) {
            // console.log(data);
            window.open(data);
        }
    });
}

function importExcel(formId,resultId,importUrl) {
    
    $.ajax({
        cache: true,
        type: "POST",
        url:importUrl,
        data: new FormData($('#'+formId)[0]),
        processData: false,
        contentType: false,
        async: false,
        error: function(request) {
            alert("Connection error");
            console.log(request);
        },
        success: function(result) {
            console.log(result);
            var status = JSON.parse(result);
            $('#'+resultId).empty();
            if(status.success){
                $('#'+resultId).append('<p>导入成功：'+status.errorMsg+'</p>');
                $('#'+resultId).append('<p>导入总数目：'+status.totalCount+'</p>');
                $('#'+resultId).append('<p>成功数目：'+status.successCount+'</p>');
                $('#'+resultId).append('<p>失败数目：'+status.failCount+'</p>');
                $('#'+resultId).append('<p>导入总数目：'+status.totalCount+'</p>');
                $('#'+resultId).append('<p>导入成功数据：'+'</p>');
                for(var index in status.batchAddList) {
                    $('#' + resultId).append('<p>'+ JSON.stringify(status.batchAddList[index]) +'</p>');
                }
                $('#'+resultId).append('<p>导入详细信息：'+'</p>');
                for(var item in status.msg) {
                    $('#' + resultId).append('<p>'+status.msg[item]+'</p>');
                }
            }else{
                $('#'+resultId).append('<p>导入出错：'+status.errorMsg+'</p>');
            }

        }
    });
}