package com.dci.aspectdemo.service;

import com.dci.aspectdemo.aspect.LoggingAspect;
import com.dci.aspectdemo.model.Circle;

/**
 * Created by ltornquist on 1/21/2015.
 */
public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
