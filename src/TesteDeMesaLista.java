public class TesteDeMesaLista {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(4);

        Object elements[] = {3,9,1,2};
        listaSimples.inserirSequencia(elements);
        listaSimples.ordenarCrescente();
        listaSimples.exibir();
        listaSimples.limpar();
    }
}