package ru.practicum.enw.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String annotation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initiator")
    private User initiator;

    @OneToOne
    @JoinColumn(name = "location")
    private LocationEwm location;

    private Boolean paid = false;
    private Integer participantLimit = 0;
    private Boolean requestModeration = true;
    private Integer confirmedRequests = 0;
    private LocalDateTime createdOn;
    private LocalDateTime publishedOn;
    private String state;
    private Integer views;

}
