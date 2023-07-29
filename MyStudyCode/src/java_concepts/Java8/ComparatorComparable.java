package java_concepts.Java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class Employee implements Comparable<Employee>{
    int age;
    String name;

    Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.age - emp.age;
    }

    @Override
    public String toString() {
        return "age = "+this.age+"; name = "+this.name;
    }

}

class Student implements Comparable<Student>{
    int age;
    String name;
    int num;

    public Student(int i, String soubhik,int i1) {
        this.age = i;
        this.name = soubhik;
        this.num = i1;
    }

    @Override
    public int compareTo(Student student) {
        return this.age-student.age;
    }
}

public class ComparatorComparable {
    public static void main(String[] args) {
        Employee[] emp = new Employee[3];
        emp[0]= new Employee(21, "Shikha");
        emp[1] = new Employee(24, "Amrit");
        emp[2] = new Employee(18, "Shukla");

        Arrays.sort(emp);
        System.out.println(Arrays.toString(emp));
        System.out.println();
        List<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student(1,"Soubhik",10));
        arrayList.add(new Student(2,"Anamika", 9));
        arrayList.add(new Student(3,"Joy", 8));
        arrayList.add(new Student(4,"Rony", 7));

        arrayList.sort(Comparator.comparingInt(student -> student.num));
        arrayList.forEach(student -> System.out.print(student.age+" "+student.name+" "));
        System.out.println();
        Collections.sort(arrayList);
        arrayList.forEach(student -> System.out.print(student.age+" "+student.name+" "));
        System.out.println();

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

//        Comparator<HashMap.Entry<String, Integer>> hashmapValue = Comparator.comparingInt(Map.Entry::getValue);
//        Comparator<HashMap.Entry<String, Integer>> hashmapValue = (o1, o2) -> o1.getValue()-o2.getValue();
//        Comparator<HashMap.Entry<String, Integer>> hashMapKey = Comparator.comparing(Map.Entry::getKey);
        List<Map.Entry<String, Integer>> listVal = new ArrayList<>(map.entrySet());
        Collections.sort(listVal, Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<String, Integer> ma : listVal){
            System.out.print(ma.getKey()+" "+ma.getValue()+" ");
        }
        System.out.println();
        Collections.sort(listVal, Map.Entry.comparingByKey());
        for(Map.Entry<String, Integer> ma : listVal){
            System.out.print(ma.getKey()+" "+ma.getValue()+" ");
        }
        System.out.println();
    }
}
