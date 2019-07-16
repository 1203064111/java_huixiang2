package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class DeviceReplenishmentBatchBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int replenishment_batch_id;//
	private String replenishment_id;//
	private String replenishment_cargo_id;//
	private String device_no;//设备号
	private String cargo_no;//货道号
	private String product_id;//产品id
	private String goods_id;
	
	private String batch_id;//批次id
	private String purchase_id;//采购单id
	private String batch_no;//批次号
	private String batch_stock;//批次库存
	private String batch_now_stock;//批次还剩库存
	private String batch_price;//批次价格
	
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	
	public String getGoods_id() {
		return goods_id;
	}
	public DeviceReplenishmentBatchBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public int getReplenishment_batch_id(){
		return replenishment_batch_id;
	}
	public DeviceReplenishmentBatchBean setReplenishment_batch_id(int replenishment_batch_id){
		this.replenishment_batch_id= replenishment_batch_id;
		return this;
	}
	
	public String getReplenishment_id(){
		return replenishment_id;
	}
	public DeviceReplenishmentBatchBean setReplenishment_id(String replenishment_id){
		this.replenishment_id= replenishment_id;
		return this;
	}
	public String getReplenishment_cargo_id(){
		return replenishment_cargo_id;
	}
	public DeviceReplenishmentBatchBean setReplenishment_cargo_id(String replenishment_cargo_id){
		this.replenishment_cargo_id= replenishment_cargo_id;
		return this;
	}
	
	public String getDevice_no() {
		return device_no;
	}
	public DeviceReplenishmentBatchBean setDevice_no(String device_no) {
		this.device_no = device_no;
		return this;
	}
	public String getCargo_no() {
		return cargo_no;
	}
	public DeviceReplenishmentBatchBean setCargo_no(String cargo_no) {
		this.cargo_no = cargo_no;
		return this;
	}
	public String getProduct_id() {
		return product_id;
	}
	public DeviceReplenishmentBatchBean setProduct_id(String product_id) {
		this.product_id = product_id;
		return this;
	}
	public String getBatch_id(){
		return batch_id;
	}
	public DeviceReplenishmentBatchBean setBatch_id(String batch_id){
		this.batch_id= batch_id;
		return this;
	}
	
	public String getPurchase_id() {
		return purchase_id;
	}
	public DeviceReplenishmentBatchBean setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
		return this;
	}
	public String getBatch_no() {
		return batch_no;
	}
	public DeviceReplenishmentBatchBean setBatch_no(String batch_no) {
		this.batch_no = batch_no;
		return this;
	}
	public String getBatch_stock(){
		return batch_stock;
	}
	public DeviceReplenishmentBatchBean setBatch_stock(String batch_stock){
		this.batch_stock= batch_stock;
		return this;
	}
	
	public String getBatch_now_stock() {
		return batch_now_stock;
	}
	public DeviceReplenishmentBatchBean setBatch_now_stock(String batch_now_stock) {
		this.batch_now_stock = batch_now_stock;
		return this;
	}
	
	public String getBatch_price() {
		return batch_price;
	}
	public DeviceReplenishmentBatchBean setBatch_price(String batch_price) {
		this.batch_price = batch_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public DeviceReplenishmentBatchBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public DeviceReplenishmentBatchBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public DeviceReplenishmentBatchBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
