package wooteco.helloworld.core;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class SpringCoreService {
    public String sayName(String name) throws InterruptedException {
        doHeavyWork();

        return "My name is " + name;
    }

    private void doHeavyWork() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }
}
