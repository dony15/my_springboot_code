package com.dubbo.common_interface;

import com.dubbo.common_domain.City;
import com.dubbo.common_domain.QuartzEntity;

public interface QuartzCityService {

    /**
     * 开启指定城市任务
     * @param quartz
     */
    void getCityByName(QuartzEntity quartz);

}
