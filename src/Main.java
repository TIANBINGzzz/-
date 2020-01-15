import java.util.Scanner;

public class Main {
    private static doModel doModel = new doModel();
    public static void Initialize(){
        BookModel bookmodel1 = new BookModel();
        BookModel bookmodel2 = new BookModel();
        BookModel bookmodel3 = new BookModel();
        BookModel bookmodel4 = new BookModel();
        UserModel usermodel1 = new UserModel();
        UserModel usermodel2 = new UserModel();
        UserModel usermodel3 = new UserModel();
        UserModel usermodel4 = new UserModel();
        usermodel1.setId(1);
        usermodel1.setName("张三");
        doModel.userModels.add(usermodel1);
        usermodel2.setId(2);
        usermodel2.setName("李四");
        doModel.userModels.add(usermodel2);
        usermodel3.setId(3);
        usermodel3.setName("王五");
        doModel.userModels.add(usermodel3);
        usermodel4.setId(4);
        usermodel4.setName("田七");
        doModel.userModels.add(usermodel4);

        bookmodel1.setId(1);
        bookmodel1.setName("C语言基础教程");
        bookmodel1.setStock(10);
        doModel.bookModels.add(bookmodel1);
        bookmodel2.setId(2);
        bookmodel2.setName("Java从入门到精通");
        bookmodel2.setStock(56);
        doModel.bookModels.add(bookmodel2);
        bookmodel3.setId(3);
        bookmodel3.setName("30天精通python");
        bookmodel3.setStock(23);
        doModel.bookModels.add(bookmodel3);
        doModel.addBook(4,"玩转树莓派",10);
        doModel.lentBook(1,4,1,"2020.1.20");
        doModel.lentBook(1,2,3,"2020.3.1");
        doModel.lentBook(2,3,1,"2020.5.21");
        doModel.lentBook(3,1,2,"2020.4.7");
        doModel.lentBook(4,4,2,"2020.2.14");



    }

    public static void Menu(){
        System.out.println("------图书管理系统------");
        System.out.println("1.查看书目");
        System.out.println("2.查询个人借阅情况");
        System.out.println("3.借书");
        System.out.println("4.还书");
        System.out.println("------管理员模式------");
        System.out.println("5.查看借阅人");
        System.out.println("6.查看借阅情况");
        System.out.println("7.采编入库");
        System.out.println("0.退出");

    }

    public static void run(){
        int choose = 100;
        while(choose!=0){
            Menu();
            System.out.println("请输入您的选择");
            Scanner cin = new Scanner(System.in);
            choose = cin.nextInt();
            if (choose == 1){
                doModel.showBooks();

                System.out.println("回到主菜单请按任意键,退出请按 0 ");
                Scanner tempcin9 = new Scanner(System.in);
                int num3 = tempcin9.nextInt();
                if (num3 == 0){
                    choose = 0;
                    break;
                }
            }
            else if(choose == 2){
                System.out.println("请输入要查询的用户ID");
                Scanner tempcin1 = new Scanner(System.in);
                long userId1 = tempcin1.nextLong();
                LinkList<lentModel> lent  = doModel.findUserInLentModelReturnModel(userId1);
                if (lent == null){
                    System.out.println("用户不存在");
                    continue;
                }
                doModel.showLentModel(lent);



                System.out.println("回到主菜单请按任意键,退出请按 0 ");
                Scanner tempcin10 = new Scanner(System.in);
                int num3 = tempcin10.nextInt();
                if (num3 == 0){
                    choose = 0;
                    break;
                }

            }
            else if (choose == 3){
                System.out.println("请输入用户ID");
                Scanner tempcin2 = new Scanner(System.in);
                long UserId2 = tempcin2.nextLong();
                System.out.println("请输入书目ID");
                Scanner tempcin3 = new Scanner(System.in);
                long BookId2 = tempcin3.nextLong();
                System.out.println("请输入借书数量");
                Scanner tempcin4 = new Scanner(System.in);
                int num2 = tempcin4.nextInt();
                System.out.println("请输入还书时间");
                Scanner tempcin5 = new Scanner(System.in);
                String date2 = tempcin5.next();
                doModel.lentBook(UserId2,BookId2,num2,date2);

                System.out.println("回到主菜单请按任意键,退出请按 0 ");
                Scanner tempcin11 = new Scanner(System.in);
                int num3 = tempcin11.nextInt();
                if (num3 == 0){
                    choose = 0;
                    break;
                }
            }
            else if (choose ==4){
                System.out.println("请输入用户ID");
                Scanner tempcin6 = new Scanner(System.in);
                long UserId3 = tempcin6.nextLong();
                System.out.println("请输入书目ID");
                Scanner tempcin7 = new Scanner(System.in);
                long BookId3 = tempcin7.nextLong();

                System.out.println("请输入还书数量");
                Scanner tempcin8 = new Scanner(System.in);
                int num3 = tempcin8.nextInt();
                doModel.returnBook(UserId3,BookId3,num3);

                System.out.println("回到主菜单请按任意键,退出请按 0 ");
                Scanner tempcin12 = new Scanner(System.in);
                int num4 = tempcin12.nextInt();
                if (num4 == 0){
                    choose = 0;
                    break;
                }
            }
            else if (choose == 5){
                doModel.showUsers();
                System.out.println("回到主菜单请按任意键,退出请按 0 ");
                Scanner tempcin13 = new Scanner(System.in);
                int num3 = tempcin13.nextInt();
                if (num3 == 0){
                    choose = 0;
                    break;
                }
            }
            else if (choose == 6){
                doModel.showLents();
                System.out.println("回到主菜单请按任意键,退出请按 0 ");
                Scanner tempcin14 = new Scanner(System.in);
                int num3 = tempcin14.nextInt();
                if (num3 == 0){
                    choose = 0;
                    break;
                }
            }
            else if (choose == 7){
                System.out.println("请输入书目ID");
                Scanner tempcin22 = new Scanner(System.in);
                long BookId7 = tempcin22.nextLong();
                System.out.println("请输入书目名");
                Scanner tempcin23 = new Scanner(System.in);
                String BookName7 = tempcin23.next();
                System.out.println("请输入书目数量");
                Scanner tempcin24 = new Scanner(System.in);
                int num7 = tempcin24.nextInt();
                doModel.addBook(BookId7,BookName7,num7);
                System.out.println("回到主菜单请按任意键,退出请按 0 ");
                Scanner tempcin14 = new Scanner(System.in);
                int num3 = tempcin14.nextInt();
                if (num3 == 0){
                    choose = 0;
                    break;
                }
            }
        }
    }



    public static void main(String[] args) {
        Initialize();
        run();
    }

}
