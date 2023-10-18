public class Main {
    public static void main(String[] args) {
            No item = new No(11);
            No item2 = new No(22);
            No item3 = new No(33);
        Hash tabela = new Hash(10, 11);

        tabela.inserir(item);
        tabela.inserir(item2);
        tabela.inserir(item3);

        tabela.buscar(item);
        tabela.buscar(item2);
        tabela.buscar(item3);

        tabela.remover(item3);
        tabela.buscar(item);
        tabela.buscar(item2);
        tabela.buscar(item3);

        tabela.remover(item3);
        tabela.buscar(item);
        tabela.buscar(item2);
        tabela.buscar(item3);

    }
}