package com.fruit.web.mapper.system.listener;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SystemCornMappper {

	@Select("select * from qrtz_corn")
	public List<Map<String,Object>> loadCorn();

	@Delete("delete from qrtz_corn where id=#{id} ")
	public void removeCorn(String id);
	
	@Insert("insert into qrtz_corn(corn,name) values(#{corn},#{name})")
	public void addCorn(@Param("name") String name,@Param("corn") String corn);
}
