package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class FreightFreeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int freight_free_id;//
	private String freight_id;//
	private String province_ids;//省id 逗号隔开
	private String province_names;//省名称 逗号隔开
	private String city_ids;//地区id 逗号隔开
	private String city_names;//地区名称 逗号隔开
	private String free_range;//免邮的设置范围 （件/重量/体积）
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getFreight_free_id(){
		return freight_free_id;
	}
	public FreightFreeBean setFreight_free_id(int freight_free_id){
		this.freight_free_id= freight_free_id;
		return this;
	}
	public String getFreight_id(){
		return freight_id;
	}
	public FreightFreeBean setFreight_id(String freight_id){
		this.freight_id= freight_id;
		return this;
	}
	public String getProvince_ids(){
		return province_ids;
	}
	public FreightFreeBean setProvince_ids(String province_ids){
		this.province_ids= province_ids;
		return this;
	}
	public String getProvince_names(){
		return province_names;
	}
	public FreightFreeBean setProvince_names(String province_names){
		this.province_names= province_names;
		return this;
	}
	public String getCity_ids(){
		return city_ids;
	}
	public FreightFreeBean setCity_ids(String city_ids){
		this.city_ids= city_ids;
		return this;
	}
	public String getCity_names(){
		return city_names;
	}
	public FreightFreeBean setCity_names(String city_names){
		this.city_names= city_names;
		return this;
	}
	public String getFree_range(){
		return free_range;
	}
	public FreightFreeBean setFree_range(String free_range){
		this.free_range= free_range;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public FreightFreeBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public FreightFreeBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public FreightFreeBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
