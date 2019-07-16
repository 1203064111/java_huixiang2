package tst.project.bean.order;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class OrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_id;//订单id
	private String order_no;//订单号
	private String shop_id;//归属某个店铺的用户id
	private String shop_name;//归属某个店铺的用户id
	private String device_no;//设备号
	private String cargo_no;//货道号
	private String member_id;//用户id
	private String address_id;//地址id
	private String order_type;//订单类型 goods:正常商品下单订单 group:团购订单 device:设备订单 app:视频下单订单
	private String order_state;//订单状态   cancel:取消 wait_pay:等待支付  end:已支付
	private String order_actual_price;//
	private String freight_price;//运费
	private String taxation_price;//税费
	private String profit_price;//销售可得价格
	private String product_total_price;//产品总价格
	private String order_group_id;//组团信息主键  团购订单有值
	private String group_state;//0:未开始 1:进行中 2:已结束 3:失败
	private String car_ids;//购物车id组合
	private String cancel_time;//取消订单时间
	private String pay_end_time;//等待付款结束时间
	private String pay_time;//付款时间
	private String pay_way;//支付方式 wx:微信  alipay:支付宝
	private String pay_charge;//支付凭证
	private String out_trade_no;//支付单号
	private String trade_no;//交易单号
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private OrderAddressBean orderAddressBean;//订单地址详情
	private List<OrderMerchantsBean> orderMerchantsBeans;//订单管理明细表
	
	public int getOrder_id(){
		return order_id;
	}
	public OrderBean setOrder_id(int order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public OrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getShop_id(){
		return shop_id;
	}
	public OrderBean setShop_id(String shop_id){
		this.shop_id= shop_id;
		return this;
	}
	
	public String getShop_name() {
		return shop_name;
	}
	public OrderBean setShop_name(String shop_name) {
		this.shop_name = shop_name;
		return this;
	}
	public String getDevice_no(){
		return device_no;
	}
	public OrderBean setDevice_no(String device_no){
		this.device_no= device_no;
		return this;
	}
	
	public String getCargo_no() {
		return cargo_no;
	}
	public OrderBean setCargo_no(String cargo_no) {
		this.cargo_no = cargo_no;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public OrderBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	
	public String getAddress_id() {
		return address_id;
	}
	public OrderBean setAddress_id(String address_id) {
		this.address_id = address_id;
		return this;
	}
	
	public String getOrder_type() {
		return order_type;
	}
	public OrderBean setOrder_type(String order_type) {
		this.order_type = order_type;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public OrderBean setOrder_state(String order_state){
		this.order_state= order_state;
		return this;
	}
	
	public String getOrder_actual_price() {
		return order_actual_price;
	}
	public OrderBean setOrder_actual_price(String order_actual_price) {
		this.order_actual_price = order_actual_price;
		return this;
	}
	public String getFreight_price(){
		return freight_price;
	}
	public OrderBean setFreight_price(String freight_price){
		this.freight_price= freight_price;
		return this;
	}
	public String getTaxation_price(){
		return taxation_price;
	}
	public OrderBean setTaxation_price(String taxation_price){
		this.taxation_price= taxation_price;
		return this;
	}
	
	
	public String getProfit_price() {
		return profit_price;
	}
	public OrderBean setProfit_price(String profit_price) {
		this.profit_price = profit_price;
		return this;
	}
	public String getProduct_total_price() {
		return product_total_price;
	}
	public OrderBean setProduct_total_price(String product_total_price) {
		this.product_total_price = product_total_price;
		return this;
	}
	public String getOrder_group_id(){
		return order_group_id;
	}
	public OrderBean setOrder_group_id(String order_group_id){
		this.order_group_id= order_group_id;
		return this;
	}
	public String getGroup_state(){
		return group_state;
	}
	public OrderBean setGroup_state(String group_state){
		this.group_state= group_state;
		return this;
	}
	public String getCar_ids(){
		return car_ids;
	}
	public OrderBean setCar_ids(String car_ids){
		this.car_ids= car_ids;
		return this;
	}
	public String getCancel_time(){
		return cancel_time;
	}
	public OrderBean setCancel_time(String cancel_time){
		this.cancel_time= cancel_time;
		return this;
	}
	public String getPay_end_time(){
		return pay_end_time;
	}
	public OrderBean setPay_end_time(String pay_end_time){
		this.pay_end_time= pay_end_time;
		return this;
	}
	public String getPay_time(){
		return pay_time;
	}
	public OrderBean setPay_time(String pay_time){
		this.pay_time= pay_time;
		return this;
	}
	public String getPay_way(){
		return pay_way;
	}
	public OrderBean setPay_way(String pay_way){
		this.pay_way= pay_way;
		return this;
	}
	public String getPay_charge(){
		return pay_charge;
	}
	public OrderBean setPay_charge(String pay_charge){
		this.pay_charge= pay_charge;
		return this;
	}
	public String getOut_trade_no(){
		return out_trade_no;
	}
	public OrderBean setOut_trade_no(String out_trade_no){
		this.out_trade_no= out_trade_no;
		return this;
	}
	
	public String getTrade_no() {
		return trade_no;
	}
	public OrderBean setTrade_no(String trade_no) {
		this.trade_no = trade_no;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public OrderBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	public List<OrderMerchantsBean> getOrderMerchantsBeans() {
		return orderMerchantsBeans;
	}
	public OrderBean setOrderMerchantsBeans(List<OrderMerchantsBean> orderMerchantsBeans) {
		this.orderMerchantsBeans = orderMerchantsBeans;
		return this;
	}
	
}
