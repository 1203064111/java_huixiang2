package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class ShopProductBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int shop_product_id;//
	private String member_id;//用户id
	private String shop_id;//店铺id
	private String product_id;//产品id
	private String product_name;//产品名称
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	public int getShop_product_id() {
		return shop_product_id;
	}
	public ShopProductBean setShop_product_id(int shop_product_id) {
		this.shop_product_id = shop_product_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public ShopProductBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	
	public String getShop_id() {
		return shop_id;
	}
	public ShopProductBean setShop_id(String shop_id) {
		this.shop_id = shop_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public ShopProductBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public ShopProductBean setProduct_name(String product_name) {
		this.product_name = product_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ShopProductBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ShopProductBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ShopProductBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
