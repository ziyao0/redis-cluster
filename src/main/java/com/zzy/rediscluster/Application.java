package com.zzy.rediscluster;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Redisson redisson() {

        Config config = new Config();
        //单机版配置
        config.useSingleServer().setAddress("redis://39.100.197.157:6379").setDatabase(0);
        //集群 配置
        /*config.useClusterServers()
                .addNodeAddress("redis://192.168.32.245:6379")
                .addNodeAddress("redis://192.168.32.245:6380")
                .addNodeAddress("redis://192.168.32.245:6381")
                .addNodeAddress("redis://192.168.32.245:6382")
                .addNodeAddress("redis://192.168.32.245:6383")
                .addNodeAddress("redis://192.168.32.245:6384");*/
        return (Redisson) Redisson.create(config);
    }
}
