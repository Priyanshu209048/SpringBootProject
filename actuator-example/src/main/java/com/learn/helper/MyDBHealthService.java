package com.learn.helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class MyDBHealthService implements HealthIndicator {

    public static final String DB_SERVICE = "Database Service";

    public boolean isHealthGood(){
        //Custom logic
        return true;
    }

    @Override
    public Health health() {
        if (isHealthGood())
            return Health.up().withDetail(DB_SERVICE, "Database service is running.").build();

        return Health.down().withDetail(DB_SERVICE, "Database service is running down.").build();
    }

}
