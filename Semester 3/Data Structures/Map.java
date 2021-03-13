public interface Map {
    Object get(Object key);
    Object put(Object key, Object value);
    Object remove(Object key);
    int size();
}

//Linear & Quadratic Probing Implementation
class HashTable implements Map{
    private int useProbe;
    private Entry[] entries;
    private float loadFactor;
    private int size, used;         //used acquires space for NIL
    private Entry NIL = new Entry(null,null);
    private class Entry{
        Object key, value;
        Entry(Object k, Object v){
            key = k;    value = v;
        }
    }
    public HashTable(int capacity, float loadFactor, int useProbe){
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
        this.useProbe = useProbe;
    }
    public HashTable(int capacity, float loadFactor){
        this(capacity, loadFactor, 0);      // by default use linear probing
    }
    public HashTable(int capacity){
        this(capacity, 0.75F);
    }
    public HashTable(){
        this(10);
    }
    //Complementary functions
    public int hash(Object key){
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }
    private int nextProbe(int h, int i){
        if(useProbe==0)return (h+i) % entries.length;  //Linear Probing
        else return (h+i*i) % entries.length; // quadratic probing
    }
    private void rehash(){
        Entry[] oldEntries = entries;
        entries = new Entry[2*entries.length+1];
        for(int i = 0; i < oldEntries.length; i++){
            Entry entry = oldEntries[i];
            if(entry == NIL || entry == null) continue;
            int h = hash(entry.key);
            for(int x = 0; x < entries.length; x++){
                int j = nextProbe(h,x);
                if(entries[j] == null){
                    entries[j] = entry;
                    break;
                }
            }
            used = size;
        }
    }
    @Override
    public Object get(Object key) {
        int h = hash(key);
        for(int i = 0; i < entries.length; i++){
            int j = nextProbe(h , i);
            Entry entry = entries[j];
            if(entry == null)break;
            if(entry == NIL)continue;
            if(entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if(used > (loadFactor*entries.length))rehash();
        int h = hash(key);
        System.out.println("Hash of " + key + " is "+h);
        for (int i = 0; i < entries.length; i++){
            int j = (h+i) % entries.length;
            Entry entry = entries[j];
            if(entry==null){
                entries[j]=new Entry(key,value);
                ++size;
                ++used;
                return null;
            }
            if(entry == NIL)continue;
            if(entry.key.equals(key)){
                Object oldValue = entry.value;
                entries[j].value = value;
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        int h = hash(key);
        for(int i = 0; i < entries.length; i++){
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if(entry == NIL)continue;
            if(entry.key.equals(key)){
                Object Value = entry.value;
                entries[j] = NIL;
                size--;
                return Value;
            }
            if(entry == null)break;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
    public String toString(){
        String s= "";
        for (int i = 0; i < entries.length; i++) {
            if(entries[i] != null){
                s += i+" "+entries[i].key +" has value " + entries[i].value +"\n";
            }
            else {
                s += i + " is empty \n";
            }
        }
        return s;
    }
}

//
class TestMap{
    public static void main(String[] args) {
        HashTable linearHash = new HashTable(15,0.5F,0);
        HashTable quadHash = new HashTable(15,0.5F,1);

        long init = System.currentTimeMillis();
        linearHash.put("FA" , "faraz");
        linearHash.put("HA" , "haris");
        linearHash.put("NO" , "noor");
        linearHash.put("SA" , "saad");
        linearHash.put("FU" , "furqan");
        linearHash.put("RI" , "ritik");
        linearHash.put("FI" , "faisal");
        linearHash.put("BI" , "bilal");
        linearHash.put("MI" , "milton");
        linearHash.put("HU" , "hunain");
        System.out.println("Total time taken by linear probe is " + (System.currentTimeMillis() - init) + " milli secs" );

        init = System.currentTimeMillis();
        quadHash.put("FA" , "faraz");
        quadHash.put("HA" , "haris");
        quadHash.put("NO" , "noor");
        quadHash.put("SA" , "saad");
        quadHash.put("FU" , "furqan");
        quadHash.put("RI" , "ritik");
        quadHash.put("FI" , "faisal");
        quadHash.put("BI" , "bilal");
        quadHash.put("MI" , "milton");
        quadHash.put("HU" , "hunain");
        System.out.println("Total time taken by quadratic probe is " + (System.currentTimeMillis()- init) + " milli secs" );

    }
}