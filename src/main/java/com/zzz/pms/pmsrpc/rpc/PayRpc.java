package com.zzz.pms.pmsrpc.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "frpc-pay", url = "${frpc.pay.url}")
public interface PayRpc {

    @GetMapping(value = "/pay/detail")
    public Map<String, Object> detail(@RequestParam Integer codeType, @RequestParam String payOrder);
}
