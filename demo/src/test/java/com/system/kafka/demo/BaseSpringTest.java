package com.system.kafka.demo;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <ul>
 * <li>****类</li>
 * <li>说明简介<li>
 * <li>User: weiwei Date:16/5/12 <li>
 * </ul>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public abstract class BaseSpringTest extends TestCase {

}
