package leetcode;

public class sol706 {

    static class MyHashMap {

        private int[] hashMap;
    
        public MyHashMap() {
            hashMap = new int[1000001];
            for(int i=0; i<=1000000; i++) hashMap[i] = -1;
        }
        
        public void put(int key, int value) {
            hashMap[key] = value;
        }
        
        public int get(int key) {
            return hashMap[key];
        }
        
        public void remove(int key) {
            hashMap[key] = -1;
        }
    }

    public static void main(String[] argss) {

        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}
