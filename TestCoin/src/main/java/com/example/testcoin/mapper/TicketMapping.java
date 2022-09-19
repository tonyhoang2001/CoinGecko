package com.example.testcoin.mapper;

import com.example.testcoin.dto.TicketDto;
import com.example.testcoin.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapping {
    public TicketDto toDto(Ticket ticket);
    public Ticket toEntity(TicketDto ticketDto);
}
