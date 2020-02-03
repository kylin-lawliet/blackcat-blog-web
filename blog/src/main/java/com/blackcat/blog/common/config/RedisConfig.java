package com.blackcat.blog.common.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;


/**
 * @author zjjlive)
 * @version 1.0
 * @website https://www.foreknow.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
//@Configuration
//@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 缓存数据时Key的生成器，可以依据业务和技术场景自行定制
     *
     * @return
     */
    /*@Bean
    @Override
    @Deprecated
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                //类名+方法名
                sb.append(target.getClass().getName());
                sb.append("." + method.getName());
                for (Object obj : params) {
                    sb.append(String.valueOf(obj));
                }
                System.out.println("============:" + sb.toString());
                return sb.toString();
            }

        };
    }

    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(null);
        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }

    @Bean
    @SuppressWarnings({"rawtypes", "unchecked"})
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        //使用Jackson2JsonRedisSerializer替换默认的序列化规则
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        //设置value的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        //设置key的序列化规则
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }*/
}
