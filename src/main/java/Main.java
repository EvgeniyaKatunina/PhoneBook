import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    private static final HashMap<String, ArrayList<String>> phonesByName = new HashMap<>();

    public static final String NO_EMPLOYEE = "This employee is absent in database.";
    public static final String USAGE = "Usage: ФИО";

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException(USAGE);
        }
        fillPhoneBook();
        ArrayList<String> phones = getPhones(args[0]);
        for (String phone : phones) {
            System.out.println(phone);
        }
    }

    public static ArrayList<String> getPhones(String name) {
        return phonesByName.computeIfAbsent(name, k -> new ArrayList<>(Arrays.asList(NO_EMPLOYEE)));
    }

    public static void fillPhoneBook() {
        phonesByName.put("Иванов И. И.", new ArrayList<>(Arrays.asList("+8 800 2000 500", "+8 800 200 600")));
        phonesByName.put("Петров П. П.", new ArrayList<>(Arrays.asList("+8 800 2000 700")));
        phonesByName.put("Сидоров С. С.", new ArrayList<>(Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800" +
                " 2000 000")));
    }
}
