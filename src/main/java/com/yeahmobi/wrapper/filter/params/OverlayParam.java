package com.yeahmobi.wrapper.filter.params;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OverlayParam implements FilterParam {

    private Integer horizontalOffset;

    private Integer verticalOffset;

}
