package tst.project.bean.order;

import java.io.Serializable;
import java.util.List;

import tst.project.bean.product.GoodsBatchBean;
import tst.project.bean.product.OrderProductBatchBean;

/**

**

*/

public class OrderProductGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_product_goods_id;//
	private String order_id;//订单id
	private String order_merchants_id;//订单关联商家id
	private String order_product_id;//订单关联产品id
	private String specification_id;//产品规格id
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String goods_sku;//商品sku
	private String goods_type;//商品类型
	private String goods_num;//商品数量
	
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	private List<OrderProductBatchBean> orderProductBatchBeans;//商品批次列表
	
	public int getOrder_product_goods_id(){
		return order_product_goods_id;
	}
	public OrderProductGoodsBean setOrder_product_goods_id(int order_product_goods_id){
		this.order_product_goods_id= order_product_goods_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderProductGoodsBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderProductGoodsBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getOrder_product_id(){
		return order_product_id;
	}
	public OrderProductGoodsBean setOrder_product_id(String order_product_id){
		this.order_product_id= order_product_id;
		return this;
	}
	
	public String getSpecification_id() {
		return specification_id;
	}
	public OrderProductGoodsBean setSpecification_id(String specification_id) {
		this.specification_id = specification_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public OrderProductGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public OrderProductGoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	public String getGoods_sku(){
		return goods_sku;
	}
	public OrderProductGoodsBean setGoods_sku(String goods_sku){
		this.goods_sku= goods_sku;
		return this;
	}
	public String getGoods_type(){
		return goods_type;
	}
	public OrderProductGoodsBean setGoods_type(String goods_type){
		this.goods_type= goods_type;
		return this;
	}
	public String getGoods_num(){
		return goods_num;
	}
	public OrderProductGoodsBean setGoods_num(String goods_num){
		this.goods_num= goods_num;
		return this;
	}
	

	public String getIs_delete(){
		return is_delete;
	}
	public OrderProductGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderProductGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderProductGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public List<OrderProductBatchBean> getOrderProductBatchBeans() {
		return orderProductBatchBeans;
	}
	public OrderProductGoodsBean setOrderProductBatchBeans(List<OrderProductBatchBean> orderProductBatchBeans) {
		this.orderProductBatchBeans = orderProductBatchBeans;
		return this;
	}
}
