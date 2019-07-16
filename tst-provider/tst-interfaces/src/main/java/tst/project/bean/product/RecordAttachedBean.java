package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class RecordAttachedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int attached_id;//
	private String record_id;//
	private String GUID;//主键
	private String GUID_HEAD;//表头GUID
	private String BIZ_TYPE_CODE;//附件种类
	private String ATTACHED_SEQ_NO;//附件序号
	private String CERT_TYPE_CODE;//单据类型
	private String CERT_CLOB;//单据内容
	private String FILE_NAME;//文件名称
	private String FILE_TYPE;//文件类型文件后缀 
	private String STORE_DATE;//存储日期
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getAttached_id(){
		return attached_id;
	}
	public RecordAttachedBean setAttached_id(int attached_id){
		this.attached_id= attached_id;
		return this;
	}
	public String getRecord_id(){
		return record_id;
	}
	public RecordAttachedBean setRecord_id(String record_id){
		this.record_id= record_id;
		return this;
	}
	public String getGUID(){
		return GUID;
	}
	public RecordAttachedBean setGUID(String GUID){
		this.GUID= GUID;
		return this;
	}
	public String getGUID_HEAD(){
		return GUID_HEAD;
	}
	public RecordAttachedBean setGUID_HEAD(String GUID_HEAD){
		this.GUID_HEAD= GUID_HEAD;
		return this;
	}
	public String getBIZ_TYPE_CODE(){
		return BIZ_TYPE_CODE;
	}
	public RecordAttachedBean setBIZ_TYPE_CODE(String BIZ_TYPE_CODE){
		this.BIZ_TYPE_CODE= BIZ_TYPE_CODE;
		return this;
	}
	public String getATTACHED_SEQ_NO(){
		return ATTACHED_SEQ_NO;
	}
	public RecordAttachedBean setATTACHED_SEQ_NO(String ATTACHED_SEQ_NO){
		this.ATTACHED_SEQ_NO= ATTACHED_SEQ_NO;
		return this;
	}
	public String getCERT_TYPE_CODE(){
		return CERT_TYPE_CODE;
	}
	public RecordAttachedBean setCERT_TYPE_CODE(String CERT_TYPE_CODE){
		this.CERT_TYPE_CODE= CERT_TYPE_CODE;
		return this;
	}
	public String getCERT_CLOB(){
		return CERT_CLOB;
	}
	public RecordAttachedBean setCERT_CLOB(String CERT_CLOB){
		this.CERT_CLOB= CERT_CLOB;
		return this;
	}
	public String getFILE_NAME(){
		return FILE_NAME;
	}
	public RecordAttachedBean setFILE_NAME(String FILE_NAME){
		this.FILE_NAME= FILE_NAME;
		return this;
	}
	public String getFILE_TYPE(){
		return FILE_TYPE;
	}
	public RecordAttachedBean setFILE_TYPE(String FILE_TYPE){
		this.FILE_TYPE= FILE_TYPE;
		return this;
	}
	public String getSTORE_DATE(){
		return STORE_DATE;
	}
	public RecordAttachedBean setSTORE_DATE(String STORE_DATE){
		this.STORE_DATE= STORE_DATE;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public RecordAttachedBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public RecordAttachedBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public RecordAttachedBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
