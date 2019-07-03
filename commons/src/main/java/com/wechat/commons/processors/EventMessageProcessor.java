package com.wechat.commons.processors;

import com.wechat.commons.domain.event.EventInMessage;

public interface EventMessageProcessor {

	void onMessage(EventInMessage event);

}
