package ru.practicum.enw.controller.admin;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.enw.exceptions.NotFoundCustomException;
import ru.practicum.enw.model.event.EventFullDto;
import ru.practicum.enw.model.event.UpdateEventAdminRequest;
import ru.practicum.enw.service.comment.CommentService;
import ru.practicum.enw.service.event.EventService;
import ru.practicum.enw.utils.Constants;

@RestController
@RequestMapping(value = "/admin/events")
@AllArgsConstructor
public class EventAdminController {

    private final EventService eventService;
    private final CommentService commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventFullDto> getAllEventsHavingParams(@RequestParam(required = false) List<Long> users,
                                                       @RequestParam(required = false) List<Long> categories,
                                                       @RequestParam(required = false) List<String> states,
                                                       @RequestParam(required = false)
                                                       @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime rangeStart,
                                                       @RequestParam(required = false)
                                                       @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime rangeEnd,
                                                       @RequestParam(required = false, defaultValue = "0") int from,
                                                       @RequestParam(required = false, defaultValue = "10") int size) {

        return eventService.getAdminAllEvents(users, states, categories, rangeStart, rangeEnd, from, size);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventFullDto modifyEventById(@PathVariable long id,
                                        @Valid @RequestBody(required = false) UpdateEventAdminRequest event) throws NotFoundCustomException {

        return eventService.updateEventByAdmin(id, event);
    }

    @DeleteMapping(value = "/comment/{idComment}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentByAdmin(@PathVariable long idComment) throws NotFoundCustomException {

        commentService.deleteCommentByAdmin(idComment);
    }
}
