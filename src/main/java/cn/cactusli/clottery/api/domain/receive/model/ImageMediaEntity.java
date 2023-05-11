package cn.cactusli.clottery.api.domain.receive.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.model
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/11 14:39
 * @Github https://github.com/lixuanfengs
 */
public class ImageMediaEntity {

    @XStreamAlias("MediaId")
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public ImageMediaEntity setMediaId(String mediaId) {
        MediaId = mediaId;
        return this;
    }
}
