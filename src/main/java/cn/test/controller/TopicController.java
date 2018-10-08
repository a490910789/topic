package cn.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import cn.test.domain.Reply;
import cn.test.domain.Topic;
import cn.test.service.ReplyService;
import cn.test.service.TopicService;
import cn.test.vo.TopicVo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chen
 * @since 2018-10-08
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	private TopicService topService;
	@Autowired
	private ReplyService replyService;
    //跳转到贴吧列表页面
	@RequestMapping("toTopicList")
	public String toTopicList(Model model) {
		Wrapper<Topic> wrapper=new EntityWrapper<>();
		List<Topic> list = this.topService.selectList(wrapper);
		model.addAttribute("list", list);
		return "list";
	}
	//跳转到详细内容页面
	@RequestMapping("toViewDetails")
	public String toViewDetails(TopicVo topicVo,Model model) {
		//拿到帖子ID
		Integer topicid = topicVo.getTopicid();
		//根据ID查询帖子对象
		Topic topic = this.topService.selectById(topicid);
		//增加点击量
		topic.setClickamount(topic.getClickamount()+1);
		this.topService.updateById(topic);
		//根据帖子ID查询对应评论
		Wrapper<Reply> wrapper=new EntityWrapper<>();
		wrapper.andNew("topicid =({0})", topicid);
		List<Reply> replyList = this.replyService.selectList(wrapper);
		
		model.addAttribute("topic", topic);
		model.addAttribute("list", replyList);
		return "viewDetails";
	}
}

