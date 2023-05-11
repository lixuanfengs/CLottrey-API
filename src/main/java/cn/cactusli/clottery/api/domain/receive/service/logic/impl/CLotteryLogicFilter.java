package cn.cactusli.clottery.api.domain.receive.service.logic.impl;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.model.LogicResult;
import cn.cactusli.clottery.api.domain.receive.service.logic.LogicFilter;
import cn.cactusli.clottery.rpc.booth.ICLotteryActivityBooth;
import cn.cactusli.clottery.rpc.booth.dto.AwardDTO;
import cn.cactusli.clottery.rpc.booth.req.DrawReq;
import cn.cactusli.clottery.rpc.booth.res.DrawRes;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.logic.impl
 * Description:
 *  抽奖服务
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:37
 * @Github https://github.com/lixuanfengs
 */
@Service("clotteryd")
public class CLotteryLogicFilter implements LogicFilter {


    @DubboReference(interfaceClass = ICLotteryActivityBooth.class)
    private ICLotteryActivityBooth icLotteryActivityBooth;

    @Override
    public LogicResult filter(BehaviorMatter request) {
        LogicResult result = new LogicResult();

        DrawReq drawReq = new DrawReq();
        drawReq.setuId(request.getOpenId().substring(1, 11));
        drawReq.setActivityId(100003L);

        DrawRes drawRes = icLotteryActivityBooth.doDraw(drawReq);
        AwardDTO awardDTO = drawRes.getAwardDTO();

        if (!"0000".equals(drawRes.getCode())) {
            return result.setIdentifing("text").setLogicT(result.new LogicText().setContent("抽奖 💐💐 提示：" + drawRes.getInfo()));
        }
        return  result.setIdentifing("text").setLogicT(result.new LogicText().setContent("恭喜 💐💐 中奖：" + awardDTO.getAwardName() + "\n 详情请联系 Cactusesli(微信号)"));
    }

}
