package tst.project.bean.hx;

import java.util.List;

public class HxMsgBean {
	private String msg_id;
	private String timestamp;
	private String direction;
	private String to;
	private String from;
	private String chat_type;
	private PayloadBean payload;
	
	
	
	public String getMsg_id() {
		return msg_id;
	}



	public HxMsgBean setMsg_id(String msg_id) {
		this.msg_id = msg_id;
		return this;
	}



	public String getTimestamp() {
		return timestamp;
	}



	public HxMsgBean setTimestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}



	public String getDirection() {
		return direction;
	}



	public HxMsgBean setDirection(String direction) {
		this.direction = direction;
		return this;
	}



	public String getTo() {
		return to;
	}



	public HxMsgBean setTo(String to) {
		this.to = to;
		return this;
	}



	public String getFrom() {
		return from;
	}



	public HxMsgBean setFrom(String from) {
		this.from = from;
		return this;
	}



	public String getChat_type() {
		return chat_type;
	}



	public HxMsgBean setChat_type(String chat_type) {
		this.chat_type = chat_type;
		return this;
	}



	public PayloadBean getPayload() {
		return payload;
	}



	public HxMsgBean setPayload(PayloadBean payload) {
		this.payload = payload;
		return this;
	}



	public class PayloadBean{
		private List<BodiesBean> bodies;
		public List<BodiesBean> getBodies() {
			return bodies;
		}
		public PayloadBean setBodies(List<BodiesBean> bodies) {
			this.bodies = bodies;
			return this;
		}
		
		public class BodiesBean{
			private String msg;
			private String type;
			public String getMsg() {
				return msg;
			}
			public BodiesBean setMsg(String msg) {
				this.msg = msg;
				return this;
			}
			public String getType() {
				return type;
			}
			public BodiesBean setType(String type) {
				this.type = type;
				return this;
			}
		}
	}
     
}
