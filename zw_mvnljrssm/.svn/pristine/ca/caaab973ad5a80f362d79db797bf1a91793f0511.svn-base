/**
 * 公共js
 */

// 项目路径
var path = "http://127.0.0.1:8080/zw_mvnljrssm/";



//URL传参公用方法(h5新特性)
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	} else {
		return null;
	}
}