function exportExcel(formId,exportURL) {
    $.ajax({
        cache: true,
        type: "POST",
        url:exportURL,
        data:$('#'+formId).serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
            console.log(data);
            window.open(data);
        }
    });
}