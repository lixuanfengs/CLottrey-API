package cn.cactusli.clottery.api.domain.validate;

import cn.cactusli.clottery.api.application.IWxValidateService;
import cn.cactusli.clottery.api.infrastructure.utils.sdk.SignatureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Package: cn.cactusli.clottery.api.domain.validate
 * Description:
 *  消息验证
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:31
 * @Github https://github.com/lixuanfengs
 */
@Service
public class WxValidateServiceImpl implements IWxValidateService {

    @Value("${wx.config.token}")
    private String token;

    @Override
    public boolean checkSign(String signature, String timestamp, String nonce) {
        return SignatureUtil.check(token, signature, timestamp, nonce);
    }
}
