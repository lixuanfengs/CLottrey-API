package cn.cactusli.clottery.api.domain.receive.service.engine.impl;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.model.ImageMediaEntity;
import cn.cactusli.clottery.api.domain.receive.model.LogicResult;
import cn.cactusli.clottery.api.domain.receive.model.MessageTextEntity;
import cn.cactusli.clottery.api.domain.receive.service.engine.EngineBase;
import cn.cactusli.clottery.api.domain.receive.service.logic.LogicFilter;
import cn.cactusli.clottery.api.infrastructure.utils.XmlUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.engine.impl
 * Description:
 *  消息处理
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 11:00
 * @Github https://github.com/lixuanfengs
 */
@Service("msgEngineHandle")
public class MsgEngineHandle extends EngineBase {

    @Value("${wx.config.originalid:gh_95b2229b90fb}")
    private String originalId;

    @Override
    public String process(BehaviorMatter request) throws Exception {
        LogicFilter router = super.router(request);
        if (null == router) {
            return null;
        }
        LogicResult logicResult = router.filter(request);
        if (null != logicResult && logicResult.getIdentifing().equals("text")) {
            //反馈信息[文本]
            return combinationMessageText(logicResult, request);
        } else if (null != logicResult && logicResult.getIdentifing().equals("image")) {
            return combinationMessageImage(logicResult, request);
        } else {
            return "";
        }
    }

    public String combinationMessageText(LogicResult logicResult, BehaviorMatter request) {
        //反馈信息[文本] && [图片] 等信息
        MessageTextEntity res = new MessageTextEntity();
        res.setToUserName(request.getOpenId());
        res.setFromUserName(originalId);
        res.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000L));
        res.setMsgType(logicResult.getIdentifing());
        res.setContent(logicResult.getLogicT().getContent());
        return XmlUtil.beanToXml(res);
    }

    public String combinationMessageImage(LogicResult logicResult, BehaviorMatter request) {
        //反馈信息[文本] && [图片] 等信息
        MessageTextEntity res = new MessageTextEntity();
        res.setToUserName(request.getOpenId());
        res.setFromUserName(originalId);
        res.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000L));
        res.setMsgType(logicResult.getIdentifing());
        res.setImage(new ImageMediaEntity().setMediaId(logicResult.getLogicImage().getMediaId()));

        return XmlUtil.beanToXml(res);
    }

}
