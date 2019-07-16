package tst.project.bean.member;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.glassfish.jersey.internal.util.StringIgnoreCaseKeyComparator;

/**

**

*/

public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_id;//
	private String member_ids;
	private String member_account;//
	private String member_password;//
	private String unionid;
	private String member_state;//用户状态 0正常 1拉黑
	private String weixin_pub_open_id;//微信公众号openid
	private String weixin_lite_open_id;//微信小程序openid
	private String ins_open_id;//ins openid
	private String fb_open_id;//fb openid
	
	private String wx_open_id;//微信 openid
	private String qq_open_id; //qq openid
	private String member_token;//
	private String member_img;//
	private String member_nick_name;//
	private String member_type;//1:普通用户 2:商家用户
	private String member_type_show;//1:普通用户 2:商家用户
	private String shop_id;//店铺id
	private String member_balance;//用户余额
	private String settle_balance;//结算金额
	private String settle_ing_balance;//结算中的余额
	private String member_end_withdrawal;//已提现
	private String member_ing_withdrawal;//正在提现
	private String pay_password;//支付密码
	private String realname_state;//1:待审核 2:已接受 3:已拒绝
	private String realname_state_show;//1:待审核 2:已接受 3:已拒绝
	private String start_time;
	private String end_time;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String parent_member_id;//其他用户id 传输用
	
	private Integer fans_num;//粉丝数
	private Integer collection_num;//收藏商品数
	private Integer follow_num;//关注数
	private Integer footprint_num;//足迹数
	private Integer well_num;//视频点赞数
	private String is_follow;//是否关注
	
	
	
	
	public String getMember_state() {
		return member_state;
	}

	public MemberBean setMember_state(String member_state) {
		this.member_state = member_state;
		return this;
	}

	public String getWx_open_id() {
		return wx_open_id;
	}

	public MemberBean setWx_open_id(String wx_open_id) {
		this.wx_open_id = wx_open_id;
		return this;
	}

	public String getQq_open_id() {
		return qq_open_id;
	}

	public MemberBean setQq_open_id(String qq_open_id) {
		this.qq_open_id = qq_open_id;
		return this;
	}

	public String getIs_follow() {
		return is_follow;
	}

	public MemberBean setIs_follow(String is_follow) {
		this.is_follow = is_follow;
		return this;
	}

	public String getParent_member_id() {
		return parent_member_id;
	}

	public MemberBean setParent_member_id(String parent_member_id) {
		this.parent_member_id = parent_member_id;
		return this;
	}


	public Integer getFans_num() {
		return fans_num;
	}

	public MemberBean setFans_num(Integer fans_num) {
		this.fans_num = fans_num;
		return this;
	}

	public Integer getCollection_num() {
		return collection_num;
	}

	public MemberBean setCollection_num(Integer collection_num) {
		this.collection_num = collection_num;
		return this;
	}

	public Integer getFollow_num() {
		return follow_num;
	}

	public MemberBean setFollow_num(Integer follow_num) {
		this.follow_num = follow_num;
		return this;
	}

	public Integer getFootprint_num() {
		return footprint_num;
	}

	public MemberBean setFootprint_num(Integer footprint_num) {
		this.footprint_num = footprint_num;
		return this;
	}

	public Integer getWell_num() {
		return well_num;
	}

	public MemberBean setWell_num(Integer well_num) {
		this.well_num = well_num;
		return this;
	}

	public String getIns_open_id() {
		return ins_open_id;
	}

	public MemberBean setIns_open_id(String ins_open_id) {
		this.ins_open_id = ins_open_id;
		return this;
	}

	public String getFb_open_id() {
		return fb_open_id;
	}

	public MemberBean setFb_open_id(String fb_open_id) {
		this.fb_open_id = fb_open_id;
		return this;
	}

	public String getMember_ids() {
		return member_ids;
	}

	public MemberBean setMember_ids(String member_ids) {
		this.member_ids = member_ids;
		return this;
	}

	public int getMember_id(){
		return member_id;
	}
	public MemberBean setMember_id(int member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMember_account(){
		return member_account;
	}
	public MemberBean setMember_account(String member_account){
		this.member_account= member_account;
		return this;
	}
	
	public String getMember_password() {
		return member_password;
	}
	public MemberBean setMember_password(String member_password) {
		this.member_password = member_password;
		return this;
	}
	
	public String getUnionid() {
		return unionid;
	}

	public MemberBean setUnionid(String unionid) {
		this.unionid = unionid;
		return this;
	}

	public String getWeixin_pub_open_id() {
		return weixin_pub_open_id;
	}

	public MemberBean setWeixin_pub_open_id(String weixin_pub_open_id) {
		this.weixin_pub_open_id = weixin_pub_open_id;
		return this;
	}

	public String getWeixin_lite_open_id(){
		return weixin_lite_open_id;
	}
	public MemberBean setWeixin_lite_open_id(String weixin_lite_open_id){
		this.weixin_lite_open_id= weixin_lite_open_id;
		return this;
	}
	public String getMember_token(){
		return member_token;
	}
	public MemberBean setMember_token(String member_token){
		this.member_token= member_token;
		return this;
	}
	public String getMember_img(){
		return member_img;
	}
	public MemberBean setMember_img(String member_img){
		this.member_img= member_img;
		return this;
	}
	public String getMember_nick_name(){
		return member_nick_name;
	}
	public MemberBean setMember_nick_name(String member_nick_name){
		this.member_nick_name= member_nick_name;
		return this;
	}
	public String getMember_type(){
		return member_type;
	}
	public MemberBean setMember_type(String member_type){
		this.member_type= member_type;
		this.member_type_show="1".equals(member_type)?"普通用户":"商家用户";
		return this;
	}
	
	
	public String getMember_type_show() {
		return member_type_show;
	}

	public MemberBean setMember_type_show(String member_type_show) {
		this.member_type_show = member_type_show;
		return this;
	}

	public String getShop_id() {
		return shop_id;
	}
	public MemberBean setShop_id(String shop_id) {
		this.shop_id = shop_id;
		return this;
	}
	public String getMember_balance(){
		return member_balance;
	}
	public MemberBean setMember_balance(String member_balance){
		this.member_balance= member_balance;
		return this;
	}
	
	public String getSettle_balance() {
		return settle_balance;
	}

	public MemberBean setSettle_balance(String settle_balance) {
		this.settle_balance = settle_balance;
		return this;
	}

	public String getSettle_ing_balance() {
		return settle_ing_balance;
	}

	public MemberBean setSettle_ing_balance(String settle_ing_balance) {
		this.settle_ing_balance = settle_ing_balance;
		return this;
	}

	public String getMember_end_withdrawal(){
		return member_end_withdrawal;
	}
	public MemberBean setMember_end_withdrawal(String member_end_withdrawal){
		this.member_end_withdrawal= member_end_withdrawal;
		return this;
	}
	public String getMember_ing_withdrawal(){
		return member_ing_withdrawal;
	}
	public MemberBean setMember_ing_withdrawal(String member_ing_withdrawal){
		this.member_ing_withdrawal= member_ing_withdrawal;
		return this;
	}

	public String getPay_password() {
		return pay_password;
	}
	public MemberBean setPay_password(String pay_password) {
		this.pay_password = pay_password;
		return this;
	}
	
	public String getRealname_state() {
		return realname_state;
	}

	public MemberBean setRealname_state(String realname_state) {
		this.realname_state = realname_state;
		this.realname_state_show="1".equals(realname_state)?"待审核":
			"2".equals(realname_state)?"已接受":
			"3".equals(realname_state)?"已拒绝":"未提交";
		return this;
	}

	public String getRealname_state_show() {
		return realname_state_show;
	}

	public MemberBean setRealname_state_show(String realname_state_show) {
		this.realname_state_show = realname_state_show;
		return this;
	}
	
	public String getStart_time() {
		return start_time;
	}

	public MemberBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}

	public String getEnd_time() {
		return end_time;
	}

	public MemberBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}

	public String getIs_delete(){
		return is_delete;
	}
	public MemberBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
