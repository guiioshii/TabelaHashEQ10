import java.util.LinkedList;

public class Hash {
    private int max_posicao;
    private int max_itens;
    private int quant_itens;
    private LinkedList<No>[] tabela;
    public Hash(int max_itens, int max_posicao) {
        quant_itens = 0;
        this.max_posicao = max_posicao;
        this.max_itens = max_itens;
        tabela = new LinkedList[max_posicao];
        for (int i = 0; i < max_posicao; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    public boolean isFull() {
        return quant_itens == max_itens;
    }

    private int FuncaoHash(int item) {
        return item % max_posicao;
    }

    public void inserir(No item) {
        int local = FuncaoHash(item.getNumero());
        LinkedList<No> lista = tabela[local];
        if (isFull()) {
            System.out.println("ta cheio");
        }
        lista.add(item);
        quant_itens++;
    }
    public void remover(No item) {
        int local = FuncaoHash(item.getNumero());
        LinkedList<No> lista = tabela[local];
        for (No numero: lista){
            if(numero.equals(item)){
                lista.remove(numero);
                System.out.println(numero);
                quant_itens--;
                break;
            }
        }
    }

    public void buscar(No item) {
        long tempo_inicio = System.currentTimeMillis();
        int local = FuncaoHash(item.getNumero());
        LinkedList<No> lista = tabela[local];
        int achado = 0;
        for(No numero: lista){
            if(numero.equals(item)){
                achado = numero.getNumero();
            }
        }
        if(achado == 0){
            System.out.println("O numero nao foi encontrado");
            long tempo_final = System.currentTimeMillis();
            double media = tempo_final - tempo_inicio;
            System.out.printf("O tempo medio foi: %.3f %n", (media/1000));
        }
        else{
            System.out.println(achado);
            long tempo_final = System.currentTimeMillis();
            double media = tempo_final - tempo_inicio;
            System.out.printf("O tempo medio foi: %.3f %n", (media/1000));
        }
    }
}


