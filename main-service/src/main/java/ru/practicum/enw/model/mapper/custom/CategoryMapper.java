package ru.practicum.enw.model.mapper.custom;

import org.springframework.stereotype.Component;
import ru.practicum.enw.model.category.CategoryDto;
import ru.practicum.enw.model.category.NewCategoryDto;
import ru.practicum.enw.model.entity.Category;

@Component
public class CategoryMapper {

    public static Category fromNewToEntity(NewCategoryDto newCategoryDto) {

        return Category.builder().name(newCategoryDto.getName()).build();

    }

    public static CategoryDto toDtoFromEntity(Category category) {

        return CategoryDto.builder().id(category.getId()).name(category.getName()).build();
    }

    public static Category toDtoFromNewCategoryDtoWithId(long id, NewCategoryDto category) {

        return Category.builder().id(id).name(category.getName()).build();
    }

    public static Category fromDtoToEntity(CategoryDto categoryDto) {

        return Category.builder().id(categoryDto.getId()).name(categoryDto.getName()).build();
    }

}
