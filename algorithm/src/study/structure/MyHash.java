package study.structure;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {this.hashTable = new Slot[size];}

    class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {return (int)(key.charAt(0)) % this.hashTable.length;}

    public boolean saveDate(String key, String value) {
        var address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key.equals(key)) {
                this.hashTable[address].value = value;
            } else {
                var currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key.equals(key)) {
                        this.hashTable[currAddress].value = value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
            }
            return true;
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        var address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key.equals(key)) {
                return this.hashTable[address].value;
            } else {
                var currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key.equals(key)) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash hash = new MyHash(20);

        hash.saveDate("young", "1");
        hash.saveDate("old", "2");
        hash.saveDate("you", "3");

        System.out.println(hash.getData("young"));
        System.out.println(hash.getData("old"));
        System.out.println(hash.getData("you"));
    }
}
