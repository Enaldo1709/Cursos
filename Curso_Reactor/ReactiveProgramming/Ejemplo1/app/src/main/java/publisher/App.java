
package publisher;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

import publisher.models.SimplePublisher;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        new SimplePublisher(15).subscribe(new Flow.Subscriber<>() {

            @Override
            public void onSubscribe(Subscription subscription) {
                
            }

            @Override
            public void onNext(Integer item) {
                System.out.printf("Item = [%d]\n",item);
                
            }

            @Override
            public void onError(Throwable throwable) {
                
            }

            @Override
            public void onComplete() {
                System.out.println("¡Complete!");
                
            }
            
        });
    }
}
