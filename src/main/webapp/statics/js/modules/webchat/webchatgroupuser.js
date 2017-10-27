$(function () {
	
	$("#jqGrid").jqGrid({
        url:  "",
        datatype: "json",
        colModel: [			
			{ label: '群号', name: 'gid', index: 'gid', width: 50},
			{ label: '群员ID', name: 'uid', index: 'uid', width: 80 , key: true ,sortname:false}, 			
			{ label: '入群时间', name: 'addtime', index: 'addtime', width: 80 }, 			
			{ label: '发言状态', name: 'gStatus', width: 80, formatter: function(value, options, row){
				return value === 0 ? 
						'<span class="label label-success">未禁言</span>' : 
						'<span class="label label-danger">被禁言</span>';
			}}, 			
			{ label: '禁言时长', name: 'bannedTime', index: 'banned_time', width: 80 }, 			
			{ label: '最后发言时间', name: 'speakTime', index: 'speak_time', width: 80 }, 			
			{ label: '级别', name: 'level',  width: 80 , formatter: function(value, options, row){
					if(value==0){
						return '<span class="label label-warning">群主</span>' ;
					}else if (value==1) {
						return '<span class="label label-primary">会员</span>' ; 
					}else if (value==2) {
						vm.groupadmin="设为群主";
						return '<span class="label label-success">管理员</span>' ; 
					}
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
          var val= rowData.level; 
           
          if(typeof(val)=="undefined"){ 
//	   		  　$('#offline').attr("disabled","disabled");  
	   		  $('#del').attr("disabled","disabled");  
	   		  $('#admins').attr("disabled","disabled");  
	   		  $('#banned').attr("disabled","disabled");  
	   		  $('#groupadmin').attr("disabled","disabled");  
	   	   }else {
	   		   console.log("222222222")
//	   		   $("#offline").attr("disabled", false);
	   		   $("#del").attr("disabled", false);
	   		   $("#admins").attr("disabled", false);
	   		   $("#groupadmin").attr("disabled", false);
	   		   $("#banned").attr("disabled", false);
	   	   }
          
          
          if(val.indexOf("会员")==-1){
        	 vm.adminsname="取消管理员";
          }else{
        	  vm.adminsname="设置管理员";
          }
          
         
          
        }
    });
	 
	 
    
	
});

  
var vm = new Vue({
	el:'#rrapp',
	data:{
		 q:{
	            uid: null
	        },
	    showList: true,
		title: null,
		svalue:null,
		gid:null,
		groupname:null,
		groupadmin:null,
		webchatGroups: {},
		webchatGroupDetail: {},
		adminsname:"设置管理员",
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
			vm.webchatGroups = {};
			if(vm.groupname!=null){
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
	                		 vm.webchatGroupDetail.gid=vm.svalue;
	                		 
	                		 vm.webchatGroupDetail.users=count;
	                		 vm.save();
	                	 }
	                    layer.close(index);
	                }
	            });
			}else{
				alert("请先选择需要管理的聊天群")
			}
		},
		save: function (event) {
			$.ajax({
				type: "POST",
			    url: baseURL + "webchatgroupdetail/save",
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
		del: function (event) {
			var ids = getSelectedRows();
			var gid=vm.svalue;
			ids.splice(0, 0, gid);  
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
		banned: function (event) {
		    var userId = getSelectedRow();
            if(userId == null){
                return ;
            }
          

            
        	layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "禁言设置",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#bannedLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                	
                	 var userId = getSelectedRow();
     	            if(userId == null){
     	                return ;
     	            }
     	            
     				var gid=vm.gid[0];
     	            var banned_time=document.getElementById("banned_time").value;  
     	           console.log("gid:"+gid)
     	           console.log("uid:"+userId)
     	           console.log("banned_time:"+banned_time)
     	            vm.webchatGroupDetail.gid=gid;
     	           vm.webchatGroupDetail.uid=userId;
     	           vm.webchatGroupDetail.bannedTime=banned_time;
     	           			
     	           			$.ajax({
								type: "POST",
							    url: baseURL + "webchatgroupdetail/banned",
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
		admins: function (event) {
			 var userId = getSelectedRow();
	            if(userId == null){
	                return ;
	            }
	            
	      
	            
	            var gid=vm.gid;
	        	$.get(baseURL + "webchatgroupdetail/admins/"+gid+"-"+userId, function(r){
	        		vm.reload();
	            });
	        	
		},
		getUsers: function(){
			 $("#tableInfoId0").empty();
	         var $select = $("#tableInfoId0")
			 $.get(baseURL + "webchatuser/select", function(r){
				 $.each(r.list,function(n,value) {
		                $opt = $("<option />", {
		                    value: value.uid,
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
               	 vm.groupname="当前群名:"+name;
               	   console.log("id:"+id)
       	           console.log("name:"+name)
       	           vm.gid=id;
               	 vm.getdate(id);
               	 layer.close(index);
               }
           });
       },
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'uid': vm.q.uid},
                page:page
            }).trigger("reloadGrid");
		} ,
		getInfo: function(id){
			$.get(baseURL + "webchatgroupdetail/info/"+id, function(r){
                vm.webchatFriendgroup = r.webchatFriendgroup;
            });
		},
		getdate(value){
			$('#jqGrid').jqGrid('clearGridData');
			$('#jqGrid').jqGrid('setGridParam', {
				url: baseURL + 'webchatgroupdetail/select/'+value,
			}).trigger('reloadGrid');
		}
	}
});