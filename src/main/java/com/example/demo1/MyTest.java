package com.example.demo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MyTest {

    @Test
    void MemberTest(){
        Member member = new Member();
        member.setPassword("myPassword");
        assertEquals("myPassword",member.getPassword());
    }

    @Test
    void StickCheck(){
        double num = 100;
        MainGame cont = new MainGame();
        cont.setStickHeight();
        assertFalse((cont.getStickHeight()) == num);
    }

    @Test
    void TestChecker(){
        HelloController controller = new HelloController();
        controller.setTestInt("Hello");
        assertTrue((controller.getTestInt()).equals("Hello"));
    }

}
