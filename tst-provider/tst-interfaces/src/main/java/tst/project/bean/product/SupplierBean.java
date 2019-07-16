package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class SupplierBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int supplier_id;//
	private String supplier_ids;//
	private String supplier_name;//供应商名称
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getSupplier_id(){
		return supplier_id;
	}
	public SupplierBean setSupplier_id(int supplier_id){
		this.supplier_id= supplier_id;
		return this;
	}
	
	
	public String getSupplier_ids() {
		return supplier_ids;
	}
	public SupplierBean setSupplier_ids(String supplier_ids) {
		this.supplier_ids = supplier_ids;
		return this;
	}
	public String getSupplier_name(){
		return supplier_name;
	}
	public SupplierBean setSupplier_name(String supplier_name){
		this.supplier_name= supplier_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SupplierBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SupplierBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SupplierBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
