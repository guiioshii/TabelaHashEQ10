import java.util.ArrayList;
public class HashH {
    private int max_posicao;
    private int max_itens;
    private int quant_itens;
    private Feira[] tabela;
    private Feira fruta_vazia = new Feira(-1, "vazio");
    private Feira fruta_removida = new Feira(-2, "removido");
    public HashH(int max_itens, int max_posicao) {
        quant_itens = 0;
        this.max_posicao = max_posicao;
        this.max_itens = max_itens;
        tabela = new Feira[max_posicao];
        for (int i = 0; i < max_posicao; i++) {
            tabela[i] = fruta_vazia;
        }
    }

    public boolean isFull() {
        return quant_itens == max_itens;
    }

    private int FuncaoHash(int item) {
        return item % max_posicao;
    }

    public void inserir(Feira item){
        int local = FuncaoHash(item.getCodigo());

        if(isFull()){
            System.out.println("A tabela ta cheia!");
        }
        else {
            while (tabela[local].getCodigo() > 0) {
                local = (local + 1) % max_posicao;
            }
            tabela[local] = item;
            quant_itens++;
        }
    }

    public String remover(Feira item){
        int local = FuncaoHash(item.getCodigo());
        ArrayList<Feira> removido = new ArrayList<>();
        while(tabela[local].getCodigo() != -1){
            if(tabela[local].getCodigo() == item.getCodigo()){
                removido.add(tabela[local]);
                tabela[local] = fruta_removida;
                quant_itens--;
                return "A fruta " + removido.get(0).getFruta() + " do codigo " + removido.get(0).getCodigo() + " foi removido!";
            }
            local = (local + 1) % max_posicao;
        }
        return "A fruta nao esta na lista!";
    }

    public String buscar(Feira item){
        long tempo_inicio = System.currentTimeMillis();
        int local = FuncaoHash(item.getCodigo());
        ArrayList<Feira> buscado = new ArrayList<>();
        while(tabela[local].getCodigo() != -1) {
            if (tabela[local].getCodigo() == item.getCodigo()) {
                long tempo_final = System.currentTimeMillis();
                double media = tempo_final - tempo_inicio;
                System.out.printf("O tempo medio foi: %.3f %n", (media/1000));
                buscado.add(tabela[local]);
                return  "A fruta " + buscado.get(0).getFruta() + " do codigo " + buscado.get(0).getCodigo() + " foi encontrada!";
            }
            local = (local + 1) % max_posicao;
        }
        long tempo_final = System.currentTimeMillis();
        double media = tempo_final - tempo_inicio;
        System.out.printf("O tempo medio foi: %.3f %n", (media/1000));
        return "Fruta nao encontrada!";
    }

    public void imprimir(){
        System.out.println("Tabela: ");
        for(int i = 0; i < max_posicao; i++){
            System.out.println("Codigo: " + tabela[i].getCodigo() + "; Fruta: " + tabela[i].getFruta());
        }
    }
}