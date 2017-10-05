package com.fruit.web.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.Comment;
import com.fruit.web.service.comment.CommentService;

/**
 * @author jzx
 * @date 2016.9.14 
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("comment/comment-list");
		model.addObject("data", commentService.select());
		return model;
	}

	/**
	 * 添加评论管理
	 * 
	 * @param comment
	 */
	@RequestMapping(value = "addComment", method = RequestMethod.POST)
	public void addComment(Comment comment) {
		comment.setuId(getCurrentUser().getId());
		commentService.create(comment);
		renderJson200();
	}

	/**
	 * 跳转到评论添加页面
	 */
	@RequestMapping(value = "toAddComment", method = RequestMethod.GET)
	public ModelAndView toAddComment() {
		return new ModelAndView("comment/comment-add");
	}
}
