package cn.cactusli.clottery.api.domain.lucky.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: cn.cactusli.clottery.api.domain.lucky.model
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:23
 * @Github https://github.com/lixuanfengs
 */
public class Prize {

    private List<Strategy> fonts = new ArrayList<>();
    private String background;

    public Prize(Strategy fonts, String background) {
        this.fonts.add(fonts);
        this.background = background;
    }

    public Prize(List<Strategy> fonts, String background) {
        this.fonts = fonts;
        this.background = background;
    }

    public List<Strategy> getFonts() {
        return fonts;
    }

    public void setFonts(List<Strategy> fonts) {
        this.fonts = fonts;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
