package tst.project.bean.setting;
import java.io.Serializable;
import java.util.List;

import tst.project.bean.product.ProductBean;

public class MemberChallengeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int challenge_id;//挑战id
	private String challenge_ids;
	private int member_id;//用户id 或者商户id 平台id为-1
	private String member_name;//用户名
	private String member_img;//用户头像
	private int member_fans;//用户粉丝数
	
	private String is_follow;//是否关注
	private Integer good_num;//点赞数量
	private Integer comment_num;//评论数
	private String create_time;
	private String challenge_rule;//挑战规则
	private Integer collection_num;//收藏数
	private String title;//标题
	private String product_name;//产品名称
	private String product_img;//产品图片
	private int is_delete;
	private int product_class;//视频分类id(产品的一级分类id)
	private String video;//用户的挑战视频
	private String class_name;//视频一级分类名称
	private String update_time;
	private int product_id;//产品id
	private String state;//状态 0下架 1上架
	private String challenge_desc;//描述
	private Integer share_num;//分享数
	
	private String is_front;//首页推荐
	private String challenge_resource;//视频类型 member用户挑战 platform平台视频 shop商户视频
	private String challenge_resource_show;
	
	private Integer offical_sort;//官方权重
	
	private ProductBean productBean;
	
	private String is_collection;//是否收藏
	private String is_good;//是否点赞
	
	private String product_price;//产品价格 传输用
	private String product_sales;//产品销量 传输用
	private int good_set;
	private int comment_set;
	private int random_set;
	private int lable_set;
	
	private String field;
	private String order;
	
	private String sales_start_time;
	private String sales_end_time;
	private String shop_id;//商家id
	
	public String getSales_start_time() {
		return sales_start_time;
	}
	public MemberChallengeBean setSales_start_time(String sales_start_time) {
		this.sales_start_time = sales_start_time;
		return this;
	}
	public String getSales_end_time() {
		return sales_end_time;
	}
	public MemberChallengeBean setSales_end_time(String sales_end_time) {
		this.sales_end_time = sales_end_time;
		return this;
	}
	public String getProduct_price() {
		return product_price;
	}
	public MemberChallengeBean setProduct_price(String product_price) {
		this.product_price = product_price;
		return this;
	}
	public String getProduct_sales() {
		return product_sales;
	}
	public MemberChallengeBean setProduct_sales(String product_sales) {
		this.product_sales = product_sales;
		return this;
	}
	public String getProduct_img() {
		return product_img;
	}
	public MemberChallengeBean setProduct_img(String product_img) {
		this.product_img = product_img;
		return this;
	}
	public int getGood_set() {
		return good_set;
	}
	public MemberChallengeBean setGood_set(int good_set) {
		this.good_set = good_set;
		return this;
	}
	public int getComment_set() {
		return comment_set;
	}
	public MemberChallengeBean setComment_set(int comment_set) {
		this.comment_set = comment_set;
		return this;
	}
	public int getRandom_set() {
		return random_set;
	}
	public MemberChallengeBean setRandom_set(int random_set) {
		this.random_set = random_set;
		return this;
	}
	public int getLable_set() {
		return lable_set;
	}
	public MemberChallengeBean setLable_set(int lable_set) {
		this.lable_set = lable_set;
		return this;
	}
	public String getIs_follow() {
		return is_follow;
	}
	public MemberChallengeBean setIs_follow(String is_follow) {
		this.is_follow = is_follow;
		return this;
	}
	public int getMember_fans() {
		return member_fans;
	}
	public MemberChallengeBean setMember_fans(int member_fans) {
		this.member_fans = member_fans;
		return this;
	}
	public String getIs_collection() {
		return is_collection;
	}
	public MemberChallengeBean setIs_collection(String is_collection) {
		this.is_collection = is_collection;
		return this;
	}
	public String getIs_good() {
		return is_good;
	}
	public MemberChallengeBean setIs_good(String is_good) {
		this.is_good = is_good;
		return this;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public MemberChallengeBean setProductBean(ProductBean productBean) {
		this.productBean = productBean;
		return this;
	}
	public String getChallenge_resource() {
		return challenge_resource;
	}
	public MemberChallengeBean setChallenge_resource(String challenge_resource) {
		this.challenge_resource = challenge_resource;
		this.challenge_resource_show = "member".equals(challenge_resource)?"用户挑战":
			"platform".equals(challenge_resource)?"平台视频":
				"shop".equals(challenge_resource)?"商户视频":"";
		return this;
	}
	public String getChallenge_resource_show() {
		return challenge_resource_show;
	}
	public MemberChallengeBean setChallenge_resource_show(String challenge_resource_show) {
		this.challenge_resource_show = challenge_resource_show;
		return this;
	}
	
	
	public String getIs_front() {
		return is_front;
	}
	public MemberChallengeBean setIs_front(String is_front) {
		this.is_front = is_front;
		return this;
	}
	public String getField() {
		return field;
	}
	public MemberChallengeBean setField(String field) {
		this.field = field;
		return this;
	}
	public String getOrder() {
		return order;
	}
	public MemberChallengeBean setOrder(String order) {
		this.order = order;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public MemberChallengeBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public MemberChallengeBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public String getVideo() {
		return video;
	}
	public MemberChallengeBean setVideo(String video) {
		this.video = video;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public MemberChallengeBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getChallenge_ids() {
		return challenge_ids;
	}
	public MemberChallengeBean setChallenge_ids(String challenge_ids) {
		this.challenge_ids = challenge_ids;
		return this;
	}
	public int getChallenge_id() {
		return challenge_id;
	}
	public MemberChallengeBean setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public MemberChallengeBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	

	public String getCreate_time() {
		return create_time;
	}
	public MemberChallengeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getChallenge_rule() {
		return challenge_rule;
	}
	public MemberChallengeBean setChallenge_rule(String challenge_rule) {
		this.challenge_rule = challenge_rule;
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	public MemberChallengeBean setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getProduct_name() {
		return product_name;
	}
	public MemberChallengeBean setProduct_name(String product_name) {
		this.product_name = product_name;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public MemberChallengeBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public int getProduct_class() {
		return product_class;
	}
	public MemberChallengeBean setProduct_class(int product_class) {
		this.product_class = product_class;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberChallengeBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public int getProduct_id() {
		return product_id;
	}
	public MemberChallengeBean setProduct_id(int product_id) {
		this.product_id = product_id;
		return this;
	}
	public String getState() {
		return state;
	}
	public MemberChallengeBean setState(String state) {
		this.state = state;
		return this;
	}
	
	public String getChallenge_desc() {
		return challenge_desc;
	}
	public MemberChallengeBean setChallenge_desc(String challenge_desc) {
		this.challenge_desc = challenge_desc;
		return this;
	}
	public Integer getGood_num() {
		return good_num;
	}
	public MemberChallengeBean setGood_num(Integer good_num) {
		this.good_num = good_num;
		return this;
	}
	public Integer getComment_num() {
		return comment_num;
	}
	public MemberChallengeBean setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
		return this;
	}
	public Integer getCollection_num() {
		return collection_num;
	}
	public MemberChallengeBean setCollection_num(Integer collection_num) {
		this.collection_num = collection_num;
		return this;
	}
	public Integer getShare_num() {
		return share_num;
	}
	public MemberChallengeBean setShare_num(Integer share_num) {
		this.share_num = share_num;
		return this;
	}
	public Integer getOffical_sort() {
		return offical_sort;
	}
	public MemberChallengeBean setOffical_sort(Integer offical_sort) {
		this.offical_sort = offical_sort;
		return this;
	}
	public String getShop_id() {
		return shop_id;
	}
	public MemberChallengeBean setShop_id(String shop_id) {
		this.shop_id = shop_id;
		return this;
	}
	
	


}
