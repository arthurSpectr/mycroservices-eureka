package regexit.plannertodo.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import regexit.plannertodo.service.TestDataService;

@EnableBinding(TodoBinding.class)
@Component
public class MessageConsumer {

    private TestDataService testDataService;

    private MessageConsumer(TestDataService testDataService){
        this.testDataService = testDataService;
    }

    // метод вызывается автометически как только появляется сообщение в канале
    @StreamListener(target = TodoBinding.INPUT_CHANNEL)
    public void initTestData(Long userId) {
        testDataService.initTestData(userId);
    }
}
