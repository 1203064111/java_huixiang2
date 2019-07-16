package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class ServiceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int service_id;//
	private String service_ids;//
	private String service_name;//服务名称
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getService_id(){
		return service_id;
	}
	public ServiceBean setService_id(int service_id){
		this.service_id= service_id;
		return this;
	}
	
	public String getService_ids() {
		return service_ids;
	}
	public ServiceBean setService_ids(String service_ids) {
		this.service_ids = service_ids;
		return this;
	}
	public String getService_name(){
		return service_name;
	}
	public ServiceBean setService_name(String service_name){
		this.service_name= service_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ServiceBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ServiceBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ServiceBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
