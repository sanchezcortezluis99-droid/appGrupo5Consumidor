package pe.cibertec.grupo5.consumidor.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pe.cibertec.grupo5.consumidor.config.RabbitMQConfig;
import pe.cibertec.grupo5.consumidor.service.MergeSortService;

import java.util.Arrays;
import java.util.stream.Stream;

@Component
public class NumberConsumer {

    private final MergeSortService mergeSortService;

    public NumberConsumer(MergeSortService mergeSortService) {
        this.mergeSortService = mergeSortService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(String cadenaNumeros) throws InterruptedException {
        System.out.println("Mensaje recibido desde RabbitMQ: " + cadenaNumeros);

        Integer[] integerArray = Stream.of(cadenaNumeros.split(";"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] resultado = mergeSortService.sort(integerArray);

        Thread.sleep(20000);

        System.out.println("Lista ordenada con Merge Sort: " + Arrays.toString(resultado));
    }
}
