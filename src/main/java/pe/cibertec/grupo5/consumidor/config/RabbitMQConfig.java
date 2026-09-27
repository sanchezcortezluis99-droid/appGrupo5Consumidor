package pe.cibertec.grupo5.consumidor.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "Grupo5Queue";
    public static final String EXCHANGE = "Grupo5Exchange";
    public static final String ROUTING_KEY = "Grupo5Routing";

    @Bean
    public Queue grupo5Queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public DirectExchange grupo5Exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding grupo5Binding(Queue grupo5Queue, DirectExchange grupo5Exchange) {
        return BindingBuilder
                .bind(grupo5Queue)
                .to(grupo5Exchange)
                .with(ROUTING_KEY);
    }
}
