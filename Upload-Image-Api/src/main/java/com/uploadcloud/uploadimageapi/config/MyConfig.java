package com.uploadcloud.uploadimageapi.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyConfig {

    @Bean
    public Cloudinary getCloudinary() {

        Map map = new HashMap();
        map.put("cloud_name", "dgbkpsojy");
        map.put("api_key", "521923216928262");
        map.put("api_secret", "Dy4DDzaplVTy6q8ChxO98PkUYtM");
        map.put("secure", true);

        return new Cloudinary(map);
    }

}
