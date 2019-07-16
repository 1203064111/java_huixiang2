package tst.project.interfaces;

import tst.project.bean.product.ProductCarBean;
import tst.project.page.PageBean;

public interface IProductCarService {
	/**
     * 用户购物车列表
     * @param productCarBean
     */
    public Object getProductCars(ProductCarBean productCarBean,PageBean pageBean);
    
	/**
     *用户购物车 包含的店铺列表
     * @param productCarBean
     */
    public Object getProductShops(ProductCarBean productCarBean);
    /**
     * 店铺用户的购物车数量
     * @param productCarBean
     * @return
     */
    public Object getProductCarsNum(ProductCarBean productCarBean);
    /**
     * 修改购物车数量
     * @param productCarBean
     * @return
     */
    public int updateProductCarNum(ProductCarBean productCarBean);
    /**
     * 删除购物车（支持批量删除）
     * @param carId
     * @return
     */
    public Object deleteProductCar(ProductCarBean productCarBean);

    /**
     * 添加购物车
     * @param productCarBean
     * @return
     */
    public Object insertProductCar(ProductCarBean productCarBean);
}
