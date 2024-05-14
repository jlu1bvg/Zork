package minizorks.whodunit.Parallel.src.zork.proto;

public class Key extends Item {
    private String keyId;
    
    public Key(String keyId, String keyName, double weight) {
        super(keyName, weight, false, false);
        this.keyId = keyId;
    }
    
    public String getKeyId() {
        return keyId;
    }
}