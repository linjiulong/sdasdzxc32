$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/user/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'id', index: "id", width: 45, key: true , hidden: true},
			{ label: '用户名', name: 'username', width: 75 },
            { label: '包网', name: 'deptName', width: 75 },
            { label: '额度', name: 'limits', width: 75 },
			{ label: '注册时间', name: 'addTime',  width: 80 }, 			
			{ label: '状态', name: 'status', width: 60, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-danger">禁用</span>' : 
					'<span class="label label-success">正常</span>';
			}}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        admins:null,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            username: null
        },
        showList: true,
        title:null,
        roleList:{},
        user:{
            status:1,
            deptId:null,
            deptName:null,
            roleIdList:[]
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.roleList = {};
            vm.user = {deptName:null, deptId:null, status:1, roleIdList:[]};

            //获取角色信息
            this.getRoleList();
            vm.getDept();
        },
        getDept: function(){
            //加载树
            $.get(baseURL + "sys/dept/list", function(r){
                ztree = $.fn.zTree.init($("#deptTree"), setting, r);
                var node = ztree.getNodeByParam("deptId", vm.user.deptId);
                if(node != null){
                    ztree.selectNode(node);

                    vm.user.deptName = node.name;
                }
            })
        },
        update: function () {
            var Id = getSelectedRow();
            if(Id == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getUser(Id);
            //获取角色信息
            this.getRoleList();
        },
        del: function () {
            var Ids = getSelectedRows();
            if(Ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/user/delete",
                    contentType: "application/json",
                    data: JSON.stringify(Ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            var url = vm.user.id == null ? "sys/user/save" : "sys/user/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.user),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getUser: function(Id){
            $.get(baseURL + "sys/user/info/"+Id, function(r){
                vm.user = r.user;
                vm.user.password = null;
                vm.getDept();
            });
        },
        recharge: function () {
        	var Id = getSelectedRow();
            if(Id == null){
                return ;
            }
            document.getElementById("limits").value="";
        	 layer.open({
                 type: 1,
                 offset: '50px',
                 skin: 'layui-layer-molv',
                 title: "充值面板",
                 area: ['300px', '280px'],
                 shade: 0,
                 shadeClose: false,
                 content: jQuery("#divrecharge"),
                 btn: ['确定', '取消'],
                 btn1: function (index) {
                	 console.log("Id:"+Id);
                	 console.log("limitss:" + document.getElementById("limits").value );
                	 
                	 var obj = document.getElementsByName("limi");
                	 var add="+";
                	 for (i in obj)
                	  {
                		 if(obj[i].checked==true)
                		 {
                			 add=obj[i].value;
                			 break;
                		 }
                	  }


                	 vm.user.id = Id;
                	 vm.user.limits = add+document.getElementById("limits").value;
                	 $.ajax({
                         type: "POST",
                         url: baseURL + "sys/user/recharge",
                         contentType: "application/json",
                         data: JSON.stringify(vm.user),
                         success: function(r){
                             if(r.code === 0){
                                 alert('操作成功', function(){
                                     vm.reload();
                                 });
                             }else{
                                 alert(r.msg);
                             }
                         }
                     });
                     layer.close(index);
                 }
             });
        },
        getRoleList: function(){
            $.get(baseURL + "sys/role/select", function(r){
                vm.roleList = r.list;
            });
        },
        deptTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级
                    vm.user.deptId = node[0].deptId;
                    vm.user.deptName = node[0].name;
                    vm.user.roleIdList = [];
                    $.get(baseURL + "sys/role/select/"+vm.user.deptId, function(r){
                    	 vm.roleList = r.list;
                    });
                    
                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
        }
    }
});