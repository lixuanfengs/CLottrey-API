package cn.cactusli.clottery.api.infrastructure.utils.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.cactusli.clottery.api.infrastructure.utils.sdk.XmlUtil.mapToXML;

/**
 * Package: cn.cactusli.clottery.api.infrastructure.utils.sdk
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/9 10:20
 * @Github https://github.com/lixuanfengs
 */
public class SendUtil {


    /**
     * 回复文本消息
     */
    public static String sendTextMsg(Map<String,String> requestMap, String content){

        Map<String,Object> map = new HashMap<>();
        map.put("ToUserName", requestMap.get(WeChatConstant.FROM_USER_NAME));
        map.put("FromUserName", requestMap.get(WeChatConstant.TO_USER_NAME));
        map.put("MsgType", WeChatConstant.RESP_MESSAGE_TYPE_TEXT);
        map.put("CreateTime", System.currentTimeMillis());
        map.put("Content", content);
        return mapToXML(map);
    }

    /**
     * 回复图文消息
     */
    public static String sendArticleMsg(Map<String,String> requestMap, List<Article> articles){
        if(articles == null || articles.size()<1){
            return "";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("ToUserName", requestMap.get(WeChatConstant.FROM_USER_NAME));
        map.put("FromUserName", requestMap.get(WeChatConstant.TO_USER_NAME));
        map.put("MsgType", WeChatConstant.RESP_MESSAGE_TYPE_NEWS);
        map.put("CreateTime", System.currentTimeMillis());
        List<Map<String, Object>> articleMaps = new ArrayList<>();
        for(Article article : articles){
            Map<String,Object> item = new HashMap<>();
            Map<String,Object> itemContent = new HashMap<>();
            itemContent.put("Title", article.getTitle());
            itemContent.put("Description", article.getDescription());
            itemContent.put("PicUrl", article.getPicUrl());
            itemContent.put("Url", article.getUrl());
            item.put("item",itemContent);
            articleMaps.add(item);
        }
        map.put("Articles", articleMaps);
        map.put("ArticleCount", articleMaps.size());
        return mapToXML(map);
    }
}
