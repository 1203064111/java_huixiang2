package tst.project.bean.hx;

import java.util.List;

public class HxRecordBean {
	private String error;
	private String action;
	private String application;
	private String timestamp;
	private String duration;
	private String organization;
	private String applicationName;
	private String uri;
	private List<DataBean> data;
	
	public String getError() {
		return error;
	}

	public HxRecordBean setError(String error) {
		this.error = error;
		return this;
	}

	public String getAction() {
		return action;
	}

	public HxRecordBean setAction(String action) {
		this.action = action;
		return this;
	}

	public String getApplication() {
		return application;
	}

	public HxRecordBean setApplication(String application) {
		this.application = application;
		return this;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public HxRecordBean setTimestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public String getDuration() {
		return duration;
	}

	public HxRecordBean setDuration(String duration) {
		this.duration = duration;
		return this;
	}

	public String getOrganization() {
		return organization;
	}

	public HxRecordBean setOrganization(String organization) {
		this.organization = organization;
		return this;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public HxRecordBean setApplicationName(String applicationName) {
		this.applicationName = applicationName;
		return this;
	}

	public String getUri() {
		return uri;
	}

	public HxRecordBean setUri(String uri) {
		this.uri = uri;
		return this;
	}

	public List<DataBean> getData() {
		return data;
	}

	public HxRecordBean setData(List<DataBean> data) {
		this.data = data;
		return this;
	}

	public class DataBean{
		private String url;

		public String getUrl() {
			return url;
		}

		public DataBean setUrl(String url) {
			this.url = url;
			return this;
		}
		
	}	 
}
