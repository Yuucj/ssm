package cn.itcast.controller;

import cn.itcast.dao.SysLogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/3 18:45
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private HttpServletRequest request;
    //开始访问时间
    private Date startTime;
    //访问的类
    private Class executionClass;
    //访问的方法
    private Method executionMethod;
    //连接点
    @Pointcut("execution(* cn.itcast.controller.*.*(..))")
    private void pointId() {
    }

    @Before("pointId()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        //获取访问时间
        startTime = new Date();

        executionClass = joinPoint.getTarget().getClass();
        //访问的方法的名称
        String methodName = joinPoint.getSignature().getName();
        //访问参数
        Object[] args = joinPoint.getArgs();

       if(executionClass != SysLogController.class){
           if (args == null || args.length == 0) {
               executionMethod = executionClass.getMethod(methodName);
           } else {
               List<Class> argsList = new ArrayList<Class>();
               //org.springframework.ui.Model
               //org.springframework.validation.support.BindingAwareModelMap
               for (Object arg : args) {
                   if(arg instanceof BindingAwareModelMap){
                       argsList.add(Model.class);
                   }else {
                       argsList.add(arg.getClass());
                   }
               }
               executionMethod = executionClass.getMethod(methodName, argsList.toArray(new Class[argsList.size()]));
           }
       }


    }

    @After("pointId()")
    public void doAfter(JoinPoint joinPoint) throws Exception {

        if (executionClass != SysLogController.class) {
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                //url
                String url = "";
                if (methodAnnotation != null) {
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];
                }
                //访问时长
                Long executionTime = new Date().getTime() - startTime.getTime();
                //ip
                String ip = request.getRemoteAddr();
                //method
                String method = "[类名]:" + executionClass.getName() + "[方法名]:" + executionMethod.getName();
                //username
                SecurityContextImpl securityContext = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                String username = ((User) securityContext.getAuthentication().getPrincipal()).getUsername();
                SysLog sysLog = new SysLog();
                sysLog.setVisitTime(startTime);
                sysLog.setUsername(username);
                sysLog.setIp(ip);
                sysLog.setUrl(url);
                sysLog.setExecutionTime(executionTime);
                sysLog.setMethod(method);
                sysLogService.save(sysLog);
            }
        }
    }

}
