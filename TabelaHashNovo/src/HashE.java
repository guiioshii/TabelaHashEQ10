import java.util.LinkedList;

public class HashE {
    private int max_posicao;
    private int max_itens;
    private int quant_itens;
    private LinkedList<Feira>[] tabela;
    public HashE(int max_itens, int max_posicao) {
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

    public void inserir(Feira item) {
        int local = FuncaoHash(item.getCodigo());
        LinkedList<Feira> lista = tabela[local];
        if (isFull()) {
            System.out.println("A tabela esta cheia!");
        }
        lista.add(item);
        quant_itens++;
    }
    public String remover(Feira item) {
        int local = FuncaoHash(item.getCodigo());
        LinkedList<Feira> lista = tabela[local];
        for (Feira numero: lista){
            if(numero.equals(item)){
                lista.remove(numero);
                quant_itens--;
                return "A fruta " + item.getFruta() + " do codigo " +  item.getCodigo() + " foi removido!";
            }
        }
        return "A fruta nao esta na tabela!";
    }

    public String buscar(Feira item) {
        long tempo_inicio = System.currentTimeMillis();
        int local = FuncaoHash(item.getCodigo());
        LinkedList<Feira> lista = tabela[local];
        int achado = 0;
        String achado2 = " ";
        for(Feira numero: lista){
            if(numero.equals(item)){
                achado = numero.getCodigo();
                achado2 = numero.getFruta();
            }
        }
        if(achado == 0){
            long tempo_final = System.currentTimeMillis();
            double media = tempo_final - tempo_inicio;
            System.out.printf("O tempo medio de busca foi: %.3f %n", (media/1000));
            return "Fruta nao encontrada!";
        }
        else{
            long tempo_final = System.currentTimeMillis();
            double media = tempo_final - tempo_inicio;
            System.out.printf("O tempo medio de busca foi: %.3f %n", (media/1000));

            return "A fruta " + achado2 + " do codigo " + achado + " foi encontrado!";
        }
    }
    public void imprimir(){
        System.out.println("Tabela: ");
        for(int i = 0; i < max_posicao; i++){
            LinkedList<Feira> lista = tabela[i];
            for(Feira frutas: lista){
                System.out.println("Codigo: " + frutas.getCodigo() + "; Fruta: " + frutas.getFruta());
            }
        }
    }
}