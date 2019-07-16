package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class MemberBillBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_bill_id;//
	private String member_id;//
	private String bill_desc;//账单内容
	private String bill_type;//1:线上商城小程序支付 2:线上商城 余额支付 3：售货机售卖获得 4：线上商城售卖获得 5：余额提现申请  6:后台充值 7:团购失败 退款 11挑战奖励
	private String bill_type_show;//1:线上商城小程序支付 2:线上商城 余额支付 3：售货机售卖获得 4：线上商城售卖获得 5：余额提现申请  6:后台充值 7:团购失败 退款
	private String bill_value;//账单金额
	private String withdraw_id;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getMember_bill_id(){
		return member_bill_id;
	}
	public MemberBillBean setMember_bill_id(int member_bill_id){
		this.member_bill_id= member_bill_id;
		return this;
	}
	
	public String getWithdraw_id() {
		return withdraw_id;
	}
	public MemberBillBean setWithdraw_id(String withdraw_id) {
		this.withdraw_id = withdraw_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MemberBillBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getBill_desc(){
		return bill_desc;
	}
	public MemberBillBean setBill_desc(String bill_desc){
		this.bill_desc= bill_desc;
		return this;
	}
	public String getBill_type(){
		return bill_type;
	}
	public MemberBillBean setBill_type(String bill_type){
		this.bill_type= bill_type;//1:线上商城小程序支付 2:线上商城 余额支付 3：售货机售卖获得 4：线上商城售卖获得 5：余额提现申请  6:后台充值
		this.bill_type_show="1".equals(bill_type)?"线上商城小程序支付":
							"2".equals(bill_type)?"线上商城 余额支付":
							"3".equals(bill_type)?"售货机售卖获得":
							"4".equals(bill_type)?"线上商城售卖获得":
							"5".equals(bill_type)?"余额提现申请":
							"6".equals(bill_type)?"后台充值":
							"7".equals(bill_type)?"团购失败 退款":
								"11".equals(bill_type)?"挑战奖励":"未知";
		return this;
	}
	
	public String getBill_type_show() {
		return bill_type_show;
	}
	public MemberBillBean setBill_type_show(String bill_type_show) {
		this.bill_type_show = bill_type_show;
		return this;
	}
	public String getBill_value(){
		return bill_value;
	}
	public MemberBillBean setBill_value(String bill_value){
		this.bill_value= bill_value;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberBillBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberBillBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberBillBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
