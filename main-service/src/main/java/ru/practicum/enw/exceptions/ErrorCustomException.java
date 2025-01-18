package ru.practicum.enw.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.practicum.enw.utils.Constants;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorCustomException {
    private String status;
    private String message;
    private String reason;
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime timestamp;
}
