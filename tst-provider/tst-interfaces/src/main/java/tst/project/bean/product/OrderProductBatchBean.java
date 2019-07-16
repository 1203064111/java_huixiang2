package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class OrderProductBatchBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_product_batch_id;//
	private String order_product_goods_id;//
	private String order_id;//
	private String order_merchants_id;//
	private String order_product_id;//
	private String goods_id;//商品id
	private String batch_id;//批次id
	private String purchase_id;//采购id
	private String batch_no;//批次号
	private String batch_price;//本批次价格
	private String batch_stock;//本批次库存
	private String batch_now_stock;//本批次此时的库存
	private String replenishment_batch_id;

	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getOrder_product_batch_id(){
		return order_product_batch_id;
	}
	public OrderProductBatchBean setOrder_product_batch_id(int order_product_batch_id){
		this.order_product_batch_id= order_product_batch_id;
		return this;
	}
	public String getOrder_product_goods_id(){
		return order_product_goods_id;
	}
	public OrderProductBatchBean setOrder_product_goods_id(String order_product_goods_id){
		this.order_product_goods_id= order_product_goods_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderProductBatchBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderProductBatchBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getOrder_product_id(){
		return order_product_id;
	}
	public OrderProductBatchBean setOrder_product_id(String order_product_id){
		this.order_product_id= order_product_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public OrderProductBatchBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getBatch_id(){
		return batch_id;
	}
	public OrderProductBatchBean setBatch_id(String batch_id){
		this.batch_id= batch_id;
		return this;
	}
	public String getPurchase_id(){
		return purchase_id;
	}
	public OrderProductBatchBean setPurchase_id(String purchase_id){
		this.purchase_id= purchase_id;
		return this;
	}
	public String getBatch_no(){
		return batch_no;
	}
	public OrderProductBatchBean setBatch_no(String batch_no){
		this.batch_no= batch_no;
		return this;
	}
	public String getBatch_price(){
		return batch_price;
	}
	public OrderProductBatchBean setBatch_price(String batch_price){
		this.batch_price= batch_price;
		return this;
	}
	public String getBatch_stock(){
		return batch_stock;
	}
	public OrderProductBatchBean setBatch_stock(String batch_stock){
		this.batch_stock= batch_stock;
		return this;
	}
	public String getBatch_now_stock(){
		return batch_now_stock;
	}
	public OrderProductBatchBean setBatch_now_stock(String batch_now_stock){
		this.batch_now_stock= batch_now_stock;
		return this;
	}
	
	public String getReplenishment_batch_id() {
		return replenishment_batch_id;
	}
	public OrderProductBatchBean setReplenishment_batch_id(String replenishment_batch_id) {
		this.replenishment_batch_id = replenishment_batch_id;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderProductBatchBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderProductBatchBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderProductBatchBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
