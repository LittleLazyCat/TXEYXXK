package com.fruit.web.service.system;

import java.util.List;
import java.util.Map;

import com.fruit.core.form.MapWapper;
import com.fruit.core.persistence.IBaseDao;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.model.SystemIcon;

public interface SystemIconService extends IBaseDao<SystemIcon, Integer> {

	public List<Map<String,Object>> loadIcon();
	
	public ResultVO addicon(MapWapper<String, String> map);
	
	public ResultVO delIcon(Integer id);
}
