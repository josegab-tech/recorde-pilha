public class Pilha<T> {
    private int topo;
    private T[] elementos;
    
    public Pilha(int capacidade){
        this.topo = -1;
        this.elementos = (T[]) new Object[capacidade];
    }

    public boolean isFull(){
        return this.elementos.length-1 == this.topo;
    }

    public boolean push(T elemento){
            if(!this.isFull()){
                this.topo++;
                this.elementos[topo] = elemento;
                return true;
            }
            return false;
    }

    public boolean isEmpty(){
       /*  if (this.topo== -1)
            return true;
        else 
            return false;*/
        return this.topo == -1;
    }

     public T pop(){
        if(!isEmpty()){
            T removido = this.elementos[this.topo];
            this.topo--;
            return removido;
        }
        return null;
     }

     public T peek(){
        if(!isEmpty())
            return this.elementos[this.topo];
        else
            return null;
     }

     @Override
     public String toString(){
        StringBuilder pilha = new StringBuilder("Topo\n");
        for(int i = this.topo; i>=0; i--)
            pilha.append(this.elementos[i]+"\n");

        pilha.append("__________\n");
        return pilha.toString();
     }


}