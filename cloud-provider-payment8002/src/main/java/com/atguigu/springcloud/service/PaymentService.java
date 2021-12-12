package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by accumulate on 2021-12-08 21:37
 */
public interface PaymentService {
    Long create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
