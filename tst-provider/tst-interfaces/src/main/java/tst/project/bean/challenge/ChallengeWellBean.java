package tst.project.bean.challenge;
import java.io.Serializable;

public class ChallengeWellBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int well_id;//id
	private int member_id;//用户id
	private String update_time;
	private String create_time;
	private int challenge_id;//挑战视频id
	private String wx_code;
	private String qq_code;
	private String fb_code;
	private String tw_code;
	private String wb_code;
	private int is_delete;
	public int getMember_id() {
		return member_id;
	}
	public ChallengeWellBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeWellBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeWellBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getChallenge_id() {
		return challenge_id;
	}
	public ChallengeWellBean setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
		return this;
	}
	
	public int getWell_id() {
		return well_id;
	}
	public ChallengeWellBean setWell_id(int well_id) {
		this.well_id = well_id;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeWellBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getWx_code() {
		return wx_code;
	}
	public ChallengeWellBean setWx_code(String wx_code) {
		this.wx_code = wx_code;
		return this;
	}
	public String getQq_code() {
		return qq_code;
	}
	public ChallengeWellBean setQq_code(String qq_code) {
		this.qq_code = qq_code;
		return this;
	}
	public String getFb_code() {
		return fb_code;
	}
	public ChallengeWellBean setFb_code(String fb_code) {
		this.fb_code = fb_code;
		return this;
	}
	public String getTw_code() {
		return tw_code;
	}
	public ChallengeWellBean setTw_code(String tw_code) {
		this.tw_code = tw_code;
		return this;
	}
	public String getWb_code() {
		return wb_code;
	}
	public ChallengeWellBean setWb_code(String wb_code) {
		this.wb_code = wb_code;
		return this;
	}



}
