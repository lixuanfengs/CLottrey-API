package cn.cactusli.clottery.api.domain.receive.model;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.model
 * Description:
 *  返回消息的类型
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/11 10:53
 * @Github https://github.com/lixuanfengs
 */
public class LogicResult {

    private String identifing;

    private LogicText logicT;

    private LogicImage logicImage;

    public LogicResult() {

    }

    public class LogicText {
        private String content;

       public LogicText() {
       }

       public String getContent() {
            return content;
        }

        public LogicText setContent(String content) {
            this.content = content;
            return this;
        }

        @Override
        public String toString() {
            return "LogicText{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    public class LogicImage {
        private String mediaId;

        public LogicImage() {

        }


        public String getMediaId() {
            return mediaId;
        }

        public LogicImage setMediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }

        @Override
        public String toString() {
            return "LogicImage{" +
                    ", mediaId='" + mediaId + '\'' +
                    '}';
        }
    }


    public String getIdentifing() {
        return identifing;
    }

    public LogicResult setIdentifing(String identifing) {
        this.identifing = identifing;
        return this;
    }

    public LogicText getLogicT() {
        return logicT;
    }

    public LogicResult setLogicT(LogicText logicT) {
        this.logicT = logicT;
        return this;
    }

    public LogicImage getLogicImage() {
        return logicImage;
    }

    public LogicResult setLogicImage(LogicImage logicImage) {
        this.logicImage = logicImage;
        return this;
    }

    @Override
    public String toString() {
        return "LogicResult{" +
                "identifing='" + identifing + '\'' +
                ", logicT=" + logicT +
                ", logicImage=" + logicImage +
                '}';
    }
}
