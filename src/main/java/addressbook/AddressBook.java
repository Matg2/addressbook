package addressbook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class AddressBook {
    private List<Entries> entry;

    public AddressBook() {
        this.entry = new ArrayList<>();

    }

    //note this
    public boolean addEntry(Entries entry) {
        if (this.entry.contains(entry)) {
            System.out.println("Another entry already present with same email address\n");
            return false;
        }
        this.entry.add(entry);
        System.out.println("Entry added successfully\n");
        return true;
    }

    public boolean removeEntry(String email) {
        int index = getEntryIndexByEmail(email);

        if (index == -1) {
            System.out.println("No entry found with given email\n");
            return false;
        }

        this.entry.remove(index);
        System.out.println("Entry deleted successfully\n");
        return true;
    }

    public int getEntryIndexByEmail(String email) {
        for (int i = 0; i < this.entry.size(); i++) {
            if (this.entry.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }
    public List<Entries> searchForAnEntry(String searchType, String searchQuery) {
        searchQuery = searchQuery.strip();
        if (searchType.equals("firstName")) {
            return searchByFirstName(searchQuery);
        } else if (searchType.equals("lastName")) {
            return searchByLastName(searchQuery);
        } else if (searchType.equals("phone")) {
            return searchByPhone(searchQuery);
        } else {
            return searchByEmail(searchQuery);
        }
    }


    private List<Entries> searchByFirstName(String firstName) {
        List<Entries> ans = new ArrayList<>();
        for (Entries entry : this.entry) {
            if (entry.getFirstName().contains(firstName)) {
                ans.add(entry);
            }
        }
        return ans;
    }

    private List<Entries> searchByLastName(String lastName) {
        List<Entries> ans = new ArrayList<>();
        for (Entries entry : this.entry) {
            if (entry.getLastName().contains(lastName)) {
                ans.add(entry);
            }
        }
        return ans;
    }

    private List<Entries> searchByPhone(String phone) {
        List<Entries> ans = new ArrayList<>();
        for (Entries entry : this.entry) {
            if (entry.getPhone().contains(phone)) {
                ans.add(entry);
            }
        }
        return ans;
    }

    private List<Entries> searchByEmail(String email) {
        for (Entries entry : this.entry) {
            if (entry.getEmail().equals(email)) {
                return Arrays.asList(entry);
            }
        }
        return new ArrayList<>();
    }

    public void printAddressBook() {
        if (this.entry.size() == 0) System.out.println("Address book is empty.");
        else {
            System.out.println("Printing Entries in Address Book:");
            System.out.println(this.toString());
        }
        System.out.println();
    }
    public void deleteAddressBook() {
        this.entry.clear();
        System.out.println("Address book deleted\n");
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for (Entries entry : this.entry) {
            sj.add(entry.toString());
        }
        return sj.toString();
    }
}


