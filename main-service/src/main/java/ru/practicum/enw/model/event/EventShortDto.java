package ru.practicum.enw.model.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.practicum.enw.model.category.CategoryDto;
import ru.practicum.enw.model.user.UserShortDto;
import ru.practicum.enw.utils.Constants;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventShortDto {

    private long id;
    private String title;
    private String annotation;
    private CategoryDto category;
    private int confirmedRequests;
    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime eventDate;
    private UserShortDto initiator;
    private int views;
    private boolean paid;

}
