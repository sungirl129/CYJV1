function show(id,_this) {
    var arr = $('.collapse');
    $.each(arr,function (i,item) {
        console.log(i);
        $(item).collapse('hide'); 
    });
    $(id).collapse('show');
    var pre = $('.myPre');
    $.each(pre,function (i,item) {
        $(item).removeClass('active');
    });
    $($(_this).parent()).addClass('active');
}