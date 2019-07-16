package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class AddressBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int address_id;//
	private String member_id;//
	private String address_mobile;//联系方式
	private String address_name;//收货人
	private String address_province;//省
	private String address_city;//市
	private String address_country;//区
	private String address_detailed;//详情地址
	private String address_road;//街道
	private String address_zip_code;//邮编
	private String address_longitude;//经度
	private String address_latitude;//维度
	private String is_default;//是否为默认地址
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String language;//语言
	public int getAddress_id(){
		return address_id;
	}
	public AddressBean setAddress_id(int address_id){
		this.address_id= address_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public AddressBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getAddress_mobile(){
		return address_mobile;
	}
	public AddressBean setAddress_mobile(String address_mobile){
		this.address_mobile= address_mobile;
		return this;
	}
	public String getAddress_name(){
		return address_name;
	}
	public AddressBean setAddress_name(String address_name){
		this.address_name= address_name;
		return this;
	}
	public String getAddress_province(){
		return address_province;
	}
	public AddressBean setAddress_province(String address_province){
		this.address_province= address_province;
		return this;
	}
	public String getAddress_city(){
		return address_city;
	}
	public AddressBean setAddress_city(String address_city){
		this.address_city= address_city;
		return this;
	}
	public String getAddress_country(){
		return address_country;
	}
	public AddressBean setAddress_country(String address_country){
		this.address_country= address_country;
		return this;
	}
	public String getAddress_detailed(){
		return address_detailed;
	}
	public AddressBean setAddress_detailed(String address_detailed){
		this.address_detailed= address_detailed;
		return this;
	}
	public String getAddress_road(){
		return address_road;
	}
	public AddressBean setAddress_road(String address_road){
		this.address_road= address_road;
		return this;
	}
	public String getAddress_zip_code(){
		return address_zip_code;
	}
	public AddressBean setAddress_zip_code(String address_zip_code){
		this.address_zip_code= address_zip_code;
		return this;
	}
	public String getAddress_longitude(){
		return address_longitude;
	}
	public AddressBean setAddress_longitude(String address_longitude){
		this.address_longitude= address_longitude;
		return this;
	}
	public String getAddress_latitude(){
		return address_latitude;
	}
	public AddressBean setAddress_latitude(String address_latitude){
		this.address_latitude= address_latitude;
		return this;
	}
	public String getIs_default(){
		return is_default;
	}
	public AddressBean setIs_default(String is_default){
		this.is_default= is_default;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public AddressBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public AddressBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public AddressBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getLanguage(){
		return language;
	}
	public AddressBean setLanguage(String language){
		this.language= language;
		return this;
	}
}
