/**
 * 添加/修改
 */

var vm;

$(function(){
	vm = new Vue({
		el:'#app',
		data:{
			// 用户信息
			users:[],
			
			// 判断是添加还是修改,添加则显示,修改则删除
			isIf:''
		},
		methods:{
			// 提交
			userAddUpdate:function(){
				// 调用提交的ajax方法
				userAddUpdate();
			},
			
			// 修改显示之前信息
			show:function(){
				//获取url传参的id
				var userId = getUrlParam("userId");
				console.log(userId)
				console.log(typeof(userId))
				// 判断是否传入id进而判断是否显示用户名栏
				if (userId == -1) {
					// 添加模式
					this.isIf = true;
				} else {
					// 修改模式
					this.isIf = false;
				}
			}
		}
	});
	// 调用修改显示之前信息
	vm.show();
});


// 提交
function userAddUpdate(){
	$.ajax({
		// 请求url
		url:path + "UserServlet?action=userAddUpdate",
		// 请求方式
		type:"post",
		// 请求数据
		data:{
			"username":vm.users.username,
			"sex":vm.users.sex,
			"address":vm.users.address,
			"birthday":vm.users.birthday,
			"pwd":vm.users.pwd,
			"love":vm.users.love,
			"email":vm.users.email
		},
		// 响应类型
		dataType:"json",
		// 响应数据
		success:function(data){
			// 判断是否添加/修改成功
			if (data.code == 1) {
				// 清除缓存
				sessionStorage.removeItem("userLogin");
				
				alert("提交成功");
				// 回调用户列表页面
				window.location.href = path + "index.html";
			} else {
				alert("提交失败");
			}
		}
	})
}













