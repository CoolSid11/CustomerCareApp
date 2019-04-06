package sid.com.customercareapp.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sid.com.customercareapp.Model.Person;


public class Common {
    public static final int VIEWTYPE_GROUP = 0;
    public static final int VIEWTYPE_PERSON = 1;
    public static final int RESULT_CODE = 1000;

    public static List<String> alphabet_available =  new ArrayList<>();


    /*
    Function to sort person list name by alphabet
     */

    public static ArrayList<Person> sortList(final ArrayList<Person> people){
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().compareTo(t1.getName());
            }
        });
        return people;
    }

    /*
    After sorted ,this function will add alphabet char to list
     */

    public static ArrayList<Person> addAlphabets(ArrayList<Person> list) {
        int i = 0;
        ArrayList<Person> customList = new ArrayList<>();
        Person firstPostion = new Person();
        firstPostion.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPostion.setViewType(VIEWTYPE_GROUP);
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0))); //Add first character to group header

        customList.add(firstPostion);

        for (i = 0; i < list.size() - 1; i++) {
            Person person = new Person();
            char name1 = list.get(i).getName().charAt(0); //Get first character in the name
            char name2 = list.get(i + 1).getName().charAt(0);

            if (name1 == name2) {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
            } else {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEWTYPE_GROUP);
                alphabet_available.add(String.valueOf(name2));
                customList.add(person);

            }


        }
        list.get(i).setViewType(VIEWTYPE_PERSON);
        customList.add(list.get(i));
        return customList;
    }

    /*
    this func will return postion of string in list
     */

    public static int findPositionWithName(String name,ArrayList<Person> list){
        for(int i = 0 ;i <list.size();i++){
            if(list.get(i).getName().equals(name))
                return i;

        }
        return -1;
    }

    /*
    this func will generate an alphabet list
     */

    public static ArrayList<String> genAlphabet(){
        ArrayList<String> result  = new ArrayList<>();

        for (int i=65;i<=90;i++){ //65 in ASCII code is A,90=z
            char character = (char)i;
            result.add(String.valueOf(character));
        }
        return result;

    }

    /*
    this func will create an person grp with random name
     */
    public static ArrayList<Person> genPeopleGroup() {
        ArrayList<Person> personList = new ArrayList<>();

        Person person = new Person("Andy","Director",-1);
        personList.add(person);

        person = new Person("L","Staff",-1);
        personList.add(person);

        person = new Person("F","Staff",-1);
        personList.add(person);

        person = new Person("B","Staff",-1);
        personList.add(person);

        person = new Person("N","Staff",-1);
        personList.add(person);

        person = new Person("Z","Staff",-1);
        personList.add(person);

        return personList;
    }
}
