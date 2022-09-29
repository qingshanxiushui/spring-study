package com.bjpowernode.service.impl;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.dao.SaleDao;
import com.bjpowernode.entity.Goods;
import com.bjpowernode.entity.Sale;
import com.bjpowernode.excetion.NotEnougthException;
import com.bjpowernode.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//@Transactional
public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


    //@Transactional 放在public方法的上面。表示方法有事务功能
    /*
    第一种设置方式
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false, timeout = 20,
            rollbackFor = {NullPointerException.class,NotEnougthException.class})
     */


    /*
    第二种设置方式
     @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false, timeout = 20
     )

     解释 rollbackFor 的使用；
     1）框架首先检查方法抛出的异常是不是在 rollbackFor 的数组中， 如果在一定回滚。
     2）如果方法抛出的异步不在 rollbackFor 数组， 框架会继续检查 抛出的异常 是不是 RuntimeException.
        如果是RuntimeException， 一定回滚。


     例如 抛出 SQLException , IOException
     rollbackFor={SQLException.class, IOException.class}
     */


    //第三种方式： 使用默认值 REQUIRED ， 发生运行时异常回滚。
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer num) {
        System.out.println("====buy方法的开始====");

        //生成销售记录
        Sale sale  = new Sale();
        sale.setGid(goodsId);
        sale.setNum(num);
        saleDao.insertSale(sale);

        //查询商品
        Goods goods = goodsDao.selectById(goodsId);
        if( goods == null){
            throw new NullPointerException( goodsId+",商品不存在");
        } else if( goods.getAmount() < num ){
            throw new NotEnougthException(goodsId+",库存不足");
        }

        //更新库存
        Goods buyGoods  = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(num);

        goodsDao.updateGoods(buyGoods);


        System.out.println("====buy方法的完成====");
    }
}
