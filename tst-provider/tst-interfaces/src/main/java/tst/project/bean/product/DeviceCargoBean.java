package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class DeviceCargoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int cargo_id;//
	private String cargo_no;//货道号
	private String cargo_num;//货道可存产品数量
	private String cargo_name;//货道名称
	private String cargo_img;//货道图片
	
	private String device_id;//设备id
	private String product_id;//产品id
	private String product_name;//产品名称
	private String product_origin_price;//产品原价(区间)
	private String product_now_price;//产品现价(区间)
	private String profit_price;//销售可得价格(区间)
	private String product_type;//
	private String product_stock;//产品库存
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getCargo_id(){
		return cargo_id;
	}
	public DeviceCargoBean setCargo_id(int cargo_id){
		this.cargo_id= cargo_id;
		return this;
	}
	public String getCargo_no(){
		return cargo_no;
	}
	public DeviceCargoBean setCargo_no(String cargo_no){
		this.cargo_no= cargo_no;
		return this;
	}
	
	public String getCargo_num() {
		return cargo_num;
	}
	public DeviceCargoBean setCargo_num(String cargo_num) {
		this.cargo_num = cargo_num;
		return this;
	}
	
	public String getCargo_name() {
		return cargo_name;
	}
	public DeviceCargoBean setCargo_name(String cargo_name) {
		this.cargo_name = cargo_name;
		return this;
	}
	public String getCargo_img() {
		return cargo_img;
	}
	public DeviceCargoBean setCargo_img(String cargo_img) {
		this.cargo_img = cargo_img;
		return this;
	}
	public String getDevice_id(){
		return device_id;
	}
	public DeviceCargoBean setDevice_id(String device_id){
		this.device_id= device_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public DeviceCargoBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public DeviceCargoBean setProduct_name(String product_name) {
		this.product_name = product_name;
		return this;
	}
	
	public String getProduct_origin_price() {
		return product_origin_price;
	}
	public DeviceCargoBean setProduct_origin_price(String product_origin_price) {
		this.product_origin_price = product_origin_price;
		return this;
	}
	public String getProduct_now_price() {
		return product_now_price;
	}
	public DeviceCargoBean setProduct_now_price(String product_now_price) {
		this.product_now_price = product_now_price;
		return this;
	}
	public String getProfit_price() {
		return profit_price;
	}
	public DeviceCargoBean setProfit_price(String profit_price) {
		this.profit_price = profit_price;
		return this;
	}
	
	public String getProduct_type() {
		return product_type;
	}
	public DeviceCargoBean setProduct_type(String product_type) {
		this.product_type = product_type;
		return this;
	}
	public String getProduct_stock(){
		return product_stock;
	}
	public DeviceCargoBean setProduct_stock(String product_stock){
		this.product_stock= product_stock;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public DeviceCargoBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public DeviceCargoBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public DeviceCargoBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
