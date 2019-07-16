package tst.project.bean.wx;

import java.io.Serializable;
import java.util.List;

/**
 * @author shichen
 * @create 2018/3/6
 * @desc
 */
public class WXFansBean  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 关注该公众账号的总用户数
     */
    private int total;

    /**
     * 拉取的OPENID个数，最大值为10000
     */
    private int count;

    /**
     * 列表数据，OPENID的列表
     */
    private Data data;

    /**
     * 拉取列表的最后一个用户的OPENID
     */
    private String next_openid;

    private String errcode;
    private String errmsg;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public class Data {
        private List<String> openid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "WXFansBean{" +
                "total=" + total +
                ", count=" + count +
                ", next_openid='" + next_openid + '\'' +
                '}';
    }
}
