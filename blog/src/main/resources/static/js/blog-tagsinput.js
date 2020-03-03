
/**
 * <p> 描述 : 标签库主要方法类
 * - - - 存选中id的input id写死了 $("#tags")
 * - - - 页面没有多个选标签的，就简单写
 * @author : blackcat
 * @date  : 2020/3/2 16:41
*/
$(function(){
    var tagId=$("#tagId").val();
    // 加载标签库
    if(tagId){
        $.get("/code/allJson/"+tagId,function (json) {
            if (json){
                var items=$("#tag-items");
                var articleTags=$("#tags").val();
                num = json.data.length;
                for (var i=0; i<num; i++) {
                    if (articleTags.indexOf(json.data[i].id) != -1) {
                        items.append('<li data="' + json.data[i].id + '" class="selected"><span>' + json.data[i].name + '</span></li>');
                    } else {
                        items.append('<li data="' + json.data[i].id + '"><span>' + json.data[i].name + '</span></li>');
                    }
                }
            }
        });
    }

    $(".show-labelitem").on("click",function(){
        $(this).hide();
        $(".hide-labelitem").show();
        $("#labelItem").show();
    });
    $(".hide-labelitem").on("click",function(){
        $(this).hide();
        $(".show-labelitem").show();
        $("#labelItem").hide();
    });
    $(".label-item").on("click","li",function(){
        var id = $(this).attr("data");
        var text = $(this).children("span").html();
        var labelHTML = "<li data='"+id+"''>x "+text+"</li>";
        if($(this).hasClass("selected")){
            return false;
        }else if($(".label-selected").children("li").length >= 8){
            $.tool.alert("最多可以选择8个哦");
            return false;
        }
        $(".label-selected").append(labelHTML);
        val = '';
        for(var i = 0; i < $(".label-selected").children("li").length; i++){
            val += $(".label-selected").children("li").eq(i).attr("data")+',';
        }
        $("#tags").val(val);
        $(this).addClass("selected");
    });
    var val = "";
    $(".label-selected").on("click","li",function(){
        var id = $(this).attr("data");
        val = '';
        $(this).remove();
        for(var i = 0; i < $(".label-selected").children("li").length; i++){
            val += $(".label-selected").children("li").eq(i).attr("data")+',';
        }
        $("#tags").val(val);
        $(".label-item").find("li[data='"+id+"']").removeClass("selected");
    });


    //点击更换标签
    var limit = 0;
    $(".replacelable").on("click",function(){
        limit += 32;
        $.ajax({
            url:window.location.href,
            type:"post",
            datatype:"json",
            data:{
                labellimit:limit
            },
            success:function(data){
                // layer.closeAll('loading');
                $(".label-item").find("li").remove();//删除原先所有
                var html = '';
                for(var i in data){
                    html += "<li data=\""+data[i].term_id+"\">x<span>"+data[i].name+"</span></li>";//拼接标签
                }
                $(".label-item").append(html);//追加至文档
            },
            error:function(){
                $.tool.alertError("错误~~~");
            }
        });
    });
});