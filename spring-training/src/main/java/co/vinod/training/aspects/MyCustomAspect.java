package co.vinod.training.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import co.vinod.training.dao.DaoException;

// AOP benefits:
// 1. no code duplications (cross-cutting concerns) A.K.A. code scattering (spaghetti)
// 2. no code tangling (mixing up of other related concerns with the main concern)
@Component
@Aspect // concern in hand
public class MyCustomAspect {

	public MyCustomAspect() {
		System.out.println("MyCustomAspect instantiated!");
	}

	// an aspect contains 1 or more advice
	// an advice is a function (which provides a solution to the concern)
	// 4 types: before, after, around, after-throwing
	// an advice is applied on a join-point (a function in Spring/Java)
	// a subset of join-points on which you actually apply an advice --> pointcut
	// point is a predicate defined using AspectJ expression language
	@Before("execution (* co.vinod..*Dao.*(..))")
	public void logMethodInfo(JoinPoint jp) {
		System.out.println(">>>>>>> " + jp.getSignature().getName() + " called!");
		System.out.println("Arguments = " + Arrays.toString(jp.getArgs()));
	}

	@Around("execution (* co.vinod..*Dao.*Price*(Double, Double))")
	public Object checkAndSwapArgs(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		System.out.println("MyCustomAspect.checkAndSwapArgs called with arguments: " + Arrays.toString(args));
		double min = (double) args[0];
		double max = (double) args[1];

		if (min > max) {
			args = new Object[] { max, min };
		}
		return pjp.proceed(args);
	}
	
	@AfterThrowing(value="execution(* co.vinod..*Dao.*(..))", throwing = "ex")
	public void convertToDaoException(Exception ex) throws DaoException {
		throw new DaoException(ex);
	}
}




