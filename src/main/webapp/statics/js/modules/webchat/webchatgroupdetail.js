$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'webchatgroupdetail/list',
        datatype: "json",
        colModel: [			
			{ label: 'gid', name: 'gid', index: 'gid', width: 50, key: true },
			{ label: '群成员', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '加入时间', name: 'addtime', index: 'addtime', width: 80 }, 			
			{ label: ' 0 正常 1禁言', name: 'gStatus', index: 'g_status', width: 80 }, 			
			{ label: '禁言时长', name: 'bannedTime', index: 'banned_time', width: 80 }, 			
			{ label: '最后发言时间', name: 'speakTime', index: 'speak_time', width: 80 }, 			
			{ label: '1 普通会员 2 管理员 0游客', name: 'level', index: 'level', width: 80 }			
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
		webchatGroupDetail: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;

			vm.title = "新增";
			vm.webchatGroupDetail = {};
		},
		update: function (event) {
			var gid = getSelectedRow();
			if(gid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(gid)
		},
		saveOrUpdate: function (event) {
			var url = vm.webchatGroupDetail.gid == null ? "webchatgroupdetail/save" : "webchatgroupdetail/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.webchatGroupDetail),
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
			var gids = getSelectedRows();
			if(gids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "webchatgroupdetail/delete",
				    contentType: "application/json",
				    data: JSON.stringify(gids),
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
		getInfo: function(gid){
			$.get(baseURL + "webchatgroupdetail/info/"+gid, function(r){
                vm.webchatGroupDetail = r.webchatGroupDetail;
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