package itcode;


/**
 * 高级统计部分工具类
 */
public class AdvancedUtil {

  static String REGX = "<\u0001>";


  /**
   * id生成算法
   */

  public static int DJBHash(String str) {
    int hash = 5381;

    for (int i = 0; i < str.length(); i++) {
      hash = ((hash << 5) + hash) + str.charAt(i);
    }

    return (hash & 0x7FFFFFFF);
  }

  public static int DEKPosiHash(String str) {
    int hash = str.length();
    for (int i = 0; i < str.length(); i++) {
      hash = ((hash << 5) ^ (hash >>> 27)) ^ str.charAt(i);
    }
    return (hash & 0x7FFFFFFF);
  }

  public static long mixPosiHash(String str) {
    long hash = DJBHash(str);
    hash <<= 22;
    hash |= DEKPosiHash(str);
    return hash;
  }


  public static Long createId(String str, long projectId) {
    StringBuffer un = new StringBuffer().append(str).append(REGX).append(projectId)
        .append(REGX);
    return mixPosiHash(un.toString().toLowerCase());
  }

}