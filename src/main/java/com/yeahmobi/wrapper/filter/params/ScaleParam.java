package com.yeahmobi.wrapper.filter.params;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScaleParam implements FilterParam {

    private Integer width;

    private Integer height;

    private Boolean forceAspectRatio;

    private Boolean isIncrease;

}
