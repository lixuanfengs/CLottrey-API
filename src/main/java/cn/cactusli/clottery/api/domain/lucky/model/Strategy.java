package cn.cactusli.clottery.api.domain.lucky.model;

/**
 * Package: cn.cactusli.clottery.api.domain.lucky.model
 * Description:
 *  策略
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:24
 * @Github https://github.com/lixuanfengs
 */
public class Strategy {


    private String text;
    private String top;

    public Strategy(String text, String top) {
        this.text = text;
        this.top = top;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

}
