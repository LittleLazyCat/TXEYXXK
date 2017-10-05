package com.fruit.web.service.menu.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.persistence.convention.id.UUIDHexGenerator;
import com.fruit.core.utils.Printer;
import com.fruit.core.web.utils.MapUtils;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.mapper.menu.MenuMapper;
import com.fruit.web.model.common.Button;
import com.fruit.web.model.common.CommonButton;
import com.fruit.web.model.common.ComplexButton;
import com.fruit.web.model.common.Menu;
import com.fruit.web.model.common.ViewButton;
import com.fruit.web.service.menu.WeixinMenuService;
import com.fruit.web.service.weixin.WeixinAccountService;
import com.fruit.web.weixin.model.MenuEntity;

import net.sf.json.JSONObject;

@Service
public class WeixinMenuServiceImpl extends BaseDao<MenuEntity, String> implements WeixinMenuService {
	
	@Resource
	private WeixinAccountService weixinAccountService;
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Map<String, Object>> selectFatherMenuByAccountId(String accountId) {
		return menuMapper.selectFatherMenuByAccountId(accountId);
	}

	@Override
	public List<Map<String, Object>> selectSonMenuByAccountId(String fatherId, String accountId) {
		return menuMapper.selectSonMenuByAccountId(fatherId);
	}

	@Override
	public List<Map<String, Object>> list() {
		List<Map<String,Object>> selectFatherMenuByAccountId = selectFatherMenuByAccountId("");
		for(Map<String,Object> k : selectFatherMenuByAccountId) {
			List<Map<String,Object>> selectSonMenuByAccountId = selectSonMenuByAccountId(k.get("ID")+"", null);
			if(!selectSonMenuByAccountId.isEmpty())
				k.put("selectSonMenuByAccountId", selectSonMenuByAccountId);
		}
		return selectFatherMenuByAccountId;
	}

	@Override
	public Map<String, Object> loadObjById(String objId) {
		return menuMapper.loadObjById(objId);
	}

	@Override
	public void delObjById(String objId) {
		menuMapper.delObjById(objId);
	}

	@Override
	public Map<String, Object> loadSonObjById(String objId) {
		return menuMapper.loadSonObjById(objId);
	}

	@Override
	public boolean createMenu(MenuEntity menuEntity) {
		menuEntity.setId(UUIDHexGenerator.get());
		menuMapper.createMenu(menuEntity);
		return true;
	}

	@Override
	public ResultVO delMenu(String id) {
		ResultVO resultVO = new ResultVO(true);
		Map<String, Object> obj = loadObjById(id);
		List<Map<String, Object>> son = selectSonMenuByAccountId(obj.get("id")+"", "");
		for(Map<String, Object> ids : son) {
			delObjById(ids.get("id") + "");
		}
		delObjById(id);
		return resultVO;
	}

	@Override
	public ResultVO addMenu(MenuEntity menuEntity) {
		ResultVO resultVO = new ResultVO(true);
		createMenu(menuEntity);
		resultVO.setMsg("创建菜单成功");
		return resultVO;
	}

	@Override
	public ResultVO editMenu(MenuEntity menuEntity) {
		ResultVO resultVO = new ResultVO(true);
		update(menuEntity);
		resultVO.setMsg("修改菜单成功");
		return resultVO;
	}

	@Override
	public ResultVO sameMenu() {
		ResultVO resultVO = new ResultVO(true);
		try {
			List<Map<String, Object>> menuList = selectFatherMenuByAccountId("");
			Printer.info(".....一级菜单的个数是....." + menuList.size());
			Menu menu = new Menu();
			Button firstArr[] = new Button[menuList.size()];
			for(int a = 0; a < menuList.size(); a++) {
				MenuEntity entity = new MenuEntity(); 
				MapUtils.toObject(entity, menuList.get(a));
				List<Map<String, Object>> childList = selectSonMenuByAccountId(menuList.get(a).get("ID")+"", "");
				if(childList.size() == 0) {
					if("view".equals(entity.getType())){
						ViewButton viewButton = new ViewButton();
						viewButton.setName(entity.getName());
						viewButton.setType(entity.getType());
						viewButton.setUrl(entity.getUrl());
						firstArr[a] = viewButton;
					}else if("click".equals(entity.getType())){
						CommonButton cb = new CommonButton();
						cb.setKey(entity.getMenuKey());
						cb.setName(entity.getName());
						cb.setType(entity.getType());
						firstArr[a] = cb;
					}
				} else {
					ComplexButton complexButton = new ComplexButton();
					complexButton.setName(entity.getName());
					Button[] secondARR = new Button[childList.size()];
					for (int i = 0; i < childList.size(); i++) {
						MenuEntity children = new MenuEntity(); 
						MapUtils.toObject(children, childList.get(i));
						String type = children.getType();
						if ("view".equals(type)) {
							ViewButton viewButton = new ViewButton();
							viewButton.setName(children.getName());
							viewButton.setType(children.getType());
							viewButton.setUrl(children.getUrl());
							secondARR[i] = viewButton;
						} else if ("click".equals(type)) {
							CommonButton cb1 = new CommonButton();
							cb1.setName(children.getName());
							cb1.setType(children.getType());
							cb1.setKey(children.getMenuKey());
							secondARR[i] = cb1;
						}
					}
					complexButton.setSub_button(secondARR);
					firstArr[a] = complexButton;
				}
			}
			menu.setButton(firstArr);
			JSONObject jsonMenu = JSONObject.fromObject(menu);
			String accessToken = weixinAccountService.getAccessToken();
			String message = weixinAccountService.createMenu(accessToken,jsonMenu.toString());
			resultVO.setMsg(message);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return resultVO;
	}

}
