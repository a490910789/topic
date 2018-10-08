package cn.test.service.impl;

import cn.test.domain.Reply;
import cn.test.mapper.ReplyMapper;
import cn.test.service.ReplyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2018-10-08
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {

}
