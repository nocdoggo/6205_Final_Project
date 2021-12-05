package lookuptable;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        StrokeNumbers sn=new StrokeNumbers();
        System.out.println(sn.split("台霏蕃")[0]);
        System.out.println(sn.split("台霏蕃")[1]);
        System.out.println(sn.split("台霏蕃")[2]);

    }
}
