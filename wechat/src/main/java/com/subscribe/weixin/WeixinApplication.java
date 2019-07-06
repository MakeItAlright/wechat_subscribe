package com.subscribe.weixin;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.subscribe.commons.EventListenerConfig;
import com.subscribe.commons.domain.event.EventInMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.xml.StaxUtils;

@SpringBootApplication
public class WeixinApplication implements EventListenerConfig {

	@Bean()
	public XmlMapper xmlMapper() {
		XmlMapper mapper = new XmlMapper(StaxUtils.createDefensiveInputFactory());
		return mapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}

	@Override
	public void handleEvent(EventInMessage event) {
		// 不需要处理事件，所以方法留空即可
	}
}
