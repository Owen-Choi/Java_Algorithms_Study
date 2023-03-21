package algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Sorting {

    static class Person {
        int index;
        int age;
        String name;

        public Person(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }
    }

    static int N;
    static Person[] persons;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        persons = new Person[N];
        StringTokenizer st;
        int count = 0;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Person tempPerson = new Person(count, age, name);
            persons[count] = tempPerson;
            count++;
        }

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age == o2.age) {
                    return o1.index - o2.index;
                } else {
                    return o1.index - o2.index;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<persons.length; i++) {
            sb.append(persons[i].index).append(" ").append(persons[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
