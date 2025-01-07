package ru.practicum.stats.service;

import ru.practicum.statsdto.HitObject;
import ru.practicum.statsdto.HitObjectProjection;
import ru.practicum.statsdto.ParamObject;

import java.util.List;

public interface StatsService {
    HitObject hit(HitObject object);

    List<HitObjectProjection> viewStats(ParamObject params);
}
