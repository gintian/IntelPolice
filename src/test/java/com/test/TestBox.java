package com.test;

import com.utils.StoreUtil;
import org.junit.Test;

public class TestBox {
    @Test
    public void openBox(){
        try {
            StoreUtil.openBox(13,"10.164.22.219");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
