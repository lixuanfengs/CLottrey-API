package cn.cactusli.clottery.api.domain.receive.service;

import cn.cactusli.clottery.api.application.IWxReceiveService;
import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.service.engine.Engine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service
 * Description:
 *  处理接收信息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 11:12
 * @Github https://github.com/lixuanfengs
 */
@Service
public class WxReceiveServiceImpl implements IWxReceiveService {

    @Resource(name = "msgEngineHandle")
    private Engine msgEngineHandle;

    @Override
    public String doReceive(BehaviorMatter behaviorMatter) throws Exception {
        return msgEngineHandle.process(behaviorMatter);
    }
}
