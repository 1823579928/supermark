package com.dageda.vueshiromodel.shiro.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName RedisCacheManager
 * @Description:
 * @Author 邹捷
 * @Date 2019/11/20
 * @Version V1.0
 **/
public class RedisCacheManager  implements CacheManager {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new RedisCache<>(name, redisTemplate);
    }
}
