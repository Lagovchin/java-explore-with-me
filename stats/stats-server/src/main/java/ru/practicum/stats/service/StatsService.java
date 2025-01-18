package ru.practicum.stats.service;

import org.apache.coyote.BadRequestException;
import ru.practicum.statsdto.HitObject;
import ru.practicum.statsdto.HitObjectDto;
import ru.practicum.statsdto.ParamObject;

import java.util.List;

public interface StatsService {

    HitObject hit(HitObject object);

    List<HitObjectDto> viewStats(ParamObject params) throws BadRequestException;
}
