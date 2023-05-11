package cn.cactusli.clottery.api.domain.receive.model;

import java.util.Date;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.model
 * Description:
 *  息类型
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:28
 * @Github https://github.com/lixuanfengs
 */
public class BehaviorMatter {

    private String openId;
    private String fromUserName;
    private String msgType;
    private String content;
    private String event;
    private Date createTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
