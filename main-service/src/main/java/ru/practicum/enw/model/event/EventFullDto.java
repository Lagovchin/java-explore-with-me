package ru.practicum.enw.model.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import ru.practicum.enw.model.category.CategoryDto;
import ru.practicum.enw.model.entity.LocationEwm;
import ru.practicum.enw.model.user.UserDto;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventFullDto {
    private long id;

    @NotBlank(message = "Error: Title is required. Value: ${validatedValue}")
    @Size(min = 3, max = 120, message = "Error: Title length must be between 3 and 120 characters. " +
            "Value: ${validatedValue}")
    private String title;

    @NotBlank(message = "Error: Annotation is required")
    @Size(min = 20, max = 2000, message = "Error: Annotation length must be between 20 and 2000 characters. " +
            "Value: ${validatedValue}")
    private String annotation;

    @NotNull(message = "Error: Category is required. Value: ${validatedValue}")
    private CategoryDto category;

    @NotBlank(message = "Error: Description is required. Value: ${validatedValue}")
    @Size(min = 20, max = 7000, message = "Error: Description length must be between 20 and 7000 characters. " +
            "Value: ${validatedValue}")
    private String description;

    @NotNull(message = "Error: Event date must be specified. Value: ${validatedValue}")
    @Future
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

    @NotNull(message = "Error: Initiator must be specified. Value: ${validatedValue}")
    private UserDto initiator;

    @NotNull(message = "Error: Location must be specified. Value: ${validatedValue}")
    private LocationEwm location;

    private Boolean paid = false;
    @Min(value = 0, message = "Error: Participant limit must be positive. Value: ${validatedValue}")
    private Integer participantLimit = 0;
    private Boolean requestModeration = true;
    private Integer confirmedRequests;
    private LocalDateTime createdOn;
    private LocalDateTime publishedOn;
    private String state;
    private Integer views;

}
