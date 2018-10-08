package cn.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.test.service.ReplyService;
import cn.test.vo.ReplyVo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chen
 * @since 2018-10-08
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	// 发表评论
	@RequestMapping("addReply")
	@ResponseBody
	public Map<String, Object> addReply(ReplyVo replyVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = null;
		try {
			replyVo.setCreatedate(new Date());
			boolean flag = this.replyService.insert(replyVo);
			if (flag) {
				msg = "发表评论成功";
			} else {
				msg = "发表评论失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "发表评论失败";
		}
		map.put("msg", msg);
		return map;
	}
}
