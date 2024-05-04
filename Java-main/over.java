class constructor {
    String name;
    int id;

    constructor(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public constructor(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        constructor t = new constructor("asdasd", 234);
        constructor t1 = new constructor(44444444);
        System.out.println(t.name);
        System.out.println(t1.id);
    }
}



