package cn.cactusli.clottery.api.interfaces;

import cn.cactusli.clottery.api.domain.lucky.model.Prize;
import cn.cactusli.clottery.api.domain.lucky.model.Strategy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: cn.cactusli.clottery.api.interfaces
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 11:02
 * @Github https://github.com/lixuanfengs
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LuckyController {

    @GetMapping(value = "queryPrizeList", produces = "application/json;charset=utf-8")
    public List<Prize> queryPrizeList() {

        List<Prize> list = new ArrayList<>();
        list.add(new Prize(new Strategy("MacBook Pro", "1%"), "#e9e8fe"));
        list.add(new Prize(new Strategy("iPhone 13", "8%"), "#b8c5f2"));
        list.add(new Prize(new Strategy("iPad", "11%"), "#e9e8fe"));
        list.add(new Prize(new Strategy("坚果投影仪", "25%"), "#b8c5f2"));
        list.add(new Prize(new Strategy("任天堂 Switch", "25%"), "#e9e8fe"));
        list.add(new Prize(new Strategy("HHKB 键盘", "30%"), "#b8c5f2"));

        return list;
    }
}
