package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class PurchaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int purchase_id;//
	private String purchase_ids;//
	private String supplier_id;//供应商id
	private String supplier_name;//供应商名称
	private String purchase_title;//采购标题
	private String purchase_state;//采购状态 0:申请中 1:采购中 2:已到货
	private String purchase_state_show;//采购状态 0:申请中 1:采购中 2:已到货
	private String purchase_desc;//采购内容具体描述
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private List<PurchaseGoodsBean> purchaseGoodsBeans;//采购商品列表

	public int getPurchase_id(){
		return purchase_id;
	}
	public PurchaseBean setPurchase_id(int purchase_id){
		this.purchase_id= purchase_id;
		return this;
	}
	
	public String getPurchase_ids() {
		return purchase_ids;
	}
	public PurchaseBean setPurchase_ids(String purchase_ids) {
		this.purchase_ids = purchase_ids;
		return this;
	}
	
	public String getSupplier_id() {
		return supplier_id;
	}
	public PurchaseBean setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
		return this;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public PurchaseBean setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
		return this;
	}
	public String getPurchase_title(){
		return purchase_title;
	}
	public PurchaseBean setPurchase_title(String purchase_title){
		this.purchase_title= purchase_title;
		return this;
	}
	
	public String getPurchase_state() {
		return purchase_state;
	}
	public PurchaseBean setPurchase_state(String purchase_state) {
		this.purchase_state = purchase_state;//采购状态 0:申请中 1:采购中 2:已到货
		this.purchase_state_show="0".equals(purchase_state)?"申请中":
								"1".equals(purchase_state)?"采购中":"已到货";
		return this;
	}
	
	public String getPurchase_state_show() {
		return purchase_state_show;
	}
	public PurchaseBean setPurchase_state_show(String purchase_state_show) {
		this.purchase_state_show = purchase_state_show;
		return this;
	}
	public String getPurchase_desc(){
		return purchase_desc;
	}
	public PurchaseBean setPurchase_desc(String purchase_desc){
		this.purchase_desc= purchase_desc;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public PurchaseBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public PurchaseBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public PurchaseBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public List<PurchaseGoodsBean> getPurchaseGoodsBeans() {
		return purchaseGoodsBeans;
	}
	public PurchaseBean setPurchaseGoodsBeans(List<PurchaseGoodsBean> purchaseGoodsBeans) {
		this.purchaseGoodsBeans = purchaseGoodsBeans;
		return this;
	}
	
}
