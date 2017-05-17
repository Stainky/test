import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sj on 17/4/13.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==before==");
        Object result = method.invoke(target, args);
        System.out.println("==before==");
        return result;
    }
}
