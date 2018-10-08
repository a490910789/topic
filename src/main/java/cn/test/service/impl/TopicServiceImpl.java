package cn.test.service.impl;

import cn.test.domain.Topic;
import cn.test.mapper.TopicMapper;
import cn.test.service.TopicService;
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
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

}
