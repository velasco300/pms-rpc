package com.zzz.pms.pmsrpc.controller;

import com.zzz.pms.pmsgeneric.common.Result;
import com.zzz.pms.pmsrpc.rpc.PayRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "外部第三方接口模块")
@RestController
@RequestMapping(value = "pay/")
public class PayController extends BaseController {

    @Autowired
    private PayRpc payRpc;

    @ApiOperation(value = "查询支付详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "codeType", value = "支付类型", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "payOrder", value = "支付单号", dataType = "String", required = true)
    })
    @GetMapping(value = "detail")
    public Result<String> queryByCodeTypeAndPayOrder(Integer codeType, String payOrder) {
        log.error(msg("参数codeType=" + codeType + "; payOrder=" + payOrder));
        Result<String> rs = new Result<String>();
        log.debug(msg(payRpc.detail(codeType, payOrder).toString()));
        return rs;
    }

}
