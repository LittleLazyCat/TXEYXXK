package com.fruit.web.service.comment.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.Comment;
import com.fruit.web.service.comment.CommentService;

@Service
public class CommentServiceImpl extends BaseDao<Comment, String> implements CommentService {

	@Override
	public List<Map<String, Object>> select() {
		return sqlSessionTemplate.selectList(getMapperMethodId("select"));
	}

}
