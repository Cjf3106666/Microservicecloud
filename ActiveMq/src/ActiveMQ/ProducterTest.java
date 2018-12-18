package ActiveMQ;

public class ProducterTest {
    public static void main(String[] args) {
        Producter producter=new Producter();
        producter.init();

        ProducterTest producterTest=new ProducterTest();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //1
        new Thread(producterTest.new ProductorMq(producter)).start();
        //2
        new Thread(producterTest.new ProductorMq(producter)).start();
        //3
        new Thread(producterTest.new ProductorMq(producter)).start();
        //4
        new Thread(producterTest.new ProductorMq(producter)).start();
        //5
        new Thread(producterTest.new ProductorMq(producter)).start();


    }
    public class ProductorMq implements Runnable{
        Producter producter;
        public ProductorMq(Producter producter){
            this.producter=producter;
        }

        @Override
        public void run() {
            while(true){
                try{
                    producter.sendMessage("Active-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
