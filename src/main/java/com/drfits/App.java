package com.drfits;

import com.drfits.annotation.RunMethod;
import com.drfits.transfer.Transfer;
import com.drfits.transfer.TransferExecutorImpl;
import com.drfits.transfer.TransferImpl;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * Application for execute annotated method
 */
public class App {

    public static void main(String[] args) {
        Transfer transfer = new TransferImpl("Hello, World!");
        Method[] methods = TransferExecutorImpl.class.getMethods();
        for (Method method : methods) {
            RunMethod annotation = method.getAnnotation(RunMethod.class);
            if (annotation != null) {
                try {
                    MethodHandles.Lookup lookup = MethodHandles.lookup();
                    MethodHandle methodHandle = lookup.unreflect(method);
                    MethodType invokedType = MethodType.methodType(Function.class);
                    MethodType functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
                    Function lambda = (Function) LambdaMetafactory.metafactory(
                            lookup,
                            "apply",
                            invokedType,
                            functionMethodType,
                            methodHandle,
                            methodHandle.type()).getTarget().invokeExact();
                    lambda.apply(transfer);
                } catch (Throwable t) {
                    System.out.println(t.getMessage());
                }
            }
        }
    }

}