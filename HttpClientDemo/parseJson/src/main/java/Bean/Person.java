package Bean;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Person {
//    @SerializedName("NAME")
    private String name;
    private Boolean has_gf;
    private double age;
    private Object car;
    private String[] major;

    //该属性不可见

    private transient String ignore;
    //日期
    private Date birthday;

    public Person(){}
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getIgnore(){
        return ignore;
    }
    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public String getName() {
        return name;
    }
    public Boolean getHas_gf() {
        return has_gf;
    }
    public double getAge() {
        return age;
    }
    public Object getCar() {
        return car;
    }
    public String[] getMajor() {
        return major;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHas_gf(Boolean has_gf) {
        this.has_gf = has_gf;
    }
    public void setAge(double age) {
        this.age = age;
    }
    public void setCar(Object car) {
        this.car = car;
    }
    public void setMajor(String[] major) {
        this.major = major;
    }

}
