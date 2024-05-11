public class Course {
    private String nama;
    private String deskripsi;
    private String namaPengajar;
    private String level;
    private int harga;

    public Course(String nama, String deskripsi, String namaPengajar, String level, int harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.namaPengajar = namaPengajar;
        this.level = level;
        this.harga = harga;
    }

    // Getter
    public String getNama() {
        return this.nama;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public String getNamaPengajar() {
        return this.namaPengajar;
    }

    public String getLevel() {
        return this.level;
    }

    public int getHarga() {
        return this.harga;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setNamaPengajar(String namaPengajar) {
        this.namaPengajar = namaPengajar;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Method getInfo
    public void getInfo() {
        System.out.println("===");
        System.out.println("COURSE INFO");
        System.out.println("tile: " + this.nama);
        System.out.println("description: " + this.deskripsi);
        System.out.println("lecturer: " + this.namaPengajar);
        System.out.println("level: " + this.level);
        System.out.println("price: " + this.harga);
        System.out.println("===");
      }

    public static void main(String[] args) throws Exception {
        Course course1 = new Course("data science", " learn about data science", "john doe", "all level", 150000);
        course1.getInfo();

        Course course2 = new Course("algorithm", "master the basic of algorithm", "enki", "beginner", 75000);
        course2.getInfo();

        Course course3 = new Course("docker", "learn about docker form zero to master", "ray krieger", "all level", 125000);
        course3.getInfo();
    }
}
