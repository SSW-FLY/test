package itcode.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author imp
 * @date 2020/7/7
 */
public class ProxyFactory implements InvocationHandler {

    private Class<?> target;

    private Object real;

    public ProxyFactory(Class<?> target) {
        this.target = target;
    }

    public ProxyFactory(Class<?> target, Object real) {
        this.target = target;
        this.real = real;
    }

    public Object bind() {
        return Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, this);
    }

    public Object bind(Object real) {
        this.real = real;
        return Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin");
        Object invoke = method.invoke(real, args);
        System.out.println("end");
        return invoke;
    }
}
