package com.subscribe.commons.processors;

import com.subscribe.commons.domain.event.EventInMessage;

public interface EventMessageProcessor {

	void onMessage(EventInMessage event);

}
