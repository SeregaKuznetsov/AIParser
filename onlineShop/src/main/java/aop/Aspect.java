package aop;


import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect {
    // for executable
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Начало выполнения метода "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Конец выполнения метода: "+ joinPoint.getTarget().getClass().getSimpleName()+" "+ (end - start) + "ms");
        return result;
    }
    // for annotation
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("Начал свое выполнение метод: "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Закончил выполнение метод: "+ joinPoint.getTarget().getClass().getSimpleName()+" "+ (end - start) + "ms");
        return result;
    }
}
