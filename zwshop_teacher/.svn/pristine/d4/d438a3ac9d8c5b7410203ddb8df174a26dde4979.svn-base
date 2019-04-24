layui.use(['table', 'layer'], function() {
	var table = layui.table;
	var layer = layui.layer;

	if(login != null) {
		//表格加载
		table.render({
			elem: "#table_sys_user",
			url: basePath + "sys_user/list",
			method: 'post', //请求类型
			page: true, //分页
			toolbar: "#toolbarDemo", //模板选择
			cols: [
				[
					{ title: '序号', type: 'numbers', fixed: 'left' },
					{ field: "userId", type: 'checkbox', align: 'center' },
					{ field: "username", title: '用户名' },
					{ field: "createTime", title: '创建时间' },
					{ field: "remarks", title: '备注信息' },
				]
			],
			parseData: function(res) { //res 即为原始返回的数据，进行解析
				return {
					"code": res.code, //解析接口状态，0代表成功
					//"msg": res.message, //解析提示文本
					"count": res.page.total, //解析数据长度,多少条记录数
					"data": res.page.list //解析数据列表，  列表的数据
				};
			},
		})

	}

	//检索监控事件
	$("#search").click(function() {
		//表格重载
		table.reload('table_sys_user', {
			where: { //设定异步数据接口的额外参数
				username: $("#username").val()
			},
			page: {
				curr: 1 //重新从第 1 页开始
			}
		})
	})

	//头部工具栏的事件
	table.on('toolbar(filter_sys_user)', function(obj) {
		//var checkStatus = table.checkStatus(obj.config.id); //获取选中的行
		var checkStatus = table.checkStatus("table_sys_user"); //获取选中的行
		switch(obj.event) {
			case 'add':
				window.location.href = "sys_user_add.html";
				break;
			case 'delete':
				if(checkStatus.data.length == 0) {
					layer.msg('请先选择要删除的数据行！', { icon: 2 });
					return;
				}
				var ids = "";
				for(var i = 0; i < checkStatus.data.length; i++) {
					ids += checkStatus.data[i].userId + ",";
				}
				layer.msg('删除中...', { icon: 16, shade: 0.3, time: 3000 })
				//执行删除操作
				$.ajax({
					url: basePath + "sys_user/delete", //删除管理员
					type: "post",
					data: {
						ids: ids
					},
					dataType: "json",
					success: function(data) {
						if(data.code == 0) {
							layer.msg("删除成功", { icon: 6 });
							//重新加载表格  
							setTimeout(function() {
								window.location.href = "sys_user.html";
							}, 2000);
						} else {
							layer.msg("删除失败", { icon: 5 });
						}
					},
					error: function() {
						layer.msg("删除失败", { icon: 5 });
					}
				})

				break;
		};
	});

})