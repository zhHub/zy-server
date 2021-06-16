package com.zy.server.core.api.controller;

import com.zy.boot.email.exception.EmailSendException;
import com.zy.server.core.infra.constant.ControllerSwaggerConstant;
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
@Api(tags = ControllerSwaggerConstant.EXAMPLE_CONTROLLER)
@RestController("exampleController")
@RequestMapping("/example")
public class ExampleController {
    
    @ApiOperation(value = "示例接口")
    @GetMapping
    public String example(){
        throw new EmailSendException();
    }
}
