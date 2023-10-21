public class Main {
    public static void main(String[] args) {
        Feira item = new Feira(11, "abacaxi");
        Feira item2 = new Feira(22, "melao");
        Feira item3 = new Feira(33, "goiaba");
        Feira item4 = new Feira(44, "maca");
        Feira item5 = new Feira(55, "banana");
        Feira item6 = new Feira(66, "carambola");
        HashE tabela = new HashE(10, 11);
        HashH tabela2 = new HashH(10,11);


        System.out.println("------------------------\n" +
                "Tabela usando lista encadeada: ");
        tabela.inserir(item);
        tabela.inserir(item2);
        tabela.inserir(item3);

        System.out.println(tabela.buscar(item));
        System.out.println(tabela.buscar(item2));
        System.out.println(tabela.buscar(item3));

        System.out.println(tabela.remover(item3));
        System.out.println(tabela.buscar(item));
        System.out.println(tabela.buscar(item2));
        System.out.println(tabela.buscar(item3));

        System.out.println(tabela.remover(item3));
        System.out.println(tabela.buscar(item));
        System.out.println(tabela.buscar(item2));
        System.out.println(tabela.buscar(item3));
        tabela.imprimir();

        System.out.println("-------------------------\n" +
                "Tabela Homogenea: ");
        tabela2.inserir(item4);
        tabela2.inserir(item5);
        tabela2.inserir(item6);

        System.out.println(tabela2.buscar(item4));
        System.out.println(tabela2.buscar(item5));
        System.out.println(tabela2.buscar(item6));

        System.out.println(tabela2.remover(item4));
        System.out.println(tabela2.buscar(item4));
        System.out.println(tabela2.buscar(item5));
        System.out.println(tabela2.buscar(item6));

        System.out.println(tabela2.remover(item4));
        System.out.println(tabela2.buscar(item4));
        System.out.println(tabela2.buscar(item5));
        System.out.println(tabela2.buscar(item6));
        tabela2.imprimir();
    }

}