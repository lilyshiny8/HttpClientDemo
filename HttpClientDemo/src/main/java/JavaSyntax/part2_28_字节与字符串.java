package JavaSyntax;

/*
字节更多的情况是用于数据传输以及编码转换处理之中，在String类中提供有对字节操作的支持
 */
public class part2_28_字节与字符串 {
    public static void main(String[] args) {
        String str = "hello world!";
        byte [] byteArr = str.getBytes();
        for (int x=0; x<byteArr.length; x++) {
            System.out.print(byteArr[x] + ",");
        }
        System.out.println();
        String str1 = new String(byteArr);
        System.out.println(str1);

        //getBytes(String charsetName)


    }
}
