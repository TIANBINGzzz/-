
//整合其他的model，并做出行为
public class doModel {

    //模拟数据库
    //使用文件
    public LinkList<lentModel> lentModels = new LinkList<>();
    public LinkList<BookModel> bookModels = new LinkList<>();
    public LinkList<UserModel> userModels = new LinkList<>();



    //根据书号索引找到书，返回书的类
    public BookModel findBook(long id){
        for (int i = 0;i < bookModels.size();i++){
            if (id==bookModels.get(i).getId()){
                return bookModels.get(i);
            }
        }
        return null;
    }

    //根据书号索引找到书，返回书在列表中的位置
    public int findBookReturnIndex(long id){
        for (int i = 0;i < bookModels.size();i++){
            if (id==bookModels.get(i).getId()){
                return i;
            }
        }
        return -1;                              //返回-1即未找到
    }
    //查找用户是否存在
    public boolean findUser(long id){
        for (int i = 0;i < userModels.size();i++){
            if (id==userModels.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    //在用户表里查找用户，找到的话返回在表中的位置
    public int findUserReturnIndex(long id){
        for (int i = 0;i < userModels.size();i++){
            if (id==userModels.get(i).getId()){
                return i;
            }
        }
        return -1;
    }

    //查找借书的情况是否存在
    public int findUserInLentModel(long userId,long bookId){
        for (int i = 0;i < lentModels.size();i++){
            if (userId == lentModels.get(i).getUserId()&&bookId == lentModels.get(i).getBookId()){
                return i;
            }
        }
        return -1;
    }

    //查找用户借书的情况
    public LinkList<lentModel> findUserInLentModelReturnModel(long userId){
        LinkList<lentModel> lentmodels = new LinkList<>();
        for (int i = 0;i < lentModels.size();i++){
            if (userId == lentModels.get(i).getUserId()){
                lentmodels.add(lentModels.get(i));
            }
        }
        return lentmodels;
    }

    //添加书目
    public void addBook(long id,String name,long stock){
        BookModel bookmodel = new BookModel();
        int index = findBookReturnIndex(id);
        //如果找到了书的id号，说明书已经存在
        if (index!=-1){
            bookModels.get(index).setStock(bookModels.get(index).getStock()+stock);  //库存增加
        }
        else {
            bookmodel.setId(id);
            bookmodel.setName(name);
            bookmodel.setStock(stock);
            bookModels.add(bookmodel);
        }
    }



    //借出书的操作
    public void lentBook(long userid,long bookid,int num,String date) {
        lentModel lentmodel = new lentModel();
        UserModel usermodel = new UserModel();
        int i =  findBookReturnIndex(bookid);
        if (i == -1){
            System.out.println("未找到书目");
            return;
        }
        //修改库存和借出量
        bookModels.get(i).StockDec(num);
        bookModels.get(i).LentNumAdd(num);
        //是否有这个用户了
        boolean flag = findUser(userid);
        if(!flag){
            usermodel.setId(userid);
            userModels.add(usermodel);
        }
        BookModel bookModel = findBook(bookid);
        lentmodel.setBookName(bookModel.getName());
        lentmodel.setUserId(userid);
        lentmodel.setBookId(bookid);
        lentmodel.setDate(date);
        lentmodel.setLentNum(num);
        lentModels.add(lentmodel);
    }
    //查询某人是否借过书
    public boolean findUserInLentModelByUserId(long userId){
        if (lentModels.head==null){
            return false;
        }
        for (int i = 0;i < lentModels.size();i++){
            if (userId == lentModels.get(i).getUserId()){
                return true;
            }
        }
        return false;
    }
    //归还书目
    public void returnBook(long userId,long bookId,int num){
        int n = findUserInLentModel(userId,bookId);
//        System.out.println("n:"+n);
        if (n == -1){
            System.out.println("输入有误，用户号或书目号不存在");
            return;
        }
        else {
            //改变书目的数量
            int index = findBookReturnIndex(bookId);
            bookModels.get(index).setStock(bookModels.get(index).getStock()+num);
            bookModels.get(index).setLentNum(bookModels.get(index).getLentNum()-num);
            lentModels.deleteNodeByPlace(n);                            //先删除借书记录
            boolean temp = findUserInLentModelByUserId(userId);         //找这个人还有没有再借
            if (!temp){
                 userModels.deleteNodeByPlace(findUserReturnIndex(userId)); //没有就删除他在用户表里的数据
            }
        }
    }

    //打印书目情况
    public void showBooks(){
        BookModel bookmodel = new BookModel();
        for (int i = 0;i<bookModels.size();i++){
            bookmodel = bookModels.get(i);
            System.out.println("书目编号："+bookmodel.getId()+"     书目名称："+bookmodel.getName()+"     作者："+bookmodel.getAuthor()+
                    "     库存数："+bookmodel.getStock()+"       借出数："+bookmodel.getLentNum());
        }
    }
    //打印借阅人情况
    public void showUsers(){
        UserModel usermodel = new UserModel();
        for (int i = 0;i<userModels.size();i++){
            usermodel = userModels.get(i);
            System.out.println("借阅人编号："+usermodel.getId()+"     借阅人姓名："+usermodel.getName());
        }
    }
    //打印用户借书情况
    public void showLentModel( LinkList<lentModel> lentmodels){
        lentModel lentmodel;
        for (int i = 0;i<lentmodels.size();i++){
            lentmodel = lentmodels.get(i);
            System.out.println("借阅人编号："+lentmodel.getUserId()+"     书目编号："+lentmodel.getBookId()+
                    "       书目名称："+lentmodel.getBookName()+"       归还日期："+lentmodel.getDate()+
                    "       借出数量："+lentmodel.getLentNum());
        }
    }
    //打印借阅情况
    public void showLents(){
        lentModel lentmodel = new lentModel();
        for (int i = 0;i<lentModels.size();i++){

            lentmodel = lentModels.get(i);
            System.out.println("借阅人编号："+lentmodel.getUserId()+"     书目编号："+lentmodel.getBookId()+
                    "       书目名称："+lentmodel.getBookName()+"       归还日期："+lentmodel.getDate()+
                    "       借出数量："+lentmodel.getLentNum());
        }
    }
}
