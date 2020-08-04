package com.akita.moa.desk.rest.api;

import com.akita.moa.common.api.CommonResult;
import com.akita.moa.desk.entity.Banner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @GetMapping("/list")
    public Mono<CommonResult<List<Banner>>> list() {
        Banner b1 = new Banner();
        b1.setUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596554849496&di=1e1bd6ce419a657534b740e1195a7347&imgtype=0&src=http%3A%2F%2Fpn.gexing.com%2Fshaitu%2F20130220%2F1311%2F51245b1e684f3.jpg");
        b1.setClickUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596554849496&di=1e1bd6ce419a657534b740e1195a7347&imgtype=0&src=http%3A%2F%2Fpn.gexing.com%2Fshaitu%2F20130220%2F1311%2F51245b1e684f3.jpg");

        Banner b2 = new Banner();
        b2.setUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596554849496&di=dc7e19468e684cc3016c7704d5cc7e4b&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171111%2F36a0d5e0b2f94289b2b0e993ff095fae.jpeg");
        b2.setClickUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596554849496&di=dc7e19468e684cc3016c7704d5cc7e4b&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171111%2F36a0d5e0b2f94289b2b0e993ff095fae.jpeg");

        Banner b3 = new Banner();
        b3.setUri("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2659998876,1549965278&fm=26&gp=0.jpg");
        b3.setClickUri("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2659998876,1549965278&fm=26&gp=0.jpg");

        return Mono.just(CommonResult.success(Arrays.asList(b1, b2, b3)));
    }
}
