package com.myjava.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class testb {
    private static final String REGEX = "cat";
    private static Map<String, List<String>> multi = new HashMap<>();
    private static String INPUT =
            "catcat cat cat tie cat";
    private static final String OUTPUT =
            "dog";

    private static final Object obj = new Object();
    private static boolean flag = true;



    public static void main(String[] args) {

//        float floatVar = 0.9f;
//        int intVar = 9;
//        String stringVar = "dfd";
//        System.out.printf("浮点型变量的值为 " +
//                "%f, 整型变量的值为 " +
//                " %d, 字符串变量的值为 " +
//                "is %s", floatVar, intVar, stringVar);
//        String a = String.format(Locale.CHINESE, "浮点型变量的值为 %f, 整型变量的值为  %d, 字符串变量的值为 is %s", floatVar, intVar, stringVar);
//        Date date = new Date(100000000);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss,E,z", Locale.CHINA);
//        System.out.print(simpleDateFormat.format(date));
//        Calendar c = Calendar.getInstance();
//        c.
//        Pattern p = Pattern.compile(REGEX);
//        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
//        int count = 0;
//        INPUT = m.replaceAll(OUTPUT);
//        System.out.println(INPUT);
//        char c;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        do {
//            c = (char) br.read();
//            System.out.println(c);
//        } while (c != 'q');
//        throw new IOException();
//        String a = "a";
//
//        String b = "A";
//        Cup cup = new Cup();
//        Cup cup1 = new Cup();
//        System.out.println("重地".hashCode());
//        System.out.println("通话".hashCode());
//        Integer integer = new Integer(1);
//        int j = 10;
//        for (int i = 0; i < j; i++) {
//
//        }
//        List<Integer> integers = new ArrayList<>();
//        for (Integer integer1 : integers) {
//
//        }
//        String a;
//        if (a == null) {
//
//        }
//        try {
//            a
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("s");
//            }
//        };
//        Integer p = 1;
//    }
//        Thread t1 = new Thread(new MyThread1());
//        Thread t2 = new Thread(new MyThread2());
//        t1.start();
//        t2.start();
//        Chil chil = (Chil) new Parent();
//        Parent parent = new Chil();
////        chil.getAge();
//        parent.getAge();
//        Chil chil = (Chil) parent;
//        Node<String> a = new Node<>("efre");
//        Node<String> b = new Node<>("efre");
//        a.next = b;
//        byte a = 127;
//        byte b = (byte) (a + 1);
//        System.out.println(b);//-128
//        Runtime runtime = Runtime.getRuntime();
//        runtime.exec("dsfa.exe");
//        Collection<String> strings = new ArrayList<>();
//        strings.add("dgad");
//        strings.add("dfsgad");
//        strings.add("safh");
////        strings.forEach(System.out::println);
//        strings.removeIf(s -> s.length() < 10);//predicate操作判断是否符合条件实现过滤操作
//        Stream stream = Stream.builder()
//                .add("ssg")
//                .add("fdsa")
//                .build();
//        stream.forEach(System.out::println);
//        HashSet<String> strings = new HashSet<>();
//        SortedSet<Integer> sortedSet = new TreeSet<>();
//
//        for (int i = 1; i < 1000; i++) {
//            sortedSet.add(i);
//        }
//        NavigableSet<Integer> s = ((TreeSet<Integer>) sortedSet).descendingSet();
//        s.forEach(System.out::println);
//        List<String> strings = new ArrayList<>();
//        System.out.println(strings.getClass());
//        List<String>[] a = new List[10];
//        File file = new File(".\\lib\\src\\test.txt");
//        file.mkdir();
////        file.createNewFile();
//        String[] list = file.list((dir, name) -> name.endsWith(".txt"));
//        for (int i = list.length - 1; i >= 0; i--) {
//            System.out.println(list[i]);
//        }
//        File file1 = new File(".");
//        File.createTempFile("aaa", ".rx", file1);
//        file1.deleteOnExit();
//        InputStream inputStream = new FileInputStream(".\\lib\\src\\main\\java\\com\\myjava\\test\\test.txt");
//        byte[] b = new byte[5];
//        int hasRead = 0;
//        while ((hasRead = inputStream.read(b)) > 0) {
//            System.out.println(hasRead);
//            System.out.println(new String(b, 0, hasRead));
//        }
//        inputStream.close();
//        FileReader reader = null;
//        try {
//            reader = new FileReader(".\\lib\\src\\main\\java\\com\\myjava\\test\\test.txt");
//            char[] chars = new char[32];
//            int hasRead = 0;
//            while ((hasRead = reader.read(chars)) > 0) {
//                System.out.println(new String(chars, 0, hasRead));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }
//        try (FileInputStream fileInputStream = new FileInputStream(".\\lib\\src\\main\\java\\com\\myjava\\test\\test.txt");
//             FileOutputStream fileOutputStream = new FileOutputStream("ui.txt")) {
//            byte[] bytes = new byte[1000];
//            int hasRead = 0;
//            while ((hasRead = fileInputStream.read(bytes)) > 0) {
//                fileOutputStream.write(bytes, 0, hasRead);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try (
//                Scanner scanner = new Scanner(System.in);
//                InputStreamReader reader1 = new InputStreamReader(System.in);
//                BufferedReader bufferedReader = new BufferedReader(reader1);
//        ) {
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                if (line.equals("exit")) {
//                    System.exit(1);
//                }
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ui.txt"))) {
//            Apple apple = new Apple("sdfa", "sdfasfadg");
//            outputStream.writeObject(apple);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ui.txt"))) {
//            Apple apple = (Apple) inputStream.readObject();
//            System.out.println(apple.getAge());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        CharBuffer charBuffer = CharBuffer.allocate(9);
//        charBuffer.put("a");
//        charBuffer.put("b");
//        charBuffer.put("C");
//        charBuffer.flip();
//        System.out.println(charBuffer.get(6));
//        Thread a = new Thread();
//        FutureTask<String> task = new FutureTask<>(() ->"df");
//        new Thread(task, "ds").start();
//        int s = 79005380;
//        System.out.println(Integer.valueOf("27iii4",26));
//        InetAddress ip = InetAddress.getByName("www.baidu.com");
//        System.out.println(ip.isReachable(2000));
//        System.out.println(ip.getHostAddress());
//        String urlString = URLEncoder.encode("大爹", "GBK");
//        System.out.println(urlString);
//        final DownUtils downUtils = new DownUtils("https://mp3d.jamendo.com/download/track/16356/mp32/", "io.map3", 4);
//        downUtils.download();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println("已完成"+downUtils.getCompleteRate());
//                    try {
//                        Thread.sleep(1000);
//                    }catch (Exception e){
//
//                    }
//                }
//            }
//        }).start();
//        Class cla = Apple.class;
//        Constructor[] c = cla.getDeclaredConstructors();
//        cla.getAn
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(c[i]);
//        }
//        InvocationHandler handler = new MyInvokationHandler();
//        Class proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class[]{Person.class});
//        Constructor ctor = proxyClass.getConstructor(new Class[]{InvocationHandler.class});
//        Person a = (Person) ctor.newInstance(new Object[]{handler});
//        Person s = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
//        a.walk();
//        a.sayHellO("df");
//        Dog target = new GunDog();
//        Dog dog = (Dog) MyProxyFactory.getProxy(target);
//        dog.info();
//        dog.run();
//        System.out.println(String.format(Locale.ENGLISH,"%.2f",3.455555));


//        String s = DES.encryptDES("brunomars.rycooder.kwesiarthur.johnsykes.shredz.etaerock.manuelcarrasco.ozuna.rosalía.yoxti.евапольна.поётлюбовь.молчание.aipa.papi.paapi.pappi.tips.kismatkonnection.ajabprem.berex.mjealous.lovehua.hindi.kumarsanu.alkayagnik.jaanamsam.jhakaro", "fashionn");
//        System.out.println(s);
//        System.out.println(DES.decryptDES("FoteX/0nqPCsRSnbxNZ/VwwVQTDDV2NJ","sfkdsjfd"));
//        try {
//            InputStream inputStream = new FileInputStream(
//                    "./testc.java");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        byte[] b = new byte[1024];
//        int hasread = 0;
//        while (((hasread = inputStream.read(b)) > 0)) {
//            System.out.println(new String(b, 0, hasread));
//        }
//        inputStream.close();
//        try {
//            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("persion.txt"));
//            Apple apple = new Apple();
//            apple.setAge(34);
//            apple.setName("Dg");
//            ob.writeObject(apple);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("persion.txt"));
//            Apple apple = (Apple) inputStream.readObject();
//            System.out.println(apple.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("fdgf");
//        List<Integer> integers = new ArrayList<>();
//        integers.add(0);
//        integers.add(9);
//        integers.remove(0);
//        System.out.println(integers.get(0));b
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ou();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ou();
//            }
//        }).start();
//        try {
//            fooo();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        final int[] i = new int[1];
//        BlockingQueue<Integer> integers = new ArrayBlockingQueue<Integer>(3);
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                        integers.offer(30);
////                        System.out.println(integers.size());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread1.start();
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        System.out.println(integers.take());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread.start();

    }

    public void setf() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    private static void fooo() {
//        throw new NullPointerException("fdsfeg");
        try {
            FileInputStream fileInputStream = new FileInputStream("gd");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new NullPointerException("null");
        }
    }

    private static final String TAG = "testb";
    static int i = 0;
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static synchronized void ou() {
        System.out.println(i++);
        System.out.println(Thread.currentThread());
        try {
            System.out.println(i++);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }


    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread1 start");
                try {
//                    Thread.sleep(500);
//                    obj.wait();
                    Thread.yield();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 end");
            }
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread2 start");
                obj.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 end");
            }
        }
    }

    /**
     * sleep 不释放锁 阻塞线程 等待完成之后，下一个获得锁继续执行  Thread的方法
     * wait  释放锁 等到其他notify之后才唤醒此线程  object
     * yield 让步 不释放锁 不会让线程进入阻塞状态 而是重回就绪状态 Thread 。和 sleep 不同的是 yield 方法只能使同优先级或更高优先级的线程有执行的机会
     * join 执行完之后其他线程才能继续执行
     * suspend
     */

    public void fff(Chil chil) {
        final Chil ch = chil;

    }

    public static <Base> void fg(Base[] a, Base[] b) {

    }
}
