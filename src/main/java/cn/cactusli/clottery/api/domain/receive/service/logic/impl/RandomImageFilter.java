package cn.cactusli.clottery.api.domain.receive.service.logic.impl;

import cn.cactusli.clottery.api.domain.receive.model.BehaviorMatter;
import cn.cactusli.clottery.api.domain.receive.model.GetToken;
import cn.cactusli.clottery.api.domain.receive.model.LogicResult;
import cn.cactusli.clottery.api.domain.receive.service.logic.LogicFilter;
import cn.cactusli.clottery.api.infrastructure.utils.CacheGuava;
import cn.cactusli.clottery.api.infrastructure.utils.HttpClient;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.concurrent.ExecutionException;

/**
 * Package: cn.cactusli.clottery.api.domain.receive.service.logic.impl
 * Description:
 *  随机返回一张图片
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/10 16:43
 * @Github https://github.com/lixuanfengs
 */
@Service("randomImageFilter")
public class RandomImageFilter implements LogicFilter {

    private static Logger logger = LoggerFactory.getLogger(RandomImageFilter.class);


    // 注入 Guava 缓存
    @Resource
    private CacheGuava cacheGuava;

    // 获取微信 Token 的接口
    private static final String GET_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

    // 获取媒体库 图片的列表
    private static final String GET_BATCHGET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";


    @Value("${wx.config.appid}")
    private String appid;

    @Value("${wx.config.granttype}")
    private String granttype;

    @Value("${wx.config.secret}")
    private String secret;

    @Override
    public LogicResult filter(BehaviorMatter request) {

        LogicResult logicResult = new LogicResult();

        try {
            // 获取微信 Token 并存入本地缓存 7200后 失效
            GetToken tokenCache = (GetToken) cacheGuava.getTokenCache().get(GET_TOKEN, () -> {
                logger.info("获取到的 uri: {}",montageUri(GET_TOKEN, granttype, appid, secret, ""));
                return JSON.parseObject(HttpClient.sendGetRequest(montageUri(GET_TOKEN, granttype, appid, secret, ""), ""), GetToken.class);
            });
            logger.info("获取到的 Token: {}",tokenCache.toString());

            if (null !=tokenCache) {
                JSONObject jsonString = new JSONObject();
                jsonString.put("type", "image");
                jsonString.put("offset", 0);
                jsonString.put("count", 1000);
                JSONObject objJson = JSONObject.parseObject(HttpClient.sendPostRequest(montageUri(GET_BATCHGET_MATERIAL,"","","", tokenCache.getAccess_token()), jsonString.toString()));
                JSONArray item = objJson.getJSONArray("item");

                // 根据返回集合的大小创建一个加密强度高的随机数生成器获
                int info = new SecureRandom().nextInt(item.size() + 1);
                JSONObject mjObject = (JSONObject) item.get(info);
                logger.info("获取到的图片 ID 为：{}", mjObject.get("media_id"));

                logicResult = logicResult.setIdentifing("image").setLogicImage(logicResult.new LogicImage()
                                .setMediaId(mjObject.get("media_id").toString()));
            }
            logger.info("最后返回的数据 logicResult: {}", logicResult.toString());
            return logicResult;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    // 拼接 GET 和 POST 请求
    public String montageUri(String url, String granttype, String appid, String secret, String token) {

        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url);
        if (!"".equals(granttype) && !"".equals(appid) && !"".equals(secret) && "".equals(token)) {
            return uri.queryParam("grant_type", granttype)
                    .queryParam("appid", appid)
                    .queryParam("secret", secret)
                    .build()
                    .encode()
                    .toUri()
                    .toString();
        } else {
            return uri.queryParam("access_token", token)
                    .build()
                    .encode()
                    .toUri()
                    .toString();
        }



    }
}
