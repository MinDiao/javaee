/**
 * 
 * @authors LiuJinrong (jinrongxiaogege@foxmail.com)
 * @date    2019-1-3 16:26:46
 * @version $Id$
 */



// 项目路径
// var path = "http://47.93.198.253:8080/zw_repertory_layui/";
var path = "http://127.0.0.1:8080/zw_repertory_layui/";



$(function(){

	//URL传参公用方法
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r != null) {
			return unescape(r[2]);
		} else {
			return null;
		}
	}


	
	//获取url传参的id
	var shopIdCB = getUrlParam("shopId");
	console.log(shopIdCB)
	console.log(typeof(shopIdCB))


	// 修改页面异步回显
	if (shopIdCB != null) {
		
		$.ajax({
			// 请求路径
			url: path + 'repertory/repertorySelectById', // 添加管理员
			// 请求方式
			type: 'post',
			// 请求数据
			data: {
				shopId: shopIdCB
			},
			// 响应类型
			dataType: 'json',
			// 响应数据
			success: function(data){
				
				// 商品id隐藏域
				$('input[name=shopId]').val(data.code.shopId);
				// 商品名称
				// $("input[name='listName']").attr('value', data.code.listName);
				$("input[name='listName']").val(data.code.listName);
				// 商品代码
				// $('#listCode').val(data.code.listCode)
				// $("select[name='listCode']").val(data.code.listCode)
				$('#listCode option[value='+data.code.listCode+']').prop('selected', true);
				// 商品价格
				$('input[name=listPrice]').val(data.code.listPrice)
				// 商品状态
				$('input[name=listStatus][value='+data.code.listStatus+']').prop('checked', true);
				// 贩卖开始时间
				$('input[name=listBegindate]').val(data.code.listBegindate);
				// 贩卖结束时间
				$('input[name=listEnddate]').val(data.code.listEnddate);
				// 库存数量
				$('input[name=countNumber]').val(data.code.repertoryCount.countNumber);
				
			},
			// 抛出异常
			error: function(data){
				// 暂时不需要
			}
		})
	}


});





layui.use(['form','layer','laydate'], function() {
	var form = layui.form;
	var laydate = layui.laydate;

	laydate.render({
		elem: '#date1', //指定元素
		//type: 'datetime'
	});

	//执行一个laydate实例?
	laydate.render({
		elem: '#date2', //指定元素
		//type: 'datetime',
		//range: '~'
	});

	//监听提交
	form.on('submit(tijiao)', function(data) {
		// layer.msg(JSON.stringify(data.field));
		$.ajax({
			// 请求地址
			url : path + "repertory/repertoryAddUpdate",
			// 请求方式
			type: 'post',
			// 请求数据
			data: data.field,
			// 响应类型
			dataType: 'json',
			// 响应数据
			success: function(data){
				// 判断是否添加成功
				if (data.code == 1) {
					
					layer.open({
						title: '提示',
						content: '提交成功',
						btn: ['确认'],
						// 点击确定回调
						yes: function(index, layero) {
							// 跳转至查询页面
							window.location.href = path + 'index.html';
						}
					});


				} else {
					layer.open({
						title: '提示',
						content: '提交失败'
					});    
				}
			}
		});

		// 阻止form表单提交
		return false;
	});
});








