package com.xin.note;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xin.note.common.utils.MybatisGeneratorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class NoteApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
    /**
     * 使用bean方式注入fastjson解析器
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 创建fastjson对象
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig confg = new FastJsonConfig();
        // 设置是否需要格式化
        confg.setSerializerFeatures(SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(confg);
        return new HttpMessageConverters(converter);
    }


    public static void main(String[] args) {
        SpringApplication.run(NoteApplication.class, args);
    }


}
