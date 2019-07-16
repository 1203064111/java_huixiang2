package tst.project.bean.setting;

import java.io.Serializable;

/**

**

*/

public class AdviceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int advice_id;//
	private String member_id;//反馈用户
	private String member_account;//用户账号
	private String advice_desc;//反馈内容
	private String advice_contact;//联系方式
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	public int getAdvice_id(){
		return advice_id;
	}
	public AdviceBean setAdvice_id(int advice_id){
		this.advice_id= advice_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public AdviceBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	
	public String getMember_account() {
		return member_account;
	}
	public AdviceBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	public String getAdvice_desc(){
		return advice_desc;
	}
	public AdviceBean setAdvice_desc(String advice_desc){
		this.advice_desc= advice_desc;
		return this;
	}
	public String getAdvice_contact(){
		return advice_contact;
	}
	public AdviceBean setAdvice_contact(String advice_contact){
		this.advice_contact= advice_contact;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public AdviceBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public AdviceBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public AdviceBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
