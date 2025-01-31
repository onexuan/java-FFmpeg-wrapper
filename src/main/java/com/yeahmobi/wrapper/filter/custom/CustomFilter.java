package com.yeahmobi.wrapper.filter.custom;

import com.google.gson.JsonObject;
import com.yeahmobi.wrapper.filter.Filter;
import com.yeahmobi.wrapper.filter.params.CustomParam;
import com.yeahmobi.wrapper.filterable.Filterable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class CustomFilter implements Filter {

    private Filterable input;
    private Filterable output;
    private String filterName;
    private List<CustomParam> params;

    public <T extends Filterable> T build(){
        return (T) this.output;
    }

    public CustomFilter addParam(String param, String value){
        this.params.add(new CustomParam(param, value));
        return this;
    }

    @Override
    public String generateFilter() {
        StringBuilder command = new StringBuilder();
        command.append(filterName);
        if (Objects.nonNull(this.params) && !this.params.isEmpty()) {
            command.append("=");
            for (CustomParam param : params) {
                command.append(param.getField());
                command.append("=");
                command.append(param.getValue());
                if (this.params.indexOf(param) != this.params.size() - 1) {
                    command.append(":");
                }
            }
        }
        return command.toString();
    }
}
