package com.vinicius.internetbanking.consumer.message;

import com.vinicius.internetbanking.consumer.mapper.HistoricExtractMessageMapper;
import com.vinicius.internetbanking.repositories.HistoricExtractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedHistoricExtractConsumer {

    @Autowired
    private HistoricExtractRepository historicExtractRepository;

    @Autowired
    private HistoricExtractMessageMapper historicExtractMessageMapper;

    @KafkaListener(topics = "tp-historic-extract-validated", groupId = "torres",
            containerFactory = "historicExtractMessageConcurrentKafkaListenerContainerFactory")
    public void receive(HistoricExtractMessage historicExtractMessage) {
        var historic = historicExtractMessageMapper.toHistoricExtract(historicExtractMessage);
        historicExtractRepository.save(historic);
    }
}
