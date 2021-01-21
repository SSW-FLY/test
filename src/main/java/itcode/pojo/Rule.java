package itcode.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rule {
    private String rid;
    private String ua;
    private int timeRange;
    private String dimension;
    private String filters;
}