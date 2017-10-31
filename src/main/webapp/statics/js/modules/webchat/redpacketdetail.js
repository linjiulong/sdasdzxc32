$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'redpacketdetail/list',
        datatype: "json",
        colModel: [			
			{ label: 'rid', name: 'rid', index: 'rid', width: 50, key: true },
			{ label: '会员id 收红包人ID', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '领取金额', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '领取时间', name: 'time', index: 'time', width: 80 }			
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
		redPacketDetail: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.redPacketDetail = {};
		},
		update: function (event) {
			var rid = getSelectedRow();
			if(rid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(rid)
		},
		saveOrUpdate: function (event) {
			var url = vm.redPacketDetail.rid == null ? "redpacketdetail/save" : "redpacketdetail/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.redPacketDetail),
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
			var rids = getSelectedRows();
			if(rids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "redpacketdetail/delete",
				    contentType: "application/json",
				    data: JSON.stringify(rids),
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
		getInfo: function(rid){
			$.get(baseURL + "redpacketdetail/info/"+rid, function(r){
                vm.redPacketDetail = r.redPacketDetail;
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