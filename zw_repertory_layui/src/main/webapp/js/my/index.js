/**
 * 
 * @authors LiuJinrong (jinrongxiaogege@foxmail.com)
 * @date    2019-1-3 16:26:46
 * @version $Id$
 */



// 项目路径
// var path = "http://47.93.198.253:8080/zw_repertory_layui/";
var path = "http://127.0.0.1:8080/zw_repertory_layui/";



layui.use(['form','layer','laydate','table'], function() {
	var form = layui.form;
	var laydate = layui.laydate;
	var table = layui.table;
	var layer = layui.layer;

	laydate.render({
		elem: '#date1', //指定元素
	});

	//执行一个laydate实例
	laydate.render({
		elem: '#date2' //指定元素
	});

	//监听提交
	form.on('submit(tijiao)', function(data) {
		
		// 表格的重载
		table.reload('table_demo', {
			// 设置异步数据接口的额外参数
			where: {
				listName: data.field.listName,
				listStatus: data.field.listStatus,
				listCode: data.field.listCode,
				listBegindate: data.field.listBegindate,
				listEnddate: data.field.listEnddate,
				listPrice: data.field.listPrice
			},
			page: {
				// 重新从第一页开始
				curr: 1
			}
		});

		// 阻止form表单提交
		return false;
	});



	// 加载一个table实例
	table.render({
		elem: '#table_demo', // id选择器
		url : path + "repertory/repertorySelect",
		page: true,
		limit: 8,
		// 头部模板调用
		toolbar: '#toolbarDemo',
		//设置分页组件显示
		//layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
		cols: [[
		        // 表头
		        {field: 'shopId', title:'ID', type: 'checkbox'},
		        {field: 'shopId', title:'ID', type: 'numbers', align: 'center'},
		        {field: 'listName', title:'商品名称', align: 'center'},
		        {field: 'listStatus', title:'商品状态', align: 'center',
		        	// 使用layui判断显示
		        	templet: function(d){
		        		if (d.listStatus == 0) {
							return '可贩卖';
						} else {
							return '不可贩卖';
						}
		        	}
		        },
		        {field: 'listCode', title:'商品代码', align: 'center'},
		        {field: 'listBegindate', title:'贩卖开始时间', align: 'center'},
		        {field: 'listEnddate', title:'贩卖结束时间', align: 'center'},
		        {field: 'listPrice', title:'价格', align: 'center'},
		        {field: 'repertoryCount.countNumber', title:'库存数', align: 'center',
		        	// 使用layui模板获取级联一对一值
		        	templet: function(d){
		                return d.repertoryCount.countNumber;
		            }
		        },
		              
		        //这里的toolbar值是模板元素的选择器
		        {fixed: 'right', width:150, align:'center', toolbar: '#barDemo'},
	        ]],
	        // skin: 'line', // 行边框风格
	        even: true, // 开启隔行背景
	        // size: 'sm', // 小尺寸

	        // 数据预解析回调函数
	        parseData: function(res){ // res 即为原始返回的数据
	        	return {
	        		"code": 0, //解析接口状态, 0代表成功
	        		"count": res.code.total, //解析数据长度, 多少条记录数
	        		"data": res.code.list //解析数据列表, 列表的数据
	        	};
	        }

	});

	

	//监听行尾工具条事件
	table.on('tool(table_filter)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		var data = obj.data; //获得当前行数据
		var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		var tr = obj.tr; //获得当前行 tr 的DOM对象

		if(layEvent === 'del'){ //删除
			layer.confirm('真的删除行么', function(index){
				obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				layer.close(index);
				//console.log(data)
				
				//向服务端发送删除指令
				// 调用删除单条方法
				repertoryDeleteById(data.shopId);
				
				// 重新渲染数据表格
				table.reload('table_demo');
			});

		} else if(layEvent === 'edit'){ //编辑
			// 跳转至修改/添加页面
			window.location.href = 'add.html?shopId='+data.shopId;
			
			// 重新渲染数据表格
			table.reload('table_demo');
		}
	});
	
	
	
	
	//监听头部工具头事件
	table.on('toolbar(table_filter)', function(obj){
		// 获取选中的行
		var checkStatus = table.checkStatus(obj.config.id);
		switch(obj.event){
			case 'add':
				
				// 跳转至修改/添加页面
				window.location.href = 'add.html';
				break;
	    
			case 'delete':
				
				// 声明一个数组用来填充批量删除的商品ids
				var shopIdsArr = [];
				// 遍历出数组中的对象
				checkStatus.data.forEach(function(value){
					// 填充至创建的新数组中
					shopIdsArr.push(value.shopId);
				})
				
				// 调用批量删除方法
				repertoryDeleteByIds(shopIdsArr);
				
				// 重新渲染数据表格
				table.reload('table_demo');
				break;
		};
	});



});




// 删除单条
function repertoryDeleteById(shopId){
	console.log(typeof(shopId))
	// ajax请求
	$.ajax({
		// 请求地址
		url: 'repertory/repertoryDeleteById',
		// 请求方式
		type: 'post',
		// 请求数据
		data: {
			shopId: shopId
		},
		// 响应类型
		dataType: 'json',
		// 响应数据
		success: function(data){
			// 判断删除是否成功
			if (data.code == 1) {
				layer.msg('删除成功');
			} else {
				layer.msg('删除失败');
			}
		}
	});
}



// 批量删除方法
function repertoryDeleteByIds(shopIdsArr){
	console.log(typeof(shopIdsArr))
	console.log(shopIdsArr)
	// ajax请求
	$.ajax({
		// 请求地址
		url: 'repertory/repertoryDeleteByIds',
		// 请求方式
		type: 'post',
		// 请求数据
		data: {
			// 数组对象转字符串的方式
			shopIds: shopIdsArr + ''
		},
		// 响应类型
		dataType: 'json',
		// 响应数据
		success: function(data){
			// 判断删除是否成功
			if (data.code == 1) {
				layer.msg('删除成功');
			} else {
				layer.msg('删除失败');
			}
		}
	});
}























