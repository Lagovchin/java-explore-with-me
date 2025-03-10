package ru.practicum.enw.model.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.practicum.enw.model.category.CategoryDto;
import ru.practicum.enw.model.comment.CommentDto;
import ru.practicum.enw.utils.Constants;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventShortWithCommentDto {

    private long id;
    private String title;
    private String annotation;
    private CategoryDto category;
    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime eventDate;
    private List<CommentDto> comments;
}
