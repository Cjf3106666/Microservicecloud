package ActiveMQ;

public class ConsumerTest {
    public static void main(String[] args){
        Consumer Consumer = new Consumer();
        Consumer.init();
        ConsumerTest testConsumer = new ConsumerTest();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
        new Thread(testConsumer.new ConsumerMq(Consumer)).start();
    }

    private class ConsumerMq implements Runnable{
        Consumer Consumer;
        public ConsumerMq(Consumer Consumer){
            this.Consumer = Consumer;
        }
        @Override
        public void run() {
            while(true){
                try {
                    Consumer.getMessage("Active-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
