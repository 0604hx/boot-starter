package org.nerve.boot.web;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.lang3.StringUtils;
import org.nerve.boot.FileStore;
import org.nerve.boot.module.setting.Setting;
import org.nerve.boot.module.setting.SettingService;
import org.nerve.boot.util.FileLoader;
import org.nerve.boot.util.Timing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.List;

@Configuration
public class SystemInit {
    private Logger logger = LoggerFactory.getLogger(SystemInit.class);

    @Autowired
    SettingService settingService;
    @Autowired
    FileStore fileStore;

    @EventListener(ApplicationStartedEvent.class)
    public void initOnStart(){
        try{
            Class.forName("org.springframework.boot.test.context.SpringBootTest");
            logger.debug("[初始化] 检测到为测试环境，跳过...");
            return;
        }catch (ClassNotFoundException e){
            if(logger.isDebugEnabled()) logger.debug("[初始化] 程序即将初始化（包含但不限于超级管理员、附件目录）...");
        }

        Timing timing = new Timing();

        initSetting();

        if(logger.isDebugEnabled()) logger.debug("[初始化] 作业完成，耗时 {} 秒 ^_^", timing.toSecondStr());
    }

    /**
     * 初始化系统配置
     *
     * ① 判断是否存在 settings.json 文件
     * ②
     */
    private void initSetting(){
        try{
            String jsonStr = FileLoader.loadContent("settings.json");
            List<Setting> settings = JSON.parseArray(jsonStr, Setting.class);
            logger.info("[初始化-配置项] 读取到 {} 个配置信息", settings.size());

            for (int i = 0; i < settings.size(); i++) {
                Setting s = settings.get(i);
                if(s.getSort() == -1)
                    s.setSort(i);

                if(!settingService.existsByUUID(s.id())){
                    logger.info("[初始化-配置项] 检测到 {} 不存在，即将保存该项...", s.getId());

                    if(StringUtils.isEmpty(s.getContent()))
                        s.setContent(s.getDefaultContent());
                    else if(StringUtils.isEmpty(s.getDefaultContent()))
                        s.setDefaultContent(s.getContent());

                    settingService.save(s);
                }
            }
        }catch (IOException e){
            if(logger.isDebugEnabled()) logger.debug("[初始化-配置项] settings.json 文件不存在，跳过配置项...");
        }
    }
}
