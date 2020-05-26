package com.work.learn.controller;

import com.work.learn.result.RpcResult;
import com.work.learn.service.OrderDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @description:
 * @author: HeYin
 * @date: 2020-05-26 18:15
 * @version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderConsumerController {

    @Reference
    OrderDubboService orderDubboService;

    @GetMapping("getOrder")
    public RpcResult getOrder() {
        return orderDubboService.getOrder();
    }
}
