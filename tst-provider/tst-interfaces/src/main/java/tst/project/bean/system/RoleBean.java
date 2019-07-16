package tst.project.bean.system;

import java.io.Serializable;

/**

**

*/

public class RoleBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int role_id;//
	private String role_ids;//
	private String role_name;//
	private String role_type;//1:平台角色 2:商家角色
	private String role_type_show;//1:平台角色 2:商家角色
	private String merchants_id;
	private String is_delete;//1:删除
	private String create_time;//
	private String update_time;//
	
	public int getRole_id(){
		return role_id;
	}
	public RoleBean setRole_id(int role_id){
		this.role_id= role_id;
		return this;
	}
	
	
	public String getRole_ids() {
		return role_ids;
	}
	public RoleBean setRole_ids(String role_ids) {
		this.role_ids = role_ids;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public RoleBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getRole_name(){
		return role_name;
	}
	public RoleBean setRole_name(String role_name){
		this.role_name= role_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public RoleBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public RoleBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public RoleBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getRole_type() {
		return role_type;
	}
	public RoleBean setRole_type(String role_type) {
		this.role_type = role_type;
		this.role_type_show="1".equals(role_type)?"平台角色":"商家角色";
		return this;
	}
	public String getRole_type_show() {
		return role_type_show;
	}
	public RoleBean setRole_type_show(String role_type_show) {
		this.role_type_show = role_type_show;
		return this;
	}
}
