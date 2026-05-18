/*
package com.johnny.singlegradlespringboot;

import com.johnny.singlegradlespringboot.entity.Book;
import com.johnny.singlegradlespringboot.entity.User;
import com.johnny.singlegradlespringboot.repository.BookRepository;
import jakarta.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AtomicTest {
    @Resource
    BookRepository bookRepository;
    @Test
    public void atomicTest() throws InterruptedException {
        AtomicInteger value = new AtomicInteger(10);
        Assert.assertFalse(value.compareAndSet(2, 4));

        //
        final int threadSize = 30;
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread(value::incrementAndGet);
        }

        for(Thread t:ts) {
            System.out.println(value.get());
            t.start();
            System.out.println(t.getName());
//            t.join();
            System.out.println(value.get());
        }
//        for(Thread t:ts) {
//            t.join();
//        }
Thread.sleep(1000);
        System.out.println(value.get());
        Assert.assertEquals(value.get(), threadSize+10);
    }


    @Test
    public void textBlockTest(){
        var sql = """
                insert into book(name, publish, author) \
                values ('%s', 'Tor Books', 'Liu Cixin');
                """;
        var json = """
                {
                    "id": 6,
                    "name": "jane",
                    "company": "CITI",
                    "age": 33
                }
                """.indent(4);
        System.out.println(json);
        String format = String.format(sql, "The Three-Body problem");
        System.out.printf((sql), "The Three-Body problem");

        Map<String, String> s = new HashMap<>();
        s.put("a", "1");
        s.put("b", "2");
//        s.forEach((k, v)->format+k);
    }

    @Test
    public void instanceofTest(){
        Object a = "This is a text";
        String s1 = a instanceof String s ? s.indent(4) : a.toString();
        System.out.println(s1);

        List<String> strings = Stream.of("Records", "text Block", "sealed Classes")
                .map(String::toLowerCase)
                .filter(s -> s.contains(" "))
                .toList();
        System.out.println(strings.size());
        System.out.println(strings);


    }

//    @Test
//    public void hiddenTest() throws Throwable {
//        String classInfo = "yv66vgAAAD0AFAoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAZaHR0cHM6Ly93d3cuZGlkaXNwYWNlLmNvbQcACgEALmNvbS9kaWRpc3BhY2UvZGVidWcvamF2YTE1L0pFUDM3MUhpZGRlbkNsYXNzZXMBAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQASTG9jYWxWYXJpYWJsZVRhYmxlAQAEdGhpcwEAMExjb20vZGlkaXNwYWNlL2RlYnVnL2phdmExNS9KRVAzNzFIaWRkZW5DbGFzc2VzOwEABWhlbGxvAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAApTb3VyY2VGaWxlAQAYSkVQMzcxSGlkZGVuQ2xhc3Nlcy5qYXZhACEACQACAAAAAAACAAEABQAGAAEACwAAAC8AAQABAAAABSq3AAGxAAAAAgAMAAAABgABAAAAAwANAAAADAABAAAABQAOAA8AAAAJABAAEQABAAsAAAAbAAEAAAAAAAMSB7AAAAABAAwAAAAGAAEAAAAGAAEAEgAAAAIAEw==";
//        byte[] decode = Base64.getDecoder().decode(classInfo);
//        Class<?> lookupClass = MethodHandles.lookup().defineHiddenClass(decode, true, MethodHandles.Lookup.ClassOption.NESTMATE)
//                .lookupClass();
//
//        System.out.println(lookupClass.getName());
//        String name = Arrays.stream(lookupClass.getDeclaredMethods()).findFirst().get().getName();
//
////        Assert.assertEquals(name, "hello");
//        System.out.println(name);
//        MethodHandle aStatic = MethodHandles.lookup().findStatic(lookupClass, name, MethodType.methodType(String.class));
//        Object o = aStatic.invokeExact();
//        if(o instanceof String s)
//            System.out.println(s);
//
//    }

}
*/
