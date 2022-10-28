package com.github0604hx;
/*
 * @project boot-starter
 * @file    com.github.demo.IndexController
 * CREATE   2022年10月27日 16:26 下午
 * --------------------------------------------------------------
 * 0604hx   https://github.com/0604hx
 * --------------------------------------------------------------
 */

import org.nerve.boot.Result;
import org.nerve.boot.util.DateUtil;
import org.nerve.boot.web.ctrl.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@RestController
public class IndexController extends BaseController {

    @RequestMapping("time")
    public Result time(){
        return resultWithData(()-> DateUtil.getDateTime());
    }

    @RequestMapping("up")
    public Result upTime(){
        return resultWithData(()-> {
            RuntimeMXBean runtimeMX = ManagementFactory.getRuntimeMXBean();
            return "JVM UpTime is "+runtimeMX.getUptime()+" ms!";
        });
    }
}
