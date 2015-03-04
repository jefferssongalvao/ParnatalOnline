package TrabalhoEDB;
//Essa classe simula a estrutura conjunto disjunto
public class UnionFind<E> {
    private UnionFind<?> parent;
    private int rank;
    private final E value;
    
    private UnionFind(E value) {
        this.value = value;
        this.parent = this;
    }
    //Faz o make set de valor
    public static <E> UnionFind<E> singleton(E value) {
        return new UnionFind<>(value);
    }

    public E value() {
        return value;
    }
    //Faz uniao de dois conjuntos disjuntos
    public UnionFind<?> merge(UnionFind<?> other) {
        UnionFind<?> root1 = other.find();
        UnionFind<?> root2 = find();
        if (root1.rank < root2.rank) {
            root1.parent = root2;
            return root2;
        } else if (root1.rank > root2.rank) {
            root2.parent = root1;
            return root1;
        } else {
            root2.parent = root1;
            root1.rank++;
            return root1;
        }
    }
    //Procura o representante e compara 
    public UnionFind<?> find() {
        UnionFind<?> current = this;
        UnionFind<?> last = this;
        while (current.parent != current) {
            last.parent = current.parent; 
            last = current;
            current = current.parent;
        }
        return current;
    }
    //Uniao de particoes
    public static boolean areMerged(UnionFind<?> partition1, UnionFind<?> partition2) {
        return partition1.find() == partition2.find();
    }
}
