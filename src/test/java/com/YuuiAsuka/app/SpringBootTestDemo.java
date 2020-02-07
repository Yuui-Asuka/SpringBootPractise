package com.YuuiAsuka.app;
import com.YuuiAsuka.app1.Start;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Start.class})  //启动整个spring工程
public class SpringBootTestDemo {

    @Test
    public void testOne(){
        System.out.println("hello");
        TestCase.assertEquals(1, 1);
    }

    @Before
    public void testBefore(){
        System.out.println("before");
    }

    @After
    public void testAfter(){
        System.out.println("after");
    }


}
