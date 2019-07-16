package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class DeviceCargoLoadingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int loading_id;//
	private String device_no;//设备编号
	private String cargo_id;//货道id
	private String cargo_no;//货道号
	private String cargo_num;//货道容量
	private String cargo_name;//货道名称
	private String cargo_img;//货道图片
	private String product_id;//产品id
	private String product_stock;//货道库存
	private String product_price;//货道价格
	private String loading_state;//0:未处理 1:已处理
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getLoading_id(){
		return loading_id;
	}
	public DeviceCargoLoadingBean setLoading_id(int loading_id){
		this.loading_id= loading_id;
		return this;
	}
	public String getDevice_no(){
		return device_no;
	}
	public DeviceCargoLoadingBean setDevice_no(String device_no){
		this.device_no= device_no;
		return this;
	}
	public String getCargo_id(){
		return cargo_id;
	}
	public DeviceCargoLoadingBean setCargo_id(String cargo_id){
		this.cargo_id= cargo_id;
		return this;
	}
	public String getCargo_no(){
		return cargo_no;
	}
	public DeviceCargoLoadingBean setCargo_no(String cargo_no){
		this.cargo_no= cargo_no;
		return this;
	}
	public String getCargo_num(){
		return cargo_num;
	}
	public DeviceCargoLoadingBean setCargo_num(String cargo_num){
		this.cargo_num= cargo_num;
		return this;
	}
	public String getCargo_name(){
		return cargo_name;
	}
	public DeviceCargoLoadingBean setCargo_name(String cargo_name){
		this.cargo_name= cargo_name;
		return this;
	}
	public String getCargo_img(){
		return cargo_img;
	}
	public DeviceCargoLoadingBean setCargo_img(String cargo_img){
		this.cargo_img= cargo_img;
		return this;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public DeviceCargoLoadingBean setProduct_id(String product_id) {
		this.product_id = product_id;
		return this;
	}
	public String getProduct_stock(){
		return product_stock;
	}
	public DeviceCargoLoadingBean setProduct_stock(String product_stock){
		this.product_stock= product_stock;
		return this;
	}
	public String getProduct_price(){
		return product_price;
	}
	public DeviceCargoLoadingBean setProduct_price(String product_price){
		this.product_price= product_price;
		return this;
	}
	
	public String getLoading_state() {
		return loading_state;
	}
	public DeviceCargoLoadingBean setLoading_state(String loading_state) {
		this.loading_state = loading_state;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public DeviceCargoLoadingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public DeviceCargoLoadingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public DeviceCargoLoadingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
