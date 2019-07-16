package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tst.project.aspect.AppController;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductCarBean;
import tst.project.page.PageBean;

/**
 * @author lhw
 */
@Controller
@RequestMapping("/productCarInterfaces/v1.0")
public class ProductCarInterfaces {
    @Autowired
    IProductCarService productCarService;
    /**
     * 用户购物车 包含的店铺列表
     * @param productCarBean
     */
    @RequestMapping("/getProductCars")
    @AppController(isVerToken=true,isPage=true)
    public Object getProductCars(ProductCarBean productCarBean,PageBean pageBean) {
        return productCarService.getProductCars(productCarBean,pageBean);
    }
    
    /**
     * 用户购物车 包含的店铺列表
     * @param productCarBean
     */
    @RequestMapping("/getProductShops")
    @AppController(isVerToken=true)
    public Object getProductShops(ProductCarBean productCarBean) {
        return productCarService.getProductShops(productCarBean);
    }

    /**
     * 店铺用户的购物车数量
     * @param productCarBean
     * @return
     */
    @RequestMapping("getProductCarsNum")
    @AppController(isVerToken=true)
    public Object getProductCarsNum(ProductCarBean productCarBean){
        return productCarService.getProductCarsNum(productCarBean);
    }

    /**
     * 修改购物车数量
     * @param productCarBean
     * @return
     */
    @RequestMapping("updateProductCarNum")
    @AppController(isVerToken=true)
    public Object updateProductCarNum(ProductCarBean productCarBean){
        Object object = productCarService.updateProductCarNum(productCarBean);
        return object;
    }

    /**
     * 删除购物车（支持批量删除）
     * @param carId
     * @return
     */
    @RequestMapping("deleteProductCar")
    @AppController(isVerToken=true)
    public Object deleteProductCar(ProductCarBean productCarBean){
        Object object = productCarService.deleteProductCar(productCarBean);
        return object;
    }

    /**
     * 添加购物车
     * @param productCarBean
     * @return
     */
    @RequestMapping("insertProductCar")
    @AppController(isVerToken=true)
    public Object insertProductCar(ProductCarBean productCarBean){
        return productCarService.insertProductCar(productCarBean);
    }


}
