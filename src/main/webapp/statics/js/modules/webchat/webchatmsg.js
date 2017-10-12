$(function () {
	$.get(baseURL + "webchatgroups/select", function(r){
		vm.webchatGroups=r.list;
    });
	
	 $("#jqGrid").jqGrid({
	        url: baseURL + 'webchatmsg/list',
	        datatype: "json",
	        colModel: [			
				{ label: 'id', name: 'id', index: 'id', width: 20, key: true },
				{ label: '会员ID', name: 'uid', index: 'uid', width: 20 }, 			
				{ label: '发送者ID', name: 'fromuser', index: 'fromuser', width: 20 }, 			
				{ label: '群ID', name: 'gid', index: 'gid', width: 20 }, 			
				{ label: '内容', name: 'msg', index: 'msg', width: 80 }, 			
				{ label: '发送时间', name: 'addtime', index: 'addtime', width: 50 }			
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
    
    
});

function open(){
	$.get(baseURL + "webchatgroups/select", function(r){
		vm.webchatGroups=r.list;
    });
} 

function selectOnchang(obj){ 
	var value = obj.options[obj.selectedIndex].value;
	vm.getdate(value);
	vm.svalue=value;
}

var vm = new Vue({
	el:'#rrapp',
	data:{
		 q:{
			 msg: null
	        },
	    showList: true,
		title: null,
		svalue:null,
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
			vm.getUsers();
			if(vm.svalue!=null){
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
	                	
	                	 var $select = $("#tableInfoId0")
	                	 var count=$('#tableInfoId0').multipleSelect('getSelects');
	                	 if(count==null||count==""){
	                		   alert("未选择，添加失败!");
	                	 }else{
	                		 vm.user.count=count.length+"位";
	                		 vm.webchatGroups.users=count;
	                		 vm.saveOrUpdate();
	                	 }
	                    layer.close(index);
	                }
	            });
			}else{
				alert("请先选择需要管理的聊天群")
			}
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
							vm.reload();
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
				    url: baseURL + "webchatgroupdetail/delete",
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
		getUsers: function(){
			 $("#tableInfoId0").empty();
	         var $select = $("#tableInfoId0")
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
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'uid': vm.q.uid},
                page:page
            }).trigger("reloadGrid");
		} ,
		getdate(value){
			$('#jqGrid').jqGrid('clearGridData');
			$('#jqGrid').jqGrid('setGridParam', {
				url: baseURL + 'webchatgroupdetail/select/'+value,
			}).trigger('reloadGrid');
		}
	}
});