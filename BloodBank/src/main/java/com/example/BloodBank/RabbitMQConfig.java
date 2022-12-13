package com.example.BloodBank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitMQConfig {

	@Value("${custom.rabbitmq.newsQueue}")
	private String newsQueue;

    @Value("${custom.rabbitmq.scheduledOrdersQueue}")
    private String scheduledOrdersQueue;

    @Value("${custom.rabbitmq.sentOrdersQueue}")
    private String sentOrdersQueue;
	
	@Value("${custom.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${custom.rabbitmq.newsRoutingkey}")
	private String newsRoutingkey;

    @Value("${custom.rabbitmq.scheduledOrdersRoutingkey}")
    private String scheduledOrdersRoutingkey;

    @Value("${custom.rabbitmq.sentOrdersRoutingkey}")
    private String sentOrdersRoutingkey;
	
	@Bean
	Queue newsQueue()
    {
		return new Queue(newsQueue, true);
	}
    @Bean Queue scheduledOrdersQueue(){
        return new Queue(scheduledOrdersQueue, true);
    }
    @Bean Queue sentOrdersQueue(){
        return new Queue(sentOrdersQueue, true);
    }
	
	@Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }
	
	@Bean
    Binding bindingNewsQueue(Queue newsQueue, DirectExchange exchange) {
        return BindingBuilder.bind(newsQueue).to(exchange).with(newsRoutingkey);
    }
    @Bean
    Binding bindingScheduledOrdersQueue(Queue scheduledOrdersQueue, DirectExchange exchange) {
        return BindingBuilder.bind(scheduledOrdersQueue).to(exchange).with(scheduledOrdersRoutingkey);
    }
    @Bean
    Binding bindingSentOrdersRoutingkey(Queue sentOrdersQueue, DirectExchange exchange) {
        return BindingBuilder.bind(sentOrdersQueue).to(exchange).with(sentOrdersRoutingkey);
    }
	
	@Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
