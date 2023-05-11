package cn.cactusli.clottery.api.domain.receive.service.engine;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.service.logic.LogicFilter;
import cn.cactusli.clottery.api.infrastructure.common.Constants;

import java.util.Map;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.engine
 * Description:
 *  引擎基类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:59
 * @Github https://github.com/lixuanfengs
 */
public class EngineBase extends EngineConfig implements Engine {

    @Override
    public String process(BehaviorMatter request) throws Exception {
        throw new RuntimeException("未实现消息引擎服务");
    }


    /**
     * 消息类型&业务内容路由器
     *
     * @param request 消息内容
     * @return 返回消息处理器
     */
    protected LogicFilter router(BehaviorMatter request) {

        Map<String, LogicFilter> logicGroup = logicFilterMap.get(request.getMsgType());

        // 事件处理
        if ("event".equals(request.getMsgType())) {
            return logicGroup.get(request.getEvent());
        }

        // 内容处理
        if ("text".equals(request.getMsgType())) {
            if (Constants.MessageType.GET_MESSAGE_CLOTTERY().equals(request.getContent())) {
                return logicGroup.get("clottery");
            } else if (Constants.MessageType.GET_MESSAGE_IMAGE().equals(request.getContent())) {
                return logicGroup.get("material");
            } else {

            }
        }

        return null;
    }

}
