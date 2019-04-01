package mvnTest.junit;


import org.testng.annotations.Test;

public class RandomGeneratorTest {
    @Test(groups={"unit","integration"})
    public void testAdd(){

        int a = 1 ;
        int b= 2 ;
        System.out.println("计算a+b="+a+b);
    }

    @Test(groups={"integration"})
    public void testdel(){

        int a = 1 ;
        int b= 2 ;
        System.out.print("计算2-1=");
        System.out.println(b-a);
    }
}