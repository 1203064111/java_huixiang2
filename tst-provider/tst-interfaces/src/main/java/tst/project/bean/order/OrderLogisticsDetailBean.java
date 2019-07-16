package tst.project.bean.order;

import java.io.Serializable;

/**

**

*/

public class OrderLogisticsDetailBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int logistics_id;//
	private String logistics_no;//
	private String logistics_state;//2-在途中 3-签收 4-问题件
	private String logistics_time;//
	private String logistics_context;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getLogistics_id(){
		return logistics_id;
	}
	public OrderLogisticsDetailBean setLogistics_id(int logistics_id){
		this.logistics_id= logistics_id;
		return this;
	}
	public String getLogistics_no(){
		return logistics_no;
	}
	public OrderLogisticsDetailBean setLogistics_no(String logistics_no){
		this.logistics_no= logistics_no;
		return this;
	}
	public String getLogistics_state(){
		return logistics_state;
	}
	public OrderLogisticsDetailBean setLogistics_state(String logistics_state){
		this.logistics_state= logistics_state;
		return this;
	}
	public String getLogistics_time(){
		return logistics_time;
	}
	public OrderLogisticsDetailBean setLogistics_time(String logistics_time){
		this.logistics_time= logistics_time;
		return this;
	}
	public String getLogistics_context(){
		return logistics_context;
	}
	public OrderLogisticsDetailBean setLogistics_context(String logistics_context){
		this.logistics_context= logistics_context;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderLogisticsDetailBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderLogisticsDetailBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderLogisticsDetailBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
