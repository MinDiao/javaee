/**
 * 
 * @authors LiuJinrong (jinrongxiaogege@foxmail.com)
 * @date    2018-12-31 18:40:42
 * @version $Id$
 */

//项目路径
var path = "http://127.0.0.1:8080/zw_repertory/";

var vm;

//预加载
$(function() {
	// vue初始化
	vm = new Vue({
		el : "#app",
		data : {
			// 商品添加的对象集
			repertoryAdd:{}
		},
		
		methods:{
			// 添加商品
			repertoryAdd:function(){
				// 调用添加商品方法
				repertoryAdd();
			}
		}
	});

});



//用户列表
function repertoryAdd() {
	// ajax异步请求不会等待上一个请求,所以底下的"创建分页信息方法"获取不到值
	$.ajax({
		//请求的地址url,为字符串
		url : path + "repertory/repertoryAdd",
		
		// 请求类型
		type: "post",
		
		//请求的数据pojo
		data : vm.repertoryAdd,
		
		//数据类型
		dataType : "json",

		//请求成功后的 调用方法     data:是返回的数据信息
		success : function(data) { 
			// 判断是否添加成功
			if (data.code == 1) {
				alert("添加成功")
				
				// 跳转至查询页面
				window.location.href = path + 'index.html';
			} else {
				alert("添加失败")
			}
		}
	})
};









