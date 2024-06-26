package ems.example.ems_demo.aspect;

import ems.example.ems_demo.model.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditLogAspect.class);

    // Pointcut for addEmployee method execution
    @Pointcut("execution(public * ems.example.ems_demo.controller.EmployeeController.addEmployee(..))")
    public void addEmployeePointcut() {}

    // Pointcut for updateEmployee method execution
    @Pointcut("execution(public * ems.example.ems_demo.controller.EmployeeController.updateEmployee(Long, ems.example.ems_demo.model.Employee)) && args(id, employee)")
    public void updateEmployeePointcut(Long id, Employee employee) {}

    // Pointcut for deleteEmployee method execution
    @Pointcut("execution(public * ems.example.ems_demo.controller.EmployeeController.deleteEmployee(Long)) && args(id)")
    public void deleteEmployeePointcut(Long id) {}

    // Advice that logs after an employee is added
    @After("addEmployeePointcut()")
    public void logAddEmployeeAction(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Employee) {
            Employee employee = (Employee) args[0];
            LOGGER.info("Employee added: {} at {}", employee, LocalDateTime.now());
        }
    }

    // Advice that logs after an employee is updated
    @After("updateEmployeePointcut(id, employee)")
    public void logUpdateEmployeeAction(JoinPoint joinPoint, Long id, Employee employee) {
        LOGGER.info("Employee with ID {} updated at {}", id, LocalDateTime.now());
    }

    // Advice that logs after an employee is deleted
    @After("deleteEmployeePointcut(id)")
    public void logDeleteEmployeeAction(JoinPoint joinPoint, Long id) {
        LOGGER.info("Employee with ID {} deleted at {}", id, LocalDateTime.now());
    }
}
