/**
 * Created by wxwreus@163.com on 2018/12/4.
 */

$(function(){
    $("#canvas").qrcode({
        size: 200,
        ecLevel: 'H',
        mode:2,
        fill: '#000',
        render:'div'
    });
    html2canvas(document.getElementById("canvas"),{
        onrendered: function(canvas) {
            var url = canvas.toDataURL("image/png").replace("image/png","image/octet-stream");
            console.dir("print......");
            image = new Image();
            image.src = url;
            $(image).print();
        }
    });
});
