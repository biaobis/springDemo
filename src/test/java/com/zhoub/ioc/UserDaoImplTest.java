package com.zhoub.ioc;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void getMsg() {
        assertEquals("Junit", new UserDaoImpl().getMsg());
    }
}
