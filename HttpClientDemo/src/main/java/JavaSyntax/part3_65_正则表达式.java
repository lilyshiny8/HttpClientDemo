package JavaSyntax;

import org.testng.annotations.Test;

/*
java.util.regex
正则标记
所有的标记都在java.util.regex.Pattern类中进行了定义
 */
public class part3_65_正则表达式 {
    /*
    Characters 【单个】
        x   The character x
        \\  The backslash character
        \t  The tab character ('\u0009')
        \n  The newline (line feed) character ('\u000A')
     */
    @Test
    public void test1(){
        System.out.println("a".matches("a"));//true
        System.out.println("aa".matches("a"));//false
        System.out.println("\\".matches("\\\\"));
    }
    /*
    Character classes 【单个】描述一个范围
        [abc]    a, b, or c (simple class)
        [^abc]   Any character except a, b, or c (negation)
        [0-9]    '0' throuth '9'
        [a-zA-Z] a through z or A through Z, inclusive (range)
     */
    @Test
    public void test2(){
        System.out.println("a".matches("[abc]"));
        System.out.println("a".matches("[^abc]"));
        System.out.println("A".matches("[a-zA-Z]"));
        System.out.println("1".matches("[0-9]"));
    }
    /*
    Predefined character classes
        .    Any character (may or may not match line terminators)
        \d   A digit: [0-9]
        \D   A non-digit: [^0-9]
        \s   A whitespace character: [ \t\n\x0B\f\r]   可能是空格 \t \n
        \S   A non-whitespace character: [^\s]
        \w   A word character: [a-zA-Z_0-9]
        \W   A non-word character: [^\w]
     */
    @Test
    public void test3(){
//        System.out.println("a".matches("."));
//        System.out.println(".".matches("."));
//        System.out.println(".".matches("\\."));//  \\.描述的是.
//        System.out.println("1".matches("\\d"));
//        System.out.println("1".matches("\\D"));
        System.out.println(" ".matches("\\s"));
        System.out.println("\n".matches("\\s"));
        System.out.println("a".matches("\\S"));
    }
    /*
    Boundary matchers
        ^ The beginning of a line
        $ The end of a line
     */

    /*
    Greedy quantifiers
        X?     X, once or not at all   0次或者1次
        X*     X, zero or more times
        X+     X, one or more times
        X{n}   X, exactly n times
        X{n,}  X, at least n times
        X{n,m} X, at least n but not more than m times
     */
    @Test
    public void test4(){
        System.out.println("aaa".matches("a{3}"));
        System.out.println("aaa".matches("a?"));
    }
    /*
    ???
    Logical operators
        XY     X followed by Y   第一个正则匹配之后立即进行第二个正则的匹配
        X|Y    Either X or Y      正则X或者正Y出现一次
        (X)    X, as a capturing group  按照一组正则进行处理
     */
    @Test
    public void test5(){
        System.out.println("abc".matches("a*b*"));
        System.out.println("abc".matches("a?|b?"));

    }
}
