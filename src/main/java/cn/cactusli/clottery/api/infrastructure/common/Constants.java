package cn.cactusli.clottery.api.infrastructure.common;

/**
 * Package: cn.cactusli.clottery.api.infrastructure.common
 * Description:
 *  通用常量类
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:17
 * @Github https://github.com/lixuanfengs
 */
public class Constants {

    // 匹配文字内容
    public static final class MessageType {

        private static final String MESSAGE_CLOTTERY = "抽奖";
        private static final String MESSAGE_IMAGE = "图片";

        public static String GET_MESSAGE_CLOTTERY() {
            return MESSAGE_CLOTTERY;
        }
        public static String GET_MESSAGE_IMAGE() {
            return MESSAGE_IMAGE;
        }

    }

}
