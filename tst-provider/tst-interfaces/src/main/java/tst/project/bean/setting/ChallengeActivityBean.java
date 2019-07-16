package tst.project.bean.setting;

import java.io.Serializable;
import java.util.List;

import tst.project.bean.product.ProductBean;

public class ChallengeActivityBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int activity_id;//挑战活动id
	private String activity_ids;
	private String activity_name;//挑战活动名称
	private String activity_img;//挑战封面
	private String video;//挑战活动视频路径
	private String product_id;//挑战产品id
	private String state;//活动状态 0关闭 1开启
	private String sales_state;//结算状态 0未结算 1已结算
	private String sales_state_show;
	private String sales_start_time;//销售分成开始区间
	private String sales_end_time;//销售分成结束区间
	private String challenge_rule;//挑战规则
	private String percent_reward;//销售比例奖励模板id
	private String fixed_reward;//固定值奖励方式模板id
	private String start_time;//开始时间
	private String end_time;//结束时间
	
	private String activity_people;//活动人数
	
	private int is_delete;//
	private String total_amount;//此次挑战的总销售额
	private String total_num;//此次销售
	private String update_time;
	private String create_time;
	

	private List<ChallengeSalesRewardBean> challengeSalesRewardBeans;
	private List<ChallengeFixedRewardBean> challengeFixedRewardBeans;
	private ProductBean productBean;
	
	
	
	public String getActivity_people() {
		return activity_people;
	}
	public ChallengeActivityBean setActivity_people(String activity_people) {
		this.activity_people = activity_people;
		return this;
	}
	public String getSales_state_show() {
		return sales_state_show;
	}
	public ChallengeActivityBean setSales_state_show(String sales_state_show) {
		this.sales_state_show = sales_state_show;
		return this;
	}
	public String getTotal_num() {
		return total_num;
	}
	public ChallengeActivityBean setTotal_num(String total_num) {
		this.total_num = total_num;
		return this;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public ChallengeActivityBean setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
		return this;
	}
	public String getActivity_img() {
		return activity_img;
	}
	public ChallengeActivityBean setActivity_img(String activity_img) {
		this.activity_img = activity_img;
		return this;
	}
	public String getActivity_ids() {
		return activity_ids;
	}
	public ChallengeActivityBean setActivity_ids(String activity_ids) {
		this.activity_ids = activity_ids;
		return this;
	}
	
	public String getState() {
		return state;
	}
	public ChallengeActivityBean setState(String state) {
		this.state = state;
		return this;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public ChallengeActivityBean setActivity_id(int activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public ChallengeActivityBean setActivity_name(String activity_name) {
		this.activity_name = activity_name;
		return this;
	}
	public String getVideo() {
		return video;
	}
	public ChallengeActivityBean setVideo(String video) {
		this.video = video;
		return this;
	}
	public String getProduct_id() {
		return product_id;
	}
	public ChallengeActivityBean setProduct_id(String product_id) {
		this.product_id = product_id;
		return this;
	}
	
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeActivityBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeActivityBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeActivityBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public List<ChallengeSalesRewardBean> getChallengeSalesRewardBeans() {
		return challengeSalesRewardBeans;
	}
	public ChallengeActivityBean setChallengeSalesRewardBeans(List<ChallengeSalesRewardBean> challengeSalesRewardBeans) {
		this.challengeSalesRewardBeans = challengeSalesRewardBeans;
		return this;
	}
	public List<ChallengeFixedRewardBean> getChallengeFixedRewardBeans() {
		return challengeFixedRewardBeans;
	}
	public ChallengeActivityBean setChallengeFixedRewardBeans(List<ChallengeFixedRewardBean> challengeFixedRewardBeans) {
		this.challengeFixedRewardBeans = challengeFixedRewardBeans;
		return this;
	}
	public String getSales_start_time() {
		return sales_start_time;
	}
	public ChallengeActivityBean setSales_start_time(String sales_start_time) {
		this.sales_start_time = sales_start_time;
		return this;
	}
	public String getSales_end_time() {
		return sales_end_time;
	}
	public ChallengeActivityBean setSales_end_time(String sales_end_time) {
		this.sales_end_time = sales_end_time;
		return this;
	}
	public String getChallenge_rule() {
		return challenge_rule;
	}
	public ChallengeActivityBean setChallenge_rule(String challenge_rule) {
		this.challenge_rule = challenge_rule;
		return this;
	}
	public String getPercent_reward() {
		return percent_reward;
	}
	public ChallengeActivityBean setPercent_reward(String percent_reward) {
		this.percent_reward = percent_reward;
		return this;
	}
	public String getFixed_reward() {
		return fixed_reward;
	}
	public ChallengeActivityBean setFixed_reward(String fixed_reward) {
		this.fixed_reward = fixed_reward;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public ChallengeActivityBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public ChallengeActivityBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public ChallengeActivityBean setProductBean(ProductBean productBean) {
		this.productBean = productBean;
		return this;
	}
	public String getSales_state() {
		return sales_state;
	}
	public ChallengeActivityBean setSales_state(String sales_state) {
		this.sales_state = sales_state;
		this.sales_state_show="0".equals(sales_state)?"未结算":
			"1".equals(sales_state)?"已结算":"";
		return this;
	}
	
	
	

}
