package ru.practicum.stats.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.stats.service.StatsService;
import ru.practicum.statsdto.HitObject;
import ru.practicum.statsdto.HitObjectProjection;
import ru.practicum.statsdto.ParamObject;

import java.util.List;


@RestController
@AllArgsConstructor
public class StatsController {

    private final StatsService service;

    @PostMapping(value = "/hit")
    @ResponseStatus(value = HttpStatus.CREATED)
    public HitObject hit(@RequestBody @Valid HitObject object) {

        return service.hit(object);
    }


    @GetMapping(value = "/ru/practicum/stats")
    @ResponseStatus(value = HttpStatus.OK)
    public List<HitObjectProjection> getStats(@ModelAttribute ParamObject params) {

        List<HitObjectProjection> list = service.viewStats(params);
        return service.viewStats(params);
    }
}
