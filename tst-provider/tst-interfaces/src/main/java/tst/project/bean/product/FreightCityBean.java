package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class FreightCityBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int freight_city_id;//
	private String freight_id;//
	private String province_ids;//
	private String province_names;//
	private String city_ids;//地区id 逗号隔开
	private String city_names;//地区名称 逗号隔开
	private String freight_range;//默认范围 如果按件 就是默认多少件  如果按体重 就是默认多少kg  如果按体积 就是默认多少平方米
	private String freight_price;//默认运费价格
	private String freight_add_range;//增加运费范围 如果按件 就是每增加多少件  如果按体重 就是每增加多少kg  如果按体积 就是每增加多少平方米
	private String freight_add_price;//增加运费价格
	private String is_delete;//0：未删除 1：删除
	private String create_time;//
	private String update_time;//
	public int getFreight_city_id(){
		return freight_city_id;
	}
	public FreightCityBean setFreight_city_id(int freight_city_id){
		this.freight_city_id= freight_city_id;
		return this;
	}
	public String getFreight_id(){
		return freight_id;
	}
	public FreightCityBean setFreight_id(String freight_id){
		this.freight_id= freight_id;
		return this;
	}
	public String getProvince_ids(){
		return province_ids;
	}
	public FreightCityBean setProvince_ids(String province_ids){
		this.province_ids= province_ids;
		return this;
	}
	public String getProvince_names(){
		return province_names;
	}
	public FreightCityBean setProvince_names(String province_names){
		this.province_names= province_names;
		return this;
	}
	public String getCity_ids(){
		return city_ids;
	}
	public FreightCityBean setCity_ids(String city_ids){
		this.city_ids= city_ids;
		return this;
	}
	public String getCity_names(){
		return city_names;
	}
	public FreightCityBean setCity_names(String city_names){
		this.city_names= city_names;
		return this;
	}
	public String getFreight_range(){
		return freight_range;
	}
	public FreightCityBean setFreight_range(String freight_range){
		this.freight_range= freight_range;
		return this;
	}
	public String getFreight_price(){
		return freight_price;
	}
	public FreightCityBean setFreight_price(String freight_price){
		this.freight_price= freight_price;
		return this;
	}
	public String getFreight_add_range(){
		return freight_add_range;
	}
	public FreightCityBean setFreight_add_range(String freight_add_range){
		this.freight_add_range= freight_add_range;
		return this;
	}
	public String getFreight_add_price(){
		return freight_add_price;
	}
	public FreightCityBean setFreight_add_price(String freight_add_price){
		this.freight_add_price= freight_add_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public FreightCityBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public FreightCityBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public FreightCityBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
