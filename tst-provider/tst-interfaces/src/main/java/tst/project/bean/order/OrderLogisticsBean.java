package tst.project.bean.order;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class OrderLogisticsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int logistics_order_id;//
	private String order_id;//订单总id
	private String order_merchants_id;//
	private String logistics_no;//快递单号
	private String logistics_name;//快递公司名称
	private String logistics_pinyin;//快递公司简写
	private String send_company;//发件人公司名称
	private String send_name;//发件人姓名
	private String send_mobile;//发件人手机号
	private String send_privince;//发件人省
	private String send_city;//发件人市
	private String send_country;//发件人区
	private String send_address;//发件人地址
	private String send_zip_code;//发件人邮编
	private String logistics_state;//-1:暂无轨迹 0-已揽收  3:已签收  其他:在途中
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private OrderAddressBean orderAddressBean;//发货信息
	private List<OrderLogisticsDetailBean> orderLogisticsDetailBeans;//物流详情
	public int getLogistics_order_id(){
		return logistics_order_id;
	}
	public OrderLogisticsBean setLogistics_order_id(int logistics_order_id){
		this.logistics_order_id= logistics_order_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderLogisticsBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderLogisticsBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getLogistics_no(){
		return logistics_no;
	}
	public OrderLogisticsBean setLogistics_no(String logistics_no){
		this.logistics_no= logistics_no;
		return this;
	}
	public String getLogistics_name(){
		return logistics_name;
	}
	public OrderLogisticsBean setLogistics_name(String logistics_name){
		this.logistics_name= logistics_name;
		return this;
	}
	public String getLogistics_pinyin(){
		return logistics_pinyin;
	}
	public OrderLogisticsBean setLogistics_pinyin(String logistics_pinyin){
		this.logistics_pinyin= logistics_pinyin;
		return this;
	}
	public String getSend_company(){
		return send_company;
	}
	public OrderLogisticsBean setSend_company(String send_company){
		this.send_company= send_company;
		return this;
	}
	public String getSend_name(){
		return send_name;
	}
	public OrderLogisticsBean setSend_name(String send_name){
		this.send_name= send_name;
		return this;
	}
	public String getSend_mobile(){
		return send_mobile;
	}
	public OrderLogisticsBean setSend_mobile(String send_mobile){
		this.send_mobile= send_mobile;
		return this;
	}
	public String getSend_privince(){
		return send_privince;
	}
	public OrderLogisticsBean setSend_privince(String send_privince){
		this.send_privince= send_privince;
		return this;
	}
	public String getSend_city(){
		return send_city;
	}
	public OrderLogisticsBean setSend_city(String send_city){
		this.send_city= send_city;
		return this;
	}
	public String getSend_country(){
		return send_country;
	}
	public OrderLogisticsBean setSend_country(String send_country){
		this.send_country= send_country;
		return this;
	}
	public String getSend_address(){
		return send_address;
	}
	public OrderLogisticsBean setSend_address(String send_address){
		this.send_address= send_address;
		return this;
	}
	public String getSend_zip_code(){
		return send_zip_code;
	}
	public OrderLogisticsBean setSend_zip_code(String send_zip_code){
		this.send_zip_code= send_zip_code;
		return this;
	}
	public String getLogistics_state(){
		return logistics_state;
	}
	public OrderLogisticsBean setLogistics_state(String logistics_state){
		this.logistics_state= logistics_state;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderLogisticsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderLogisticsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderLogisticsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public OrderLogisticsBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	public List<OrderLogisticsDetailBean> getOrderLogisticsDetailBeans() {
		return orderLogisticsDetailBeans;
	}
	public OrderLogisticsBean setOrderLogisticsDetailBeans(List<OrderLogisticsDetailBean> orderLogisticsDetailBeans) {
		this.orderLogisticsDetailBeans = orderLogisticsDetailBeans;
		return this;
	}
	
	
}
