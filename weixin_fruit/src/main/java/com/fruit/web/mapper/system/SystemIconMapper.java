package com.fruit.web.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SystemIconMapper {

	@Select("select * from system_icon")
	public List<Map<String,Object>> loadIcon();
}
