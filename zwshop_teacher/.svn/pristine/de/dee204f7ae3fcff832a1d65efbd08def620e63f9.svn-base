var vm;

$(function() {
	vm = new Vue({
		el: "#app",
		data: {
			categorys: [] //一级分类集合
		}
	})
	selectF(); //查询一级分类
})

//查询一级分类列表
function selectF() {
	$.ajax({
		url: basePath + "category/selectF",
		type: "post",
		data: {},
		dataType: "json",
		success: function(data) {
			if(data.code == 0) {
				vm.categorys = data.categorys; //给vm的一级分类 赋值
				setTimeout(function() {
					layui.form.render('select'); //更新全部
				}, 10)
			}
		}
	})
}

layui.use(['form', 'table', 'layer'], function() {
	var table = layui.table;
	var layer = layui.layer;
	var form = layui.form;

	if(login != null) {
		//表格加载
		table.render({
			elem: "#table_cate",
			url: basePath + "category/list",
			method: 'post', //请求类型
			page: true, //分页
			toolbar: "#toolbarDemo", //模板选择
			cols: [
				[
					{ title: '序号', type: 'numbers', fixed: 'left' },
					{ field: "cateId", type: 'checkbox', align: 'center' },
					{ field: "cateName", title: '分类名称' },
					{
						field: "level",
						title: '级别',
						templet: function(d) {
							if(d.level == 1) {
								return '一级分类';
							} else {
								return '二级分类';
							}
						}
					},
					{
						field: "pCateName",
						title: '上级分类名称',
						templet: function(d) {
							if(d.pCateName == undefined) {
								return '无';
							} else {
								return d.pCateName;
							}
						}
					},
					{ field: "createTime", title: '创建时间' },
					{
						field: "disabled",
						title: '禁用状态',
						templet: function(d) {
							if(d.disabled == 0) {
								return '<a class="layui-btn layui-btn-xs" lay-event="disable">禁用</a>';
							} else {
								return '';
							}
						}
					},
					{ title: '操作',fixed: 'right', width: 220, align: 'center', toolbar: '#barDemo' }
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
		search();
	})

	function search() {
		//表格重载
		table.reload('table_cate', {
			where: { //设定异步数据接口的额外参数
				cateName: $("#cateName").val(),
				pId: $("#pId").val()
			},
			page: {
				curr: 1 //重新从第 1 页开始
			}
		})
	}

	//头部工具栏的事件
	table.on('toolbar(filter_cate)', function(obj) {
		//var checkStatus = table.checkStatus(obj.config.id); //获取选中的行
		var checkStatus = table.checkStatus("table_sys_user"); //获取选中的行
		switch(obj.event) {
			case 'add':
				window.location.href = "category_add.html";
				break;
			case 'delete':
				if(checkStatus.data.length == 0) {
					layer.msg('请先选择要删除的数据行！', { icon: 2 });
					return;
				}
				var ids = "";
				for(var i = 0; i < checkStatus.data.length; i++) {
					ids += checkStatus.data[i].cateId + ",";
				}
				layer.msg('删除中...', { icon: 16, shade: 0.3, time: 3000 })
				//执行删除操作
				$.ajax({
					url: basePath + "category/delete", //删除分类信息 注意：如果是一级分类，应该判断有无二级分类，
					//如果有，应该提示不能删除，请先删除本类下的二级分类。
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
								table.reload('table_cate');
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

	table.on('tool(filter_cate)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		var data = obj.data; //获得当前行数据
		//alert(JSON.stringify(data.id))
		var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		var tr = obj.tr; //获得当前行 tr 的DOM对象

		if(layEvent === 'del') { //删除
			layer.confirm('真的删除行么', function(index) {
				//obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				//layer.close(index);
				//向服务端发送删除指令

			});
		} else if(layEvent === 'edit') { //编辑
			//do something
			layer.msg('编辑');
		}
	});

})