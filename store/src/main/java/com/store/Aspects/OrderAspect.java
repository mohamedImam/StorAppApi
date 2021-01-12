package com.store.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 16:49
 */
@Aspect
@Component
public class OrderAspect {

    public void checkQantity(JoinPoint request) {}
}
