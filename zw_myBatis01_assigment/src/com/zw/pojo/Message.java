package com.zw.pojo;
/**
 * 
 * 类描述：帖子实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月18日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class Message {

	private int msgid;
	
	private int userid;
	
	private String msgtopic;
	
	private String msgcontents;
	
	private String msgtime;
	
	private String msgip;

	public Message() {
		
	}

	public Message(int userid, String msgtopic, String msgcontents, String msgtime, String msgip) {
		this.userid = userid;
		this.msgtopic = msgtopic;
		this.msgcontents = msgcontents;
		this.msgtime = msgtime;
		this.msgip = msgip;
	}

	public int getMsgid() {
		return msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getMsgtopic() {
		return msgtopic;
	}

	public void setMsgtopic(String msgtopic) {
		this.msgtopic = msgtopic;
	}

	public String getMsgcontents() {
		return msgcontents;
	}

	public void setMsgcontents(String msgcontents) {
		this.msgcontents = msgcontents;
	}

	public String getMsgtime() {
		return msgtime;
	}

	public void setMsgtime(String msgtime) {
		this.msgtime = msgtime;
	}

	public String getMsgip() {
		return msgip;
	}

	public void setMsgip(String msgip) {
		this.msgip = msgip;
	}

	@Override
	public String toString() {
		return "Message [msgid=" + msgid + ", userid=" + userid + ", msgtopic=" + msgtopic + ", msgcontents="
				+ msgcontents + ", msgtime=" + msgtime + ", msgip=" + msgip + "]";
	}
}
