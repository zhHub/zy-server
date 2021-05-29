package com.zy.server.core.infra.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * fileName: RestTemplateExample
 * create: 2021-5-29 11:03
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public class RestTemplateExample {
    public static void main(String[] args) {
        /*
         * 目标地址：https://support.huaweicloud.com/productdesc-ecs/zh-cn_topic_0013771112.html
         * */
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://support.huaweicloud.com/qs-iam/iam_01_0034.html", String.class);
        System.out.println(forEntity.getStatusCode());
        System.out.println(forEntity.getStatusCode().is2xxSuccessful());
    }
}
