package com.akita.moa.desk.rest.api;

import com.akita.moa.common.api.CommonResult;
import com.akita.moa.desk.entity.Webapp;
import com.akita.moa.desk.entity.WebappSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/webapp")
public class WebappController {

    @GetMapping("/list")
    public Mono<CommonResult<List<WebappSet>>> list() {
        WebappSet s1 = new WebappSet();

        Webapp a1 = new Webapp();
        a1.setIcon("icon://add");
        a1.setName("测试应用");
        a1.setUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596555783682&di=f7bb0bfe12942a0affd7cd25a59e2928&imgtype=0&src=http%3A%2F%2Fpn.gexing.com%2FG1%2FM00%2FE7%2F8A%2FrBACFFcsksbQx6dQABUfWBlAB7o930.jpg");

        s1.setCategory("测试类别");
        s1.setWebapps(Arrays.asList(a1, a1, a1, a1, a1));

        return Mono.just(CommonResult.success(Arrays.asList(s1, s1, s1)));
    }

}
