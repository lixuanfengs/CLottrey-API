package cn.cactusli.clottery.api.infrastructure.utils;

import com.google.common.cache.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Package: cn.cactusli.clottery.api.infrastructure.utils
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/5/10 17:23
 * @Github https://github.com/lixuanfengs
 */
@Component
public class CacheGuava {

    private Cache<String, Object> tokenCache = CacheBuilder.newBuilder()
                // 设置并发级别为5，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(5)
                // 设置写缓存后10秒钟后过期
                .expireAfterWrite(7200, TimeUnit.SECONDS)
                // 设置缓存容器的初始容量为8
                .initialCapacity(8)
                // 设置缓存最大容量为10，超过10之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(10)
                // 设置统计缓存的各种统计信息（生产坏境关闭）
                .recordStats()
                // 设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                }).build();

    public Cache<String, Object> getTokenCache() {
        return tokenCache;
    }

    public void setTokenCache(Cache<String, Object> tokenCache) {
        this.tokenCache = tokenCache;
    }
}
