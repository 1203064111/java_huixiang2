package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.product.ProductCarBean;
import tst.project.page.PageBean;

/**
 * @author Miscanthus
 */
@Mapper
public interface ProductCarDao {
	/**
     * 用户购物车列表
     * @param productCarBean
     */
    public List<ProductCarBean> getProductCars(ProductCarBean productCarBean,PageBean pageBean);
    
	/**
	 * 用户购物车 包含的店铺列表
	 * @param productCarBean
	 * @return
	 */
	public List<Map<String,Object>> getProductShops(ProductCarBean productCarBean);
	
	/**
	 * 购物车详情
	 * @param productCarBean
	 * @return
	 */
	public ProductCarBean getProductCarDetail(ProductCarBean productCarBean);

	/**
     * 店铺用户的购物车数量
     * @param productCarBean
     * @return
     */
    int getProductCarsNum(ProductCarBean productCarBean);
    /**
     * 修改购物车数量
     * @param productCarBean
     * @return
     */
    int updateProductCarNum(ProductCarBean productCarBean);
    /**
     * 删除购物车（支持批量删除）
     * @param carId
     * @return
     */
    int deleteProductCar(ProductCarBean productCarBean);

    /**
     * 添加购物车
     * @param productCarBean
     * @return
     */
    int insertProductCar(ProductCarBean productCarBean);
}
