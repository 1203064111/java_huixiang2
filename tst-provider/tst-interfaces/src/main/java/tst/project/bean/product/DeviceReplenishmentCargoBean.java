package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class DeviceReplenishmentCargoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int replenishment_cargo_id;//
	private String replenishment_id;//补货id
	private String device_no;//设备号
	private String cargo_id;//货道id
	private String cargo_no;//货道号
	private String product_id;//产品id
	private String product_name;//产品名称
	private String product_origin_price;//产品原价(区间)
	private String product_now_price;//产品现价(区间)
	private String profit_price;//销售可得价格(区间)
	private String replenishment_stock;//补货库存
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private List<DeviceReplenishmentBatchBean> deviceReplenishmentBatchBeans;//产品批次
	public int getReplenishment_cargo_id(){
		return replenishment_cargo_id;
	}
	public DeviceReplenishmentCargoBean setReplenishment_cargo_id(int replenishment_cargo_id){
		this.replenishment_cargo_id= replenishment_cargo_id;
		return this;
	}
	public String getReplenishment_id(){
		return replenishment_id;
	}
	public DeviceReplenishmentCargoBean setReplenishment_id(String replenishment_id){
		this.replenishment_id= replenishment_id;
		return this;
	}
	
	public String getDevice_no() {
		return device_no;
	}
	public DeviceReplenishmentCargoBean setDevice_no(String device_no) {
		this.device_no = device_no;
		return this;
	}
	public String getCargo_id(){
		return cargo_id;
	}
	public DeviceReplenishmentCargoBean setCargo_id(String cargo_id){
		this.cargo_id= cargo_id;
		return this;
	}
	public String getCargo_no(){
		return cargo_no;
	}
	public DeviceReplenishmentCargoBean setCargo_no(String cargo_no){
		this.cargo_no= cargo_no;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public DeviceReplenishmentCargoBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public DeviceReplenishmentCargoBean setProduct_name(String product_name) {
		this.product_name = product_name;
		return this;
	}
	public String getProduct_origin_price() {
		return product_origin_price;
	}
	public DeviceReplenishmentCargoBean setProduct_origin_price(String product_origin_price) {
		this.product_origin_price = product_origin_price;
		return this;
	}
	public String getProduct_now_price() {
		return product_now_price;
	}
	public DeviceReplenishmentCargoBean setProduct_now_price(String product_now_price) {
		this.product_now_price = product_now_price;
		return this;
	}
	public String getProfit_price() {
		return profit_price;
	}
	public DeviceReplenishmentCargoBean setProfit_price(String profit_price) {
		this.profit_price = profit_price;
		return this;
	}
	public String getReplenishment_stock(){
		return replenishment_stock;
	}
	public DeviceReplenishmentCargoBean setReplenishment_stock(String replenishment_stock){
		this.replenishment_stock= replenishment_stock;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public DeviceReplenishmentCargoBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public DeviceReplenishmentCargoBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public DeviceReplenishmentCargoBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public List<DeviceReplenishmentBatchBean> getDeviceReplenishmentBatchBeans() {
		return deviceReplenishmentBatchBeans;
	}
	public DeviceReplenishmentCargoBean setDeviceReplenishmentBatchBeans(List<DeviceReplenishmentBatchBean> deviceReplenishmentBatchBeans) {
		this.deviceReplenishmentBatchBeans = deviceReplenishmentBatchBeans;
		return this;
	}
	
}
