public class Feira {
    private int codigo;
    private String fruta;
    public Feira(int codigo, String fruta) {
        this.codigo = codigo;
        this.fruta = fruta;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getFruta() {
        return fruta;
    }
}