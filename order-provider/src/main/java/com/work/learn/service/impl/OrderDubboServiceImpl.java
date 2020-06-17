package com.work.learn.service.impl;

import com.work.learn.domain.OrderDomain;
import com.work.learn.result.RpcResult;
import com.work.learn.service.CallbackListener;
import com.work.learn.service.OrderDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

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
        String index = RpcContext.getContext().getAttachment("index");
        System.err.println("隐式参数:"+index);
        return RpcResult.success(new OrderDomain(1, 10086, LocalDateTime.now()));
    }

}
