package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class ProductCarBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int car_id;//
	private String car_ids;//
	private String shop_id;//店铺id -1:平台
	private String member_id;//用户id
	private String product_id;//产品id
	private String product_name;//产品名称
	private String specification_id;//规格id
	private String specification_name;//规格名称
	private String specification_img;//规格图片
	private String specification_price;//规格价格
	private String car_num;//购物车数量
	private String is_delete;//1删除
	private String create_time;//
	private String update_time;//
	public int getCar_id(){
		return car_id;
	}
	public ProductCarBean setCar_id(int car_id){
		this.car_id= car_id;
		return this;
	}
	
	public String getCar_ids() {
		return car_ids;
	}
	public ProductCarBean setCar_ids(String car_ids) {
		this.car_ids = car_ids;
		return this;
	}
	public String getShop_id(){
		return shop_id;
	}
	public ProductCarBean setShop_id(String shop_id){
		this.shop_id= shop_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public ProductCarBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public ProductCarBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public ProductCarBean setProduct_name(String product_name) {
		this.product_name = product_name;
		return this;
	}
	public String getSpecification_id(){
		return specification_id;
	}
	public ProductCarBean setSpecification_id(String specification_id){
		this.specification_id= specification_id;
		return this;
	}
	
	public String getSpecification_name() {
		return specification_name;
	}
	public ProductCarBean setSpecification_name(String specification_name) {
		this.specification_name = specification_name;
		return this;
	}
	public String getSpecification_img() {
		return specification_img;
	}
	public ProductCarBean setSpecification_img(String specification_img) {
		this.specification_img = specification_img;
		return this;
	}
	public String getSpecification_price() {
		return specification_price;
	}
	public ProductCarBean setSpecification_price(String specification_price) {
		this.specification_price = specification_price;
		return this;
	}
	public String getCar_num(){
		return car_num;
	}
	public ProductCarBean setCar_num(String car_num){
		this.car_num= car_num;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ProductCarBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ProductCarBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ProductCarBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
