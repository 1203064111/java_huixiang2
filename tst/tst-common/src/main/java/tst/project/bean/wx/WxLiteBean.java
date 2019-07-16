package tst.project.bean.wx;

import java.io.Serializable;

public class WxLiteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String openId;
	private String nickName;
	private String gender;
	private String language;
	private String city;
	private String province;
	private String country;
	private String avatarUrl;
	private String unionId;
	public String getOpenId() {
		return openId;
	}
	public WxLiteBean setOpenId(String openId) {
		this.openId = openId;
		return this;
	}
	public String getNickName() {
		return nickName;
	}
	public WxLiteBean setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public WxLiteBean setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public String getLanguage() {
		return language;
	}
	public WxLiteBean setLanguage(String language) {
		this.language = language;
		return this;
	}
	public String getCity() {
		return city;
	}
	public WxLiteBean setCity(String city) {
		this.city = city;
		return this;
	}
	public String getProvince() {
		return province;
	}
	public WxLiteBean setProvince(String province) {
		this.province = province;
		return this;
	}
	public String getCountry() {
		return country;
	}
	public WxLiteBean setCountry(String country) {
		this.country = country;
		return this;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public WxLiteBean setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
		return this;
	}
	public String getUnionId() {
		return unionId;
	}
	public WxLiteBean setUnionId(String unionId) {
		this.unionId = unionId;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
