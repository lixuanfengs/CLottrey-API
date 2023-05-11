package cn.cactusli.clottery.api.application;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;

/**
 * Package: cn.cactusli.clottery.api.application
 * Description:
 *  处理接收信息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:30
 * @Github https://github.com/lixuanfengs
 */
public interface IWxReceiveService {

    /**
     * 接收信息
     *
     * @param behaviorMatter    入参
     * @return                  出惨
     * @throws Exception        异常
     */
    String doReceive(BehaviorMatter behaviorMatter) throws Exception;

}
