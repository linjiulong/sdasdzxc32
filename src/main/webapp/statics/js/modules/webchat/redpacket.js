$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'redpacket/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '群组ID  按群查询发红包记录', name: 'gid', index: 'gid', width: 80 }, 			
			{ label: '用户ID 发红包人ID  按发红包人来查', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '红包总金额', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '红包个数', name: 'num', index: 'num', width: 80 }, 			
			{ label: '已领数据', name: 'take', index: 'take', width: 80 }, 			
			{ label: '红包过期时间', name: 'outTime', index: 'out_time', width: 80 }, 			
			{ label: '红包发出时间', name: 'sendTime', index: 'send_time', width: 80 }, 			
			{ label: '红包标题', name: 'headMessage', index: 'head_message', width: 80 }, 			
			{ label: '红包留言', name: 'detailMessage', index: 'detail_message', width: 80 }			
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
		redPacket: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.redPacket = {};
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
		saveOrUpdate: function (event) {
			var url = vm.redPacket.id == null ? "redpacket/save" : "redpacket/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.redPacket),
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
				    url: baseURL + "redpacket/delete",
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
			$.get(baseURL + "redpacket/info/"+id, function(r){
                vm.redPacket = r.redPacket;
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