package com.akita.moa.portal.rest.api;

import com.akita.moa.common.api.CommonResult;
import com.akita.moa.portal.entity.ClientVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/{platform}/version")
    public Mono<CommonResult<ClientVersion>> clientVersion(@PathVariable String platform) {
        return Mono.just(CommonResult.success(ClientVersion.builder().platform(platform).version("0.0.1").upgradeLog("第一次测试").build()));
    }

}
