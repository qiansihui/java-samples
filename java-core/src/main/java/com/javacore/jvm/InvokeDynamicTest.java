package com.javacore.jvm;

import java.lang.invoke.*;

/**
 * @Author qianqian.sun
 * @Date 2018/2/27
 * 描述：
 */
public class InvokeDynamicTest {
    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("hello");
    }

    public static void testMethod(String s) {
        System.out.println("hello s:" + s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType methodType) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, methodType));
    }

    private static MethodType MT_BootstrapMethod() {
        return MethodType.fromMethodDescriptorString(
                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                null);
    }

    private static MethodHandle MH_BootstrapMethod() throws Throwable {
        return MethodHandles.lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite callSite = (CallSite) MH_BootstrapMethod().invokeWithArguments(
                MethodHandles.lookup(),
                "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return callSite.dynamicInvoker();
    }
}
