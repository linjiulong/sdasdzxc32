$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'webchatuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true , hidden: true},
			{ label: '用户名', name: 'username', index: 'username', width: 150 }, 			
			{ label: '个人介绍', name: 'sign', index: 'sign', width: 80 }, 			
			{ label: '注册时间', name: 'addTime', index: 'add_time', width: 70 }, 			
			{ label: '群组', name: 'groupsname', index: 'groupsname', width: 80 }, 			
			{ label: '在线', name: 'online', index: 'online', width: 30 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 30 }	, 	
			{ label: '包网', name: 'deptId', index: 'dept_id', width: 40 }, 			
			{ label: '登录次数', name: 'count', index: 'count', width: 30 }			
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
			username:null
		},
		offlinestate : null,
		showList: true,
		title: null,
		groupnames: null,
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
            console.log(id);
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
               	 var $select = $("#Group")
               	 var id=$('#Group').multipleSelect('getSelects', 'value');
               	 var name=$('#Group').multipleSelect('getSelects', 'text');
               	 vm.groupnames="当前群名:"+name;
               	   console.log("id:"+id)
       	           console.log("name:"+name)
       	           vm.gid=id;
               	 vm.getdate(id);
               	 layer.close(index);
               }
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
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
		}
	}
});