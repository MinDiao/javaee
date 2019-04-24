/**
 * 首页js
 */

var vm;

// 页码,并赋初始值为第1页
var pageNum = 1;
// 页容量(每页多少条数据)
var pageSize = 5;
// 一共多少页
var pages;
// 一共多少条记录
var total;


//预加载
$(function() {
	// vue初始化
	vm = new Vue({
		el : "#user",
		data : {
			// 用户列表
			users:[],
			
			/* 用户查询 模块 - 可整合成数组 */
			// 模糊查询用户名
			username : '',
			// 模糊查询年龄
			sex : '',
			// 范围查询起始生日
			birthdayBefore:'',
			// 范围查询结束生日
			birthdayAfter:'',

			// 批量删除多选框
			checked:[]
		},
		methods:{
			// 删除用户
			del:function(obj){
				if (confirm("您确定要删除此用户吗?")) {
					userDelete(obj);
				}
			},
			
			// 添加/修改用户页面跳转
			userAddUpdate:function(userId){
				window.location.href = path + "addUpdate.html?userId="+userId;
			},
			
			// 批量删除用户
			userDeleteS:function(){
				if (confirm("您确定要删除此用户吗?")) {
					// 批量删除
					userDeleteS();
				}
			},
			
			// 模糊查询
			userSelectByFuzzy:function(){
				// 调用用户列表(模糊)查询方法
				getUsers();
				// 分页信息方法
				createPage();
			}
		}
	});

	// 调用查询用户列表的方法
	getUsers();
	// 分页信息方法
	createPage();
	
});



// 用户列表
function getUsers() {
	// ajax异步请求不会等待上一个请求,所以底下的"创建分页信息方法"获取不到值
	$.ajax({
		url : path + "user/userList",//请求的地址url,为字符串
		// 请求类型
		type: "get",
		//请求的数据
		data : {
			// 模糊查询用户名
			'username': vm.username,
			// 模糊查询年龄
			'sex': vm.sex,
			// 范围查询起始生日
			'birthdaybegin': vm.birthdayBegin,
			// 范围查询结束生日
			'birthdayend': vm.birthdayEnd,
			
			// 页码
			'pageNum': pageNum,
			// 页容量
			'pageSize': pageSize
		},
		//数据类型
		dataType : "json",
		
		// 是否异步,默认是true
		async:false, 
		
		//请求成功后的 调用方法     data:是返回的数据信息
		success : function(data) { 
			// 界面list
			vm.users = data.code.list;
			// 一共多少页
			pages = data.code.pages;
			// 一共多少条记录
			total = data.code.total;
		}
	})
};

//创建分页信息方法
function createPage(){
	new Page({
		id: 'pagination',
		curPage: pageNum, //初始页码
		pageTotal: pages, //总页数
		pageAmount: pageSize, //每页多少条
		dataTotal: total, //总共多少条数据
		pageSize: 5, //可选,分页个数
		showPageTotalFlag: true, //是否显示数据统计
		showSkipInputFlag: true, //是否支持跳转
		getPage: function(page) {
			// 获取当前页数
			// console.log(page);
			// 回调
			// 给请求的页面赋值
			pageNum = page;
			// 调用查询用户的方法
			getUsers();
		}
	})
};




// 删除用户
function userDelete(obj){
	$.ajax({
		// 请求地址
		url:path + "user/userDeleteById",
		// 请求类型
		type:"post",
		// 请求数据
		data:{
			"id":obj
		},
		// 响应类型
		dataType:"json",
		// 响应数据
		success:function(data){
			if (data.code == 1) {
				alert("删除成功");
				// 回调重新查询用户列表
				getUsers();
				// 分页信息方法
				createPage();
			} else {
				alert("删除失败");
			}
		}
	})
};



// 批量删除
function userDeleteS(){
	// 将Vue对象转换为数组
	var ids = vm.checked + "";

	$.ajax({
		// 请求批量删除地址
		url:path + "user/userDeleteByIds",
		// 请求类型
		type:"post",
		// 请求数据
		data:{
			"ids":ids
		},
		// 响应类型
		dataType:"json",
		// 响应数据
		success:function (data) {
			if (data.code == 1) {
				alert("批量删除成功");
				// 回调重新查询用户列表
				getUsers();
				// 分页信息方法
				createPage();
				
			} else {
				alert("批量删除失败");
			}
		}
	})
};








