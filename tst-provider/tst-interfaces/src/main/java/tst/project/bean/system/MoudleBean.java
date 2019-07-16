package tst.project.bean.system;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class MoudleBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int moudle_id;//平台模块id
	private String moudle_ids;
	private String role_id; //平台角色id
	private String moudle_name;//
	private String moudle_url;//
	private String parent_id;//
	private String sort;//排序用
	private String moudle_type;//1:平台模块 2:商家模块
	private String moudle_type_show;//1:平台模块 2:商家模块
	private String moudle_remark;//备注
	private String is_delete;//1:删除
	private String create_time;//
	private String update_time;//
	private String moudle_uuid;//
	private String moudle_parent_uuid;//
	private String is_authority;
	private boolean LAY_CHECKED;
	private List<MoudleBean> menuBeans;
	
	
	public String getMoudle_ids() {
		return moudle_ids;
	}
	public MoudleBean setMoudle_ids(String moudle_ids) {
		this.moudle_ids = moudle_ids;
		return this;
	}
	public String getMoudle_type() {
		return moudle_type;
	}
	public MoudleBean setMoudle_type(String moudle_type) {
		this.moudle_type = moudle_type;
		this.moudle_type_show="1".equals(moudle_type)?"平台模块":"商家模块";
		return this;
	}
	public String getMoudle_type_show() {
		return moudle_type_show;
	}
	public MoudleBean setMoudle_type_show(String moudle_type_show) {
		this.moudle_type_show = moudle_type_show;
		return this;
	}
	public String getIs_authority() {
		return is_authority;
	}
	public MoudleBean setIs_authority(String is_authority) {
		this.is_authority = is_authority;
		this.LAY_CHECKED="1".equals(is_authority)?true:false;
		return this;
	}
	
	public boolean getLAY_CHECKED() {
		return LAY_CHECKED;
	}
	public MoudleBean setLAY_CHECKED(boolean LAY_CHECKED) {
		this.LAY_CHECKED = LAY_CHECKED;
		return this;
	}
	public String getRole_id() {
		return role_id;
	}
	public MoudleBean setRole_id(String role_id) {
		this.role_id = role_id;
		return this;
	}
	public List<MoudleBean> getMenuBeans() {
		return menuBeans;
	}
	public MoudleBean setMenuBeans(List<MoudleBean> menuBeans) {
		this.menuBeans = menuBeans;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getMoudle_id(){
		return moudle_id;
	}
	public MoudleBean setMoudle_id(int moudle_id){
		this.moudle_id= moudle_id;
		return this;
	}
	public String getMoudle_name(){
		return moudle_name;
	}
	public MoudleBean setMoudle_name(String moudle_name){
		this.moudle_name= moudle_name;
		return this;
	}
	public String getMoudle_url(){
		return moudle_url;
	}
	public MoudleBean setMoudle_url(String moudle_url){
		this.moudle_url= moudle_url;
		return this;
	}
	public String getParent_id(){
		return parent_id;
	}
	public MoudleBean setParent_id(String parent_id){
		this.parent_id= parent_id;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public MoudleBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getMoudle_remark(){
		return moudle_remark;
	}
	public MoudleBean setMoudle_remark(String moudle_remark){
		this.moudle_remark= moudle_remark;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MoudleBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MoudleBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MoudleBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getMoudle_uuid(){
		return moudle_uuid;
	}
	public MoudleBean setMoudle_uuid(String moudle_uuid){
		this.moudle_uuid= moudle_uuid;
		return this;
	}
	public String getMoudle_parent_uuid(){
		return moudle_parent_uuid;
	}
	public MoudleBean setMoudle_parent_uuid(String moudle_parent_uuid){
		this.moudle_parent_uuid= moudle_parent_uuid;
		return this;
	}
}
