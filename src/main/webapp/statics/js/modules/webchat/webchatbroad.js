$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'webchatbroad/list',
        datatype: "json",
        colModel: [			
			{ label: '广播编号', name: 'id', width: 50, key: true },
			{ label: '广播内容', name: 'msg', width: 80 }, 			
			{ label: '广播时间', name: 'bTime', width: 80 }, 			
			{ label: '广播频率', name: 'frequency', width: 80 }, 			
			{ label: '广播状态', name: 'bState', width: 80 }			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		groupname: null,
		webchatBroad: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.webchatBroad = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
        cycle:function(){
        	var obj = document.getElementsByName("cycle");
	       	 var add=" ";
	       	 for (i in obj)
	       	  {
	       		 if(obj[i].checked==true)
	       		 {
	       			 add=obj[i].value;
	       			 break;
	       		 }
	       	  }
	       	 
	       	 if(add==0){
	       		Range_time
	       	   $("#R_time").hide();
	       		$("#frequency").hide();
	       		$("#Range_time").show();
	       	 }else {
	       		 $("#Range_time").hide();
	       		$("#R_time").show();
	       		$("#frequency").show();
	       	}
	       	 

	       	 
        },
		saveOrUpdate: function (event) {
			var url = vm.webchatBroad.id == null ? "webchatbroad/save" : "webchatbroad/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.webchatBroad),
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
				    url: baseURL + "webchatbroad/delete",
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
		groupsTree: function(){
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
	               	 var $select = $("#Group")
	               	 var id=$('#Group').multipleSelect('getSelects', 'value');
	               	 var name=$('#Group').multipleSelect('getSelects', 'text');
	               	 vm.groupname=name;
	               	 layer.close(index);
	               }
	           });
        },
		getGroups: function(){
			 $("#Group").empty();
	         var $select = $("#Group")
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
		getInfo: function(id){
			$.get(baseURL + "webchatbroad/info/"+id, function(r){
                vm.webchatBroad = r.webchatBroad;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});