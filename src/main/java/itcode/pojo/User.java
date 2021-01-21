package itcode.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String name;
  private Integer id;
  private Integer age;
}
