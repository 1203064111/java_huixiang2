package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class DeviceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int device_id;//
	private String device_ids;//
	private String member_id;
	private String clerk_id;//上货员id
	private String device_version;//设备型号
	private String device_no;//设备编号
	private String device_name;//设备名称
	private String device_img;//设备图片
	private String device_province;//设备所属省
	private String device_city;//设备所属市
	private String device_country;//设备所属区
	private String device_address;//设备详细地址
	private String device_longitude;//设备经度
	private String device_latitude;//设备纬度
	private String device_count;//设备货道数量
	private String remind_stock;//需要提醒的库存数量
	private String apply_state;//0:未有人领取 1:已有人领取
	private String apply_state_show;//0:未有人领取 1:已有人领取
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String is_apply;//0:自己未申请 1:自己已申请
	private List<DeviceCargoBean> deviceCargoBeans;//货道列表
	
	public int getDevice_id(){
		return device_id;
	}
	public DeviceBean setDevice_id(int device_id){
		this.device_id= device_id;
		return this;
	}
	
	public String getDevice_ids() {
		return device_ids;
	}
	public DeviceBean setDevice_ids(String device_ids) {
		this.device_ids = device_ids;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public DeviceBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	
	public String getClerk_id() {
		return clerk_id;
	}
	public DeviceBean setClerk_id(String clerk_id) {
		this.clerk_id = clerk_id;
		return this;
	}
	public String getDevice_version(){
		return device_version;
	}
	public DeviceBean setDevice_version(String device_version){
		this.device_version= device_version;
		return this;
	}
	public String getDevice_no(){
		return device_no;
	}
	public DeviceBean setDevice_no(String device_no){
		this.device_no= device_no;
		return this;
	}
	public String getDevice_name(){
		return device_name;
	}
	public DeviceBean setDevice_name(String device_name){
		this.device_name= device_name;
		return this;
	}
	public String getDevice_img(){
		return device_img;
	}
	public DeviceBean setDevice_img(String device_img){
		this.device_img= device_img;
		return this;
	}
	
	public String getDevice_province() {
		return device_province;
	}
	public DeviceBean setDevice_province(String device_province) {
		this.device_province = device_province;
		return this;
	}
	public String getDevice_city(){
		return device_city;
	}
	public DeviceBean setDevice_city(String device_city){
		this.device_city= device_city;
		return this;
	}
	public String getDevice_country(){
		return device_country;
	}
	public DeviceBean setDevice_country(String device_country){
		this.device_country= device_country;
		return this;
	}
	public String getDevice_address(){
		return device_address;
	}
	public DeviceBean setDevice_address(String device_address){
		this.device_address= device_address;
		return this;
	}
	public String getDevice_longitude(){
		return device_longitude;
	}
	public DeviceBean setDevice_longitude(String device_longitude){
		this.device_longitude= device_longitude;
		return this;
	}
	public String getDevice_latitude(){
		return device_latitude;
	}
	public DeviceBean setDevice_latitude(String device_latitude){
		this.device_latitude= device_latitude;
		return this;
	}
	public String getDevice_count(){
		return device_count;
	}
	public DeviceBean setDevice_count(String device_count){
		this.device_count= device_count;
		return this;
	}
	public String getRemind_stock(){
		return remind_stock;
	}
	public DeviceBean setRemind_stock(String remind_stock){
		this.remind_stock= remind_stock;
		return this;
	}
	public String getApply_state() {
		return apply_state;
	}
	public DeviceBean setApply_state(String apply_state) {
		this.apply_state = apply_state;//0:未有人领取 1:已有人领取
		this.apply_state_show="0".equals(apply_state)?"未有人领取":
							    "1".equals(apply_state)?"已有人领取":"";
		return this;
	}
	
	public String getApply_state_show() {
		return apply_state_show;
	}
	public DeviceBean setApply_state_show(String apply_state_show) {
		this.apply_state_show = apply_state_show;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public DeviceBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public DeviceBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public DeviceBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public String getIs_apply() {
		return is_apply;
	}
	public DeviceBean setIs_apply(String is_apply) {
		this.is_apply = is_apply;
		return this;
	}
	public List<DeviceCargoBean> getDeviceCargoBeans() {
		return deviceCargoBeans;
	}
	public DeviceBean setDeviceCargoBeans(List<DeviceCargoBean> deviceCargoBeans) {
		this.deviceCargoBeans = deviceCargoBeans;
		return this;
	}
	
}
