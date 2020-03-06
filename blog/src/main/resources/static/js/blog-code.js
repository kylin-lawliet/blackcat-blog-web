/**
 * <p> 描述 : code码表相关方法(部分需要递归子节点)
 * @author : blackcat
 * @date  : 2020/3/4 15:57
 * codeId: 系统参数配置 查看CodeKey类
*/
$(function () {
    var codeType=$("#codeType").val();
    var codeId=$("#codeId").val();
    if(codeId){
        switch (codeType) {
            case "1":
                loadNavigation(codeId);// 加载导航多级菜单
                break;
            case "2":
                loadCode(codeId);// 码表管理父级选择
                break;
            default:
                null;
        }
    }
    // 加载首页右侧分类统计
    loadCategory();
});

/*$.get("",function (json) {
    if (json){
        var data=json.data;
        for (var i=0; i<data.length; i++) {

        }
    }
});*/

/**
 * <p> 描述 : 码表管理父级选择(下拉框树)
 * @author : blackcat
 * @date  : 2020/3/6 16:58
*/
function loadCode(codeId) {
    $.get("/code/getCodesByCodeListId/"+codeId,function (json) {
        if (json){
            var data=json.data;
            var html='';
            for (var i=0; i<data.length; i++) {
                var code=data[i];
                html+='<option value="' + code.id + '">' + code.name + '</option>';
                if (code.nodes.length > 0) {
                    html += creatSelectTree(code);
                }
            }
            $("#parentId").append(html);
        }
    });
}

var j="&nbsp;&nbsp;|-";//前缀符号，用于显示父子关系，这里可以使用其它符号
/**
 * <p> 描述 : 生成树下拉菜单
 * @author : blackcat
 * @date  : 2020/3/6 16:55
*/
function creatSelectTree(code){
    var option="";
    for(var i=0;i<code.nodes.length;i++){
        var child=code.nodes[i];
        if(child.nodes.length > 0){//如果有子集
            option+="<option value='"+child.id+"'>"+j+child.name+"</option>";
            j+="&nbsp;&nbsp;|-";//前缀符号加一个符号
            option+=creatSelectTree(child);//递归调用子集
            j=j.slice(0,j.length-1);//每次递归结束返回上级时，前缀符号需要减一个符号
        }else{//没有子集直接显示
            option+="<option value='"+child.id+"'>"+j+child.name+"</option>";
        }
    }
    return option;//返回最终html结果
}

/**
 * <p> 描述 : 加载首页右侧分类统计
 * @author : blackcat
 * @date  : 2020/3/6 12:45
*/
function loadCategory() {
    var category=$("#category");
    if(category){
        $.get("/article/getCategory",function (json) {
            if (json){
                var data=json.data;
                var html='';
                for (var i=0; i<data.length; i++) {
                    html+='<li class="cat-item">';
                    html+='<a href="category-grid.html">';
                    if (data[i].name == null) {
                        html+='未分类';
                    } else {
                        html+=data[i].name;
                    }
                    html+='<span class="count">'+data[i].number+'</span>';
                    html+='</li>';
                }
                category.append(html);
            }
        });
    }
}

/**
 * <p> 描述 : 加载导航多级菜单
 * @author : blackcat
 * @date  : 2020/3/4 16:02
 * @param codeId 系统参数配置 查看CodeKey类
*/
function loadNavigation(codeId) {
    $.get("/code/getCodesByCodeListId/"+codeId,function (json) {
        if (json){
            var data=json.data;
            var html='';
            for (var i=0; i<data.length; i++) {
                var code=data[i];
                if(code.nodes.length==0){
                    html+='<li><a href="' + code.remarks + '">' + code.name + '</a></li>';
                }else{
                    html+='<li class="dropdown-trigger"><a href="#">' + code.name + '</a>';
                    html+=loadNavigationChild(code);
                    html+='</li>';
                }
            }
            $("#nav").append(html);
        }
    });
}

/**
 * <p> 描述 : 加载导航子菜单（递归）
 * @author : blackcat
 * @date  : 2020/3/5 14:12
*/
function loadNavigationChild(code){
    var str ='<ul class="dropdown-content">';
    for(var i=0;i<code.nodes.length;i++){
        var child=code.nodes[i];
        if (child.nodes.length > 0) {
            str +='<li class="dropdown-trigger"><a href="' + child.remarks + '">' + child.name + '</a>';
            str += loadNavigationChild(child);
        } else {
            str +='<li><a href="' + child.remarks + '">' + child.name + '</a>';
        }
        str +='</li>';
    }
    str +='</ul>';
    return str;
}
