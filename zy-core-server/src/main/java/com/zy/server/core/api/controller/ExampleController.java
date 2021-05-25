package com.zy.server.core.api.controller;

import com.zy.server.core.infra.constant.ControllerConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName: ExampleController
 * create: 2021-5-24 23:00
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Api(value = ControllerConstant.EXAMPLE_CONTROLLER)
@RestController
@RequestMapping("/example")
public class ExampleController {
    
    @ApiOperation(value = "示例接口")
    @GetMapping
    public String example(){
        return "示例返回";
    }
}
