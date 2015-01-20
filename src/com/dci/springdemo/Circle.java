package com.dci.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Locale;

/**
 * Created by ltornquist on 1/20/2015.
 */
@Controller
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	private ApplicationEventPublisher publisher;

	@Autowired
	private MessageSource messageSource;

	public Point getCenter() {
		return center;
	}
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void draw() {
		System.out.println(messageSource.getMessage("circle.draw", null, "Not Found!", Locale.US));
		System.out.println(messageSource.getMessage("circle.points", new Object[]{getCenter().getX(), getCenter().getY()}, "Not Found!", Locale.US));
		publisher.publishEvent(new DrawEvent(this));
	}

	@PostConstruct
	public void initializeCircle()
	{
		System.out.println("Initialize Circle!");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy Circle!");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		System.out.println("Publisher: " + publisher);
		this.publisher = publisher;
	}
}
