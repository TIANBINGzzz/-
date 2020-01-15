public class BookModel {
    private long id = -1;
    private String name = "";
    private String author;
    private long stock;
    private long lentNum = 0;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getLentNum() {
        return lentNum;
    }

    public void setLentNum(long lentNum) {
        this.lentNum = lentNum;
    }

    //借出数目增加
    public void LentNumAdd(int num){
        lentNum += num;
    }
    //库存数减少
    public void StockDec(int num){
        stock -= num;
    }
}
