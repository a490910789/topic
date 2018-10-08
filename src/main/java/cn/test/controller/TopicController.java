package cn.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import cn.test.domain.Reply;
import cn.test.domain.Topic;
import cn.test.service.ReplyService;
import cn.test.service.TopicService;
import cn.test.utils.DataGridView;
import cn.test.vo.ReplyVo;
import cn.test.vo.TopicVo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private TopicService topicService;
	@Autowired
	private ReplyService replyService;
    //跳转到贴吧列表页面
	@RequestMapping("toTopicList")
	public String toTopicList() {
		return "list";
	}
	//加载所有帖子
	@RequestMapping("loadAllTopic")
	@ResponseBody
	public DataGridView loadAllTopic() {
		Wrapper<Topic> wrapper=new EntityWrapper<>();
		List<Topic> data = this.topicService.selectList(wrapper);
		return new DataGridView(Long.valueOf(data.size()), data);
	}
	 //跳转到发帖页面
	@RequestMapping("toAddTopic")
	public String toAddTopic() {
		return "addTopic";
	}
	//跳转到详细内容页面
	@RequestMapping("toViewDetails")
	public String toViewDetails(TopicVo topicVo,Model model) {
		//拿到帖子ID
		Integer topicid = topicVo.getTopicid();
		//根据ID查询帖子对象
		Topic topic = this.topicService.selectById(topicid);
		//增加点击量
		topic.setClickamount(topic.getClickamount()+1);
		this.topicService.updateById(topic);
		//根据帖子ID查询对应评论
		Wrapper<Reply> wrapper=new EntityWrapper<>();
		wrapper.andNew("topicid =({0})", topicid);
		List<Reply> replyList = this.replyService.selectList(wrapper);
		
		model.addAttribute("topic", topic);
		model.addAttribute("list", replyList);
		return "viewDetails";
	}
	// 发表帖子
	@RequestMapping("addTopic")
	@ResponseBody
	public Map<String, Object> addTopic(TopicVo topicVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = null;
		try {
			topicVo.setClickamount(0);
			topicVo.setCreatedate(new Date());
			boolean flag = this.topicService.insert(topicVo);
			if (flag) {
				msg = "发帖成功";
			} else {
				msg = "发帖失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "发帖失败";
		}
		map.put("msg", msg);
		return map;
	}
}

