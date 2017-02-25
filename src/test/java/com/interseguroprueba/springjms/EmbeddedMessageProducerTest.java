package com.interseguroprueba.springjms;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interseguroprueba.springjms.producer.MessageProducer;

public class EmbeddedMessageProducerTest {
	private MessageProducer messageProducer;

    @SuppressWarnings("resource")
    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[] {
                        "classpath:jms/embedded-activemq-jms-spring.xml",
                        "classpath:spring/apache-activemq-context.xml" });
        messageProducer = (MessageProducer) applicationContext
                .getBean("messageProducer");
    }

    @Test
    public void testSendMessageToDefaultDestination() {
        messageProducer
                .sendMessageToDefaultDestination("Send this message to default destination.");
    }
}
