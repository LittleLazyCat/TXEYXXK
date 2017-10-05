package com.fruit.web.mapper.system.count;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.fruit.web.model.SystemLog;

public interface SystemLogMapper {

	@Delete("DELETE FROM system_log  WHERE create_time>=#{begin_time} AND create_time <=#{end_time}")
	public void cleanLogByDate(@Param("begin_time") String begin,@Param("end_time") String end);


	public long listCount(Map<String, Object> params);

	public List<SystemLog> list(Map<String, Object> params);
}
