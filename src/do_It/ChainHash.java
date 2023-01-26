package do_It;

public class ChainHash<K,V> {

    class Node<K,V>{
        private K key;
        private V data;
        private Node<K,V> next;

        Node(K key, V data, Node<K,V>next){
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey(){
            return key;
        }
        V getValue(){
            return data;
        }
        public int hashCode(){
            return key.hashCode();
        }
    }

    private int size;
    private Node<K,V>[] table;

    public ChainHash(int capacity){
        try{
            table =  new Node[capacity];
            size = capacity;
        }catch(OutOfMemoryError e){
            this.size = 0;
        }
    }

    public int hashValue(Object key){
        return key.hashCode() % size;
    }

    public V search(K key){
        int hash = hashValue(key);
        Node<K,V> p = table[hash];

        while(p != null){
            if(p.getKey().equals(key))
                return p.getValue();
             p = p.next;
        }
        return null;
    }

    public int add(K key, V data){
        int hash = hashValue(key);
        Node<K,V>temp = table[hash];

        while(temp != null){
            if(temp.getKey().equals(key))
                return 1;
            temp = temp.next;
        }
        Node<K,V> p = new Node<K,V>(key, data, table[hash]);
        table[hash] = p;                                                //새로 들어온 node를 가장 앞으로
        return 0;
    }

    public int remove(K key){
        int hash = hashValue(key);
        Node<K,V>temp = table[hash];
        Node<K,V>pre = null;
        while(temp.getKey().equals(key) == false || temp != null){
            pre = temp;
            temp = temp.next;
        }
        if(temp == null)
            return 1;
        pre.next = temp.next;
        return 0;
    }

    public void dump(){
        for(int i=0; i<size; i++){
            Node<K,V>p = table[i];
            System.out.printf("%02d  ", i);
            while(p!= null){
                System.out.printf("-> %s (%s)  ", p.getKey(), p.getValue());
                p = p.next;
            }
        }
    }


}
