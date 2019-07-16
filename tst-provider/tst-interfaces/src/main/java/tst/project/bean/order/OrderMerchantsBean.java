package tst.project.bean.order;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class OrderMerchantsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_merchants_id;//
	private String order_merchants_no;//订单号
	private String shop_id;//归属某个店铺的id
	private String shop_name;//归属某个店铺的名称
	private String device_no;//设备号
	private String cargo_no;//货道号
	private String order_id;//
	private String order_no;//多商家下单 关联字段
	private String merchants_id;//商家id
	private String merchants_name;//
	private String member_id;//用户id
	private String order_total_price;//总价
	private String order_actual_price;//实际支付价
	private String product_total_price;//商品的总金额
	private String freight_price;//邮费
	private String taxation_price;//税费
	private String profit_price;//销售可得价格

	private String order_group_id;//组团信息主键  团购订单有值
	private String group_state;//0:未开始 1:进行中 2:已结束 3:失败
	private String order_type;//订单类型 goods:正常商品下单订单 group:团购订单
	private String order_type_show;//订单类型 goods:正常商品下单订单 group:团购订单

	private String order_state;//订单状态  cancel:取消  wait_pay:代付款  wait_send:待发货 wait_receive:待收货 wait_assessment:待评价 end:已完成 
	private String order_state_show;//订单状态  cancel:取消  wait_pay:代付款  wait_send:待发货 wait_receive:待收货 wait_assessment:待评价 end:已完成 
	private String order_remark;//订单备注
	private String receive_time;//确认收货时间
	private String logistics_time;//物流签收的时间
	private String cancel_time;//取消订单时间
	private String pay_time;//付款时间
	private String pay_way;//支付方式 wx:微信  alipay:支付宝 wx_pub:微信公众号  wx_lite:微信小程序
	private String pay_way_show;//支付方式 wx:微信  alipay:支付宝 wx_pub:微信公众号  wx_lite:微信小程序
	private String assessment_time;//评价时间
	private String send_time;//发货时间
	private String close_time;//结算时间
	private String is_send;//仓库是否发货  0:未发货 1:已发货
	private String is_send_show;//仓库是否发货  0:未发货 1:已发货
	
	
	private String start_time;//
	private String end_time;//
	private String address_name;//
	private String address_mobile;//
	
	private String is_cross_border;//是否跨境 0:不是 1:是
	private String cross_border_state;//海关入库状态 0:未提交 1:已提交 2:入库成功 3:入库失败
	private String cross_border_pay_state;//海关支付报关状态 0:未提交 1:已提交 2:入库成功 3:入库失败
	private String cross_border_state_show;//海关入库状态 0:未提交 1:已提交 2:入库成功 3:入库失败
	
	private String product_name;
	private String class_name;
	
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private OrderGroupBean orderGroupBean;//团购详情
	private OrderAddressBean orderAddressBean;//订单地址详情
	private List<OrderProductBean> orderProductBeans;//订单产品列表
	public int getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderMerchantsBean setOrder_merchants_id(int order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no(){
		return order_merchants_no;
	}
	public OrderMerchantsBean setOrder_merchants_no(String order_merchants_no){
		this.order_merchants_no= order_merchants_no;
		return this;
	}
	public String getShop_id(){
		return shop_id;
	}
	public OrderMerchantsBean setShop_id(String shop_id){
		this.shop_id= shop_id;
		return this;
	}
	
	public String getShop_name() {
		return shop_name;
	}
	public OrderMerchantsBean setShop_name(String shop_name) {
		this.shop_name = shop_name;
		return this;
	}
	public String getDevice_no(){
		return device_no;
	}
	public OrderMerchantsBean setDevice_no(String device_no){
		this.device_no= device_no;
		return this;
	}
	
	public String getCargo_no() {
		return cargo_no;
	}
	public OrderMerchantsBean setCargo_no(String cargo_no) {
		this.cargo_no = cargo_no;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderMerchantsBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public OrderMerchantsBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getMerchants_id(){
		return merchants_id;
	}
	public OrderMerchantsBean setMerchants_id(String merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	public String getMerchants_name(){
		return merchants_name;
	}
	public OrderMerchantsBean setMerchants_name(String merchants_name){
		this.merchants_name= merchants_name;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public OrderMerchantsBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getOrder_total_price(){
		return order_total_price;
	}
	public OrderMerchantsBean setOrder_total_price(String order_total_price){
		this.order_total_price= order_total_price;
		return this;
	}
	public String getOrder_actual_price(){
		return order_actual_price;
	}
	public OrderMerchantsBean setOrder_actual_price(String order_actual_price){
		this.order_actual_price= order_actual_price;
		return this;
	}
	
	public String getProduct_total_price() {
		return product_total_price;
	}
	public OrderMerchantsBean setProduct_total_price(String product_total_price) {
		this.product_total_price = product_total_price;
		return this;
	}
	public String getFreight_price(){
		return freight_price;
	}
	public OrderMerchantsBean setFreight_price(String freight_price){
		this.freight_price= freight_price;
		return this;
	}
	public String getTaxation_price(){
		return taxation_price;
	}
	public OrderMerchantsBean setTaxation_price(String taxation_price){
		this.taxation_price= taxation_price;
		return this;
	}
	
	public String getProfit_price() {
		return profit_price;
	}
	public OrderMerchantsBean setProfit_price(String profit_price) {
		this.profit_price = profit_price;
		return this;
	}
	public String getOrder_group_id(){
		return order_group_id;
	}
	public OrderMerchantsBean setOrder_group_id(String order_group_id){
		this.order_group_id= order_group_id;
		return this;
	}
	public String getGroup_state(){
		return group_state;
	}
	public OrderMerchantsBean setGroup_state(String group_state){
		this.group_state= group_state;
		return this;
	}
	public String getOrder_type(){
		return order_type;
	}
	public OrderMerchantsBean setOrder_type(String order_type){
		this.order_type= order_type;//订单类型 goods:正常商品下单订单 group:团购订单
		this.order_type_show="goods".equals(order_type)?"正常订单":
							 "group".equals(order_type)?"团购订单":
							 "device".equals(order_type)?"售货机订单":
								 "app".equals(order_type)?"视频订单":"异常订单";
		return this;
	}
	
	public String getOrder_type_show() {
		return order_type_show;
	}
	public OrderMerchantsBean setOrder_type_show(String order_type_show) {
		this.order_type_show = order_type_show;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public OrderMerchantsBean setOrder_state(String order_state){
		this.order_state= order_state;//cancel:取消  wait_pay:待付款  wait_send:待发货 wait_receive:待收货 wait_assessment:待评价 end:已完成 
		this.order_state_show="cancel".equals(order_state)?"已取消":
							"wait_pay".equals(order_state)?"待付款":
							"wait_send".equals(order_state)?"待发货":
							"wait_receive".equals(order_state)?"待收货":
							"wait_assessment".equals(order_state)?"待评价":
							"end".equals(order_state)?"已完成":"异常状态";
		return this;
	}
	
	public String getOrder_state_show() {
		return order_state_show;
	}
	public OrderMerchantsBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public String getOrder_remark(){
		return order_remark;
	}
	public OrderMerchantsBean setOrder_remark(String order_remark){
		this.order_remark= order_remark;
		return this;
	}
	public String getReceive_time(){
		return receive_time;
	}
	public OrderMerchantsBean setReceive_time(String receive_time){
		this.receive_time= receive_time;
		return this;
	}
	
	public String getLogistics_time() {
		return logistics_time;
	}
	public OrderMerchantsBean setLogistics_time(String logistics_time) {
		this.logistics_time = logistics_time;
		return this;
	}
	public String getCancel_time(){
		return cancel_time;
	}
	public OrderMerchantsBean setCancel_time(String cancel_time){
		this.cancel_time= cancel_time;
		return this;
	}
	public String getPay_time(){
		return pay_time;
	}
	public OrderMerchantsBean setPay_time(String pay_time){
		this.pay_time= pay_time;
		return this;
	}
	public String getPay_way(){
		return pay_way;
	}
	public OrderMerchantsBean setPay_way(String pay_way){
		this.pay_way= pay_way;
		this.pay_way_show="wx_lite".equals(pay_way)?"小程序支付":
				"wx_pub".equals(pay_way)?"公众号支付":
				"alipay_h5".equals(pay_way)?"支付宝支付":"";
		return this;
	}
	
	public String getPay_way_show() {
		return pay_way_show;
	}
	public OrderMerchantsBean setPay_way_show(String pay_way_show) {
		this.pay_way_show = pay_way_show;
		return this;
	}
	public String getAssessment_time(){
		return assessment_time;
	}
	public OrderMerchantsBean setAssessment_time(String assessment_time){
		this.assessment_time= assessment_time;
		return this;
	}
	public String getSend_time(){
		return send_time;
	}
	public OrderMerchantsBean setSend_time(String send_time){
		this.send_time= send_time;
		return this;
	}
	
	public String getAddress_name() {
		return address_name;
	}
	public OrderMerchantsBean setAddress_name(String address_name) {
		this.address_name = address_name;
		return this;
	}
	public String getAddress_mobile() {
		return address_mobile;
	}
	public OrderMerchantsBean setAddress_mobile(String address_mobile) {
		this.address_mobile = address_mobile;
		return this;
	}
	
	
	public String getIs_cross_border() {
		return is_cross_border;
	}
	public OrderMerchantsBean setIs_cross_border(String is_cross_border) {
		this.is_cross_border = is_cross_border;
		return this;
	}
	
	public String getCross_border_state() {
		return cross_border_state;
	}
	public OrderMerchantsBean setCross_border_state(String cross_border_state) {
		this.cross_border_state = cross_border_state;//海关入库状态 0:未提交 1:已提交 2:入库成功 3:入库失败
		this.cross_border_state_show="0".equals(cross_border_state)?"未提交":
									"1".equals(cross_border_state)?"已提交":
									"2".equals(cross_border_state)?"入库成功":
									"3".equals(cross_border_state)?"入库失败":"";
		return this;
	}
	public String getCross_border_state_show() {
		return cross_border_state_show;
	}
	public OrderMerchantsBean setCross_border_state_show(String cross_border_state_show) {
		this.cross_border_state_show = cross_border_state_show;
		return this;
	}
	
	public String getCross_border_pay_state() {
		return cross_border_pay_state;
	}
	public OrderMerchantsBean setCross_border_pay_state(String cross_border_pay_state) {
		this.cross_border_pay_state = cross_border_pay_state;
		return this;
	}
	public String getClose_time(){
		return close_time;
	}
	public OrderMerchantsBean setClose_time(String close_time){
		this.close_time= close_time;
		return this;
	}
	
	public String getIs_send() {
		return is_send;
	}
	public OrderMerchantsBean setIs_send(String is_send) {
		this.is_send = is_send;//仓库是否发货  0:未发货 1:已发货
		this.is_send_show="0".equals(is_send)?"未发货":"已发货";
		return this;
	}
	
	public String getIs_send_show() {
		return is_send_show;
	}
	public OrderMerchantsBean setIs_send_show(String is_send_show) {
		this.is_send_show = is_send_show;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public OrderMerchantsBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public OrderMerchantsBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public OrderMerchantsBean setProduct_name(String product_name) {
		this.product_name = product_name;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public OrderMerchantsBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderMerchantsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderMerchantsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderMerchantsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public OrderGroupBean getOrderGroupBean() {
		return orderGroupBean;
	}
	public OrderMerchantsBean setOrderGroupBean(OrderGroupBean orderGroupBean) {
		this.orderGroupBean = orderGroupBean;
		return this;
	}
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public OrderMerchantsBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	public List<OrderProductBean> getOrderProductBeans() {
		return orderProductBeans;
	}
	public OrderMerchantsBean setOrderProductBeans(List<OrderProductBean> orderProductBeans) {
		this.orderProductBeans = orderProductBeans;
		return this;
	}

}
