package com.henryhe;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilTest {

    private static StringUtil stringUtil = null;

    @BeforeClass
    public static void init(){
        stringUtil = new StringUtil();
    }

    @Test
    public void testSimpleOk(){
        String str = "aabcccbbad";
        Assert.assertEquals("d", stringUtil.removeDup(str, false));
    }

    @Test
    public void testAdvancedOk(){
        String str = "abcccbad";
        Assert.assertEquals("d", stringUtil.removeDup(str, true));
    }

    @Test
    public void testBad(){
        String str = "1aaabcccbbad";
        boolean exceptionFlag = false;
        try{
            str = stringUtil.removeDup(str, false);
        }catch (RuntimeException ex){
            exceptionFlag = true;
        }
        Assert.assertTrue(exceptionFlag);
    }
}
