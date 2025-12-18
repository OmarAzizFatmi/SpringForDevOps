package tn.esprit.tpfoyer2.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReservationExecutionTimeAspect {

    @Around("execution(* tn.esprit.tpfoyer2.Service.ReservationService.ajouterReservation(..))")
    public Object mesurerTempsAjoutReservation(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Temps d'exécution de la méthode ajouterReservation : " + duration + " ms");
        return result;
    }
}
