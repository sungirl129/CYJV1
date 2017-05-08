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