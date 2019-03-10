package hacker.rank.interviewpreparation.java8;

import org.junit.Test;

public class Inheriate {

    class A {
        void print(String s) {
            System.out.println("A print: " + s);
        }

        void printTwice(String... all) {
            for (String s : all) {
                print(s);
            }
        }
    }

    class B extends A {
        @Override
        void print(String s) {
            super.print(s);
        }

        @Override
        void printTwice(String... all) {
            super.printTwice(all);
        }
    }

    @Test
    public void testInheriate() {
        new B().printTwice("1", "2", "3");
    }
}
