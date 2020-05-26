package com.work.learn.service.impl;

import com.work.learn.domain.OrderDomain;
import com.work.learn.result.RpcResult;
import com.work.learn.service.OrderDubboService;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: HeYin
 * @date: 2020-05-26 18:09
 * @version: 1.0
 */
@Service
public class OrderDubboServiceImpl implements OrderDubboService {

    @Override
    public RpcResult<OrderDomain> getOrder() {
        return RpcResult.success(new OrderDomain(1, 10086, LocalDateTime.now()));
    }
}
