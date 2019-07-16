package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class RecordBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int record_id;//备案id
	private String guid;//
	private String record_sku;//SKU号

	private String record_electricity_code;//电商代码
	private String record_electricity_name;//电商名称

	private String record_goods_name;//商品名称
	private String record_ciq_code;//CIQ编码

	private String record_goods_specification;//商品规格


	private String record_business_types;//业务类型

	private String record_the_notification;//申报单位

	private String record_legal_units;//法定单位

	private String record_reduced_num;//法定计量单位折算数量

	private String record_hs_code;//商品HS编码 

	private String record_measuring_unit;//入区计量单位

	private String record_measuring_unit_code;//入区计量单位折算数量

	private String record_enterprise_name;//生产企业名称

	private String record_supplier_name;//供应商名称

	private String record_inspection_code;//施检机构代码

	private String record_country_code;//国家地区代码

	private String record_product_code;//商品种类代码

	private String record_product_brand;//产品品牌

	private String record_english_name;//英文原名

	private String record_translation_name;//中文翻译名

	private String record_performance_indicators;//性能指标
	private String record_authentication_information;//认证信息

	private String record_license;//许可证号

	private String record_barcode;//商品条形码

	private String record_period_validity;//产品有效期

	private String record_main_ingredients;//主要成分

	private String record_use;//用途

	private String record_applicable_standards;//适用标准

	private String record_is_inspection;//是否法检

	private String record_is_pilot;//是否试点商品

	private String record_is_attachment;//是否存在食药监局国家认监委备案附件

	private String record_is_origin;//是否存在原产地证书

	private String record_is_report;//是否存在境外官方及第三方机构的检测报告

	private String record_is_legal;//是否存在合法采购证明

	private String record_is_translation;//是否存外文标签的中文翻译件

	private String record_in_china;//是否在中国备案
	private String record_other;//其他

	private String record_status;//备案状态（0:未提交 1：待审核 2:已拒绝 3：审核通过 ）
	private String record_number;//备案号（审核通过回填备案号）
	private String is_delete;//是否删除
	private String create_time;//
	private String update_time;//
	private List<RecordAttachedBean> recordAttachedBeans;
	public int getRecord_id(){
		return record_id;
	}
	public RecordBean setRecord_id(int record_id){
		this.record_id= record_id;
		return this;
	}
	public String getGuid(){
		return guid;
	}
	public RecordBean setGuid(String guid){
		this.guid= guid;
		return this;
	}
	public String getRecord_sku(){
		return record_sku;
	}
	public RecordBean setRecord_sku(String record_sku){
		this.record_sku= record_sku;
		return this;
	}
	public String getRecord_electricity_code(){
		return record_electricity_code;
	}
	public RecordBean setRecord_electricity_code(String record_electricity_code){
		this.record_electricity_code= record_electricity_code;
		return this;
	}
	public String getRecord_electricity_name(){
		return record_electricity_name;
	}
	public RecordBean setRecord_electricity_name(String record_electricity_name){
		this.record_electricity_name= record_electricity_name;
		return this;
	}
	public String getRecord_goods_name(){
		return record_goods_name;
	}
	public RecordBean setRecord_goods_name(String record_goods_name){
		this.record_goods_name= record_goods_name;
		return this;
	}
	public String getRecord_ciq_code(){
		return record_ciq_code;
	}
	public RecordBean setRecord_ciq_code(String record_ciq_code){
		this.record_ciq_code= record_ciq_code;
		return this;
	}
	public String getRecord_goods_specification(){
		return record_goods_specification;
	}
	public RecordBean setRecord_goods_specification(String record_goods_specification){
		this.record_goods_specification= record_goods_specification;
		return this;
	}
	public String getRecord_business_types(){
		return record_business_types;
	}
	public RecordBean setRecord_business_types(String record_business_types){
		this.record_business_types= record_business_types;
		return this;
	}
	public String getRecord_the_notification(){
		return record_the_notification;
	}
	public RecordBean setRecord_the_notification(String record_the_notification){
		this.record_the_notification= record_the_notification;
		return this;
	}
	public String getRecord_legal_units(){
		return record_legal_units;
	}
	public RecordBean setRecord_legal_units(String record_legal_units){
		this.record_legal_units= record_legal_units;
		return this;
	}
	public String getRecord_reduced_num(){
		return record_reduced_num;
	}
	public RecordBean setRecord_reduced_num(String record_reduced_num){
		this.record_reduced_num= record_reduced_num;
		return this;
	}
	public String getRecord_hs_code(){
		return record_hs_code;
	}
	public RecordBean setRecord_hs_code(String record_hs_code){
		this.record_hs_code= record_hs_code;
		return this;
	}
	public String getRecord_measuring_unit(){
		return record_measuring_unit;
	}
	public RecordBean setRecord_measuring_unit(String record_measuring_unit){
		this.record_measuring_unit= record_measuring_unit;
		return this;
	}
	public String getRecord_measuring_unit_code(){
		return record_measuring_unit_code;
	}
	public RecordBean setRecord_measuring_unit_code(String record_measuring_unit_code){
		this.record_measuring_unit_code= record_measuring_unit_code;
		return this;
	}
	public String getRecord_enterprise_name(){
		return record_enterprise_name;
	}
	public RecordBean setRecord_enterprise_name(String record_enterprise_name){
		this.record_enterprise_name= record_enterprise_name;
		return this;
	}
	public String getRecord_supplier_name(){
		return record_supplier_name;
	}
	public RecordBean setRecord_supplier_name(String record_supplier_name){
		this.record_supplier_name= record_supplier_name;
		return this;
	}
	public String getRecord_inspection_code(){
		return record_inspection_code;
	}
	public RecordBean setRecord_inspection_code(String record_inspection_code){
		this.record_inspection_code= record_inspection_code;
		return this;
	}
	public String getRecord_country_code(){
		return record_country_code;
	}
	public RecordBean setRecord_country_code(String record_country_code){
		this.record_country_code= record_country_code;
		return this;
	}
	public String getRecord_product_code(){
		return record_product_code;
	}
	public RecordBean setRecord_product_code(String record_product_code){
		this.record_product_code= record_product_code;
		return this;
	}
	public String getRecord_product_brand(){
		return record_product_brand;
	}
	public RecordBean setRecord_product_brand(String record_product_brand){
		this.record_product_brand= record_product_brand;
		return this;
	}
	public String getRecord_english_name(){
		return record_english_name;
	}
	public RecordBean setRecord_english_name(String record_english_name){
		this.record_english_name= record_english_name;
		return this;
	}
	public String getRecord_translation_name(){
		return record_translation_name;
	}
	public RecordBean setRecord_translation_name(String record_translation_name){
		this.record_translation_name= record_translation_name;
		return this;
	}
	public String getRecord_performance_indicators(){
		return record_performance_indicators;
	}
	public RecordBean setRecord_performance_indicators(String record_performance_indicators){
		this.record_performance_indicators= record_performance_indicators;
		return this;
	}
	public String getRecord_authentication_information(){
		return record_authentication_information;
	}
	public RecordBean setRecord_authentication_information(String record_authentication_information){
		this.record_authentication_information= record_authentication_information;
		return this;
	}
	public String getRecord_license(){
		return record_license;
	}
	public RecordBean setRecord_license(String record_license){
		this.record_license= record_license;
		return this;
	}
	public String getRecord_barcode(){
		return record_barcode;
	}
	public RecordBean setRecord_barcode(String record_barcode){
		this.record_barcode= record_barcode;
		return this;
	}
	public String getRecord_period_validity(){
		return record_period_validity;
	}
	public RecordBean setRecord_period_validity(String record_period_validity){
		this.record_period_validity= record_period_validity;
		return this;
	}
	public String getRecord_main_ingredients(){
		return record_main_ingredients;
	}
	public RecordBean setRecord_main_ingredients(String record_main_ingredients){
		this.record_main_ingredients= record_main_ingredients;
		return this;
	}
	public String getRecord_use(){
		return record_use;
	}
	public RecordBean setRecord_use(String record_use){
		this.record_use= record_use;
		return this;
	}
	public String getRecord_applicable_standards(){
		return record_applicable_standards;
	}
	public RecordBean setRecord_applicable_standards(String record_applicable_standards){
		this.record_applicable_standards= record_applicable_standards;
		return this;
	}
	public String getRecord_is_inspection(){
		return record_is_inspection;
	}
	public RecordBean setRecord_is_inspection(String record_is_inspection){
		this.record_is_inspection= record_is_inspection;
		return this;
	}
	public String getRecord_is_pilot(){
		return record_is_pilot;
	}
	public RecordBean setRecord_is_pilot(String record_is_pilot){
		this.record_is_pilot= record_is_pilot;
		return this;
	}
	public String getRecord_is_attachment(){
		return record_is_attachment;
	}
	public RecordBean setRecord_is_attachment(String record_is_attachment){
		this.record_is_attachment= record_is_attachment;
		return this;
	}
	public String getRecord_is_origin(){
		return record_is_origin;
	}
	public RecordBean setRecord_is_origin(String record_is_origin){
		this.record_is_origin= record_is_origin;
		return this;
	}
	public String getRecord_is_report(){
		return record_is_report;
	}
	public RecordBean setRecord_is_report(String record_is_report){
		this.record_is_report= record_is_report;
		return this;
	}
	public String getRecord_is_legal(){
		return record_is_legal;
	}
	public RecordBean setRecord_is_legal(String record_is_legal){
		this.record_is_legal= record_is_legal;
		return this;
	}
	public String getRecord_is_translation(){
		return record_is_translation;
	}
	public RecordBean setRecord_is_translation(String record_is_translation){
		this.record_is_translation= record_is_translation;
		return this;
	}
	public String getRecord_in_china(){
		return record_in_china;
	}
	public RecordBean setRecord_in_china(String record_in_china){
		this.record_in_china= record_in_china;
		return this;
	}
	public String getRecord_other(){
		return record_other;
	}
	public RecordBean setRecord_other(String record_other){
		this.record_other= record_other;
		return this;
	}
	public String getRecord_status(){
		return record_status;
	}
	public RecordBean setRecord_status(String record_status){
		this.record_status= record_status;
		return this;
	}
	public String getRecord_number(){
		return record_number;
	}
	public RecordBean setRecord_number(String record_number){
		this.record_number= record_number;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public RecordBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public RecordBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public RecordBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public List<RecordAttachedBean> getRecordAttachedBeans() {
		return recordAttachedBeans;
	}
	public RecordBean setRecordAttachedBeans(List<RecordAttachedBean> recordAttachedBeans) {
		this.recordAttachedBeans = recordAttachedBeans;
		return this;
	}
	
}
