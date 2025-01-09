package ru.practicum.enw.service.category;

import ru.practicum.enw.exceptions.NotFoundCustomException;
import ru.practicum.enw.model.category.CategoryDto;
import ru.practicum.enw.model.category.NewCategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto add(NewCategoryDto category);

    void delete(long id) throws NotFoundCustomException;

    CategoryDto update(long id, NewCategoryDto newCategoryDto) throws NotFoundCustomException;

    CategoryDto getById(long id) throws NotFoundCustomException;

    List<CategoryDto> getCategoryListByParams(int from, int size);
}
