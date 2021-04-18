package hacker.rank.corejava;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetMapTest {



    static class Student implements Comparable<Student> {
        String name;
        String address;
        float gpa;

        Student(String name, String address, float gpa) {
            this.name = name;
            this.address = address;
            this.gpa = gpa;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Student student = (Student) o;

            if (Float.compare(student.gpa, gpa) != 0) {
                return false;
            }
            if (name != null ? !name.equals(student.name) : student.name != null) {
                return false;
            }
            return address != null ? address.equals(student.address) : student.address == null;

            //return name.equals(student.name) && address.equals(student.address);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (address != null ? address.hashCode() : 0);
            result = 31 * result + (gpa != +0.0f ? Float.floatToIntBits(gpa) : 0);

            result %= 3;
            return result;
        }

        @Override
        public int compareTo(Student o) {
            //return this.name.compareTo(o.name);
            int result = Float.compare(this.gpa, o.gpa);
            if (result == 0) {
                result = this.name.compareTo(o.name);
            }
            if (result == 0) {
                result = this.address.compareTo(o.address);
            }
            return result;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", gpa=" + gpa +
                    '}';
        }
    }

    Student lazyFred = new Student("Fred", "Here", 2.9F);
    Student jimFarAway = new Student("Jim", "Far away", 3.6F);
    Student shily = new Student("Shily", "There", 3.2F);
    Student jimOverThere = new Student("Jim", "Over there", 2.8F);
    Student fredAfterWork = new Student("Fred", "Here", 3.2F);
    Student duplicatedFred = new Student("Fred", "Here", 3.2F);

    @Test
    public void testTreeSet() {
        Set<Student> school = new TreeSet<>();

        school.add(lazyFred);
        school.add(new Student("Jim", "Far away", 3.6F));
        school.add(new Student("Shily", "There", 3.2F));
        for (Student s : school)
            System.out.println(s);
        System.out.println("-----------------------------------------------");
        for (Student s : school)
            System.out.println(s);
        System.out.println("-----------------------------------------------");

        school.add(fredAfterWork);
        System.out.println("Is New Fred in school?" + school.contains(fredAfterWork));
        System.out.println("Is Old Fred in school?" + school.contains(lazyFred));
        for (Student s : school)
            System.out.println(s);
    }

    @Test
    public void testHashMap() {
        Map<Student, Integer> school = new HashMap<>();
        school.put(lazyFred, lazyFred.hashCode());
        school.put(jimFarAway, jimFarAway.hashCode());
        school.put(shily, shily.hashCode());
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");


        school.put(jimOverThere, jimOverThere.hashCode());
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");

        school.put(fredAfterWork,fredAfterWork.hashCode());
        System.out.println("Is New Fred in school?" + school.keySet().contains(fredAfterWork));
        System.out.println("Is Old Fred in school?" + school.keySet().contains(lazyFred));
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");


        school.put(duplicatedFred,duplicatedFred.hashCode());
        System.out.println("Is Duplicated Fred in school?" + school.keySet().contains(duplicatedFred));
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");

    }


    @Test
    public void testTreeMap() {

        Map<Student, Integer> school = new TreeMap<>();
        school.put(lazyFred, lazyFred.hashCode());
        school.put(jimFarAway, jimFarAway.hashCode());
        school.put(shily, shily.hashCode());
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");

        school.put(jimOverThere, jimOverThere.hashCode());
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");

        school.put(fredAfterWork,fredAfterWork.hashCode());
        System.out.println("Is New Fred in school?" + school.keySet().contains(fredAfterWork));
        System.out.println("Is Old Fred in school?" + school.keySet().contains(lazyFred));
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");

        school.put(duplicatedFred,duplicatedFred.hashCode());
        System.out.println("Is Duplicated Fred in school?" + school.keySet().contains(duplicatedFred));
        school.forEach((k,v)->{
            System.out.println(k +":"+ v);
        });
        System.out.println("-----------------------------------------------");

    }


    class BadHashCode {

        int id;
        BadHashCode(int id){
            this.id = id;
        }

        @Override
        public int hashCode() {
           return super.hashCode()%3;
        }

        @Override
        public String toString(){
            return String.valueOf(this.id);
        }
    }

    @Test
    public void testBadHashCode(){
        Map<BadHashCode, Integer> testMap = new HashMap<>();
        for(int i=0;i<20;i++){
            testMap.put(new BadHashCode(i), i);
        }

        System.out.println(testMap);
    }
}
