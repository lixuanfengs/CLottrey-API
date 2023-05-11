package cn.cactussli.clottery.api.test;

import cn.cactusli.clottery.api.infrastructure.utils.HttpClient;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Package: cn.cactussli.clottery.api
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/11 9:40
 * @Github https://github.com/lixuanfengs
 */
@SpringBootTest
public class ImagesTest {


    private static Logger logger = LoggerFactory.getLogger(ImagesTest.class);


    @Test
    public void getImages() {

        String url1 = "https://api.weixin.qq.com/cgi-bin/token";
        UriComponentsBuilder uriBuilder1 = UriComponentsBuilder.fromHttpUrl(url1)
                .queryParam("grant_type", "client_credential")
                .queryParam("appid", "wxa15b34ca66b01ab8")
                .queryParam("secret", "d3835526c9ff1fa84ca5a1207615e8b0");
        // GetToken getToken = JSON.parseObject(HttpClient.sendGetRequest(uriBuilder1.build().encode().toUri().toString(), null), GetToken.class);

        String url2 = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";
        UriComponentsBuilder uriBuilder2 = UriComponentsBuilder.fromHttpUrl(url2)
                .queryParam("access_token","68_xNtFlw4KmJgLhze5N87wXMBWPWrkaqoeI2hvpCkK--8XmxmRnJoYtss44hFfU7sMA6nDXg-xPOi_QmE-DesDn0A8WXVUvEGbiuc-5aCbBSLAwv8gbfRaekoArSsQHQeAIACTC");


        JSONObject jsonString = new JSONObject();
        jsonString.put("type", "image");
        jsonString.put("offset", 0);
        jsonString.put("count", 20);

        logger.info(jsonString.toString());
        String s = HttpClient.sendPostRequest(uriBuilder2.build().encode().toUri().toString(), jsonString.toJSONString());
        logger.info("\n  请求的参数：{}  \n  返回的数据：{}",jsonString, s);

    }
}
