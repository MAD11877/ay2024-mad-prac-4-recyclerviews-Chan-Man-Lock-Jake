package sg.edu.np.mad.madpractical4;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String description;
    public int id;
    public boolean followed;
    User(String input_name, String input_description, int input_id, boolean input_followed) {
        name = input_name;
        description = input_description;
        id = input_id;
        followed = input_followed;
    }
}
