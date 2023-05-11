package cn.cactusli.clottery.api.domain.receive.service.engine;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.engine
 * Description:
 *  消息引擎接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:58
 * @Github https://github.com/lixuanfengs
 */
public interface Engine {

    /**
     * 过滤器
     * @param request       入参
     * @return              出参
     * @throws Exception    异常
     */
    String process(final BehaviorMatter request) throws Exception;

}
