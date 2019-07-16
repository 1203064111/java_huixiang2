package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class MemberWithdrawBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String withdraw_id;//
	private String member_id;//
	private String withdraw_price;//申请金额
	private String withdraw_state;//1:申请中 2:接受 3:拒绝 4:已打款
	private String withdraw_state_show;//1:申请中 2:接受 3:拒绝 4:已打款
	private String partner_trade_no;//微信打款交易号
	private String shop_name;//店铺名称
	private String shop_account;//店铺联系人
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public String getWithdraw_id(){
		return withdraw_id;
	}
	public MemberWithdrawBean setWithdraw_id(String withdraw_id){
		this.withdraw_id= withdraw_id;
		return this;
	}
	
	public String getShop_name() {
		return shop_name;
	}
	public MemberWithdrawBean setShop_name(String shop_name) {
		this.shop_name = shop_name;
		return this;
	}
	public String getShop_account() {
		return shop_account;
	}
	public MemberWithdrawBean setShop_account(String shop_account) {
		this.shop_account = shop_account;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MemberWithdrawBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getWithdraw_price(){
		return withdraw_price;
	}
	public MemberWithdrawBean setWithdraw_price(String withdraw_price){
		this.withdraw_price= withdraw_price;
		return this;
	}
	public String getWithdraw_state(){
		return withdraw_state;
	}
	public MemberWithdrawBean setWithdraw_state(String withdraw_state){
		this.withdraw_state= withdraw_state;//1:申请中 2:接受 3:拒绝 4:已打款
		this.withdraw_state_show="1".equals(withdraw_state)?"申请中":
								"2".equals(withdraw_state)?"已接受":
								"3".equals(withdraw_state)?"已拒绝":
								"4".equals(withdraw_state)?"已打款":"其他";
		return this;
	}
	
	public String getWithdraw_state_show() {
		return withdraw_state_show;
	}
	public MemberWithdrawBean setWithdraw_state_show(String withdraw_state_show) {
		this.withdraw_state_show = withdraw_state_show;
		return this;
	}
	
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public MemberWithdrawBean setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberWithdrawBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberWithdrawBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberWithdrawBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
