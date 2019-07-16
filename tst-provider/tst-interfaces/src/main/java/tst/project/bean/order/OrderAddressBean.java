package tst.project.bean.order;

import java.io.Serializable;

/**

**

*/

public class OrderAddressBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_address_id;//
	private String order_id;//订单id
	private String address_id;//地址id
	private String address_mobile;//收货人手机号
	private String address_name;//收货人姓名
	private String address_province;//收货人省
	private String address_city;//收货市
	private String address_country;//收货区
	private String address_detailed;//收货详情地址
	private String address_road;//收货路
	private String address_zip_code;//收货邮编
	private String address_longitude;//收货经度
	private String address_latitude;//收货纬度
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getOrder_address_id(){
		return order_address_id;
	}
	public OrderAddressBean setOrder_address_id(int order_address_id){
		this.order_address_id= order_address_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderAddressBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getAddress_id(){
		return address_id;
	}
	public OrderAddressBean setAddress_id(String address_id){
		this.address_id= address_id;
		return this;
	}
	public String getAddress_mobile(){
		return address_mobile;
	}
	public OrderAddressBean setAddress_mobile(String address_mobile){
		this.address_mobile= address_mobile;
		return this;
	}
	public String getAddress_name(){
		return address_name;
	}
	public OrderAddressBean setAddress_name(String address_name){
		this.address_name= address_name;
		return this;
	}
	public String getAddress_province(){
		return address_province;
	}
	public OrderAddressBean setAddress_province(String address_province){
		this.address_province= address_province;
		return this;
	}
	public String getAddress_city(){
		return address_city;
	}
	public OrderAddressBean setAddress_city(String address_city){
		this.address_city= address_city;
		return this;
	}
	public String getAddress_country(){
		return address_country;
	}
	public OrderAddressBean setAddress_country(String address_country){
		this.address_country= address_country;
		return this;
	}
	public String getAddress_detailed(){
		return address_detailed;
	}
	public OrderAddressBean setAddress_detailed(String address_detailed){
		this.address_detailed= address_detailed;
		return this;
	}
	public String getAddress_road(){
		return address_road;
	}
	public OrderAddressBean setAddress_road(String address_road){
		this.address_road= address_road;
		return this;
	}
	public String getAddress_zip_code(){
		return address_zip_code;
	}
	public OrderAddressBean setAddress_zip_code(String address_zip_code){
		this.address_zip_code= address_zip_code;
		return this;
	}
	public String getAddress_longitude(){
		return address_longitude;
	}
	public OrderAddressBean setAddress_longitude(String address_longitude){
		this.address_longitude= address_longitude;
		return this;
	}
	public String getAddress_latitude(){
		return address_latitude;
	}
	public OrderAddressBean setAddress_latitude(String address_latitude){
		this.address_latitude= address_latitude;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderAddressBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderAddressBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderAddressBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
