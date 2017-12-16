package com.goodidea.sso.interceptor;

import java.lang.reflect.Method;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.domin.SystemsLog;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.service.SystemsLogService;
import com.goodidea.sso.util.SystemUtils;





/***
 * 系统日志AOP
 * @author WangTang
 * @date 2016-5-25
 */
@Component
@Aspect
public class LogAspect {
	
	@Resource
	private SystemsLogService systemsLogService;
	
	//本地异常日志记录对象    
    protected static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut("@annotation(com.goodidea.sso.aop.SystemLog)")
	public void sysLogMethod(){};
	
	@AfterReturning(value="sysLogMethod()",argNames = "retVal",returning = "retVal")
	public void sysLogAfterReturn(JoinPoint joinPoint,Object retVal) throws Throwable{
		handleLog(joinPoint,null);
    
	}
	
	@AfterThrowing(value="sysLogMethod()",throwing="e")
    public void doAfter(JoinPoint joinPoint,Exception e){
        handleLog(joinPoint,e);
    }
	
	private void handleLog(JoinPoint joinPoint,Exception e){
        try {
        	SystemLog controllerLog = giveController(joinPoint);
    		if(controllerLog == null){
                return;
            }
    		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();        		
    		
    		HttpSession session = request.getSession();
    		User user = (User) session.getAttribute("user");
    		//*========数据库日志=========*//
    		SystemsLog log = new SystemsLog();
    		if(user!=null){
    			 log.setAccountId(user.getId());
                 log.setOperator(user.getUsername());
    		}
    		if(log.getOperator()!=null&&!"".equals(log.getOperator())){
    		
        		log.setIp(SystemUtils.getIpAddress(request));
        		//处理设置注解上的参数
                getControllerMethodDescription(controllerLog,log,request);
                //保存数据库
                systemsLogService.save(log);
    		}   		
		} catch (Exception exp) {
			// TODO: handle exception
		    logger.error(exp.getMessage());
		    exp.printStackTrace();
		}
	}
	
	/**  
     * 获取注解中对方法的描述信息 用于Controller层注解
     *  
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */   
     public  static void getControllerMethodDescription(SystemLog systemLog,SystemsLog log,HttpServletRequest request)  throws Exception { 
        log.setOperation(systemLog.operatorType());
        //是否需要保存request，参数和值
        if(systemLog.isSaveRequestData()){
            //获取参数的信息，传入到数据库中。
            setRequestValue(log,request);
        }
     }
     
     /**
      * 获取请求的参数，放到log中
      * @param userlogModel
      * @param request
      */
    @SuppressWarnings("rawtypes")
    private static void setRequestValue(SystemsLog log,HttpServletRequest request) {
        if(log == null)
        	log = new SystemsLog();
        Map map = request.getParameterMap();
        String params = JSONObject.toJSONString(map);
        log.setParameter(params);
    }
    
    /**
     * 是否存在注解，如果存在就记录日志
     * @param joinPoint
     * @param controllerLog
     * @return
     * @throws Exception
     */
    private static SystemLog giveController(JoinPoint joinPoint) throws Exception{
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;  
        Method method = methodSignature.getMethod();  
         
        if(method != null){
            return method.getAnnotation(SystemLog.class);
        }
        return null;
    }
    
    
}
