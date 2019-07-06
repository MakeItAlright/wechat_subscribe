package com.subscribe.weixin.service;

import com.subscribe.commons.domain.InMessage;
import com.subscribe.commons.domain.OutMessage;

public interface MessageService {

	OutMessage onMessage(InMessage msg);
}
