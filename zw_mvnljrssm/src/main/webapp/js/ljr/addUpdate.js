/**
 * 添加/修改
 */

// 初始化Vue对象
var vm;

// jq局部dom加载
$(function(){
	vm = new Vue({
		el:'#app',
		data:{
			// 用户信息
			users:[],
			// 用户爱好
			love:[],
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
					// 将传过来的用户id映射至vue对象中
					this.users.id = userId;
				}
			}
		}
	});
	
	// 调用修改显示之前信息
	vm.show();
	// 调用进入页面后执行根据id查询用户信息的回显
	selectUserByIdUpdateBackShow();
});



/*进入页面后执行根据id查询用户信息的回显*/
function selectUserByIdUpdateBackShow() {
	$.ajax({
		// 请求地址
		url: path + "user/selectUserByIdUpdateBackShow",
		// 请求方式
		type: 'post',
		// 请求数据
		data: {
			id: vm.users.id
		},
		// 响应类型
		dataType: 'json',
		// 响应数据
		success: function(data){
			// 将数据填充至Vue对象
			vm.users = data.code;
			// 接收用户爱好字符串
			var copyUserLove = data.code.love;
			// 将爱好字符串按照逗号","转为字符数组
			var userLoveStrs = copyUserLove.split(',');
			// 将用户爱好字符串填充至Vue对象
			vm.love = userLoveStrs;
		}
	})
}




// 提交
function userAddUpdate(){
	$.ajax({
		// 请求url
		url:path + "user/userAddUpdate",
		// 请求方式
		type:"post",
		// 请求数据
		data:{
			"id":vm.users.id,
			"username":vm.users.username,
			"sex":vm.users.sex,
			"address":vm.users.address,
			"birthday":vm.users.birthday,
			"pwd":vm.users.pwd,
			"email":vm.users.email,
			// 用户爱好多选框(将数组转换为字符串)
			"love":vm.love+''
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







