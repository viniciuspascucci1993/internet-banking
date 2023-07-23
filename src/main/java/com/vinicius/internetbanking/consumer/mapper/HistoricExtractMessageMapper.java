package com.vinicius.internetbanking.consumer.mapper;

import com.vinicius.internetbanking.consumer.message.HistoricExtractMessage;
import com.vinicius.internetbanking.entities.HistoricExtract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricExtractMessageMapper {

    HistoricExtract toHistoricExtract(HistoricExtractMessage historicExtractMessage);
}
