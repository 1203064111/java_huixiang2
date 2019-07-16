package tst.project.bean.challenge;
import java.io.Serializable;

public class ChallengeCommentBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int comment_id;//id
	private int member_id;//用户id
	private String member_name;
	private String member_img;
	private String comment_desc;//评论内容
	private String update_time;
	private String create_time;
	private int challenge_id;//挑战视频id
	private int is_delete;
	
	
	public String getMember_name() {
		return member_name;
	}
	public ChallengeCommentBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public ChallengeCommentBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public ChallengeCommentBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeCommentBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeCommentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getChallenge_id() {
		return challenge_id;
	}
	public ChallengeCommentBean setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
		return this;
	}
	
	
	
	public int getComment_id() {
		return comment_id;
	}
	public ChallengeCommentBean setComment_id(int comment_id) {
		this.comment_id = comment_id;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeCommentBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getComment_desc() {
		return comment_desc;
	}
	public ChallengeCommentBean setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
		return this;
	}



}
