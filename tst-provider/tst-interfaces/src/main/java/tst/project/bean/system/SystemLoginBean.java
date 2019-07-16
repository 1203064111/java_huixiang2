package tst.project.bean.system;

import java.io.Serializable;

/**

**

*/

public class SystemLoginBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String login_id;//
	private String account_id;//
	private String system_account;//登录账号
	private String system_name;//登录姓名
	private String login_ip;//登录ip
	private String login_address;//登录地址
	private String login_brower;//登录浏览器
	private String is_delete;//
	private String create_time;//
	private String update_tiem;//
	public String getLogin_id(){
		return login_id;
	}
	public SystemLoginBean setLogin_id(String login_id){
		this.login_id= login_id;
		return this;
	}
	public String getAccount_id(){
		return account_id;
	}
	public SystemLoginBean setAccount_id(String account_id){
		this.account_id= account_id;
		return this;
	}
	public String getSystem_account(){
		return system_account;
	}
	public SystemLoginBean setSystem_account(String system_account){
		this.system_account= system_account;
		return this;
	}
	public String getSystem_name(){
		return system_name;
	}
	public SystemLoginBean setSystem_name(String system_name){
		this.system_name= system_name;
		return this;
	}
	public String getLogin_ip(){
		return login_ip;
	}
	public SystemLoginBean setLogin_ip(String login_ip){
		this.login_ip= login_ip;
		return this;
	}
	public String getLogin_address(){
		return login_address;
	}
	public SystemLoginBean setLogin_address(String login_address){
		this.login_address= login_address;
		return this;
	}
	public String getLogin_brower(){
		return login_brower;
	}
	public SystemLoginBean setLogin_brower(String login_brower){
		this.login_brower= login_brower;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SystemLoginBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SystemLoginBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_tiem(){
		return update_tiem;
	}
	public SystemLoginBean setUpdate_tiem(String update_tiem){
		this.update_tiem= update_tiem;
		return this;
	}
}
