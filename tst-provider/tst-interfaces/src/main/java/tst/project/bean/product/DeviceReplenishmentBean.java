package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class DeviceReplenishmentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int replenishment_id;//
	private String replenishment_ids;//
	private String member_id;//申请人id
	private String member_account;//申请人账号
	private String device_id;//设备id
	private String device_no;//设备号
	private String replenishment_state;//补货状态 1:申请中 2:已接受 3:已拒绝 4:已结束
	private String replenishment_state_show;//补货状态 1:申请中 2:已接受 3:已拒绝 4:已结束
	private String replenishment_time;//补货时间
	
	private String loading_no;//上货号
	private String loading_state;//上货状态 0:未上货 1:已上货
	private String loading_state_show;//上货状态 0:未上货 1:已上货
	private String clerk_id;//上货员ID
	private String clerk_mobile;//上货员手机号
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	public String getReplenishment_ids() {
		return replenishment_ids;
	}
	public DeviceReplenishmentBean setReplenishment_ids(String replenishment_ids) {
		this.replenishment_ids = replenishment_ids;
		return this;
	}
	public int getReplenishment_id(){
		return replenishment_id;
	}
	public DeviceReplenishmentBean setReplenishment_id(int replenishment_id){
		this.replenishment_id= replenishment_id;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public DeviceReplenishmentBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	
	public String getMember_account() {
		return member_account;
	}
	public DeviceReplenishmentBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	public String getDevice_id(){
		return device_id;
	}
	public DeviceReplenishmentBean setDevice_id(String device_id){
		this.device_id= device_id;
		return this;
	}
	
	public String getDevice_no() {
		return device_no;
	}
	public DeviceReplenishmentBean setDevice_no(String device_no) {
		this.device_no = device_no;
		return this;
	}
	public String getReplenishment_state(){
		return replenishment_state;
	}
	public DeviceReplenishmentBean setReplenishment_state(String replenishment_state){
		this.replenishment_state= replenishment_state;////补货状态 1:申请中 2:已接受 3:已拒绝 4:已结束
		this.replenishment_state_show="1".equals(replenishment_state)?"申请中":
										"2".equals(replenishment_state)?"已接受":
										"3".equals(replenishment_state)?"已拒绝":"已结束";
		return this;
	}
	
	public String getReplenishment_state_show() {
		return replenishment_state_show;
	}
	public DeviceReplenishmentBean setReplenishment_state_show(String replenishment_state_show) {
		this.replenishment_state_show = replenishment_state_show;
		return this;
	}
	public String getReplenishment_time(){
		return replenishment_time;
	}
	public DeviceReplenishmentBean setReplenishment_time(String replenishment_time){
		this.replenishment_time= replenishment_time;
		return this;
	}
	
	public String getLoading_no() {
		return loading_no;
	}
	public DeviceReplenishmentBean setLoading_no(String loading_no) {
		this.loading_no = loading_no;
		return this;
	}
	public String getLoading_state() {
		return loading_state;
	}
	public DeviceReplenishmentBean setLoading_state(String loading_state) {
		this.loading_state = loading_state;//上货状态 0:未上货 1:已上货
		this.loading_state_show="0".equals(loading_state)?"未上货":"已上货";
		return this;
	}
	public String getLoading_state_show() {
		return loading_state_show;
	}
	public DeviceReplenishmentBean setLoading_state_show(String loading_state_show) {
		this.loading_state_show = loading_state_show;
		return this;
	}
	
	public String getClerk_id() {
		return clerk_id;
	}
	public DeviceReplenishmentBean setClerk_id(String clerk_id) {
		this.clerk_id = clerk_id;
		return this;
	}
	public String getClerk_mobile() {
		return clerk_mobile;
	}
	public DeviceReplenishmentBean setClerk_mobile(String clerk_mobile) {
		this.clerk_mobile = clerk_mobile;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public DeviceReplenishmentBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public DeviceReplenishmentBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public DeviceReplenishmentBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
