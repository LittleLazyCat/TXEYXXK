package com.fruit.web.service.comment;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.Comment;


public interface CommentService extends IBaseDao<Comment,String> {

	public List<Map<String,Object>> select();
}
