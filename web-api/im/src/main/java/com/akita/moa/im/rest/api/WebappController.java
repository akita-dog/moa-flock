package com.akita.moa.im.rest.api;

import com.akita.moa.common.api.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RestController
public class WebappController {

    @GetMapping("/{username}/webapps")
    public Mono<CommonResult> listWebapp(@PathVariable String username) {
        return Mono.just(CommonResult.success(Arrays.asList("aaa", "bbb")));
    }

}
