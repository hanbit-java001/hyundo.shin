package com.hanbit.hyundo.shin.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.hyundo.shin.core.dao.MybatisExampleDAO;
import com.hanbit.hyundo.shin.core.service.SchedulerService;
import com.hanbit.hyundo.shin.core.vo.ScheduleVO;

public class SpringApplication {

	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-core.xml","spring/applicationContext-dao.xml");
			
			SchedulerService schedulerService = applicationContext.getBean(SchedulerService.class);
		
			ScheduleVO schedule = new ScheduleVO();
			schedule.setScheduleId(String.valueOf(System.currentTimeMillis()));
			schedule.setTitle("저녁");
			schedule.setMemo("반찬 뭘까");
			schedule.setStartDt("202009191830");
			schedule.setEndDt("202009191930");
			
			int result = schedulerService.addSchedule(schedule);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
