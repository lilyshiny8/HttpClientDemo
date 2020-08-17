package JavaSyntax;

public class part1_12_TypeChar {
    public static void main(String[] args) {
        //字符型可以和int互相转换
        char c = 'A';
        int num = c;//将字符变为int型
        System.out.println(num);//A
        /*
        常用范围
        大写字母：A(65)~Z(90)
        小写字母：a(97)~z(122)
        字符数字：0(48)~9(57)
         */
        //字符变量+int常量=int类型
        int num1 = c + 32;
        //将int强制转换为char
        char x = (char) num1;//result is a

        //其他语言使用的编码是ASCII码，但是Java中使用的是unicode，这种编码包含有ASCII码的部分内容，但是他所包含的编码范围又多于ASCII码
        //同时unicode编码使用16进制编码，这个编码可以保存任何的文字信息，包括中文
        //保存中文字符
        char c1 = '周';
        int num2 = c1;
        System.out.println(num2);

    }
}
