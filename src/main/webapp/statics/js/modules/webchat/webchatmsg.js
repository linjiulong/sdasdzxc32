$(function () {
 
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
    
		vm.getGroups();
		
});

 
//
//function selectOnchang(obj){ 
//	var value = obj.options[obj.selectedIndex].value;
//	vm.getdate(value);
//	vm.svalue=value;
//}

var vm = new Vue({
	el:'#rrapp',
	data:{
		 q:{
			 msg: null
	        },
	    showList: true,
		title: null,
		svalue:null,
		groupname: null,
		webchatGroups: {},
		user:{
            count:null
		}
	},
	methods: {
        query: function () {
			vm.reload();
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'uid': vm.q.msg},
                page:page
            }).trigger("reloadGrid");
		},
		getGroups: function(){
			 $("#tableInfoId0").empty();
	         var $select = $("#tableInfoId0")
			 $.get(baseURL + "webchatgroups/select", function(r){
				 $.each(r.list,function(n,value) {
		                $opt = $("<option />", {
		                    value: value.id,
		                    text: value.name
		                });
			            $select.append($opt).multipleSelect("refresh");
			            $select.multipleSelect('uncheckAll');
			            
				 });
			 })
		}, 
		GroupTree: function(){
			vm.getGroups();
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择聊天群",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#GroupLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                	 var $select = $("#tableInfoId0")
                	 var id=$('#tableInfoId0').multipleSelect('getSelects', 'value');
                	 var name=$('#tableInfoId0').multipleSelect('getSelects', 'text');
                	 vm.groupname="当前群名:"+name;
                	   console.log("id:"+id)
        	           console.log("name:"+name)
                	 vm.getdate(id);
                	 layer.close(index);
                }
            });
        },
		getdate(value){
			$('#jqGrid').jqGrid('clearGridData');
			$('#jqGrid').jqGrid('setGridParam', {                
				url: baseURL + 'webchatmsg/select/'+value,
			}).trigger('reloadGrid');
		}
	}
});