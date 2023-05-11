package cn.cactusli.clottery.api.domain.receive.service.logic.impl;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.model.LogicResult;
import cn.cactusli.clottery.api.domain.receive.service.logic.LogicFilter;
import org.springframework.stereotype.Service;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.logic.impl
 * Description:
 *  关注微信公众号
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:39
 * @Github https://github.com/lixuanfengs
 */
@Service("subscribe")
public class SubscribeFilter implements LogicFilter {

    @Override
    public LogicResult filter(BehaviorMatter request) {
        LogicResult logicResult = new LogicResult();
        return logicResult.setIdentifing("text").setLogicT(logicResult.new LogicText().setContent("感谢关注，快来回复 抽奖 或 图片，参与仙人球的活动并欣赏美丽的风景吧！"));
    }
}
