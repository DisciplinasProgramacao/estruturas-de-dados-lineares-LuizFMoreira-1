import java.util.NoSuchElementException; // <-- CORREÇÃO 3: Importar a classe de exceção

public class Fila<E> { // <-- CORREÇÃO 1: Declarar a classe como genérica <E>

    private Celula<E> primeiro;
    private Celula<E> ultimo;

    public Fila() {
        Celula<E> sentinela = new Celula<E>();
        primeiro = sentinela;
        ultimo = sentinela;
    }

    // CORREÇÃO 2: Implementar o método vazia()
    public boolean vazia() {
        // A fila está vazia se o primeiro e o último ponteiro
        // apontam para o mesmo objeto (a célula sentinela).
        return (primeiro == ultimo);
    }

    public void inserir(E item) {
        ultimo.setProximo(new Celula<E>(item, null));
        ultimo = ultimo.getProximo();
    }

    public E remover() {
        if (vazia()) {
            // Agora o compilador sabe o que é NoSuchElementException
            throw new NoSuchElementException("Nao há nenhum item na fila!");
        }

        E removido = primeiro.getProximo().getItem();
        primeiro.setProximo(primeiro.getProximo().getProximo());

        if (primeiro.getProximo() == null) {
            ultimo = primeiro;
        }

        return removido;
    }

    public void mostrar() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }

        Celula<E> atual = primeiro.getProximo();
        System.out.print("Fila: ");
        while (atual != null) {
            System.out.print(atual.getItem() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}