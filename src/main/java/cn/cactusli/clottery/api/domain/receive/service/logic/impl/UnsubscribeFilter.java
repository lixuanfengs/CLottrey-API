package cn.cactusli.clottery.api.domain.receive.service.logic.impl;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.model.LogicResult;
import cn.cactusli.clottery.api.domain.receive.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.logic.impl
 * Description:
 *  取消关注微信公众号
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:40
 * @Github https://github.com/lixuanfengs
 */
@Service("unsubscribe")
public class UnsubscribeFilter implements LogicFilter {

    private Logger logger = LoggerFactory.getLogger(UnsubscribeFilter.class);
    @Override
    public LogicResult filter(BehaviorMatter request) {
        logger.info("用户{}已取消关注", request.getOpenId());
        return null;
    }
}
