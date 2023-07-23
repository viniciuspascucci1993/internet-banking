package com.vinicius.internetbanking.services.mapper;

import com.vinicius.internetbanking.dto.HistoricExtractDTO;
import com.vinicius.internetbanking.entities.HistoricExtract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricExtractDtoMapper {

    HistoricExtract toHistoricDto( HistoricExtractDTO historicExtract);
}
