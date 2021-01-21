package itcode.demo;

/**
 * @author imp
 * @date 2020/7/7
 */
public class MainDemo {

    public static void main(String[] args) {
        Calcuator proxy = (Calcuator) new ProxyFactory(Calcuator.class).bind(new CalcuatorImpl());
//        proxy.add(13, 2);
//        proxy.mins(13, 2);
//        proxy.hashCode();
//        proxy.equals("o");

        Calcuator pr = (Calcuator) new ProxyFactory(Calcuator.class, new CalcuatorImpl()).bind();
        int mins = pr.mins(12, 2);
        System.out.println(mins);
    }
}
