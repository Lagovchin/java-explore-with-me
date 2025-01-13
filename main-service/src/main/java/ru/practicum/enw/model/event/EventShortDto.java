package ru.practicum.enw.model.event;

import lombok.*;
import ru.practicum.enw.model.category.CategoryDto;
import ru.practicum.enw.model.user.UserShortDto;

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
    private LocalDateTime eventDate;
    private UserShortDto initiator;
    private int views;
    private boolean paid;

}
