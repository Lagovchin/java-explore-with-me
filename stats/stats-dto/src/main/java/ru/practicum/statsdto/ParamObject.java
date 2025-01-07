package ru.practicum.statsdto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParamObject {

    private String start;
    private String end;
    private List<String> uris;
    private Boolean unique;

}
