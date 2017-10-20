$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'webchatgroups/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 20, key: true },
			{ label: '群名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '头像', name: 'headphoto', index: 'headphoto', width: 80 }, 			
			{ label: '群主', name: 'username', index: 'owner_uid', width: 20 }, 			
			{ label: '人数', name: 'quantity', index: 'quantity', width: 40 },
			{ label: '群介绍', name: 'desc', index: '_desc', width: 80 }, 			
			{ label: '建立时间', name: 'addtime', index: 'addtime', width: 80 }, 			
			{ label: '类型', name: 'level', width: 80, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-danger">游客群</span>' : 
					'<span class="label label-success">普通群</span>';
			}}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
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
    
    
    new AjaxUpload('#upload', {
        action: baseURL + "sys/oss/upload/groups",
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
            	vm.webchatGroups.headphoto=r.url;
            	 alert("上传成功");
            }else{
                alert(r.msg);
            }
        }
    });
    
    
});

 


var vm = new Vue({
	el:'#rrapp',
	data:{
		 q:{
	            name: null
	        },
	     showList: true,
		title: null,
		usersList:null,
		webchatGroups: {},
		user:{
            count:null
		}
	},
	methods: {
        query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.webchatGroups = {};
			$.get(baseURL + "/sys/user/info", function(r){
                vm.webchatGroups.ownerUid = r.user.userId;
            });
			
			vm.getUsers();

		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id);
            $("#tableInfoId0").empty();
		},
		saveOrUpdate: function (event) {
			var url = vm.webchatGroups.id == null ? "webchatgroups/save" : "webchatgroups/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.webchatGroups),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
//							vm.reload();
							window.location.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "webchatgroups/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "webchatgroups/info/"+id, function(r){
                vm.webchatGroups = r.webchatGroups;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		},
		getUsers: function(){
			 $("select").empty();
	         var $select = $("select")
			 $.get(baseURL + "webchatuser/select", function(r){
				 $.each(r.list,function(n,value) {
					 console.log(n+"----"+value.uid+"-----"+value.name);
		                $opt = $("<option />", {
		                    value: value.uid,
		                    text: value.name
		                });
			            $select.append($opt).multipleSelect("refresh");
			            $select.multipleSelect('uncheckAll');
			            
				 });
			 })
        },
        usersTree: function(){
        	
        	layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择用户",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#usersLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                	
                	 var $select = $("select")
                	 var count=$('select').multipleSelect('getSelects');
                	 if(count==null||count==""){
                		 vm.user.count="未选择";
                	 }else{
                		 vm.user.count="邀请人数:"+count.length;
                		 vm.webchatGroups.users=count;
                	 }
                    layer.close(index);
                }
            });
        },
	}
});