package com.iu.s7;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractTest {

	@Test
	public abstract void test();

}
