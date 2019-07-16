package tst.project.bean.setting;

import java.io.Serializable;

/**

**

*/

public class PercentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int percent_id;//
	private String percent_name;//
	private String percent_value;//
	private String percent_type;//integral:用户购买商品 积分抵扣比率   order：平台计算订单的汇率
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getPercent_id(){
		return percent_id;
	}
	public PercentBean setPercent_id(int percent_id){
		this.percent_id= percent_id;
		return this;
	}
	public String getPercent_name(){
		return percent_name;
	}
	public PercentBean setPercent_name(String percent_name){
		this.percent_name= percent_name;
		return this;
	}
	public String getPercent_value(){
		return percent_value;
	}
	public PercentBean setPercent_value(String percent_value){
		this.percent_value= percent_value;
		return this;
	}
	public String getPercent_type(){
		return percent_type;
	}
	public PercentBean setPercent_type(String percent_type){
		this.percent_type= percent_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public PercentBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public PercentBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public PercentBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
