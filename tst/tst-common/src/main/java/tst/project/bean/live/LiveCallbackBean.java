package tst.project.bean.live;
/**
 * 腾讯直播流的状态回调
 * @author sjb
 *
 */
public class LiveCallbackBean {
	private String app;//推流域名
	private String appid;//
	private String appname;//推流路径
	private String channel_id;//
	private String errcode;//断流错误码
	private String errmsg;//断流错误信息
	private String event_time;//
	private String event_type;//event_type = 0 代表断流，event_type = 1 代表推流 100 — 新的录制文件已生成；200 — 新的截图文件已生成。
	private String idc_id;//
	private String node;//Upload接入点的ip
	private String sequence;//消息序列号，标识一次推流活动，一次推流活动会产生相同序列号的推流和断流消息
	private String set_id;//
	private String sign;//
	private String stream_id;//
	private String stream_param;//推流url参数
	private String t;//
	private String user_ip;//用户推流ip
	public String getApp() {
		return app;
	}
	public LiveCallbackBean setApp(String app) {
		this.app = app;
		return this;
	}
	public String getAppid() {
		return appid;
	}
	public LiveCallbackBean setAppid(String appid) {
		this.appid = appid;
		return this;
	}
	public String getAppname() {
		return appname;
	}
	public LiveCallbackBean setAppname(String appname) {
		this.appname = appname;
		return this;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public LiveCallbackBean setChannel_id(String channel_id) {
		this.channel_id = channel_id;
		return this;
	}
	public String getErrcode() {
		return errcode;
	}
	public LiveCallbackBean setErrcode(String errcode) {
		this.errcode = errcode;
		return this;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public LiveCallbackBean setErrmsg(String errmsg) {
		this.errmsg = errmsg;
		return this;
	}
	public String getEvent_time() {
		return event_time;
	}
	public LiveCallbackBean setEvent_time(String event_time) {
		this.event_time = event_time;
		return this;
	}
	public String getEvent_type() {
		return event_type;
	}
	public LiveCallbackBean setEvent_type(String event_type) {
		this.event_type = event_type;
		return this;
	}
	public String getIdc_id() {
		return idc_id;
	}
	public LiveCallbackBean setIdc_id(String idc_id) {
		this.idc_id = idc_id;
		return this;
	}
	public String getNode() {
		return node;
	}
	public LiveCallbackBean setNode(String node) {
		this.node = node;
		return this;
	}
	public String getSequence() {
		return sequence;
	}
	public LiveCallbackBean setSequence(String sequence) {
		this.sequence = sequence;
		return this;
	}
	public String getSet_id() {
		return set_id;
	}
	public LiveCallbackBean setSet_id(String set_id) {
		this.set_id = set_id;
		return this;
	}
	public String getSign() {
		return sign;
	}
	public LiveCallbackBean setSign(String sign) {
		this.sign = sign;
		return this;
	}
	public String getStream_id() {
		return stream_id;
	}
	public LiveCallbackBean setStream_id(String stream_id) {
		this.stream_id = stream_id;
		return this;
	}
	public String getStream_param() {
		return stream_param;
	}
	public LiveCallbackBean setStream_param(String stream_param) {
		this.stream_param = stream_param;
		return this;
	}
	public String getT() {
		return t;
	}
	public LiveCallbackBean setT(String t) {
		this.t = t;
		return this;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public LiveCallbackBean setUser_ip(String user_ip) {
		this.user_ip = user_ip;
		return this;
	}
}
