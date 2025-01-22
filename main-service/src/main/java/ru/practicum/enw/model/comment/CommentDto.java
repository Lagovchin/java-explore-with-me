package ru.practicum.enw.model.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.enw.model.user.UserShortDto;
import ru.practicum.enw.utils.Constants;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {

    private Long id;
    private Long eventId;
    private UserShortDto author;
    private String text;
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime created;

}
