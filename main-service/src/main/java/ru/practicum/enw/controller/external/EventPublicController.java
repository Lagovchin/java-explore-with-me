package ru.practicum.enw.controller.external;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.enw.exceptions.NotFoundCustomException;
import ru.practicum.enw.model.enums.SortType;
import ru.practicum.enw.model.event.EventFullDto;
import ru.practicum.enw.model.event.EventShortDto;
import ru.practicum.enw.model.event.EventShortWithCommentDto;
import ru.practicum.enw.service.comment.CommentService;
import ru.practicum.enw.service.event.EventService;
import ru.practicum.enw.utils.Constants;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/events")
@AllArgsConstructor
public class EventPublicController {

    private final EventService eventService;
    private final CommentService commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventShortDto> getEvents(@RequestParam(required = false) String text,
                                         @RequestParam(required = false) List<Integer> categories,
                                         @RequestParam(required = false) Boolean paid,
                                         @RequestParam(required = false)
                                         @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime rangeStart,
                                         @RequestParam(required = false)
                                         @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime rangeEnd,
                                         @RequestParam(required = false) Boolean onlyAvailable,
                                         @RequestParam(defaultValue = "VIEWS") SortType sort,
                                         @RequestParam(defaultValue = "0") int from,
                                         @RequestParam(defaultValue = "10") int size,
                                         HttpServletRequest request) {

        return eventService.getEventsForPublicWithParams(text, categories, paid, sort, rangeStart,
                rangeEnd, onlyAvailable, from, size, request);

    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventFullDto getEvent(@PathVariable long id, HttpServletRequest request) throws NotFoundCustomException {

        return eventService.getEventForPublicById(id, request);
    }

    @GetMapping(value = "/{id}/comment")
    @ResponseStatus(HttpStatus.OK)
    public EventShortWithCommentDto getEventWithComments(@PathVariable long id,
                                                         @RequestParam(required = false, defaultValue = "10") int size,
                                                         @RequestParam(required = false, defaultValue = "0") int from) throws NotFoundCustomException {

        return commentService.getEventCommentsForPublic(id, size, from);
    }
}
