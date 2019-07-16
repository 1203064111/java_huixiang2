package tst.project.bean.product;

import javax.crypto.SecretKey;
import javax.servlet.ServletContext;
import java.io.Serializable;

/**

**

*/

public class ShopBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int shop_id;//
	private String member_id;//
	private String shop_name;//商家名称
	private String shop_img;//商家logo
	
	private String shop_address;//商家地址
	private String shop_account;//联系人
	private String shop_phone;//联系人手机号
	private String is_lock;//是否锁定  0否 1是
	private String is_lock_show;//是否锁定  0否 1是
	
	private String is_collection;
	private String collection_count;
	
	private String apply_state;//1:待审核 2:通过 3:拒绝
	private String apply_state_show;//1:待审核 2:通过 3:拒绝
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getShop_id(){
		return shop_id;
	}
	public ShopBean setShop_id(int shop_id){
		this.shop_id= shop_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public ShopBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getShop_name(){
		return shop_name;
	}
	public ShopBean setShop_name(String shop_name){
		this.shop_name= shop_name;
		return this;
	}
	public String getShop_img(){
		return shop_img;
	}
	public ShopBean setShop_img(String shop_img){
		this.shop_img= shop_img;
		return this;
	}
	

	public String getShop_address() {
		return shop_address;
	}
	public ShopBean setShop_address(String shop_address) {
		this.shop_address = shop_address;
		return this;
	}
	public String getShop_account() {
		return shop_account;
	}
	public ShopBean setShop_account(String shop_account) {
		this.shop_account = shop_account;
		return this;
	}
	public String getShop_phone() {
		return shop_phone;
	}
	public ShopBean setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
		return this;
	}
	
	public String getIs_lock() {
		return is_lock;
	}
	public ShopBean setIs_lock(String is_lock) {
		this.is_lock = is_lock;//是否锁定  0否 1是
		this.is_lock_show="0".equals(is_lock)?"未锁定":"已锁定";
		return this;
	}
	
	public String getIs_lock_show() {
		return is_lock_show;
	}
	public ShopBean setIs_lock_show(String is_lock_show) {
		this.is_lock_show = is_lock_show;
		return this;
	}
	
	public String getIs_collection() {
		return is_collection;
	}
	public ShopBean setIs_collection(String is_collection) {
		this.is_collection = is_collection;
		return this;
	}
	
	public String getCollection_count() {
		return collection_count;
	}
	public ShopBean setCollection_count(String collection_count) {
		this.collection_count = collection_count;
		return this;
	}
	
	
	public String getApply_state() {
		return apply_state;
	}
	public ShopBean setApply_state(String apply_state) {
		this.apply_state = apply_state;
		this.apply_state_show="1".equals(apply_state)?"待审核":
							"2".equals(apply_state)?"已通过":
							"3".equals(apply_state)?"已拒绝":"未知";
		
		return this;
	}
	
	public String getApply_state_show() {
		return apply_state_show;
	}
	public ShopBean setApply_state_show(String apply_state_show) {
		this.apply_state_show = apply_state_show;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ShopBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ShopBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ShopBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}