package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class SupplierGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int supplier_goods_id;//
	private String supplier_goods_ids;//
	private String supplier_id;//供应商id
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String goods_sku;//商品sku
	private String goods_price;//商品价格
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getSupplier_goods_id(){
		return supplier_goods_id;
	}
	public SupplierGoodsBean setSupplier_goods_id(int supplier_goods_id){
		this.supplier_goods_id= supplier_goods_id;
		return this;
	}
	
	public String getSupplier_goods_ids() {
		return supplier_goods_ids;
	}
	public SupplierGoodsBean setSupplier_goods_ids(String supplier_goods_ids) {
		this.supplier_goods_ids = supplier_goods_ids;
		return this;
	}
	public String getSupplier_id(){
		return supplier_id;
	}
	public SupplierGoodsBean setSupplier_id(String supplier_id){
		this.supplier_id= supplier_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public SupplierGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public SupplierGoodsBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public SupplierGoodsBean setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
		return this;
	}
	public String getGoods_price(){
		return goods_price;
	}
	public SupplierGoodsBean setGoods_price(String goods_price){
		this.goods_price= goods_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SupplierGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SupplierGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SupplierGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
