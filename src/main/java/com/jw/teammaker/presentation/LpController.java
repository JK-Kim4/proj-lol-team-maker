package com.jw.teammaker.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * Spring Long Polling 구현 예제 Controller
 *
 * */
@RestController
@RequestMapping("/long-polling")
public class LpController {

    private final Logger logger = LoggerFactory.getLogger(LpController.class);

    @GetMapping("/bake/{bakedGood}")
    public DeferredResult<String> syncPublisher(
            @PathVariable String bakedGood,
            @RequestParam Integer bakeTime){

        DeferredResult<String> output = new DeferredResult<>();

        try {
            System.out.println("Thread id: " +Thread.currentThread());
            Thread.sleep(bakeTime);
            output.onTimeout(() -> System.out.println("TIME OUT"));
            output.setResult(String.format("Bake for %s complete and order dispatched. Enjoy!", bakedGood));
        }catch (Exception e){
            logger.error("long polling error", e);
        }

        return output;
    }

    private ExecutorService bakers = Executors.newFixedThreadPool(5);

    @GetMapping("/async/bake/{bakedGood}")
    public DeferredResult<String> asyncPublisher(
            @PathVariable String bakedGood,
            @RequestParam Integer bakeTime){
        DeferredResult<String> output = new DeferredResult<>(1000L);

        output.onTimeout(() -> output.setErrorResult("the bakery is not responding in allowed time"));
        bakers.execute(() -> {
            try {
                System.out.println("Thread id: " +Thread.currentThread());
                Thread.sleep(bakeTime);
                output.setResult(String.format("Bake for %s complete and order dispatched. Enjoy!", bakedGood));
            }catch (Exception e){

                logger.error("long polling error", e);
            }

        });
        return output;
    }

    @GetMapping("/async-deferredresult")
    public DeferredResult<ResponseEntity<?>> handleReqDefResult(Model model){
        logger.info("received");
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(500L);

        output.onTimeout(() -> output.setErrorResult(ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("TIME OUT")));

        ForkJoinPool.commonPool().submit(() -> {
            logger.info("Processing in separate thread");

            try {
                Thread.sleep(6000);
            }catch (Exception e){
                logger.error("error", e);
            }
            output.setResult(ResponseEntity.ok("OK"));
        });

        logger.info("servlet thread freed");
        return output;
    }
}
