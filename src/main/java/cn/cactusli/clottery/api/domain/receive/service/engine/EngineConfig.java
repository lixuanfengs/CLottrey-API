package cn.cactusli.clottery.api.domain.receive.service.engine;

import cn.cactusli.clottery.api.domain.receive.service.logic.LogicFilter;
import cn.cactusli.clottery.api.domain.receive.service.logic.impl.CLotteryLogicFilter;
import cn.cactusli.clottery.api.domain.receive.service.logic.impl.RandomImageFilter;
import cn.cactusli.clottery.api.domain.receive.service.logic.impl.SubscribeFilter;
import cn.cactusli.clottery.api.domain.receive.service.logic.impl.UnsubscribeFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.engine
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:41
 * @Github https://github.com/lixuanfengs
 */
public class EngineConfig {


    @Resource
    private CLotteryLogicFilter lotteryLogicFilter;

    @Resource
    private SubscribeFilter subscribeFilter;

    @Resource
    private UnsubscribeFilter unsubscribeFilter;

    @Resource
    private RandomImageFilter randomImageFilter;

    protected static Map<String, Map<String, LogicFilter>> logicFilterMap = new HashMap<>();

    @PostConstruct
    public void init() {

        logicFilterMap.put("text", new HashMap<String, LogicFilter>() {{
            put("clottery", lotteryLogicFilter);
            put("material", randomImageFilter);
        }});

        logicFilterMap.put("event", new HashMap<String, LogicFilter>() {
            {
                put("subscribe", subscribeFilter);
                put("unsubscribe", unsubscribeFilter);
            }
        });


    }

}
