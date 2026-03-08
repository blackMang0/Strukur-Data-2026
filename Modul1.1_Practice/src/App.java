public class App {
    public static void main(String[] args) throws Exception {
    
        //Instansiasi membuat objek
        Mahasiswa mahasiswa1 = new Mahasiswa("Mamat", "5020251067", "Teknik Perpipaan", 4.02);
        mahasiswa1.show();

        //Encapsulation
        mahasiswa1.setNama("Otong");
        mahasiswa1.show();

        //Encapsulation(variabel mahasiswa private dipanggil dengan methods)
        System.out.println("\nEnscapsulation");
        System.out.println(mahasiswa1.getNama());
        System.out.println(mahasiswa1.getNrp());
        System.out.println(mahasiswa1.getDepartemen());
        System.out.println(mahasiswa1.getIpk());

        // System.out.println(mahasiswa1.say("Hai"));

        //Inheritance(pewarisan) & Abstraction(Menyembunyikan detail)
        System.out.println("\nInheritance");
        Motorcycle motor1 = new Motorcycle("Honda", 100);
        motor1.roda = 2;
        
        motor1.forward();
        motor1.honk();
        motor1.stop();
        
        System.out.println("\nAbstraction");
        Motorcycle motor2 = new Motorcycle("Yamaha", 120);
        motor2.roda = 2;

        motor2.honk();
        motor2.stop();
        motor2.broke();

        //Polymorphism(banyak bentuk)(method sama tapi banyak bentuk)
        System.out.println("\nPolymorphism");
        Animal hewan;
        hewan = new Cat();
        hewan.sound();

        hewan = new Dog();
        hewan.sound();
    }
}

//membuat class baru mahasiswa
class Mahasiswa{
    //Encapsulation (semua variabel ini private tidak bisa diakses(terlindungi) kecuali dengan methods dibawah)
    private String nama;
    private String nrp;
    private String departemen;
    private double ipk;

    //buat construktor dengan parameter
    public Mahasiswa(String nama, String nrp, String departemen, double ipk){
        this.nama = nama;
        this.nrp = nrp;
        this.departemen = departemen;
        this.ipk = ipk;
    }
    //methods tanpa return dan tanpa parameter
    public void show(){
        System.out.println("Nama: " + this.nama);
        System.out.println("NRP: " + this.nrp);
        System.out.println("Departemen: " + this.departemen);
        System.out.println("IPK: " + this.ipk);
    }

    //methods setter(tanpa return dan dgn parameter)(untuk mengubah isi variabel private)
    public void setNama(String nama){
        this.nama = nama;
    }

    //methods getter(pake return dan tanpa parameter)(agar dapat dibaca variabel private)
    public String getNama(){
        return this.nama;
    }
    public String getNrp(){
        return this.nrp;
    }
    public String getDepartemen(){
        return this.departemen;
    }
    public double getIpk(){
        return this.ipk;
    }

    //methods pake return dan dengan parameter
    public String say(String message){
        return message + ", nama saya " + this.nama;
    }
}

//Inheritance(pewarisan sifat dari parent class ke child class)
//Abstraction(Menyembunyikan detail, hanya menampilkan fungsi penting)
abstract class Vechile{
    protected String merk;
    protected int speed;

    public Vechile(String merk, int speed){
        this.merk = merk;
        this.speed = speed;
    }

    void forward(){
        System.out.println("Kendaraan maju");
    }
    void stop(){
        System.out.println("kendaraan berhenti");
    }
    abstract void broke();
}
class Motorcycle extends Vechile{
    int roda;

    public Motorcycle(String merk, int speed){
        super(merk, speed);
    }

    void honk(){
        System.out.println("Tot tott");
    }
    
    //child class mengganti(timpa) sifat(method) parent class
    @Override
    void stop(){
        System.out.println("Motor berhenti");
    }

    void broke(){
        System.out.println("Motor " + merk + " dengan kecepatan " + speed + " ini mogok");
    }
}

//Polymorphism(Satu method dapat memiliki banyak perilaku)
//Ada dua overloading dan overriding
class Animal{
    void sound(){
        System.out.println("Hewan bersuara..");
    }
}
class Cat extends Animal{
    void sound(){
        System.out.println("Miaww miaww..");
    }
}
class Dog extends Animal{
    void sound(){
        System.out.println("Guk guk guk..");
    }
}

