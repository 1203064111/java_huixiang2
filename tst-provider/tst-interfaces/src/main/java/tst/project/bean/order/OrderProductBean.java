package tst.project.bean.order;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class OrderProductBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_product_id;//
	private String order_id;//订单id
	private String order_merchants_id;//
	private String product_id;//商品id
	private String product_name;//商品名称
	private String product_img;//商品图片连接
	private String product_weight;//产品重量
	private String product_volume;//产品体积
	private String product_count;//购买数量
	private String specification_id;//规格id
	private String group_price;//
	private String specification_name;//规格组合名称
	private String specification_stock;//规格库存
	private String specification_img;//规格图片
	private String specification_price;//
	private String product_total_price;//产品总价
	private String product_actual_price;//用户实际支付计算出来的价格
	private String profit_price;//销售可得价格
	private String freight_id;//邮费id
	private String freight_type;//1:按件 2:按重 3:按体积
	private String freight_way;//1:买家承担运费 2:卖家承担运费
	private String freight_range;//默认范围 如果按件 就是默认多少件  如果按体重 就是默认多少kg  如果按体积 就是默认多少平方米
	private String freight_price;//默认运费价格
	private String freight_add_range;//增加运费范围 如果按件 就是每增加多少件  如果按体重 就是每增加多少kg  如果按体积 就是每增加多少平方米
	private String freight_add_price;//增加运费价格
	private String free_range;//免邮的设置范围 （件/重量/体积）
	private String is_assessment;//是否评价 0:未 1:已评价
	private String is_challenge;//是否挑战过 0未 1是
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String member_id;//用户id
	private List<OrderProductGoodsBean> orderProductGoodsBeans;//产品管理商品表
	public int getOrder_product_id(){
		return order_product_id;
	}
	public OrderProductBean setOrder_product_id(int order_product_id){
		this.order_product_id= order_product_id;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public OrderProductBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderProductBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderProductBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public OrderProductBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	public String getProduct_name(){
		return product_name;
	}
	public OrderProductBean setProduct_name(String product_name){
		this.product_name= product_name;
		return this;
	}
	public String getProduct_img(){
		return product_img;
	}
	public OrderProductBean setProduct_img(String product_img){
		this.product_img= product_img;
		return this;
	}
	
	public String getProduct_weight() {
		return product_weight;
	}
	public OrderProductBean setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
		return this;
	}
	public String getProduct_volume() {
		return product_volume;
	}
	public OrderProductBean setProduct_volume(String product_volume) {
		this.product_volume = product_volume;
		return this;
	}
	public String getProduct_count(){
		return product_count;
	}
	public OrderProductBean setProduct_count(String product_count){
		this.product_count= product_count;
		return this;
	}
	public String getSpecification_id(){
		return specification_id;
	}
	public OrderProductBean setSpecification_id(String specification_id){
		this.specification_id= specification_id;
		return this;
	}
	public String getGroup_price(){
		return group_price;
	}
	public OrderProductBean setGroup_price(String group_price){
		this.group_price= group_price;
		return this;
	}
	public String getSpecification_name(){
		return specification_name;
	}
	public OrderProductBean setSpecification_name(String specification_name){
		this.specification_name= specification_name;
		return this;
	}
	public String getSpecification_stock(){
		return specification_stock;
	}
	public OrderProductBean setSpecification_stock(String specification_stock){
		this.specification_stock= specification_stock;
		return this;
	}
	public String getSpecification_img(){
		return specification_img;
	}
	public OrderProductBean setSpecification_img(String specification_img){
		this.specification_img= specification_img;
		return this;
	}
	public String getSpecification_price(){
		return specification_price;
	}
	public OrderProductBean setSpecification_price(String specification_price){
		this.specification_price= specification_price;
		return this;
	}
	public String getProduct_total_price(){
		return product_total_price;
	}
	public OrderProductBean setProduct_total_price(String product_total_price){
		this.product_total_price= product_total_price;
		return this;
	}
	public String getProduct_actual_price(){
		return product_actual_price;
	}
	public OrderProductBean setProduct_actual_price(String product_actual_price){
		this.product_actual_price= product_actual_price;
		return this;
	}
	
	public String getProfit_price() {
		return profit_price;
	}
	public OrderProductBean setProfit_price(String profit_price) {
		this.profit_price = profit_price;
		return this;
	}
	public String getFreight_id(){
		return freight_id;
	}
	public OrderProductBean setFreight_id(String freight_id){
		this.freight_id= freight_id;
		return this;
	}
	public String getFreight_type(){
		return freight_type;
	}
	public OrderProductBean setFreight_type(String freight_type){
		this.freight_type= freight_type;
		return this;
	}
	public String getFreight_way(){
		return freight_way;
	}
	public OrderProductBean setFreight_way(String freight_way){
		this.freight_way= freight_way;
		return this;
	}
	public String getFreight_range(){
		return freight_range;
	}
	public OrderProductBean setFreight_range(String freight_range){
		this.freight_range= freight_range;
		return this;
	}
	public String getFreight_price(){
		return freight_price;
	}
	public OrderProductBean setFreight_price(String freight_price){
		this.freight_price= freight_price;
		return this;
	}
	public String getFreight_add_range(){
		return freight_add_range;
	}
	public OrderProductBean setFreight_add_range(String freight_add_range){
		this.freight_add_range= freight_add_range;
		return this;
	}
	public String getFreight_add_price(){
		return freight_add_price;
	}
	public OrderProductBean setFreight_add_price(String freight_add_price){
		this.freight_add_price= freight_add_price;
		return this;
	}
	public String getFree_range(){
		return free_range;
	}
	public OrderProductBean setFree_range(String free_range){
		this.free_range= free_range;
		return this;
	}
	
	public String getIs_assessment() {
		return is_assessment;
	}
	public OrderProductBean setIs_assessment(String is_assessment) {
		this.is_assessment = is_assessment;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderProductBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderProductBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderProductBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public List<OrderProductGoodsBean> getOrderProductGoodsBeans() {
		return orderProductGoodsBeans;
	}
	public OrderProductBean setOrderProductGoodsBeans(List<OrderProductGoodsBean> orderProductGoodsBeans) {
		this.orderProductGoodsBeans = orderProductGoodsBeans;
		return this;
	}
	public String getIs_challenge() {
		return is_challenge;
	}
	public OrderProductBean setIs_challenge(String is_challenge) {
		this.is_challenge = is_challenge;
		return this;
	}
	
	
}
