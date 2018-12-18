$(function() {

    //页码
    var pageNo = $("#pageNo").text();
    //每页记录数
    var pageSize = 10;
    //总页数
    var pages = $("#pages").text();

    //初始页面加载
    window.onload = function() {
        findUserList(1,10);
    };

    //条件查找
    $('#find').click(function() {
        findUserList(pageNo,pageSize);
    });

    //调用后台
    findUserList = function(pageNo, pageSize){
        var userInfo = $("#form").serialize();
        $.post("/userInfo/list/" + pageNo + "/" + pageSize,userInfo,function(result){
            $("#new1").html(result);
        });
        // $.ajax({
        //     url : "/userInfo/list/" + pageNo + "/" + pageSize,
        //     data : userInfo,
        //     dataType : 'json',
        //     type : 'post',
        //     success : function(data, textStatus, jqXHR) {
        //         alert(data);
        //     },
        //     error : function(XMLHttpRequest, textStatus, errorThrown,res) {
        //         alert(textStatus + '  :  ' + errorThrown + '!');
        //     }
        // });
    };

    $('#prePage').click(function() {
        previous(pageNo,pageSize);
    });

    $('#nextPage').click(function() {
        next(pageNo,pageSize);
    });

    previous = function(){
        if(pageNo == 1){
            alert("已经是第一页!");
            return false;
        }
        findUserList(pageNo - 1,pageSize);
    };

    next = function(){
        if(pages == pageNo){
            alert("已经是最后一页!");
            return false;
        }
        findUserList(pageNo + 1,pageSize);
    };
})