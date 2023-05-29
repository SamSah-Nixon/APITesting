/*
 * Class that stores two values together that can be retrieved and changed
 * Sam S-N
 * Created: 5/18/23
 * Last Modified: 5/18/23
 */
public class NameValuePair<K, E>
{
    private K key;
    private E info;

    public NameValuePair()
    {
        key  = null;
        info = null;
    }

    public NameValuePair(K theKey, E theInfo)
    {
        key  = theKey;
        info = theInfo;
    }

    public K getFirst()
    { return key; }

    public E getSecond()
    { return info; }

    public void setFirst(K newKey)
    {   key = newKey;}

    public void setSecond(E newInfo)
    {   info = newInfo; }

    public String toString()
    {return "("+key + ":" + info+")";}
}
