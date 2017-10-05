package com.fruit.web.service.menu;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.weixin.model.MenuEntity;

public interface WeixinMenuService extends IBaseDao<MenuEntity, String> {

	public boolean createMenu(MenuEntity menuEntity);
	
	public List<Map<String,Object>> list();
	
	public void delObjById(String objId);
	
	public Map<String,Object> loadObjById(String objId);
	
	public Map<String, Object> loadSonObjById(String objId);
	
	public List<Map<String,Object>> selectFatherMenuByAccountId(String accountId);
	
	public List<Map<String,Object>> selectSonMenuByAccountId(String fatherId,String accountId);

	public ResultVO delMenu(String id);

	public ResultVO addMenu(MenuEntity menuEntity);

	public ResultVO editMenu(MenuEntity menuEntity);

	public ResultVO sameMenu();

}
