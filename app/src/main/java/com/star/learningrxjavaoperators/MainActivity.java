package com.star.learningrxjavaoperators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable
//                .concat(
//                        Observable.just(1, 2, 3),
//                        Observable.just(4, 5, 6),
//                        Observable.just(7, 8, 9),
//                        Observable.just(10, 11, 12))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接: concat");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .concatArray(
//                        Observable.just(1, 2, 3),
//                        Observable.just(4, 5, 6),
//                        Observable.just(7, 8, 9),
//                        Observable.just(10, 11, 12),
//                        Observable.just(13, 14, 15))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接: concatArray");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .merge(
//                        Observable.intervalRange(0, 3,
//                                1, 1, TimeUnit.SECONDS),
//                        Observable.intervalRange(3, 3,
//                                1, 1, TimeUnit.SECONDS),
//                        Observable.intervalRange(6, 3,
//                                1, 1, TimeUnit.SECONDS),
//                        Observable.intervalRange(9, 3,
//                                1, 1, TimeUnit.SECONDS))
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接: merge");
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "接收到了事件" + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .mergeArray(
//                        Observable.intervalRange(0, 3,
//                                1, 1, TimeUnit.SECONDS),
//                        Observable.intervalRange(3, 3,
//                                1, 1, TimeUnit.SECONDS),
//                        Observable.intervalRange(6, 3,
//                                1, 1, TimeUnit.SECONDS),
//                        Observable.intervalRange(9, 3,
//                                1, 1, TimeUnit.SECONDS),
//                        Observable.intervalRange(12, 3,
//                                1, 1, TimeUnit.SECONDS))
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接: mergeArray");
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "接收到了事件" + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .concatArray(
//                        Observable.create(emitter -> {
//                            emitter.onNext(1);
//                            emitter.onNext(2);
//                            emitter.onNext(3);
//                            emitter.onError(new NullPointerException()); // 发送Error事件，因为无使用concatDelayError，所以第2个Observable将不会发送事件
//                            emitter.onComplete();
//                        }),
//                        Observable.just(4, 5, 6))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接: concatArray");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .concatArrayDelayError(
//                        Observable.create(emitter -> {
//                            emitter.onNext(1);
//                            emitter.onNext(2);
//                            emitter.onNext(3);
//                            emitter.onError(new NullPointerException()); // 发送Error事件，因为无使用concatDelayError，所以第2个Observable将不会发送事件
//                            emitter.onComplete();
//                        }),
//                        Observable.just(4, 5, 6))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接: concatArrayDelayError");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
        Observable integerObservable =
                Observable
                        .create(emitter -> {

                            try {
                                Log.d(TAG, Thread.currentThread().getName());

                                Log.d(TAG, "被观察者1发送了事件1");
                                emitter.onNext(1);
                                Thread.sleep(1000);

                                Log.d(TAG, "被观察者1发送了事件2");
                                emitter.onNext(2);
                                Thread.sleep(1000);

                                Log.d(TAG, "被观察者1发送了事件3");
                                emitter.onNext(3);
                                Thread.sleep(1000);

//                                Log.d(TAG, "被观察者1发送了事件4");
//                                emitter.onNext(4);
//                                Thread.sleep(1000);

                                Log.d(TAG, "被观察者1发送了complete");
                                emitter.onComplete();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }).subscribeOn(Schedulers.io());

        Observable stringObservable =
                Observable
                        .create(emitter -> {

                            try {
                                Log.d(TAG, Thread.currentThread().getName());

                                Log.d(TAG, "被观察者2发送了事件A");
                                emitter.onNext("A");
                                Thread.sleep(1000);

                                Log.d(TAG, "被观察者2发送了事件B");
                                emitter.onNext("B");
                                Thread.sleep(1000);

                                Log.d(TAG, "被观察者2发送了事件C");
                                emitter.onNext("C");
                                Thread.sleep(1000);

                                Log.d(TAG, "被观察者2发送了事件D");
                                emitter.onNext("D");
                                Thread.sleep(1000);

                                Log.d(TAG, "被观察者2发送了complete");
                                emitter.onComplete();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }).subscribeOn(Schedulers.io());

        Observable
                .zip(integerObservable, stringObservable,
                        (BiFunction<Integer, String, String>) (integer, string)
                                -> integer + string)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接: zip");
                    }

                    @Override
                    public void onNext(String string) {
                        Log.d(TAG, "最终接收到的事件 =  " + string);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应: zip");
                    }
                });
    }
}
