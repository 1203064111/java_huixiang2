package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**
 * @author lhw
 */
public class CarResultBean implements Serializable {

    /**
     * shop_id : 9
     * productCar : [{"car_num":"3","shop_id":"9","shop_img":"图片1","specification_id":"","specification_name":"","specification_price":""}]
     * shop_img : 图片1
     */
    /**
     * 店铺id
     */
    private String shop_id;
    /**
     * 店铺图片
     */
    private String shop_img;
    /**
     * 购物车
     */
    private List<ProductCar> productCar;

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


    public List<ProductCar> getProductCar() {
        return productCar;
    }

    public void setProductCar(List<ProductCar> productCar) {
        this.productCar = productCar;
    }
}
