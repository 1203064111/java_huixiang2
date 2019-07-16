package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.container.page.Page;

import tst.project.aspect.AppController;
import tst.project.bean.order.OrderAssessmentBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.product.FootprintBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductClassBean;
import tst.project.bean.product.ShopBean;
import tst.project.bean.product.ShopProductBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/productInterfaces/v1.0")
public class ProductInterfaces {

    @Autowired
    IProductService productService;
   
    @RequestMapping("/getMemberShopDetail")
    @AppController(isVerToken=true)
    public Object getMemberShopDetail(ShopBean shopBean) {
        return productService.getMemberShopDetail(shopBean);
    }
    
    @RequestMapping("/insertShop")
    @AppController(isVerToken=true)
    public Object insertShop(ShopBean shopBean) {
        return productService.insertShop(shopBean);
    }
    
    @RequestMapping("/getShopDetail")
    @AppController
    public Object getShopDetail(ShopBean shopBean) {
        return productService.getShopDetail(shopBean);
    }
    
    @RequestMapping("/getProductCount")
    @AppController
    public Object getProductCount(ProductBean productBean) {
        return productService.getProductCount(productBean);
    }
    
    @RequestMapping("/getShopAddProducts")
    @AppController(isPage=true)
    public Object getShopAddProducts(ShopProductBean shopProductBean,PageBean pageBean) {
        return productService.getShopAddProducts(shopProductBean,pageBean);
    }
    
    @RequestMapping("/getShopProducts")
    @AppController(isPage=true)
    public Object getShopProducts(ShopProductBean shopProductBean,PageBean pageBean) {
        return productService.getShopProducts(shopProductBean,pageBean);
    }
    
    
    @RequestMapping("/insertShopProduct")
    @AppController(isVerToken=true)
    public Object insertShopProduct(ShopProductBean shopProductBean) {
        return productService.insertShopProduct(shopProductBean);
    }
    
    @RequestMapping("/getFootprints")
    @AppController(isPage=true)
    public Object getFootprints(FootprintBean footprintBean,PageBean pageBean) {
        return productService.getFootprints(footprintBean,pageBean);
    }
    
    @RequestMapping("/getProductAssessments")
    @AppController(isPage=true)
    public Object getProductAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean) {
        return productService.getProductAssessments(orderAssessmentBean,pageBean);
    }
    
    @RequestMapping("/getProductClasss")
    @AppController
    public Object getProductClasss(ProductClassBean productClassBean) {
        return productService.getProductClasss(productClassBean);
    }
    

    @RequestMapping("/getProducts")
    @AppController(isPage=true)
    public Object getProducts(ProductBean productBean,PageBean pageBean) {
        //Todo 点击产品详情插入浏览痕迹表
        return productService.getProducts(productBean,pageBean);
    }
    @RequestMapping("/getProductsByRecommand")
    @AppController()
    public Object getProductsByRecommand(ProductBean productBean) {
        return productService.getProductsByRecommand(productBean);
    }
    
    @RequestMapping("/getProductsByHot")
    @AppController()
    public Object getProductsByHot(ProductBean productBean) {
        return productService.getProductsByHot(productBean);
    }
    @RequestMapping("/getProductsByMemberOrder")
	@AppController(isVerToken = true,isPage=true)
	public Object getProductsByMemberOrder(OrderMerchantsBean orderMerchantsBean,PageBean pageBean) throws Exception {
		return productService.getProductsByMemberOrder(orderMerchantsBean,pageBean);
	}
    @RequestMapping("/getProductDetail")
    @AppController
    public Object getProductDetail(ProductBean productBean) {
        //Todo 点击产品详情插入浏览痕迹表
        return productService.getProductDetail(productBean);
    }


}
