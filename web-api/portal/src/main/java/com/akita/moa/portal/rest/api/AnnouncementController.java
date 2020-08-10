package com.akita.moa.portal.rest.api;

import com.akita.moa.common.api.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @GetMapping("/latest")
    public Mono<CommonResult> latest() {
        return Mono.just(CommonResult.success("测试版本发布啦！！！！"));
    }
}
