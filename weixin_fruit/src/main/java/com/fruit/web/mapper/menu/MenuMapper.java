package com.fruit.web.mapper.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.fruit.web.weixin.model.MenuEntity;

public interface MenuMapper {

	@Select("SELECT * FROM weixin_menuentity WHERE fatherid IS NULL")
	public List<Map<String, Object>> selectFatherMenuByAccountId(String accountId);

	@Select("SELECT * FROM weixin_menuentity WHERE fatherid=#{fatherId}")
	public List<Map<String, Object>> selectSonMenuByAccountId(String fatherId);
	
	@Select("SELECT * FROM weixin_menuentity WHERE id=#{objId}")
	public Map<String, Object> loadObjById(String objId);
	
	@Select("SELECT * FROM weixin_menuentity WHERE fatherid=#{objId}")
	public Map<String, Object> loadSonObjById(String objId);
	
	@Delete("delete FROM weixin_menuentity WHERE id=#{objId}")
	public void delObjById(String objId);
	
	public void createMenu(MenuEntity menuEntity);
}
