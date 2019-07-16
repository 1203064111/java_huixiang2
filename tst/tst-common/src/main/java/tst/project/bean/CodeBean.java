package tst.project.bean;

import java.io.Serializable;

/**
 * 验证码
 *
 */
public class CodeBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code_id;
	private String mobile;//手机号
	private String code;//验证码
	private String code_type;//验证码类型withdrawals_password:修改提现密码  					binding_bank:绑定银行卡 ver_mobile:验证手机号  				register:注册 login:登录 pay_passwrod:修改支付密码  					forget_password:修改密码 exchange:使用兑换码 binding_mobile：绑定手机号
	private String code_desc;
	private String create_time;
	private String effective_time;
	public int getCode_id() {
		return code_id;
	}
	public CodeBean setCode_id(int code_id) {
		this.code_id = code_id;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public CodeBean setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getCode() {
		return code;
	}
	public CodeBean setCode(String code) {
		this.code = code;
		return this;
	}
	public String getCode_type() {
		return code_type;
	}
	public CodeBean setCode_type(String code_type) {
		this.code_type = code_type;
		return this;
	}
	public String getCode_desc() {
		return code_desc;
	}
	public CodeBean setCode_desc(String code_desc) {
		this.code_desc = code_desc;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CodeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getEffective_time() {
		return effective_time;
	}
	public CodeBean setEffective_time(String effective_time) {
		this.effective_time = effective_time;
		return this;
	}
	
	
}
