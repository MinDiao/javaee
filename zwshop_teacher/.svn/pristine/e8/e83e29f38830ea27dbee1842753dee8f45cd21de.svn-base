/**
 * 全局公共的js
 */

//项目路径
var basePath = "http://127.0.0.1:8080/zwshop/";

var login; //登陆者信息

//登陆判断
$(function() {
	var loginUser = sessionStorage.getItem("loginUser"); //获取登陆用户信息
	if(loginUser != null && loginUser != '' && loginUser != undefined) {
		login = JSON.parse(loginUser);
	} else {
		layui.use('layer', function() {
			var layer = layui.layer;
			/*layer.msg("登陆信息过时，请重新登陆！")
			setTimeout(function() {
				parent.location.reload();
			}, 1000);*/
			layer.alert("登陆信息过时，请重新登陆！",function(){
				parent.location.reload();
			})
		})
	}
})