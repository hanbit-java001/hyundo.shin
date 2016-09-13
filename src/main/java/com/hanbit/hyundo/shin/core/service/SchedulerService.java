package com.hanbit.hyundo.shin.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hanbit.hyundo.shin.core.dao.ScheduleDAO;
import com.hanbit.hyundo.shin.core.vo.ScheduleVO;

public class SchedulerService {
	ScheduleDAO scheduleDAO = new ScheduleDAO();

	public int addSchedule(ScheduleVO schedule) {
		return scheduleDAO.insertSchedule(schedule);
	}

	public int modifySchedule(ScheduleVO schedule) {

		return scheduleDAO.updateSchedule(schedule);
	}

	public int removeSchedule(String scheduleId) {

		return scheduleDAO.deleteSchedule();
	}

	public List<ScheduleVO> listSchedules(String startDt, String endDt) {

		return null;
	}

	public ScheduleVO getSchedule(String scheduleId) {

		return null;
	}

}
