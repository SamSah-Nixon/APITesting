
import java.util.ArrayList;

public class EditableURI{

    private String root;
    private int size;
    private ArrayList<NameValuePair<String, NameValuePair<String, String>>> parameters;


    public EditableURI(String root){
        this.root = (root == null) ? "" : root;
        this.parameters = new ArrayList<>();
        this.size = 0;
    }

    public boolean addParameter(String uriSegment, String name, String value){
        if(contains(name) == null) {
            parameters.add(new NameValuePair<>(uriSegment, new NameValuePair<>(name, value)));
            size++;
            return true;
        }
        else
            return false;
    }

    public void editParameter(String name, String value){
        NameValuePair<String,NameValuePair<String,String>> parameter = contains(name);
        if(parameter != null)
            parameter.setSecond(new NameValuePair<>(parameter.getSecond().getFirst(), value));
    }

    public NameValuePair<String,NameValuePair<String,String>> contains(String name){
        for(NameValuePair<String, NameValuePair<String, String>> i : parameters){
            if(i.getSecond().getFirst().equals(name))
                return i;
        }
        return null;
    }
    public void setRoot(String root){
        this.root = (root == null) ? "" : root;
    }

    public String getRoot(){
        return root;
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        String uri = root;
        for(NameValuePair<String, NameValuePair<String, String>> i : parameters){
            uri += i.getFirst() + i.getSecond().getSecond();
        }
        return uri;
    }
}
