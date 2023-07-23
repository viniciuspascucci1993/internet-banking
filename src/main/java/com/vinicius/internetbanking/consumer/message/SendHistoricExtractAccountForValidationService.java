package com.vinicius.internetbanking.consumer.message;

import com.vinicius.internetbanking.entities.HistoricExtract;
import com.vinicius.internetbanking.repositories.messaging.SendHistoricExtractAccountForValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendHistoricExtractAccountForValidationService implements SendHistoricExtractAccountForValidationRepository {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String dateFutureReleases) {
        kafkaTemplate.send("tp-historic-extract-validation", dateFutureReleases);
    }
}
