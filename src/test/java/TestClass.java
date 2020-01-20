import org.testng.annotations.Test;

public class TestClass extends SeleniumClass{

    @Test
    public void myTestClass(){
        System.out.println(new SeleniumClass().Method());
    }
}