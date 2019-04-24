layui.use(['form', 'layer'], function() {
	var form = layui.form;
	var layer = layui.layer;

	//表单提交
	form.on('submit(add)', function(data) {
		//layer.alert(JSON.stringify(data.field));
		if($("#password").val() != $("#password_r").val()) {
			layer.msg("两次密码输入不一致");
			return false;
		}

		var pwd_md5 = hex_md5($("#password").val()); //进行md5加密
		//$("#password_md5").val(pwd_md5);
		//console.log(JSON.stringify(data.field))
		data.field.password = pwd_md5; // 给 待提交的 表单数据 赋值
		//data.field.sex="男";
		//console.log(JSON.stringify(data.field))
		$.ajax({
			url: basePath + "sys_user/add", //添加管理员
			type: "post",
			data: data.field,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					layer.msg("操作成功", { icon: 6 });
					setTimeout(function() {
						window.location.href = "sys_user.html";
					}, 2000);
					/*layer.alert("操作成功",function(){
						window.location.href = "sys_user.html";
					})*/
				} else {
					layer.msg("操作失败", { icon: 5 });
				}
			},
			error: function() {
				layer.msg("操作失败", { icon: 5 });
			}
		})
		return false;
	})

})