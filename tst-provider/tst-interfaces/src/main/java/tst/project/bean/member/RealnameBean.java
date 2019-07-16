package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class RealnameBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int realname_id;//
	private String member_id;//用户id
	private String realname_name;//实名姓名
	private String realname_mobile;//实名手机号
	private String realname_card;//实名身份证号
	private String realname_state;//1:待审核 2:已接收 3:已拒绝
	private String realname_state_show;//1:待审核 2:已接收 3:已拒绝
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getRealname_id(){
		return realname_id;
	}
	public RealnameBean setRealname_id(int realname_id){
		this.realname_id= realname_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public RealnameBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getRealname_name(){
		return realname_name;
	}
	public RealnameBean setRealname_name(String realname_name){
		this.realname_name= realname_name;
		return this;
	}
	public String getRealname_mobile(){
		return realname_mobile;
	}
	public RealnameBean setRealname_mobile(String realname_mobile){
		this.realname_mobile= realname_mobile;
		return this;
	}
	public String getRealname_card(){
		return realname_card;
	}
	public RealnameBean setRealname_card(String realname_card){
		this.realname_card= realname_card;
		return this;
	}
	
	public String getRealname_state() {
		return realname_state;
	}
	public RealnameBean setRealname_state(String realname_state) {
		this.realname_state = realname_state;//1:待审核 2:已接受 3:已拒绝
		this.realname_state_show="1".equals(realname_state)?"待审核":
								"2".equals(realname_state)?"已接受":"已拒绝";
		return this;
	}
	public String getRealname_state_show() {
		return realname_state_show;
	}
	public RealnameBean setRealname_state_show(String realname_state_show) {
		this.realname_state_show = realname_state_show;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public RealnameBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public RealnameBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public RealnameBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
