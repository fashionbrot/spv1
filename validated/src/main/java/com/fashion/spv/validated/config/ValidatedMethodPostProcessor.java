package com.fashion.spv.validated.config;

import com.fashion.spv.validated.annotation.Validated;
import com.fashion.spv.validated.spring.intercept.ValidatedMethodIntercept;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.annotation.Annotation;

public  class ValidatedMethodPostProcessor extends AbstractAdvisingBeanPostProcessor implements BeanFactoryAware,InitializingBean {

    public static final String BEAN_NAME="validatedMethodPostProcessor";

    private Class<? extends Annotation> validatedAnnotationType = Validated.class;

    private ConfigurableListableBeanFactory beanFactory;

    public void afterPropertiesSet()  {
        Pointcut pointcut =  AnnotationMatchingPointcut.forMethodAnnotation(this.validatedAnnotationType);
        this.advisor = new DefaultPointcutAdvisor(pointcut, (ValidatedMethodIntercept) beanFactory.getBean(ValidatedMethodIntercept.BEAN_NAME));
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory instanceof ConfigurableListableBeanFactory ? (ConfigurableListableBeanFactory)beanFactory : null;
    }

}
