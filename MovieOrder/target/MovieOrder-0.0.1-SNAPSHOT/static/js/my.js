
$(function() {
    //初始化fileinput
    var fileInput = new FileInput();
    fileInput.Init("picture_add_input", "http://localhost:8080/uploadImg");
});

//初始化fileinput
var FileInput = function() {
    var oFile = new Object();

    //初始化fileinput控件（第一次初始化）
    oFile.Init = function(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);

        //初始化上传控件的样式
        control.fileinput({
            language: 'zh', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions: ['jpg', 'jpeg', 'gif'], //接收的文件后缀
            uploadAsync: true, //默认异步上传

            showUpload: false, //是否显示上传按钮
            showRemove: true, //显示移除按钮
            showCaption: true, //是否显示标题

            dropZoneEnabled: true, //是否显示拖拽区域

            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data',

            browseClass: "btn btn-primary", //按钮样式: btn-default、btn-primary、btn-danger、btn-info、btn-warning
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",

        });

        //文件上传完成之后发生的事件
        $("#picture_add_input").on("fileuploaded", function(event, data, previewId, index) {

        });
    }
    return oFile; //这里必须返回oFile对象，否则FileInput组件初始化不成功
};