package cn.cactusli.clottery.api.application;

/**
 * Package: cn.cactusli.clottery.api.application
 * Description:
 *  验证
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:31
 * @Github https://github.com/lixuanfengs
 */
public interface IWxValidateService {

    /**
     * 验签
     * @param signature 签名
     * @param timestamp 时间
     * @param nonce     当前
     * @return          结果
     */
    boolean checkSign(String signature, String timestamp, String nonce);
}
