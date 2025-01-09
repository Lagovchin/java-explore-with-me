package ru.practicum.enw.service.user;

import ru.practicum.enw.exceptions.NotFoundCustomException;
import ru.practicum.enw.model.user.NewUserRequest;
import ru.practicum.enw.model.user.UserDto;

import java.util.List;

public interface UserService {

    UserDto add(NewUserRequest user);

    void delete(long id) throws NotFoundCustomException;

    List<UserDto> get(List<Long> ids, Integer from, Integer size);

    UserDto getById(long id);
}
