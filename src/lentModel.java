public class lentModel {

    private long userId = -1;
    private String userName = "";
    private long bookId = -1;
    private String bookName ="";
    private long lentNum = 0;
    private String Date;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getLentNum() {
        return lentNum;
    }

    public void setLentNum(long lentNum) {
        this.lentNum = lentNum;
    }



}
