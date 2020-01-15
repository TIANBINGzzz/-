
    public class LinkList<T> {
        Node head = null; // 头节点

        class Node {
            Node next = null;       // 节点的引用，指向下一个节点
            T data;               // 节点的对象，即内容,此处为整型数据
                                    //构造函数相当于
            public Node(T data) {
                this.data = data;
            }
        }

        //获得第n个值
        public T get(int i){
            if (size()<i&&i<0){
                return null;
            }
            Node preNode = head;
            Node curNode = preNode.next;
            for (int j = 0;j < i;j++){
                preNode = curNode;
                curNode = curNode.next;
            }
//            if (preNode.data==null){return;}
            return preNode.data;
        }


        //向链表中插入数据
        public void add(T d) {
            Node newNode = new Node(d);         // 实例化一个节点
            if (head == null) {
                head = newNode;
                return;
            }
            Node tmp = head;                    //遍历
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }


        //删除第index个节点
        public boolean deleteNodeByPlace(int index) {
            if (index < 0 || index > size()) {
                return false;
            }
            if (index == 0){
                head = head.next;
                return true;
            }
//            if (index == 1) {
//                head = head.next;
//                return true;
//            }
            int i = 1;
            Node preNode = head;
            Node curNode = preNode.next;
            while (curNode != null) {
                if (i == index) {
                    preNode.next = curNode.next;
                    return true;
                }
                else {
                    preNode = curNode;
                    curNode = curNode.next;
                    i++;
                }

            }
            return false;
        }

        //通过节点的数据删除
        public boolean deleteNodeByNodeNum(T num) {
            Node preNode = head;
            Node curNode = preNode.next;

            while (curNode != null) {
                if (num == curNode.data) {
                    preNode.next = curNode.next;
                    return true;
                }
                else {
                    preNode = curNode;
                    curNode = curNode.next;
                }

            }
            return false;
        }

        //返回长度
        public int size() {
            int length = 0;
            Node tmp = head;
            while (tmp != null) {
                length++;
                tmp = tmp.next;
            }
            return length;
        }

        //通过某个节点删除
        public boolean deleteNode(Node n) {
            if (n == null || n.next == null) {
                return false;
            }
            T tmp = n.data;
            n.data = n.next.data;
            n.next.data = tmp;
            n.next = n.next.next;
            System.out.println("删除成功！");
            return true;
        }

        //打印数据
        public void printList() {
            Node tmp = head;
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }

        //test
        public static void main(String[] args) {
            LinkList<Integer> list = new LinkList<>();

            list.add(5);
            list.add(3);
            list.add(1);
            list.add(2);
            list.add(55);
//            list.add(36);
            System.out.println("linkLength:" + list.size());
            System.out.println("head.data:" + list.head.data);
            list.printList();

            list.deleteNodeByPlace(0);
//            list.deleteNodeByNodeNum(2);

            System.out.println("After delete:");
            list.printList();

//            System.out.println(list.get(4));
        }
    }
