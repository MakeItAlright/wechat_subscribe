package com.subscribe.unsubscribe;

import com.subscribe.commons.domain.User;
import com.subscribe.commons.domain.event.EventInMessage;
import com.subscribe.commons.processors.EventMessageProcessor;
import com.subscribe.commons.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// 把对象加入Spring容器，并且根据事件处理查找Bean的规则给一个名字
@Service("unsubscribeMessageProcessor")
public class UnsubscribeEventMessageProcessor implements EventMessageProcessor {

	private static final Logger LOG = LoggerFactory.getLogger(UnsubscribeEventMessageProcessor.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional // 要有事务支持，在事务结束后，默认自动提交数据的修改
	public void onMessage(EventInMessage event) {

		if (!event.getEvent().equals("unsubscribe")) {
			// 只处理关注事件
			return;
		}
		LOG.trace("取消关注事件处理器被调用，收到的消息:\n {} ", event);

		User user = this.userRepository.findByOpenId(event.getFromUserName());
		user.setStatus(User.Status.IS_UNSUBSCRIBED);
	}
}
