/**
 * 
 * @authors LiuJinrong (jinrongxiaogege@foxmail.com)
 * @date    2018-12-31 18:40:42
 * @version $Id$
 */

//项目路径
var path = "http://127.0.0.1:8080/zw_repertory/";

var vm;

//页码,并赋初始值为第1页
var pageNum = 1;
//页容量(每页多少条数据)
var pageSize = 8;
//一共多少页
var pages;
//一共多少条记录
var total;



//预加载
$(function() {
	// vue初始化
	vm = new Vue({
		el : "#app",
		data : {
			// 用户列表
			repertoryList:[], // []或{}经检测都可以用
			
			// 查询列表
			repertoryQuery:{}, // []或{}经检测都可以用
		},
		
		methods:{
			// 添加库存页面跳转
			repertoryAdd:function(){
				window.location.href = path + "add.html";
			},

			// 模糊查询
			getRepertorySelectByFuzzy:function(){
				// 调用用户列表(模糊)查询方法
				getRepertory();
				// 分页信息方法
				createPage();
			},
			
			// 初始化页码/页容量
			init:function(){
				vm.repertoryQuery = {
					// 初始化页码
					pageNum: pageNum,
					// 初始化页容量
					pageSize: pageSize
				}
			}
		}
	});
	
	// 调用初始化页码/页容量
	vm.init();
	// 调用查询用户列表的方法
	getRepertory();
	// 分页信息方法
	createPage();

});


// 传递对象方式
// 用户列表
function getRepertory() {
	// ajax异步请求不会等待上一个请求,所以底下的"创建分页信息方法"获取不到值
	$.ajax({
		url : path + "repertory/repertorySelect",//请求的地址url,为字符串
		// 请求类型
		type: "post",
		
		// 请求的数据pojo
		data: vm.repertoryQuery,
		
		// 数据类型
		dataType : "json",

		// 是否异步,默认是true
		async:false, 

		// 请求成功后的 调用方法     data:是返回的数据信息
		success : function(data) { 
			// 界面list
			vm.repertoryList = data.code.list;
			
			// 一共多少页
			pages = data.code.pages;
			// 一共多少条记录
			total = data.code.total;
		}
	})
	
};



// 传递字符串方式
// 用户列表
function getRepertory2() {
	// ajax异步请求不会等待上一个请求,所以底下的"创建分页信息方法"获取不到值
	$.ajax({
		url : path + "repertory/repertorySelect2",//请求的地址url,为字符串
		// 请求类型
		type: "post",
		
		//请求的数据
		data: JSON.stringify(vm.repertoryQuery),
		
		// 数据类型
		dataType : "json",
		
		// 发送的数据类型
		contentType: 'application/json',
		// contentType: 'application/json;charset=UTF-8',

		// 是否异步,默认是true
		async:false, 

		// 请求成功后的 调用方法     data:是返回的数据信息
		success : function(data) { 
			// 界面list
			vm.repertoryList = data.code.list;
			
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
			// 调用初始化页码/页容量
			vm.init();
			// 调用查询用户的方法
			getRepertory();
		}
	})
};









