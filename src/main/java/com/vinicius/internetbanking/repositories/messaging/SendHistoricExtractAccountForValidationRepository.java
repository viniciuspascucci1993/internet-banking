package com.vinicius.internetbanking.repositories.messaging;

public interface SendHistoricExtractAccountForValidationRepository {

    void sendMessage(String dateFutureReleases);
}
