package com.work.learn.service;

import com.work.learn.domain.OrderDomain;
import com.work.learn.result.RpcResult;

public interface OrderDubboService {

    RpcResult<OrderDomain> getOrder();

}
