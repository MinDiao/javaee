/**
 * 首页js
 */
//var path = "http://localhost:8080/ljr/";

// 页码,并赋值初始值为第一页
var pageNum = 1;
// 页容量
var pageSize = 5;
// 一共多少页
var pages;
// 一共多少条记录
var total;

var vm;
//预加载
$(function() {
	// vue初始化
	vm = new Vue({
		el : "#user",
		data : {
			users:[],
			username : '',
			sex : '',
			birthday:'',

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
			/*userAddUpdate:function(obj){
				if (obj != null) {
					sessionStorage.setItem('userLogin', JSON.stringify(obj));
				}
				window.location.href = path + "addUpdate.html";
			},*/
			
			
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
				// 调用模糊查询方法
				userSelectByFuzzy();
			}
		}
	});

	// 调用查询用户列表的方法
	getUsers();
	// 分页信息方法
	createPage();
});

// 调用查询用户列表的方法
function getUsers() {
	// ajax异步请求不会等待上一个请求,所以底下的"创建分页信息方法"获取不到值
	$.ajax({
		url : path + "UserServlet",//请求的地址url,为字符串
		// 请求类型
		type: "get",
		data : {
			username : vm.username,
			sex : vm.sex,

			// 页码
			pageNum:pageNum,

			// 页容量
			pageSize:pageSize

		}, //请求的数据
		dataType : "json", //数据类型

		async:false, // 是否异步,默认是true

		success : function(data) { //请求成功后的 调用方法     data:是返回的数据信息
			// 界面list
			vm.users = data.page.data;

			// 一共多少页
			pages = data.page.totalPage;

			// 记录数
			total = data.page.rows;
		}
	})
};

// 创建分页信息方法
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
			//获取当前页数
			//console.log(page);

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
		url:path + "UserServlet?action=userDeleteById",
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
		url:path + "UserServlet?action=userDeleteByIds",
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



// 模糊查询
function userSelectByFuzzy(){
	// ajax
	$.ajax({
		// 请求路径
		url:path + "UserServlet?action=userSelectByFuzzy",
		// 请求类型
		tyep:'post',
		// 请求数据
		data:{
			// 用户姓名
			'username':vm.username,
			// 用户年龄
			'sex':vm.sex,
			// 用户生日
			'birthday':vm.birthday
		},
		// 响应类型
		dataType:'json',
		// 响应数据
		success:function(data){
			vm.users = data.code;
			// 回调重新查询用户列表
			getUsers();
			// 分页信息方法
			createPage();
		}
	});
}


















