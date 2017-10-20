$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'webchatuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户ID', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '用户名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '头像', name: 'headphoto', index: 'headphoto', width: 80 }, 			
			{ label: '注册时间', name: 'addtime', index: 'addtime', width: 80 }, 			
			{ label: '所在群', name: 'groupname', index: 'addtime', width: 80 }, 			
			{ label: '状态', name: 'online', formatter: function(value, options, row){
				return value === 0 ? 
						'<span class="label label-danger">离线</span>' : 
						'<span class="label label-success">在线</span>';
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
        },
        onSelectRow: function(id,status){  
            var id = $("#jqGrid").jqGrid('getGridParam','selrow'); 
            var rowData = $("#jqGrid").jqGrid("getRowData",id); 
            var val= rowData.online; 
	           console.log("val:"+val)
	          
	           
	           if(typeof(val)=="undefined"){ 
        		  　$('#updategroups').attr("disabled","disabled");  
        		  　$('#offline').attr("disabled","disabled");  
        		  $('#del').attr("disabled","disabled");  
        		  $('#update').attr("disabled","disabled");  
        	   }else {
        		   console.log("222222222")
        		   $("#updategroups").attr("disabled", false);
        		   $("#del").attr("disabled", false);
        		   $("#update").attr("disabled", false);
        	   }
	           
	           try {  
	        	   if(val.indexOf("在线")!=-1){
		        	   $("#offline").attr("disabled", false);

		            }
	               
	        	   
	        	   
	        	   throw new Error('Whoops!');  
	        	 } catch (e) {  
	        	   console.log(e.name + ': ' + e.message);  
	        	 }  
	           
          
          }
    });
    
    
    new AjaxUpload('#upload', {
        action: baseURL + "sys/oss/upload/users",
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
            	vm.webchatUser.headphoto=r.url;
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
			name:null
		},
		offlinestate : null,
		showList: true,
		title: null,
		webchatUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.webchatUser = {};
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
			var url = vm.webchatUser.id == null ? "webchatuser/save" : "webchatuser/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.webchatUser),
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
				    url: baseURL + "webchatuser/delete",
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
			$.get(baseURL + "webchatuser/info/"+id, function(r){
                vm.webchatUser = r.webchatUser;
            });
		},
		offline: function(event){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
			confirm('确定要选中的用户下线？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "webchatuser/offline",
				    contentType: "application/json",
				    data: JSON.stringify(id),
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
			});
			
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		}
	}
});