package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class DeviceClerkBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int clerk_id;//
	private String clerk_ids;//
	private String clerk_name;//店员名称
	private String clerk_img;//店员头像
	private String clerk_mobile;//店员手机号
	private String clerk_area;//店员负责区域
	private String clerk_remark;//备注
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getClerk_id(){
		return clerk_id;
	}
	public DeviceClerkBean setClerk_id(int clerk_id){
		this.clerk_id= clerk_id;
		return this;
	}
	
	public String getClerk_ids() {
		return clerk_ids;
	}
	public DeviceClerkBean setClerk_ids(String clerk_ids) {
		this.clerk_ids = clerk_ids;
		return this;
	}
	public String getClerk_name(){
		return clerk_name;
	}
	public DeviceClerkBean setClerk_name(String clerk_name){
		this.clerk_name= clerk_name;
		return this;
	}
	public String getClerk_img(){
		return clerk_img;
	}
	public DeviceClerkBean setClerk_img(String clerk_img){
		this.clerk_img= clerk_img;
		return this;
	}
	public String getClerk_mobile(){
		return clerk_mobile;
	}
	public DeviceClerkBean setClerk_mobile(String clerk_mobile){
		this.clerk_mobile= clerk_mobile;
		return this;
	}
	public String getClerk_area(){
		return clerk_area;
	}
	public DeviceClerkBean setClerk_area(String clerk_area){
		this.clerk_area= clerk_area;
		return this;
	}
	public String getClerk_remark(){
		return clerk_remark;
	}
	public DeviceClerkBean setClerk_remark(String clerk_remark){
		this.clerk_remark= clerk_remark;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public DeviceClerkBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public DeviceClerkBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public DeviceClerkBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
