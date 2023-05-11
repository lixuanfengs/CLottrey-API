package cn.cactusli.clottery.api.domain.receive.service.logic;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.model.LogicResult;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.logic
 * Description:
 *  逻辑接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:36
 * @Github https://github.com/lixuanfengs
 */
public interface LogicFilter {

    LogicResult filter(BehaviorMatter request);

}
