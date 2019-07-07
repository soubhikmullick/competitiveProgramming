package JavaConcepts.Java8;

import java.util.*;

class Employee implements Comparable<Employee> {
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

public class ComparatorComparable {
    public static void main(String[] args) {
        Employee emp[] = new Employee[3];
        emp[0]= new Employee(21, "Shikha");
        emp[1] = new Employee(24, "Amrit");
        emp[2] = new Employee(18, "Shukla");

        Arrays.sort(emp);
        System.out.println(Arrays.toString(emp));

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

//        Comparator<HashMap.Entry<String, Integer>> hashmapValue = Comparator.comparingInt(Map.Entry::getValue);
        Comparator<HashMap.Entry<String, Integer>> hashmapValue = (o1, o2) -> o1.getValue()-o2.getValue();
        Comparator<HashMap.Entry<String, Integer>> hashMapKey = Comparator.comparing(Map.Entry::getKey);
        List<Map.Entry<String, Integer>> listVal = new ArrayList<>(map.entrySet());
        Collections.sort(listVal, hashmapValue);
        for(Map.Entry<String, Integer> ma : listVal){
            System.out.println(ma.getKey()+" "+ma.getValue());
        }
        Collections.sort(listVal, hashMapKey);
        for(Map.Entry<String, Integer> ma : listVal){
            System.out.println(ma.getKey()+" "+ma.getValue());
        }

    }
}
