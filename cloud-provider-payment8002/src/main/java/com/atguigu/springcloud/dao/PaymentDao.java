package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by accumulate on 2021-12-08 21:23
 */
@Mapper
public interface PaymentDao {

    Long create(Payment payment);

    /*@Param("id")*/
    Payment getPaymentById( Long id);

}
