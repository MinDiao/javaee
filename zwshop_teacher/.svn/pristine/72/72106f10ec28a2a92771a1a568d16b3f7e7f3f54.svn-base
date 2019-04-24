/**
 * Created by Administrator on 2017/8/25.
 */

var login; //登陆者信息
//登陆判断
$(function() {
	var loginUser = sessionStorage.getItem("loginUser"); //获取登陆用户信息
	if(loginUser != null && loginUser != '' && loginUser != undefined) {
		login = JSON.parse(loginUser);
	} else {
		layui.use('layer', function() {
			var layer = layui.layer;
			layer.msg("登陆信息过时，请重新登陆！")
			setTimeout(function() {
				window.location.href = "login.html";
			}, 1000);
		})
	}
})