package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class PurchaseGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int purchase_goods_id;//
	private String purchase_id;//采购id
	private String supplier_id;//供应商id
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String goods_price;//采购价格
	private String purchase_stock;//采购库存
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getPurchase_goods_id(){
		return purchase_goods_id;
	}
	public PurchaseGoodsBean setPurchase_goods_id(int purchase_goods_id){
		this.purchase_goods_id= purchase_goods_id;
		return this;
	}
	public String getPurchase_id(){
		return purchase_id;
	}
	public PurchaseGoodsBean setPurchase_id(String purchase_id){
		this.purchase_id= purchase_id;
		return this;
	}
	public String getSupplier_id(){
		return supplier_id;
	}
	public PurchaseGoodsBean setSupplier_id(String supplier_id){
		this.supplier_id= supplier_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public PurchaseGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public PurchaseGoodsBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public PurchaseGoodsBean setGoods_price(String goods_price) {
		this.goods_price = goods_price;
		return this;
	}
	public String getPurchase_stock(){
		return purchase_stock;
	}
	public PurchaseGoodsBean setPurchase_stock(String purchase_stock){
		this.purchase_stock= purchase_stock;
		return this;
	}
	
	public String getIs_delete(){
		return is_delete;
	}
	public PurchaseGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public PurchaseGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public PurchaseGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
