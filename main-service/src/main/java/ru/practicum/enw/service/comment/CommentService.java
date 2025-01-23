package ru.practicum.enw.service.comment;

import ru.practicum.enw.exceptions.NotFoundCustomException;
import ru.practicum.enw.model.comment.CommentDto;
import ru.practicum.enw.model.comment.NewCommentDto;
import ru.practicum.enw.model.event.EventShortWithCommentDto;

public interface CommentService {

    CommentDto addComment(NewCommentDto comment, long idEvent, long idAuthor) throws NotFoundCustomException;

    CommentDto updateComment(NewCommentDto comment, long idEvent, long idAuthor, long idComment) throws NotFoundCustomException;

    void deleteCommentByAuthor(long idAuthor, long idEvent, long idComment) throws NotFoundCustomException;

    void deleteCommentByAdmin(long idComment) throws NotFoundCustomException;

    EventShortWithCommentDto getEventComments(long idEvent, long idUser, int size, int from) throws NotFoundCustomException;

    EventShortWithCommentDto getEventCommentsForPublic(long idEvent, int size, int from) throws NotFoundCustomException;
}
