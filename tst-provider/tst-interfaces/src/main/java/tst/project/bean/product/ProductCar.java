package tst.project.bean.product;
import java.io.Serializable;

/**
 * @author lhw
 */
public class ProductCar implements Serializable {

    /**
     * car_num : 3
     * shop_id : 9
     * shop_img : 图片1
     * specification_id :
     * specification_name :
     * specification_price :
     */

    /**
     * 购物车数量
     */
    private String car_num;
    /**
     * 所属店铺id
     */
    private String shop_id;
    /**
     * 所属店铺的图片
     */
    private String shop_img;
    /**
     * 规格id
     */
    private String specification_id;
    /**
     * 规格名称
     */
    private String specification_name;
    /**
     * 规格的价格
     */
    private String specification_price;

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public String getSpecification_id() {
        return specification_id;
    }

    public void setSpecification_id(String specification_id) {
        this.specification_id = specification_id;
    }

    public String getSpecification_name() {
        return specification_name;
    }

    public void setSpecification_name(String specification_name) {
        this.specification_name = specification_name;
    }

    public String getSpecification_price() {
        return specification_price;
    }

    public void setSpecification_price(String specification_price) {
        this.specification_price = specification_price;
    }
}

