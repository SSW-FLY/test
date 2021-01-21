package itcode.util;


import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

@Slf4j
@NoArgsConstructor
public class ProtoBufUtil {

  private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();

  private static Objenesis objenesis = new ObjenesisStd(true);

  private static <T> Schema<T> getSchema(Class<T> cls) {
    Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
    if (schema == null) {
      schema = RuntimeSchema.createFrom(cls);
      if (schema != null) {
        cachedSchema.put(cls, schema);
      }
    }
    return schema;
  }

  public static <T> byte[] serializer(T obj) {
    Class<T> cls = (Class<T>) obj.getClass();
    LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

    Schema<T> schema = getSchema(cls);
    return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
  }


  public static <T> T deserializer(byte[] bytes, Class<T> clazz) {
    T message = (T) objenesis.newInstance(clazz);
    Schema<T> schema = getSchema(clazz);
    ProtostuffIOUtil.mergeFrom(bytes, message, schema);
    return message;
  }
}
