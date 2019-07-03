package com.wechat.weixin.service;

import com.wechat.commons.domain.InMessage;
import com.wechat.commons.domain.OutMessage;

public interface MessageService {

	OutMessage onMessage(InMessage msg);
}
