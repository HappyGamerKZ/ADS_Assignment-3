public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 31 * hash + this.id;

        if(name!=null){
            int stringHash = 0;
            for (int i = 0; i < name.length(); i++) {
                stringHash += 31 * stringHash + name.charAt(i);
            }
            hash = 31 * hash + stringHash;
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id && (name != null ? name.equals(that.name) : that.name == null);
    }
}
