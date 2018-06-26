$.namespace('$.share');
$.share.ajax = function (options) {
    var msg = options.msg === undefined ? false : options.msg;
    var conf = options.conf === undefined ? false : options.conf;

    options.url = hostname + options.url;
    options.url = options.url + (options.url.indexOf('?')>0?'&':'?') + ('rand'+new Date().getTime()+'=') + new Date().getTime();

    options.cache = false;
    options.type = options.type === undefined ? 'POST' : options.type;
    options.dataType = options.dataType === undefined ? 'json' : options.dataType;

    var account = localStorage.getItem('sys_account');
    if (account) {
        if (options.data) {
            if (isArrayFn(options.data)) {
                if (!options.data.account) {
                    options.data.push({name: 'account', value: account});
                }
            } else {
                if (!options.data.account) {
                    options.data.account = account;
                }
            }
        } else {
            options.data = { account: account };
        }
    }

    var _success = options.success;
    options.success = function(data, status, xhr){
        if(xhr){
            if($.isFunction(_success) && data){
                if(msg){
                    layer.alert(data.msg);
                } else {
                    _success.call(this, data, status, xhr);
                }
            }
        }
    };

    if(conf){
        layer.confirm('确定要执行此操作吗？', {
            btn : [ '确定', '取消' ]//按钮
        }, function() {
            $.ajax(options);
        });

    }else{
        $.ajax(options);
    }
};


$.share.table = function (options) {
    //如果存在即销毁之前的table
    $(options.selector).bootstrapTable('destroy');
    var toolbar = options.toolbar === undefined ? '#toolbar' : options.toolbar;
    var showRefresh = options.showRefresh === undefined ? false : options.showRefresh;
    var showToggle = options.showToggle === undefined ? false : options.showToggle;
    var showColumns = options.showColumns === undefined ? false : options.showColumns;
    var pagination = options.pagination === undefined ? true : options.pagination;
    var detailView = options.detailView === undefined ? false : options.detailView;
    var onExpandRow = options.onExpandRow === undefined ? false : options.onExpandRow;

    var customParams = options.customParams === undefined ? {} : options.customParams;
    var selectItemName = options.selectItemName === undefined ? 'btSelectItem' : options.selectItemName;
    var checkboxHeader = options.checkboxHeader === undefined ? false : options.checkboxHeader;

    var account = localStorage.getItem('sys_account');

    options.url = hostname + options.url;
    $(options.selector).bootstrapTable({
        url:   options.url,         //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        toolbar: toolbar,                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: pagination,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParams: function queryParams(params) {   //设置查询参数
            if (account) {
                customParams['account'] = account;
            }
            if (pagination) {
                customParams['pageNum']=params.offset / params.limit + 1;
                customParams['pageSize']= params.limit;
            }
            return customParams;
        },//传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10,25,50],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: showColumns,                  //是否显示所有的列
        showRefresh: showRefresh,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: options.uid,                     //每一行的唯一标识，一般为主键列
        showToggle:showToggle,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: detailView,                   //是否显示父子表
        columns: options.columns,
        onExpandRow : onExpandRow,
        selectItemName : selectItemName,
        checkboxHeader: checkboxHeader,
        ajax : options.ajax,
        responseHandler:function(res){
            return res.data;
        }
    });
};

$.share.isContainsBlank = function (str) {
    return str.indexOf(' ') !== -1;
};

function isArrayFn(obj){
    if (typeof Array.isArray === "function") {
        return Array.isArray(obj);
    }else{
        return Object.prototype.toString.call(obj) === "[object Array]";
    }
}

