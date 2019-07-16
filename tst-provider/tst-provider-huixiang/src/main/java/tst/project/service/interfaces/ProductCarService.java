package tst.project.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.aspect.AppException;
import tst.project.bean.product.*;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.interfaces.MemberDao;
import tst.project.dao.interfaces.ProductCarDao;
import tst.project.interfaces.IProductCarService;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductCarService implements IProductCarService {

    @Autowired
    ProductCarDao productCarDao;
    @Autowired
    MemberDao memberDao;
    @Autowired
    GoodsDaoC goodsDaoC;

    @Override
    public Object getProductCars(ProductCarBean productCarBean,PageBean pageBean) {
    	// TODO Auto-generated method stub
    	List<ProductCarBean> productCarBeans=productCarDao.getProductCars(productCarBean, pageBean);
    	return pageBean.setObject(productCarBeans);
    }
    
    
    @Override
    public Object getProductShops(ProductCarBean productCarBean) {
    	
        return productCarDao.getProductShops(productCarBean);
    }

    @Override
    public Object getProductCarsNum(ProductCarBean productCarBean) {
        return productCarDao.getProductCarsNum(productCarBean);
    }

    @Override
    public int updateProductCarNum(ProductCarBean productCarBean) {
        int num = productCarDao.updateProductCarNum(productCarBean);
        if (num <= 0) {
            throw new AppException("更新购物车数量失败");
        }
        return num;
    }

    @Override
    public Object deleteProductCar(ProductCarBean productCarBean) {
        int num = productCarDao.deleteProductCar(productCarBean);
        if (num <= 0) {
            throw new AppException("删除购物车失败");
        }
        return num;
    }

    @Override
    public Object insertProductCar(ProductCarBean productCarBean) {
    	int num=0;
    	ProductCarBean productCarBean2=productCarDao.getProductCarDetail(productCarBean);
    	if(productCarBean2!=null){
    		int car_num=NumberUtils.Integer(productCarBean.getCar_num())+NumberUtils.Integer(productCarBean2.getCar_num());
			
			num=productCarDao.updateProductCarNum(new ProductCarBean()
					.setCar_id(productCarBean2.getCar_id())
					.setCar_num(car_num+""));
			if(num<=0){
				throw new AppException("添加失败");
			}
    	}else{
    		num = productCarDao.insertProductCar(productCarBean);
            if (num <= 0) {
                throw new AppException("添加购物车失败");
            }
    	}
        return num;
    }


}
