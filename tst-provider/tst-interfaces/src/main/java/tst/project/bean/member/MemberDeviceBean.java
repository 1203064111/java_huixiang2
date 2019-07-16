package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class MemberDeviceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_device_id;//
	private String member_id;//用户id
	private String member_account;//用户账号
	private String device_id;//设备id
	private String device_no;//设备号
	
	private String contact_name;//
	private String contact_mobile;//
	private String contact_remark;//
	
	private String apply_state;//1:申请中 2:已接受 3:已拒绝
	private String apply_state_show;//1:申请中 2:已接受 3:已拒绝
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getMember_device_id(){
		return member_device_id;
	}
	public MemberDeviceBean setMember_device_id(int member_device_id){
		this.member_device_id= member_device_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MemberDeviceBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	
	public String getDevice_no() {
		return device_no;
	}
	public MemberDeviceBean setDevice_no(String device_no) {
		this.device_no = device_no;
		return this;
	}
	public String getDevice_id(){
		return device_id;
	}
	public MemberDeviceBean setDevice_id(String device_id){
		this.device_id= device_id;
		return this;
	}
	
	public String getContact_name() {
		return contact_name;
	}
	public MemberDeviceBean setContact_name(String contact_name) {
		this.contact_name = contact_name;
		return this;
	}
	public String getContact_mobile() {
		return contact_mobile;
	}
	public MemberDeviceBean setContact_mobile(String contact_mobile) {
		this.contact_mobile = contact_mobile;
		return this;
	}
	public String getContact_remark() {
		return contact_remark;
	}
	public MemberDeviceBean setContact_remark(String contact_remark) {
		this.contact_remark = contact_remark;
		return this;
	}
	public String getMember_account() {
		return member_account;
	}
	public MemberDeviceBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	public String getApply_state(){
		return apply_state;
	}
	public MemberDeviceBean setApply_state(String apply_state){
		this.apply_state= apply_state;//1:申请中 2:已接受 3:已拒绝
		this.apply_state_show="1".equals(apply_state)?"申请中":
							"2".equals(apply_state)?"已接受":"已拒绝";
		return this;
	}
	
	public String getApply_state_show() {
		return apply_state_show;
	}
	public MemberDeviceBean setApply_state_show(String apply_state_show) {
		this.apply_state_show = apply_state_show;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberDeviceBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberDeviceBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberDeviceBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
