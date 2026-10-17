package ir.verjik.dto;

import ir.verjik.enums.TransactionStatus;

import java.time.LocalDate;
import java.util.List;

public record TransactionDTO(
        Long id,
        String number,
        LocalDate date,
        String description,
        TransactionStatus status,
        List<TransactionDetailDTO> details
) {}
